package main.GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OgLog extends JFrame {

    public OgLog() {
        JPanel panel1 = new JPanel();
        panel1.setSize(100, 50);
        JLabel label1 = new JLabel("T.C Kimlik No:");
        label1.setBounds(50, 50, 200, 30);
        JTextField jtf1 = new JTextField(20);
        panel1.add(label1);
        panel1.add(jtf1);
        JPanel panel2 = new JPanel();
        panel2.setSize(100, 50);
        JLabel label2 = new JLabel("Okul No:");
        label2.setBounds(50, 50, 200, 30);
        JTextField jtf2 = new JTextField(20);
        panel2.add(label2);
        panel2.add(jtf2);
        JPanel panel3 = new JPanel();
        panel3.setSize(100, 50);
        JLabel label3 = new JLabel("Şifre:");
        label3.setBounds(50, 50, 200, 30);
        JTextField jtf3 = new JTextField(20);
        panel3.add(label3);
        panel3.add(jtf3);
        JPanel panel4 = new JPanel();
        panel3.setSize(100, 50);
        JButton bt1 = new JButton("Geri");
        bt1.setBounds(130, 100, 100, 40);
        JButton bt2 = new JButton("Giriş");
        bt1.setBounds(130, 100, 100, 40);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login form = new Login();
                setVisible(false);
            }

        });
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileInputStream input = null;
                try {
                    String okulNo = jtf2.getText();
                    String txt = "";
                    File file = new File(okulNo + ".txt");
                    input = new FileInputStream(file);
                    int character;
                    try {
                        while ((character = input.read()) != -1) {
                            txt += (char) character;
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(OgLog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String[] infos = txt.split(",");
                    String pass = infos[1];
                    String tc = infos[2];
                    if ((pass.equals(jtf3.getText())) && (tc.equals(jtf1.getText()))) {
                        AnaOgrenciPage form = new AnaOgrenciPage();
                        form.show();
                        form.oNo = okulNo;
                        setVisible(false);
                    } else {
                        String message = "Yanlış Girdiniz.\n";
                        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(OgLog.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        input.close();
                    } catch (IOException ex) {
                        Logger.getLogger(OgLog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });
        panel4.add(bt1);
        panel4.add(bt2);
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }
}
