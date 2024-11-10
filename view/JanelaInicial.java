package view;

import java.awt.*;
import javax.swing.*;

public class JanelaInicial extends Canvas {

    private int xNovoJogo, yNovoJogo;
    private int larguraBotao = 300, alturaBotao = 50;
    private int xContinuar, yContinuar;
    private JFrame frame;

    public JanelaInicial() {
    	frame = new JFrame("Blackjack - Janela Inicial");
        frame.setSize(1006, 761);
        frame.setMinimumSize(new Dimension(1006, 761));
        frame.setMaximumSize(new Dimension(1006, 761));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        desenharFundo(g2d);
        desenharTextoPrincipal(g2d);
        desenharBotoes(g2d);
        desenharNota(g2d);
    }

    private void desenharFundo(Graphics2D g2d) {
        g2d.setColor(new Color(34, 139, 34));
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    private void desenharTextoPrincipal(Graphics2D g2d) {
        Font font = new Font("Arial", Font.BOLD, 100);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();

        String black = "BLACK";
        String jack = "JACK";

        int larguraBlack = fm.stringWidth(black);
        int larguraJack = fm.stringWidth(jack);
        int xCentro = (getWidth() - (larguraBlack + larguraJack)) / 2;

        g2d.setColor(Color.BLACK);
        g2d.drawString(black, xCentro, 200);
        g2d.setColor(Color.RED);
        g2d.drawString(jack, xCentro + larguraBlack, 200);
    }

    private void desenharBotoes(Graphics2D g2d) {
        Color corBotao = new Color(0, 100, 0);
        Color corTexto = Color.WHITE;
        Font fonteBotao = new Font("Arial", Font.PLAIN, 30);
        g2d.setFont(fonteBotao);
        FontMetrics fm = g2d.getFontMetrics();

        // Posiciona os botões
        xNovoJogo = (getWidth() - larguraBotao) / 2;
        yNovoJogo = 350;
        xContinuar = xNovoJogo;
        yContinuar = 450;

        // Desenha botões
        g2d.setColor(corBotao);
        g2d.fillRect(xNovoJogo, yNovoJogo, larguraBotao, alturaBotao);
        g2d.fillRect(xContinuar, yContinuar, larguraBotao, alturaBotao);

        // Contornos
        g2d.setColor(corTexto);
        g2d.drawRect(xNovoJogo, yNovoJogo, larguraBotao, alturaBotao);
        g2d.drawRect(xContinuar, yContinuar, larguraBotao, alturaBotao);

        // Textos dos botões
        desenharTextoBotao(g2d, "Novo Jogo", xNovoJogo, yNovoJogo, fm);
        desenharTextoBotao(g2d, "Continuar Jogo", xContinuar, yContinuar, fm);
    }

    private void desenharTextoBotao(Graphics2D g2d, String texto, int x, int y, FontMetrics fm) {
        int larguraTexto = fm.stringWidth(texto);
        int alturaTexto = fm.getAscent();
        int xTexto = x + (larguraBotao - larguraTexto) / 2;
        int yTextoFinal = y + ((alturaBotao - alturaTexto) / 2) + alturaTexto;
        g2d.setColor(Color.WHITE);
        g2d.drawString(texto, xTexto, yTextoFinal);
    }

    private void desenharNota(Graphics2D g2d) {
        Font fonteNota = new Font("Arial", Font.ITALIC, 20);
        g2d.setFont(fonteNota);
        String nota = "(Implementado na 4ª iteração)";
        int larguraNota = g2d.getFontMetrics().stringWidth(nota);
        int xNota = (getWidth() - larguraNota) / 2;
        g2d.drawString(nota, xNota, 520);
    }

    public Rectangle getBotaoNovoJogoBounds() {
        return new Rectangle(xNovoJogo, yNovoJogo, larguraBotao, alturaBotao);
    }

    public Rectangle getBotaoContinuarBounds() {
        return new Rectangle(xContinuar, yContinuar, larguraBotao, alturaBotao);
    }

    public void dispose() {
        frame.dispose();
    }

    public static void main(String[] args) {
        new JanelaInicial();
    }
}