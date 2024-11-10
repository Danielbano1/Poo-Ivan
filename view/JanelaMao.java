package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JanelaMao extends JFrame {
    
    public enum TipoMao {
        JOGADOR("Mão do Jogador", "Pontos do Jogador", new Color(0, 100, 0)),
        DEALER("Mão da Banca", "Pontos da Banca", new Color(85, 26, 0));

        private final String titulo;
        private final String labelPontos;
        private final Color corFundo;

        TipoMao(String titulo, String labelPontos, Color corFundo) {
            this.titulo = titulo;
            this.labelPontos = labelPontos;
            this.corFundo = corFundo;
        }

        public String getTitulo() { return titulo; }
        public String getLabelPontos() { return labelPontos; }
        public Color getCorFundo() { return corFundo; }
    }

    protected JLabel labelPontos;
    protected ArrayList<Image> cartas;

    public JanelaMao(TipoMao tipo) {
        configurarJanela(tipo);
        labelPontos = criarLabel(tipo.getLabelPontos() + ": 0", 10, 10, 200, 30);
        add(labelPontos);
        cartas = new ArrayList<>();
        setVisible(true);
    }

    private void configurarJanela(TipoMao tipo) {
        setTitle(tipo.getTitulo());
        setSize(800, 250);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(tipo.getCorFundo());
        setLayout(null);
    }

    private JLabel criarLabel(String texto, int x, int y, int largura, int altura) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
        label.setBounds(x, y, largura, altura);
        return label;
    }

    public void atualizarPontos(int pontos) { 	
        String prefixo = labelPontos.getText().split(":")[0];
        labelPontos.setText(prefixo + ": " + pontos);
    }

    public void receberCarta(String nomeDaCarta) {
        try {
            Image carta = ImageIO.read(new File("resources/" + nomeDaCarta + ".gif"));
            cartas.add(carta);
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        int larguraCarta = 75, alturaCarta = 112, espacamento = 10;
        int totalLargura = cartas.size() * larguraCarta + (cartas.size() - 1) * espacamento;
        int xInicial = (getWidth() - totalLargura) / 2, y = 100;

        for (int i = 0; i < cartas.size(); i++) {
            g2d.drawImage(cartas.get(i), xInicial + i * (larguraCarta + espacamento), y, larguraCarta, alturaCarta, this);
        }
    }
}