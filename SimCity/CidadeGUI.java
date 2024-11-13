
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CidadeGUI extends JFrame {
    private Cidade cidade;
    private JTextArea statusArea;
    private JButton construirCasaButton;
    private JButton construirComercioButton;
    private JButton adicionarEstradaButton;
    private JButton atualizarRecursosButton;

    public CidadeGUI() {
        cidade = new Cidade(1000, 500);

        setTitle("SimCity - Protótipo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        statusArea = new JTextArea();
        statusArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(statusArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        construirCasaButton = new JButton("Construir Casa");
        construirComercioButton = new JButton("Construir Comércio");
        adicionarEstradaButton = new JButton("Adicionar Estrada");
        atualizarRecursosButton = new JButton("Atualizar Recursos");

        panel.add(construirCasaButton);
        panel.add(construirComercioButton);
        panel.add(adicionarEstradaButton);
        panel.add(atualizarRecursosButton);
        add(panel, BorderLayout.SOUTH);

        construirCasaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                construirEdificio(new Edificio("Casa", 100, 5, 10));
            }
        });

        construirComercioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                construirEdificio(new Edificio("Comércio", 300, 0, 30));
            }
        });

        adicionarEstradaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cidade.adicionarEstrada(new Estrada("Estrada Principal"));
                atualizarStatus();
            }
        });

        atualizarRecursosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cidade.atualizarRecursos();
                atualizarStatus();
            }
        });

        atualizarStatus();
    }

    private void construirEdificio(Edificio edificio) {
        cidade.construirEdificio(edificio);
        atualizarStatus();
    }

    private void atualizarStatus() {
        statusArea.setText("");
        statusArea.append("População: " + cidade.getPopulacao() + "\n");
        statusArea.append("Dinheiro: " + cidade.getDinheiro() + "\n");
        statusArea.append("Energia: " + cidade.getEnergia() + "\n");
        statusArea.append("Número de Edifícios: " + cidade.getEdificios().size() + "\n");
        statusArea.append("Número de Estradas: " + cidade.getEstradas().size() + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CidadeGUI().setVisible(true);
            }
        });
    }
}
