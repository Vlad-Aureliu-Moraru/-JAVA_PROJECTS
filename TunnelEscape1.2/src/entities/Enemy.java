package entities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import weapons.*;

import javax.swing.*;

public class Enemy extends liveEntity {
    private int x, y;
    private List<entity> entities;
    private int rangeToHit=50;
    private int rangeToAgro=200;
    private int animationFrame = 0;
    private int ANIMATION_SPEED = 10;
    private boolean moving = false;
    private int rotated=1;
    private weapon Equiped_Weapon ;
    private int weaponCenterX ;
    private Timer atackSpeed;
    private Timer atackCooldown;
    private boolean timerActive = false;
    private boolean onCooldown =false;
    private Entity_Player player;
    public Enemy(int x, int y, List<entity> entities, weapon Equiped_Weapon) {
        super(x, y);
        this.Equiped_Weapon = Equiped_Weapon;
        this.Equiped_Weapon.setX(this.getX());
        this.Equiped_Weapon.setY(this.getY()+50);
        this.Equiped_Weapon.setVisible(false);
        this.x = x;
        this.y = y;
        this.entities = entities;
        this.weaponCenterX = (Equiped_Weapon != null) ? (int) Equiped_Weapon.getWidth() / 2 : 0;
        atackCooldown = new Timer(Equiped_Weapon.getCooldown(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(onCooldown){
                    onCooldown = false;
                }
            }
        });
        atackCooldown.setRepeats(false);
    }

    public void setEquiped_Weapon(weapon equiped_Weapon) {
        Equiped_Weapon = equiped_Weapon;
    }
    public weapon getEquiped_Weapon(){
        return Equiped_Weapon;
    }

    public void setRangeToHit(int range) {
        this.rangeToHit = range;
    }
    public void setRangeToAgro(int range) {
        this.rangeToAgro = range;
    }
    public void moveToward(int targetX, int targetY) {
        int dx = targetX - x;
        int dy = targetY - y;
        int distance = (int) Math.sqrt(dx * dx + dy * dy);
        if (distance >rangeToHit && distance<rangeToAgro) {
            rotated = this.determineFacingDirection(dx, dy);
            moving = true;
            rotateHitbox(rotated);
//            this.setBackground(Color.GREEN);
            int moveX = (dx * getSpeed()) / distance;
            int moveY = (dy * getSpeed()) / distance;
            int newX = x + moveX;
            int newY = y + moveY;

            int oldX = x, oldY = y;
            setXCoord(newX);
            setYCoord(newY);
            x = newX;
            y = newY;

            if (!checkForCollisions(this)) {
            } else {
                setXCoord(oldX);
                setYCoord(oldY);
                x = oldX;
                y = oldY;
            }
        } else if (distance>rangeToAgro){
            moving = false;
        }
        else if (distance <=rangeToHit) {
            //!ATTACK LOGIC
            if (player!=null && !onCooldown) {
                player.setHasBeenAttacked(false);
            }
            this.attack();
            if(Equiped_Weapon.isActive()){
            for (entity entity : entities) {
                if (entity instanceof Entity_Player && entity.hasCollision()) {
                    player = (Entity_Player) entity;
                    if (!((Entity_Player) entity).getHasBeenAttacked() && this.weaponColision(entity)) {
                        System.out.println("Attacking");
                        Equiped_Weapon.triggerAttack();
                        ((Entity_Player) entity).addHealth(-Enemy.this.getEquiped_Weapon().getAtackDamage());
                        ((Entity_Player) entity).setHasBeenAttacked(true);
                    }
                    if (((Entity_Player) entity).isDead()) {
                        entity.setHasCollision(false);
                    }
                }
            }
            }
            moving = false;
        }
    }

    private boolean checkForCollisions(entity e) {
        for (entity entity : entities) {
            if (entity.equals(e)) {
                continue; // Skip self
            }
            if (e.collide(entity) && entity.hasCollision()) {
                return true;
            }
        }
        return false;
    }

    public boolean isMoving() {
        return moving;
    }

    public int getRotated() {
        return rotated;
    }

    public int getANIMATION_SPEED() {
        return ANIMATION_SPEED;
    }

    public int getAnimationFrame() {
        return animationFrame;
    }
    public void setAnimationFrame(int animationFrame) {
        this.animationFrame = animationFrame;
    }
    private int determineFacingDirection(int dx, int dy) {
        if (Math.abs(dx) > Math.abs(dy)) {
            if (dx > 0) {
                return 3;
            } else if (dx < 0) {
                return 2;
            }
        } else {
            if (dy > 0) {
                return 1;
            } else if (dy < 0) {
                return 0;
            }
        }
        return 1;
    }

    public void rotateHitbox(int angle){
        if (angle ==1){
            if(rotated==2 || rotated==3){
                Equiped_Weapon.switchHW();
            }
            Equiped_Weapon.setX(this.getX()-(weaponCenterX-(int)(this.getWidth()/2)));
            Equiped_Weapon.setY(this.getY()+50);
//            rotated = 1;
            Equiped_Weapon.setRotated(rotated);
        } else if (angle ==0) {
            if(rotated==2 || rotated==3){
                Equiped_Weapon.switchHW();
            }
            Equiped_Weapon.setX(this.getX()-(weaponCenterX-(int)(this.getWidth()/2)));
            Equiped_Weapon.setY(this.getY()-Equiped_Weapon.getHeight());
//            rotated = 0;
            Equiped_Weapon.setRotated(rotated);
        } else if (angle ==3) {
            if(rotated==0 || rotated==1){
                Equiped_Weapon.switchHW();
            }
            Equiped_Weapon.setX(this.getX()+50);
            Equiped_Weapon.setY(this.getY()-(weaponCenterX-(int)(this.getHeight()/2)));
//            rotated = 3;
            Equiped_Weapon.setRotated(rotated);
        } else if (angle==2) {
            if(rotated==0 || rotated==1){
                Equiped_Weapon.switchHW();
            }
            Equiped_Weapon.setX(this.getX()-Equiped_Weapon.getWidth());
            Equiped_Weapon.setY(this.getY()-(weaponCenterX-(int)(this.getHeight()/2)));
//            rotated = 2;
            Equiped_Weapon.setRotated(rotated);

        }
    }
    public void attack() {
        if (!timerActive && !onCooldown) {
            onCooldown = true;
            this.setBackground(Color.PINK);
            Equiped_Weapon.setVisible(true);
            Equiped_Weapon.activate();
            atackSpeed = new Timer(Equiped_Weapon.getAtackSpeed(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timerActive = false;
                    Enemy.this.setBackground(Color.BLUE);
                    Equiped_Weapon.setVisible(false);
                    Equiped_Weapon.activate();
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
        return Equiped_Weapon.colides(e);
    }
}