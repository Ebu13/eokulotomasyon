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
import javax.swing.*;

public class ManagerFr extends JFrame {

    public ManagerFr() {
        JPanel panel1 = new JPanel();
        panel1.setSize(100, 50);
        JLabel label1 = new JLabel("Kullanici Adi");
        label1.setBounds(50, 50, 200, 30);
        JTextField jtf1 = new JTextField(20);
        panel1.add(label1);
        panel1.add(jtf1);
        JPanel panel2 = new JPanel();
        panel2.setSize(100, 50);
        JLabel label2 = new JLabel("Şifre");
        label2.setBounds(50, 50, 200, 30);
        JTextField jtf2 = new JTextField(20);
        panel2.add(label2);
        panel2.add(jtf2);
        JPanel panel3 = new JPanel();
        panel3.setSize(100, 50);
        JButton bt1 = new JButton("Geri");
        bt1.setBounds(130, 100, 100, 40);
        JButton bt2 = new JButton("Giriş");
        bt1.setBounds(130, 100, 100, 40);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Login form = new Login();
            }

        });
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileInputStream input = null;
                try {
                    String user = jtf1.getText();
                    String pass = jtf2.getText();
                    String txt = "";
                    File file = new File(user + ".txt");
                    input = new FileInputStream(file);
                    int character;
                    try {
                        while ((character = input.read()) != -1) {
                            txt += (char) character;
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ManagerFr.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (pass.equals(txt)) {
                        if ("math".equals(user) || "ing".equals(user) || "turk".equals(user) || "fen".equals(user) || "sosyal".equals(user)) {
                            TeacherPane form = new TeacherPane();
                            form.branch = user;
                            form.show();
                            setVisible(false);
                        } else if ("principal".equals(user) || "principalassistant".equals(user)) {
                            ManagerPane form = new ManagerPane();
                            form.show();
                            setVisible(false);
                            form.devampane.setVisible(false);
                        }
                    } else {
                        String message = "Yanlış Girdiniz.\n";
                        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ManagerFr.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        input.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ManagerFr.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });
        panel3.add(bt1);
        panel3.add(bt2);
        add(panel1);
        add(panel2);
        add(panel3);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }
}
