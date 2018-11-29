import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Ser extends JComponent {
    private Territorio territorio;
    private Color cor;
    private int x = 50;
    private int y = 40;
    private int altura = 30;
    private int largura = 30;
    private static final Random gerador_aleatorio = new Random();
    public Ser(Color cor, Territorio territorio) {
        this.cor = cor;
        this.territorio = territorio;
        x = gerador_aleatorio.nextInt(200); // gera entre 0 e 199
        y = gerador_aleatorio.nextInt(100); // gera entre 0 e 99
        System.out.println("x: " + x + ", y: " + y);

    }

    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT: { x = x - 5; break; }
            case KeyEvent.VK_RIGHT: { x = x + 5; break; }
            case KeyEvent.VK_UP: { y = y - 5; break; }
            case KeyEvent.VK_DOWN: { y = y + 5; break; }
        }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; // compatibilidade com a AWT
        g2d.setColor(cor);
        g2d.fillOval(x, y, largura, altura); // desenha um círculo
    }
}