package main.GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame {

    public Login() {
        JButton bt1 = new JButton("Yönetici");
        bt1.setBounds(130, 100, 100, 40);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManagerFr form = new ManagerFr();
                setVisible(false);
            }

        });
        JButton bt2 = new JButton("Öğrenci");
        bt2.setBounds(130, 100, 100, 40);
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OgLog form = new OgLog();
                setVisible(false);
            }

        });
        JButton bt3 = new JButton("Şifre Değiştir");
        bt3.setBounds(130, 100, 100, 40);
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pass form = new Pass();
                setVisible(false);
            }

        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(200, 200);
        add(bt1);
        add(bt2);
        add(bt3);
        setVisible(true);
    }
}
