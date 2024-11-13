
public class Edificio {
    private String nome;
    private int custo;
    private int capacidade;
    private int consumoEnergia;

    public Edificio(String nome, int custo, int capacidade, int consumoEnergia) {
        this.nome = nome;
        this.custo = custo;
        this.capacidade = capacidade;
        this.consumoEnergia = consumoEnergia;
    }

    public String getNome() {
        return nome;
    }

    public int getCusto() {
        return custo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getConsumoEnergia() {
        return consumoEnergia;
    }
}
