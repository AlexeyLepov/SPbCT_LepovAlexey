import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class Form_Main extends JComponent {
    public static double angle;
    public static double step = 5;

    public Form_Main() {
        angle = 0;
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += step/100;
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
        double y = 0.55 * height;

        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, 800, 500);

        g2d.setColor(Color.black);
        x += 360 * Math.cos(angle);
        g2d.fill(circle(x, y, 20));
    }

    private Shape circle(double x, double y, double r) {
        return new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
    }

    public static void main(String[] args) {

                JButton bt_up = new JButton("Ускорить движение точки");
                JButton bt_down = new JButton("Замедлить движение точки");
                bt_up.setBounds(50,10,300,30);
                bt_down.setBounds(430,10,300,30);
                JFrame frame = new JFrame("Dot Speed");
                frame.add(bt_up);
                frame.add(bt_down);
                frame.add(new Form_Main());

                bt_down.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if (step > 0) step-=1;
                    }
                });
                bt_up.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if (step <= 20) step+=1;
                    }
                });

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 300);
                frame.setVisible(true);
    }
}