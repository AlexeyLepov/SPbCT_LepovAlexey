import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Form_Main extends JComponent {
    private double angle;

    public Form_Main() {
        angle = 0;
        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += 0.05;
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2d = (Graphics2D) g;
        double x = 0.5 * width;
        double y = 0.5 * height;
        double r = 0.5 * Math.min(x, y);
        r= 12;
        Random rand = new Random();
        int rand_h = rand.nextInt(400) + 50;
        int rand_w = rand.nextInt(600) + 50;

        for (int i = 0; i <= 4; i++)
        {
            g2d.setColor(Color.white);
            g2d.fill(circle(rand_w , rand_h , 1));
        }

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, 800, 500);

        for (int i = 0; i <= 8; i++)
        {
            g2d.setColor(Color.white);
            g2d.fill(circle(rand_w , rand_h , 2));
        }

        g2d.setColor(Color.GREEN);
        x += 180 * Math.cos(angle);
        y += 60 * Math.sin(angle);

        r += 7*Math.sin(angle);
        g2d.fill(circle(x, y, r));

        g2d.setColor(Color.ORANGE);
        g2d.fill(circle(400, 200, 60));
    }

    private Shape circle(double x, double y, double r) {
        return new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Solar System");
                frame.add(new Form_Main());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 500);
                frame.setBackground(Color.black);
                frame.setVisible(true);
            }
        });
    }
}