package gameRelated;

import entities.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Panel_Game extends JPanel {
    //?ADDONS
    private ArrayList<entity> entities = new ArrayList();
    private GeneratedMap generatedMap = new GeneratedMap();
    private Entity_Player player = new Entity_Player(0,0);
    private boolean[] keysPressed = new boolean[256];
    private boolean stopGame = false;
    public Panel_Game() {
        this.setOpaque(false);
        this.setBackground(Color.GREEN);
        this.setLayout(null);
        this.add(player);
        this.add(player.getEquipedSword());
        this.addToEntities();
        this.loadEntities();
        System.out.println(generatedMap);

    }
    public void keyPressed(KeyEvent e) {
        keysPressed[e.getKeyCode()] = true;
    }
    public void keyReleased(KeyEvent e) {
        keysPressed[e.getKeyCode()] = false;
    }
    private boolean checkForCollisions(entity e) {
        for (entity entity : entities) {
            if (entity.equals(e)) {
                return false;

            }
            if (e.collide(entity) && entity.hasCollision() ) {
                System.out.println(entity);
                return true;
            }
        }
        return false;
    }
    private void updatePlayerPosition() {
        int newX = player.getX();
        int newY = player.getY();

        if (keysPressed[KeyEvent.VK_W]) {
            newY -= player.getSpeed();
        }
        if (keysPressed[KeyEvent.VK_S]) {
            newY += player.getSpeed();
        }
        if (keysPressed[KeyEvent.VK_A]) newX -= player.getSpeed();
        if (keysPressed[KeyEvent.VK_D]) newX += player.getSpeed();

        if (!willCollide(newX, newY)) {
            player.setXCoord(newX);
            player.setYCoord(newY);
        }
    }
    private boolean willCollide(int newX, int newY) {
        if (newX < 0 || newX + player.getWidth() > getWidth()) {
            return true;
        }
        if (newY < 0 || newY + player.getHeight() > getHeight()) {
            return true;
        }

        for (entity entity : entities) {
            if (entity != player && entity.intersects(newX, newY, player.getWidth(), player.getHeight()) && entity.hasCollision()) {
                return true;
            }
        }

        return false; // No collision detected
    }
    public void update() {
    updatePlayerPosition();
    updateEnemyPosition();
    processInput();
    if (player.isDead()){
            stopGame = true;
        }
    Panel_Game.this.repaint();
    Panel_Game.this.revalidate();
}
    private void loadEntities() {
        ArrayList<entity> floorEntities = new ArrayList<>();
        ArrayList<entity> wallEntities = new ArrayList<>();
        ArrayList<entity> enemies = new ArrayList<>();
        for (entity entity : entities) {
            if (entity instanceof Entity_Floor) {
                floorEntities.add(entity);
            }if(entity instanceof Entity_Wall || entity instanceof Entity_Door) {
                wallEntities.add(entity);
            }
            else if (entity instanceof Enemy) {
                enemies.add(entity);
            }
        }
        for (entity wallEntity : wallEntities) {
            Panel_Game.this.add(wallEntity);
        }
        for (entity enemie: enemies) {
            Panel_Game.this.add(enemie);
        }
        for (entity floorEntity : floorEntities) {
            Panel_Game.this.add(floorEntity);
        }


    }
    private void addToEntities() {
        for (int i = 0; i < generatedMap.getWidth(); i++) {
            for (int j = 0; j < generatedMap.getHeight(); j++) {
                if (generatedMap.getMap()[j][i]==1){
                    Entity_Wall wall = new Entity_Wall(i*Entity_Wall.getGeneralWidth(),j*Entity_Wall.getGeneralHeight());
                    entities.add(wall);
                }
                else if (generatedMap.getMap()[j][i]==0|| generatedMap.getMap()[j][i]==3){
                    Entity_Floor floor = new Entity_Floor(i*Entity_Floor.getGeneralWidth(),j*Entity_Floor.getGeneralHeight());
                    entities.add(floor);
                } else if (generatedMap.getMap()[j][i]==2 ) {
                    Entity_Door door = new Entity_Door(i*Entity_Door.getGeneralWidth(),j*Entity_Door.getGeneralHeight());
                    entities.add(door);
                } if (generatedMap.getMap()[j][i] == 3) {
                    player.setXCoord(i*Entity_Wall.getGeneralWidth());
                    player.setYCoord(j*Entity_Wall.getGeneralHeight());
                }
            }
        }
        Enemy_Goblin goblin = new Enemy_Goblin(100,100 ,entities);
        Enemy_Goblin goblin1 = new Enemy_Goblin(100,600,entities);
        entities.add(goblin);
        Panel_Game.this.add(goblin.getEquiped_Weapon());
        entities.add(goblin1);
        Panel_Game.this.add(goblin1.getEquiped_Weapon());
        entities.add(player);
    }
    private void processInput(){
        if(keysPressed[KeyEvent.VK_SPACE]) {
            reloadEnemies();
            if (!player.getOnCooldown()) {
                player.attack();
                for (entity entity : entities) {
                    if (entity instanceof Enemy && entity.hasCollision()) {
                        if (!((Enemy) entity).getHasBeenAttacked() && player.weaponColision(entity)) {
                            System.out.println("Attacking");
                            ((Enemy) entity).addHealth(-player.getEquipedSword().getAtackDamage());
                            ((Enemy) entity).setHasBeenAttacked(true);
                        }
                        if (((Enemy) entity).isDead()) {
                            entity.setHasCollision(false);
                        }
                    }
                }
            }
        }
        if (keysPressed[KeyEvent.VK_W]) {
            player.rotateHitbox(0);
        }
        if (keysPressed[KeyEvent.VK_S]) {
            player.rotateHitbox(1);
        }
        if (keysPressed[KeyEvent.VK_A]){
            player.rotateHitbox(2);
        }
        if (keysPressed[KeyEvent.VK_D]) {
            player.rotateHitbox(3);
        }
        if (keysPressed[KeyEvent.VK_W]||keysPressed[KeyEvent.VK_A]||keysPressed[KeyEvent.VK_D]||keysPressed[KeyEvent.VK_S]) {
            player.setMoving(true);
        }else{
            player.setMoving(false);
        }
    }
    private void reloadEnemies(){
        for (entity entity : entities) {
            if (entity instanceof Enemy){
                ((Enemy) entity).setHasBeenAttacked(false);
            }

        }
    }
    private void updateEnemyPosition(){
        for (entity entity : entities) {
            if (entity instanceof Enemy && entity.hasCollision() && !checkForCollisions(entity)) {
                ((Enemy) entity).moveToward(player.getX(), player.getY());
            }
        }
    }
    public boolean getStopGame() {
        return stopGame;
    }
}
