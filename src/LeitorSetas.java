import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

    public class LeitorSetas implements KeyListener {
        private Ser ser;
        public LeitorSetas(Ser ser) {
            this.ser = ser;
        }
        public void keyTyped(KeyEvent e) {
        }
        public void keyPressed(KeyEvent e) {
            ser.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
        }
    }