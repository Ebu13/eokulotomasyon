package main.GUI;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ManPane extends JFrame {

    private String oNo;

    public ManPane() {
        JPanel panel1 = new JPanel();
        panel1.setSize(100, 50);
        JLabel label1 = new JLabel("Öğrenci No:");
        label1.setBounds(50, 50, 200, 30);
        JTextField jtf1 = new JTextField(20);
        JButton bt1 = new JButton("Giriş");
        panel1.add(label1);
        panel1.add(jtf1);
        bt1.setBounds(130, 100, 100, 40);
        panel1.add(bt1);
        add(panel1);
        
        JPanel panel2 = new JPanel();
        panel1.setSize(100, 50);
        
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oNo = jtf1.getText();

                File file = new File(oNo + ".txt");
                if (file.exists()) {
                    remove(panel1);
                    add(panel2);
                } else {
                    jtf1.setText("");
                }
            }

        });
        
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }
}
