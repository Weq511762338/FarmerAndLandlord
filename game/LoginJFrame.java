package game;

import domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener {

    static ArrayList<User> allUsers = new ArrayList<>();

    static{
        allUsers.add(new User("jack", "123"));
    }

    JButton login = new JButton();
    JButton register = new JButton();
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();

    JLabel rightCode = new JLabel();

    public LoginJFrame(){
        initJFrame();
        initView();

        this.setVisible(true);
    }

    private void initJFrame() {
        this.setSize(633, 423);
        this.setTitle("Poker Login");
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setLayout(null);
    }

    private void initView() {
        // username
        Font usernameFont = new Font(null, 1, 16);
        JLabel usernameText = new JLabel("Username");
        usernameText.setForeground(Color.black);
        usernameText.setFont(usernameFont);
        usernameText.setBounds(140, 55, 100, 22);
        this.getContentPane().add(usernameText);

        username.setBounds(223, 46, 200, 30);
        this.getContentPane().add(username);

        // password
        Font passwordFont = new Font(null, 1, 16);
        JLabel passwordText = new JLabel("Password");
        passwordText.setForeground(Color.black);
        passwordText.setFont(passwordFont);
        passwordText.setBounds(197, 95, 100, 22);
        this.getContentPane().add(passwordText);

        password.setBounds(263, 87, 160, 30);
        this.getContentPane().add(password);

        // code
        JLabel codeText = new JLabel("Code");
        Font codeFont = new Font(null, 1, 16);
        codeText.setForeground(Color.black);
        codeText.setFont(codeFont);
        codeText.setBounds(215, 142, 55, 22);
        this.getContentPane().add(codeText);

        code.setBounds(291, 133, 100, 30);
        this.getContentPane().add(code);

        // TODO: implement this if time permits
//        String codeStr = CodeUtil.getCode();
        String codeStr = "abc123";
        Font rightCodeFont = new Font(null, 1, 15);
        rightCode.setForeground(Color.RED);
        rightCode.setFont(rightCodeFont);
        rightCode.setText(codeStr);
        rightCode.addMouseListener(this);
        rightCode.setBounds(400, 133, 100, 30);
        this.getContentPane().add(rightCode);

        // login Button
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("images/login.png"));
        login.setBorderPainted(false);
        login.setContentAreaFilled(false);
        login.addMouseListener(this);
        this.getContentPane().add(login);

        // register button
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("images/register.png"));
        register.setBorderPainted(false);
        register.setContentAreaFilled(false);
        register.addMouseListener(this);
        this.getContentPane().add(register);

        JLabel background = new JLabel(new ImageIcon("images/background.png"));
        background.setBounds(0, 0, 633, 423);
        this.getContentPane().add(background);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
