package domain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Poker extends JLabel implements MouseListener{

    private String name;

    private boolean front;

    private boolean canBeClicked = false;

    private boolean clicked = false;

    public Poker(String name, boolean front){
        this.name = name;
        this.front = front;

        if(this.front){
            this.showFront();
        }else{
            this.showRear();
        }

        this.setSize(71, 96);
        this.setVisible(true);
        this.addMouseListener(this);
    }

    public void showFront(){
        this.setIcon(new ImageIcon("image/poker/" + name + ".png"));
        this.front = true;

    }

    public void showRear(){
        this.setIcon(new ImageIcon("image/poker/rear.png"));
        this.front = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(canBeClicked){

            int step = 0;
            if(clicked){
                step = 20;
            }else{
                step = -20;
            }
            clicked = !clicked;

            Point from = this.getLocation();
            Point to = new Point(from.x, from.y + step);
            this.setLocation(to);
        }
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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public boolean isFront() {
        return front;
    }

    public void setFront(boolean front) {
        this.front = front;
    }

    public boolean isCanBeClicked() {
        return canBeClicked;
    }

    public void setCanBeClicked(boolean canBeClicked) {
        this.canBeClicked = canBeClicked;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}