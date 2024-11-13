
import java.util.ArrayList;
import java.util.List;

public class Cidade {
    private List<Edificio> edificios;
    private List<Estrada> estradas;
    private int populacao;
    private int dinheiro;
    private int energia;

    public Cidade(int dinheiroInicial, int energiaInicial) {
        this.edificios = new ArrayList<>();
        this.estradas = new ArrayList<>();
        this.populacao = 0;
        this.dinheiro = dinheiroInicial;
        this.energia = energiaInicial;
    }

    public void construirEdificio(Edificio edificio) {
        if (dinheiro >= edificio.getCusto()) {
            edificios.add(edificio);
            dinheiro -= edificio.getCusto();
            populacao += edificio.getCapacidade();
            System.out.println("Edifício construído: " + edificio.getNome());
        } else {
            System.out.println("Dinheiro insuficiente para construir " + edificio.getNome());
        }
    }

    public void adicionarEstrada(Estrada estrada) {
        estradas.add(estrada);
        System.out.println("Estrada adicionada.");
    }

    public void atualizarRecursos() {
        for (Edificio edificio : edificios) {
            energia -= edificio.getConsumoEnergia();
        }
        dinheiro += populacao * 2;
        System.out.println("Recursos atualizados. Dinheiro: " + dinheiro + ", Energia: " + energia);
    }

    public int getPopulacao() {
        return populacao;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public int getEnergia() {
        return energia;
    }

    public List<Edificio> getEdificios() {
        return edificios;
    }

    public List<Estrada> getEstradas() {
        return estradas;
    }
}
