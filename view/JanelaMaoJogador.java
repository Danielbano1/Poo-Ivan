package view;

import java.awt.*;
import javax.swing.*;

public class JanelaMaoJogador extends JanelaMao {
    private JLabel labelAposta;
    private JLabel labelDinheiro;

    public JanelaMaoJogador() {
        super(TipoMao.JOGADOR);
        setLayout(null); // Posicionamento absoluto

        int largura = 200;
        int altura = 30;

        // Pontos do jogador
        labelPontos.setBounds(10, 10, largura, altura);
        labelPontos.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelPontos);

        // Aposta do jogador
        labelAposta = criarLabel("Aposta: $ 0", largura, altura, (getWidth() - largura) / 2);
        add(labelAposta);

        // Dinheiro do jogador
        labelDinheiro = criarLabel("Dinheiro: $ 0", largura, altura, getWidth() - largura - 10);
        add(labelDinheiro);
    }

    private JLabel criarLabel(String texto, int largura, int altura, int posX) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
        label.setBounds(posX, 10, largura, altura);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    public void atualizarAposta(int valor) {
        labelAposta.setText("Aposta: $ " + valor);
    }

    public void atualizarDinheiro(int valor) {
        labelDinheiro.setText("Dinheiro: $ " + valor);
    }

    @Override
    public void atualizarPontos(int pontos) {
        super.atualizarPontos(pontos);
        labelPontos.setText("Pontos do Jogador: " + pontos);
    }
}