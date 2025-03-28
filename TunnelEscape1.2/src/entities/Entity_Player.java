package entities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import weapons.*;

public class Entity_Player extends liveEntity{
private Timer atackSpeed;
private Timer atackCooldown;
private weapon equipedWeapon;
private int rotated=1;
private boolean timerActive = false;
private boolean onCooldown =false;
private int animationFrame = 0;
private int ANIMATION_SPEED = 10;
private boolean moving = false;
private TextureRotation textureRotation = new TextureRotation();
private int weaponCenterX;
//private int weaponCenterX = (int)equipedWeapon.getWidth()/2;


    public Entity_Player(int x,int y) {
        super(x,y);
        equipedWeapon = new Spell_Tornado();
        equipedWeapon.setX(this.getX());
        equipedWeapon.setY(this.getY()+50);
        equipedWeapon.setVisible(false);
        weaponCenterX = (int)equipedWeapon.getWidth()/2;
        this.setHasCollision(true);
        this.setH(50);
        this.setW(50);
        this.setSpeed(5);
        this.setHealth(10000);
        this.setBackground(Color.BLUE);
        this.setOpaque(false);
        atackCooldown = new Timer(equipedWeapon.getCooldown(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(onCooldown){
                    onCooldown = false;
                }
            }
        });
        atackCooldown.setRepeats(false);
        loadTexture();
    }
   public weapon getEquipedSword(){
        return equipedWeapon;
    }
    public void setEquipedSword(weapon weapon){
        this.equipedWeapon = weapon;
    }
   public void rotateHitbox(int angle){
        if (angle ==1){
            if(rotated==2 || rotated==3){
                equipedWeapon.switchHW();
            }
        equipedWeapon.setX(this.getX()-(weaponCenterX-(int)(this.getWidth()/2)));
        equipedWeapon.setY(this.getY()+50);
        rotated = 1;
        equipedWeapon.setRotated(rotated);
        } else if (angle ==0) {
            if(rotated==2 || rotated==3){
                equipedWeapon.switchHW();
            }
            equipedWeapon.setX(this.getX()-(weaponCenterX-(int)(this.getWidth()/2)));
            equipedWeapon.setY(this.getY()-equipedWeapon.getHeight());
            rotated = 0;
            equipedWeapon.setRotated(rotated);
        } else if (angle ==3) {
           if(rotated==0 || rotated==1){
                equipedWeapon.switchHW();
            }
            equipedWeapon.setX(this.getX()+50);
            equipedWeapon.setY(this.getY()-(weaponCenterX-(int)(this.getHeight()/2)));
            rotated = 3;
            equipedWeapon.setRotated(rotated);
        } else if (angle==2) {
            if(rotated==0 || rotated==1){
                equipedWeapon.switchHW();
            }
            equipedWeapon.setX(this.getX()-equipedWeapon.getWidth());
            equipedWeapon.setY(this.getY()-(weaponCenterX-(int)(this.getHeight()/2)));
            rotated = 2;
            equipedWeapon.setRotated(rotated);

        }
   }
   public void attack() {
        if (!timerActive && !onCooldown) {
            equipedWeapon.triggerAttack();
            onCooldown = true;
            Entity_Player.this.setBackground(Color.PINK);
            equipedWeapon.setVisible(true);
            equipedWeapon.activate();
            atackSpeed = new Timer(equipedWeapon.getAtackSpeed(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timerActive = false;
                    Entity_Player.this.setBackground(Color.BLUE);
                    equipedWeapon.setVisible(false);
                    equipedWeapon.activate();
                    repaint();
                    atackCooldown.start();
                }
            });
            timerActive = true;
            atackSpeed.setRepeats(false);
            atackSpeed.start();
        }
    }
   public boolean weaponColision(entity e){
        return equipedWeapon.colides(e);
    }
   public boolean getOnCooldown(){
        return onCooldown;
    }
   public void loadTexture(){
        for (int i =0 ; i<=3;i++){
            for(int j =0 ; j<=1;j++){
                Image texture1 = new ImageIcon("assets\\playerSprite\\player"+i+j+".png").getImage();
                addTexture(texture1.getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH));
            }
        }
}

   public void setMoving(boolean moving) {
        this.moving = moving;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image texture = null;
        Image texture2 = null;

        // Select texture pair based on rotation
        if (rotated == 0) {
            texture = this.getTextures().get(0);
            texture2 = this.getTextures().get(1);
        } else if (rotated == 1) {
            texture = this.getTextures().get(2);
            texture2 = this.getTextures().get(3);
        } else if (rotated == 2) {
            texture = this.getTextures().get(4);
            texture2 = this.getTextures().get(5);
        } else if (rotated == 3) {
            texture = this.getTextures().get(6);
            texture2 = this.getTextures().get(7);
        }

        Image currentTexture = null;
        if (texture != null && texture2 != null) {
            if ((animationFrame / ANIMATION_SPEED) % 2 == 0) {
                currentTexture = texture;
            } else {
                currentTexture = texture2;
            }
            g.drawImage(currentTexture, 0, 0, getWidth(), getHeight(), null);
        } else {
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        if(moving){
            animationFrame++;
        }
        if (animationFrame > 1000) animationFrame = 0;
    }
}
