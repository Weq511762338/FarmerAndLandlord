package game;

import domain.Poker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameJFrame extends JFrame implements ActionListener {

    public static Container container = null;

    // rob landlord or not
    JButton[] robLandlord = new JButton[2];

    // play or pass
    JButton[] playCard = new JButton[2];

    JLabel landlord;

    // 0->left, 1->user, 2->right
    // card current in hold
    ArrayList<ArrayList<Poker>> currentList = new ArrayList<ArrayList<Poker>>();

    // cards in hand
    ArrayList<ArrayList<Poker>> playerList = new ArrayList<ArrayList<Poker>>();

    ArrayList<Poker> lordList = new ArrayList<Poker>();

    ArrayList<Poker> pokerList = new ArrayList<Poker>();

    JTextField time[] = new JTextField[3];

    public GameJFrame(){
        setIconImage(Toolkit.getDefaultToolkit().getImage("image/poker/dizhu.png"));
        initJFrame();
        initView();
        this.setVisible(true);
    }

    private void initView() {
        // rob landlord button
        JButton robBut = new JButton("Rob Landlord");
        robBut.setBounds(320, 400, 75, 20);
        robBut.addActionListener(this);
        robBut.setVisible(false);
        robLandlord[0] = robBut;
        container.add(robBut);

        // no rob button
        JButton noBut = new JButton("No");
        noBut.setBounds(420, 400, 75, 20);
        noBut.addActionListener(this);
        noBut.setVisible(false);
        robLandlord[1] = noBut;
        container.add(noBut);

        // play button
        JButton playBut = new JButton("Play");
        playBut.setBounds(320, 400, 60, 20);
        playBut.addActionListener(this);
        playBut.setVisible(false);
        playCard[0] = playBut;
        container.add(playBut);

        // pass button
        JButton passBut = new JButton("Pass");
        passBut.setBounds(420, 400, 60, 20);
        passBut.addActionListener(this);
        passBut.setVisible(false);
        playCard[1] = passBut;
        container.add(passBut);

        // timer
        for(int i = 0; i < 3; i++){
            time[i] = new JTextField("Timer: ");
            time[i].setEditable(false);
            time[i].setVisible(false);
            container.add(time[i]);
        }
        time[0].setBounds(140,230, 60, 20);
        time[1].setBounds(374, 360, 60, 20);
        time[2].setBounds(620, 230, 60, 20);

        landlord = new JLabel(new ImageIcon("images/dizhu.png"));
        landlord.setVisible(false);
        landlord.setSize(40, 40);
        container.add(landlord);
    }

    private void initJFrame() {
        this.setTitle("FarmerAndLandlord");
        this.setSize(830, 620);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
