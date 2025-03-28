package entities;

import weapons.Basic_Sword;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Enemy_Goblin extends Enemy{
    private Basic_Sword sword;
    public Enemy_Goblin(int x, int y, ArrayList<entity> entities) {
        super(x,y,entities,new Basic_Sword());
        this.sword = new Basic_Sword();
        setHealth(100);
        setEquiped_Weapon(sword);
        setH(60);
        setW(70);
        setHasCollision(true);
        this.setOpaque(false);
        setSpeed(2);
        setRangeToAgro(300);
        setRangeToHit(100);
        loadTexture();
    }
    public void loadTexture(){
        for (int i =0 ; i<=3;i++){
            for(int j =0 ; j<=1;j++){
                Image texture1 = new ImageIcon("assets\\entityTexture\\Entity_Goblin\\Entity_Goblin"+i+j+".png").getImage();
                addTexture(texture1);
            }
        }
    } @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image texture = null;
        Image texture2 = null;
;

//         Select texture pair based on rotation
        if (this.getRotated() == 0) {
            texture = this.getTextures().get(0);
            texture2 = this.getTextures().get(1);
        } else if (this.getRotated() == 1) {
            texture = this.getTextures().get(2);
            texture2 = this.getTextures().get(3);
        } else if (this.getRotated() == 2) {
            texture = this.getTextures().get(4);
            texture2 = this.getTextures().get(5);
        } else if (this.getRotated() == 3) {
            texture = this.getTextures().get(6);
            texture2 = this.getTextures().get(7);
        }

        Image currentTexture = texture;
        if (texture != null && texture2 != null) {
            if ((this.getAnimationFrame()/ this.getANIMATION_SPEED()) % 2 == 0) {
                currentTexture = texture;
            } else {
                currentTexture = texture2;
            }
            g.drawImage(currentTexture, 0, 0, getWidth(), getHeight(), null);
        } else {
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        if(this.isMoving()){
            this.setAnimationFrame(this.getAnimationFrame()+1);
        }
        if (this.getAnimationFrame()> 1000) {
            this.setAnimationFrame(0);
        }
    }
}
