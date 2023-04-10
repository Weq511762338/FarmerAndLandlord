package game;

import domain.Poker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

        initCard();
        initGame();
    }

    private void initGame() {
        for(int i = 0; i < 3; i++){
            ArrayList<Poker> list = new ArrayList<>();
            currentList.add(list);
        }

        robLandlord[0].setVisible(true);
        robLandlord[1].setVisible(true);

        for(JTextField field : time){
            field.setText("Timer 30 sec");
            field.setVisible(true);
        }
    }

    private void initCard() {
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= 13; j++){
                if((i == 5) && (j > 2)){
                    break;
                }else{
                    Poker poker = new Poker(i + "-" + j, false);
                    poker.setLocation(350, 150);
                    pokerList.add(poker);
                    container.add(poker);
                }
            }
        }

        Collections.shuffle(pokerList);

        ArrayList<Poker> p0 = new ArrayList<>();
        ArrayList<Poker> p1 = new ArrayList<>();
        ArrayList<Poker> p2 = new ArrayList<>();

        for(int i = 0; i < pokerList.size(); i++){
            Poker poker = pokerList.get(i);

            if(i <= 2){
                lordList.add(poker);
                Common.move(poker, poker.getLocation(), new Point(270 + (75*i), 10));
                continue;
            }

            if (i % 3 == 0) {
                Common.move(poker, poker.getLocation(), new Point(50, 60 + i * 5));
                p0.add(poker);
            } else if (i % 3 == 1) {
                Common.move(poker, poker.getLocation(), new Point(180 + i * 7, 450));
                p1.add(poker);
                poker.showFront();
            } else if (i % 3 == 2) {
                Common.move(poker, poker.getLocation(), new Point(700, 60 + i * 5));
                p2.add(poker);
            }

            container.setComponentZOrder(poker, 0);
        }

        playerList.add(p0);
        playerList.add(p1);
        playerList.add(p2);

        for(int i = 0; i < 3; i++){
            order(playerList.get(i));
            Common.rePosition(this, playerList.get(i), i);
        }
    }

    public void order(ArrayList<Poker> list) {
        Collections.sort(list, new Comparator<Poker>() {
            @Override
            public int compare(Poker o1, Poker o2) {
                int color1 = Integer.parseInt(o1.getName().substring(0, 1));
                int value1 = getValue(o1);

                int color2 = Integer.parseInt(o2.getName().substring(0, 1));
                int value2 = getValue(o2);

                int flag = value1 - value2;

                if (flag == 0){
                    return color1 - color2;
                }else {
                    return flag;
                }
            }
        });
    }

    public int getValue(Poker poker) {
        String name = poker.getName();
        int color = Integer.parseInt(poker.getName().substring(0, 1));
        int value = Integer.parseInt(name.substring(2));
        if (color == 5){
            return value += 100;
        }

        if (value == 1){
            return value += 20;
        }

        if (value == 2){
            return value += 30;
        }

        return value;
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
        landlord.setVisible(true);
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
        if(e.getSource() == robLandlord[0]){
            time[1].setText("Rob Landlord");
            ArrayList<Poker> p1 = playerList.get(1);
            p1.addAll(lordList);
            lordList.clear();
            order(playerList.get(1));
            for (Poker poker : p1) {
                poker.showFront();
            }
            Common.rePosition(this, playerList.get(1), 1);
        } else if (e.getSource() == robLandlord[1]) {
            time[1].setText("No");
        } else if (e.getSource() == playCard[1]) {
            time[1].setText("Pass");
        } else if (e.getSource() == playCard[0]) {
            time[1].setText("Play");
        }
    }
}
