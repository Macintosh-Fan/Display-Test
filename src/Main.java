import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The RGB Display Test program.
 *
 * @author Macintosh_Fan
 */
public class Main {
    private static boolean text;

    /**
     * The main method.
     *
     * @param args Does nothing
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Display Test");
        JPanel panel = new JPanel();
        Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
        int windowWidth = displaySize.width / 2;
        int windowHeight = displaySize.height / 2;
        text = true;

        frame.setSize(windowWidth, windowHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);
        panel.setSize(windowWidth, windowHeight);

        JLabel[] titleLabels = {
                new JLabel("Display Test"),
                new JLabel("Press 'r' for red"),
                new JLabel("Press 'g' for green"),
                new JLabel("Press 'b' for blue"),
                new JLabel("Press 'w' for white (default)"),
                new JLabel("Press 'n' for black"),
                new JLabel("Press 'h' to hide/show text"),
                new JLabel("Press 'q' to quit"),
                new JLabel("Custom sliders below for custom colours (to be added in the future)")
        };

        for (int i = 0, j = 0; i < titleLabels.length; i++, j += 30) {
            titleLabels[i].setBounds(0, j, windowWidth, 20);
            panel.add(titleLabels[i]);
        }

        frame.addKeyListener(new KeyListener() {
            /**
             * Invoked when a key has been typed.
             * See the class description for {@link KeyEvent} for a definition of
             * a key typed event.
             *
             * @param e the event to be processed
             */
            @Override
            public void keyTyped(KeyEvent e) {
            }

            /**
             * Invoked when a key has been pressed.
             * See the class description for {@link KeyEvent} for a definition of
             * a key pressed event.
             *
             * @param e the event to be processed
             */
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'r' -> panel.setBackground(Color.RED);
                    case 'g' -> panel.setBackground(Color.GREEN);
                    case 'b' -> panel.setBackground(Color.BLUE);
                    case 'w' -> panel.setBackground(Color.WHITE);
                    case 'n' -> panel.setBackground(Color.BLACK);
                    case 'h' -> {
                        text = !text;

                        for (JLabel titleLabel : titleLabels) {
                            titleLabel.setVisible(text);
                        }
                    }
                    case 'q' -> frame.dispose();
                }

                for (JLabel titleLabel : titleLabels) {
                    if (panel.getBackground() == Color.BLUE || panel.getBackground() == Color.BLACK) {
                        titleLabel.setForeground(Color.WHITE);
                    } else {
                        titleLabel.setForeground(Color.BLACK);
                    }
                }

            }

            /**
             * Invoked when a key has been released.
             * See the class description for {@link KeyEvent} for a definition of
             * a key released event.
             *
             * @param e the event to be processed
             */
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        frame.setVisible(true);
    }
}
