package game;

import domain.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LoginJFrame {

    static ArrayList<User> allUsers = new ArrayList<>();

    static{
        allUsers.add(new User("jack", "123"));
    }

    JFrame frame = new JFrame();


    JButton login = new JButton();
    JButton register = new JButton();
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();

    JLabel rightCode = new JLabel();

    public LoginJFrame(){
        initJFrame();
        initView();

        frame.setVisible(true);
    }



    private void initJFrame() {
        frame.setSize(633, 423);
        frame.setTitle("Poker Login");
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setLayout(null);
    }

    private void initView() {
        // username
        Font usernameFont = new Font(null, 1, 16);
        JLabel usernameText = new JLabel("Username");
        usernameText.setForeground(Color.WHITE); // TODO: whats the diff?
        usernameText.setFont(usernameFont);
        usernameText.setBounds(140, 55, 55, 22);
        frame.getContentPane().add(username);

        username.setBounds(223, 46, 200, 30);
        frame.getContentPane().add(username);

        // password
        Font passwordFont = new Font(null, 1, 16);
        JLabel passwordText = new JLabel("Password");
        passwordText.setForeground(Color.WHITE); // TODO: whats the diff?
        passwordText.setFont(passwordFont);
        passwordText.setBounds(140, 55, 55, 22);
        frame.getContentPane().add(password);

        password.setBounds(263, 87, 160, 30);
        frame.getContentPane().add(password);


    }
}
