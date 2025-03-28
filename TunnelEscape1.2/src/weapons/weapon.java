package weapons;

import java.awt.*;
import java.util.ArrayList;
import entities.*;

import javax.swing.*;

public class weapon extends JPanel {
   private int x,y;
   private int cooldown;
   private int atackDamage;
   private int atackSpeed;
   private int height,width;
   private ArrayList<Image> textures = new ArrayList<>();
   private ArrayList<Image> slashes = new ArrayList<>();
   private int rotated;
   private String name;
   private boolean isActive = false;
   private boolean isAttacking = false; // Track attack state
   private int frame = 0; // 0 for slash0, 1 for slash1
   private Timer attackTimer; // For animation timing
   private int frames = 2;
   //!for alternating atack sprites
//   private int attackCounter = 0; // To alternate between sprites


//   public void triggerAttack() {
//        attackCounter++; // Increment to alternate sprites
//        this.setVisible(true); // Show the sword
//        repaint(); // Redraw with the new sprite
//        // Add cooldown logic here if not handled elsewhere
//    }
//
//   public int getAttackCounter() {
//      return attackCounter;
//   }

   public void setFrames(int frames) {
      this.frames = frames;
   }
   public void setRotated(int rotated) {
      this.rotated = rotated;
   }

   public int getRotated() {
      return rotated;
   }

   public boolean isActive() {
      return isActive;
   }
   public void setActive(boolean active) {
      isActive = active;
   }
   public void activate(){
      if(!isActive){
         this.setBackground(Color.RED);
         this.setOpaque(false);
         isActive = true;
      }else {
         this.setBackground(Color.WHITE);
         this.setOpaque(true);
         isActive = false;
      }
   }
   public int getX() {
      return x;
   }

   public void setX(int x) {
      this.x = x;
   }

   // Getter and Setter for y
   public int getY() {
      return y;
   }

   public void setY(int y) {
      this.y = y;
   }

   // Getter and Setter for cooldown
   public int getCooldown() {
      return cooldown;
   }

   public void setCooldown(int cooldown) {
      if (cooldown >= 0) { // Ensure cooldown is non-negative
         this.cooldown = cooldown;
      } else {
         System.out.println("Cooldown cannot be negative.");
      }
   }

   // Getter and Setter for atackDamage
   public int getAtackDamage() {
      return atackDamage;
   }

   public void setAtackDamage(int atackDamage) {
      if (atackDamage >= 0) { // Ensure attack damage is non-negative
         this.atackDamage = atackDamage;
      } else {
         System.out.println("Attack damage cannot be negative.");
      }
   }

   // Getter and Setter for atackSpeed
   public int getAtackSpeed() {
      return atackSpeed;
   }

   public void setAtackSpeed(int atackSpeed) {
      if (atackSpeed >= 0) { // Ensure attack speed is non-negative
         this.atackSpeed = atackSpeed;
      } else {
         System.out.println("Attack speed cannot be negative.");
      }
   }

   // Getter and Setter for height
   public int getHeight() {
      return height;
   }

   public void setHeight(int height) {
      if (height > 0) { // Ensure height is positive
         this.height = height;
      } else {
         System.out.println("Height must be greater than zero.");
      }
   }

   // Getter and Setter for width
   public int getWidth() {
      return width;
   }

   public void setWidth(int width) {
      if (width > 0) { // Ensure width is positive
         this.width = width;
      } else {
         System.out.println("Width must be greater than zero.");
      }
   }
   public Rectangle getHitbox() {
      return new Rectangle(x,y,width,height);
   }
   public boolean colides(entity e){
      Rectangle hitbox = getHitbox();
      return hitbox.intersects(e.getHitBox());
   }
   // Getter and Setter for textures
   public ArrayList<Image> getTextures() {
      return textures;
   }

   public void setTextures(ArrayList<Image> textures) {
      this.textures = textures;
   }
   public void addTexture(Image texture) {
      textures.add(texture);
   }

   // Getter and Setter for slashes
   public ArrayList<Image> getSlashes() {
      return slashes;
   }
   public void addSlash(Image slash) {
      slashes.add(slash);
   }
   public void setSlashes(ArrayList<Image> slashes) {
      this.slashes = slashes;
   }

   // Getter and Setter for name
   public String getName() {
      return name;
   }
   public void switchHW(){
      int temp = height;
      height = width;
      width = temp;
   }

   public void setName(String name) {
      if (name != null && !name.isEmpty()) { // Ensure name is not null or empty
         this.name = name;
      } else {
         System.out.println("Name cannot be null or empty.");
      }
   }
   public void setupTimer() {
      int frameTime = this.getAtackSpeed() / frames; // 100ms per frame if attackSpeed is 200ms
      attackTimer = new Timer(frameTime, e -> {
         if (isAttacking) {
            frame = (frame + 1) % 2; // Switch between 0 and 1
            repaint(); // Redraw with new frame
            if (frame == 0) { // After second frame, stop attack
               isAttacking = false;
               this.setVisible(false);
               attackTimer.stop();
            }
         }
      });
   }
   public void triggerAttack() {
      if (!isAttacking) { // Prevent overlapping attacks
         isAttacking = true;
         frame = 0; // Start with first sprite
         this.setVisible(true);
         attackTimer.start(); // Begin animation
      }
   }

   // Optionally reset manually, though timer handles it
   public void resetAttack() {
      isAttacking = false;
      this.setVisible(false);
      attackTimer.stop();
   }
   public int getFrame() {
      return frame;
   }
}

