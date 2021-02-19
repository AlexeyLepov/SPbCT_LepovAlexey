import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.*;
import java.net.*;

public class Server {

    static JFrame f;
    static JComboBox combo;
    static JButton btn;
    static JPanel p1;
    static JPanel p2;
    static Socket s = null;

    public static void main(String args[]) {

        String s1[] = { "Клиент № 1", "Клиент № 2", "Клиент № 3"};
        f = new JFrame("Визуальное приложение ");
        combo = new JComboBox(s1);
        btn = new JButton("Отправить");

        p1 = new JPanel();
        p1.setSize(150, 50);
        p1.add(combo);

        p2 = new JPanel();
        p2.setLocation(0, 0);
        p2.setSize(150, 50);
        p2.add(btn);

        f.add(p1);
        f.add(p2);
        f.setSize(400, 150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(combo.getSelectedItem() == "Клиент № 1")
                {
                    try {
                        ServerSocket server = new ServerSocket(3456);
                        s = server.accept();
                        PrintStream ps = new PrintStream(s.getOutputStream());
                        ps.println("Здравствуйте, Клиент № 1!");
                        ps.flush();
                        s.close();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }

                if(combo.getSelectedItem() == "Клиент № 2")
                {
                    try {
                        ServerSocket server = new ServerSocket(3456);
                        s = server.accept();
                        PrintStream ps = new PrintStream(s.getOutputStream());
                        ps.println("Здравствуйте, Клиент № 2!");
                        ps.flush();
                        s.close();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }

                if(combo.getSelectedItem() == "Клиент № 3")
                {
                    try {
                        ServerSocket server = new ServerSocket(3456);
                        s = server.accept();
                        PrintStream ps = new PrintStream(s.getOutputStream());
                        ps.println("Здравствуйте, Клиент № 3!");
                        ps.flush();
                        s.close();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });

    }
}
