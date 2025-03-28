package weapons;

import entities.TextureRotation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Spell_Tornado extends weapon {
    private TextureRotation textureRotation = new TextureRotation();
    private ArrayList<Image> slashes0 = new ArrayList<>(); // First sprite rotations
    private ArrayList<Image> slashes1 = new ArrayList<>(); // Second sprite rotations
    private ArrayList<Image> slashes2 = new ArrayList<>(); // Third sprite rotations
    private boolean isAttacking = false;
    private int frame = 0; // 0, 1, 2 for the three sprites
    private Timer attackTimer;

    public Spell_Tornado() {
        this.setName("Tornado Book");
        this.setAtackDamage(50);
        this.setAtackSpeed(300); // Total animation time
        this.setCooldown(2000);  // 2-second cooldown
        this.setHeight(120);
        this.setWidth(70);
        this.setOpaque(false);
        this.setVisible(false); // Start hidden
        loadTextures();
        setupTimer();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image texture = null;
        ArrayList<Image> activeSlashes;
        switch (frame) {
            case 0:
                activeSlashes = slashes0;
                break;
            case 1:
                activeSlashes = slashes1;
                break;
            case 2:
                activeSlashes = slashes2;
                break;
            default:
                activeSlashes = slashes0; // Fallback
        }

        if (this.getRotated() == 0) {
            texture = activeSlashes.get(0).getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        } else if (this.getRotated() == 1) {
            texture = activeSlashes.get(2).getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        } else if (this.getRotated() == 2) {
            texture = activeSlashes.get(3).getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        } else if (this.getRotated() == 3) {
            texture = activeSlashes.get(1).getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        }

        if (texture != null) {
            g.drawImage(texture, 0, 0, getWidth(), getHeight(), null);
        } else {
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    private void loadTextures() {
        try {
            // Load three sprites from the Spell_Tornado folder
            File inputFile0 = new File("assets\\weaponTexture\\Spell_Tornado\\slash.png");
            File inputFile1 = new File("assets\\weaponTexture\\Spell_Tornado\\slash1.png");
            File inputFile2 = new File("assets\\weaponTexture\\Spell_Tornado\\slash2.png");
            BufferedImage originalImage0 = ImageIO.read(inputFile0);
            BufferedImage originalImage1 = ImageIO.read(inputFile1);
            BufferedImage originalImage2 = ImageIO.read(inputFile2);

            for (int angle = 0; angle <= 270; angle += 90) {
                BufferedImage rotatedImage0 = textureRotation.rotateImage(originalImage0, angle);
                BufferedImage rotatedImage1 = textureRotation.rotateImage(originalImage1, angle);
                BufferedImage rotatedImage2 = textureRotation.rotateImage(originalImage2, angle);

                slashes0.add(rotatedImage0);
                slashes1.add(rotatedImage1);
                slashes2.add(rotatedImage2);

                // Optionally populate superclass list (if needed elsewhere)
                if (angle == 0) { // Only add one set to superclass to avoid breaking other logic
                    this.addSlash(rotatedImage0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setupTimer() {
        int frameTime = this.getAtackSpeed() / 3; // ~66ms per frame for 200ms total
        attackTimer = new Timer(frameTime, e -> {
            if (isAttacking) {
                frame = (frame + 1) % 3; // Cycle through 0, 1, 2
                repaint();
                if (frame == 0) { // After third frame, stop
                    isAttacking = false;
                    this.setVisible(false);
                    attackTimer.stop();
                }
            }
        });
    }

    public void triggerAttack() {
        if (!isAttacking) {
            isAttacking = true;
            frame = 0;
            this.setVisible(true);
            attackTimer.start();
        }
    }

    // Optional: For external control or debugging
    public void resetAttack() {
        isAttacking = false;
        this.setVisible(false);
        attackTimer.stop();
    }
}