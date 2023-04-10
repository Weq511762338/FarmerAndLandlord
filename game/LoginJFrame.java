package game;

import domain.User;
import util.CodeUtil;

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
    JDialog dialog = new JDialog();

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

        String codeStr = CodeUtil.getCode();
        Font rightCodeFont = new Font(null, 1, 15);
        rightCode.setForeground(Color.RED);
        rightCode.setFont(rightCodeFont);
        rightCode.setText(codeStr);
        rightCode.addMouseListener(this);
        rightCode.setBounds(400, 133, 100, 30);
        this.getContentPane().add(rightCode);

        // login Button
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("image/login/login.png"));
        login.setBorderPainted(false);
        login.setContentAreaFilled(false);
        login.addMouseListener(this);
        this.getContentPane().add(login);

        // register button
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("image/login/register.png"));
        register.setBorderPainted(false);
        register.setContentAreaFilled(false);
        register.addMouseListener(this);
        this.getContentPane().add(register);

        JLabel background = new JLabel(new ImageIcon("image/login/background.png"));
        background.setBounds(0, 0, 633, 423);
        this.getContentPane().add(background);
    }

    public void showJDialog(String content){
        JDialog jDialog = new JDialog();
        jDialog.setSize(200, 150);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setModal(true);
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);
        jDialog.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();

        if(obj == register) {
            String usernameInput = username.getText();
            String passwordInput = password.getText();
            String codeInput = code.getText();

            if (dialog.isVisible()) {
                dialog.requestFocus();
                return;
            }

            if (codeInput.length() == 0) {
                showJDialog("the code can't be null");
                return;
            }

            if (usernameInput.length() == 0 || passwordInput.length() == 0) {
                showJDialog("username or password can't be null");
                return;
            }

            if(!codeInput.equalsIgnoreCase(rightCode.getText())){
                showJDialog("wrong code");
                return;
            }

            User userInfo = new User(usernameInput, passwordInput);
            if (allUsers.contains(userInfo)) {
                this.setVisible(false);
                new GameJFrame();
            } else {
                showJDialog("wrong username or password");
            }
        } else if(obj == register){
            System.out.println("user requested to register...");
        } else if(obj == rightCode){
            String code = CodeUtil.getCode();
            rightCode.setText(code);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == login){
            login.setIcon(new ImageIcon("image/login/loginPressed.png"));
        }else if(e.getSource() == register){
            register.setIcon(new ImageIcon("image/login/registerPressed.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == login){
            login.setIcon(new ImageIcon("image/login/login.png"));
        }else if(e.getSource() == register){
            register.setIcon(new ImageIcon("image/login/register.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
