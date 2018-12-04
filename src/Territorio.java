import javax.swing.*;
import java.awt.*;

public class Territorio extends JPanel {
    private static final int ALTURA_BARRA_TITULO = 20;

    public int contador = 0;

    private JFrame frame;

    private Ser ser;

    KeyListener listener = new LeitorSetas(ser);

    addKeyListener(listener);
    
    setFocusable(true);


    public Territorio(String nome) {
        frame = new JFrame(nome); // cria um frame
        frame.add(this); // insere o território no frame
        frame.setSize(400, 300 + ALTURA_BARRA_TITULO ); // define as dimensões do frame
        frame.setVisible(true); // torna o frame visível
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define como o frame é fechado
        ser = new Ser(Color.BLUE, this);
    }
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g; // por motivos de compatibilidade com a AWT
        g2d.setColor(Color.GRAY); // define a cor em uso
        g2d.setFont(new Font("Verdana", Font.BOLD, 16)); // define a fonte em uso
        g2d.drawString("Contador: " + String.valueOf(contador), 10, 30);// escreve uma string
        g2d.setColor(Color.GREEN);
        if (ser != null) ser.paint(g);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

    }
    public void jogar() {
        boolean jogando = true;
        while (jogando) {
            contador++;
            if (contador == 100) jogando = false;
            repaint(); // atualiza a imagem da janela
            try {
                Thread.sleep(500); // dorme por meio segundo
            }
            catch ( Exception e )
            {
                e.printStackTrace();
            }
            game_over();
        }
        System.out.println("largura: " + getWidth() + ", altura: " + getHeight());
    }
    private void game_over() {
        String mensagem = "Parabéns!";
        JOptionPane.showMessageDialog(this, mensagem, "Game Over", JOptionPane.YES_NO_OPTION);
    }
}