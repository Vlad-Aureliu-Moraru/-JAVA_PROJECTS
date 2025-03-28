package weapons;

import entities.TextureRotation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Basic_Sword extends weapon {

    private TextureRotation textureRotation = new TextureRotation();
    private ArrayList<Image> slashes0 = new ArrayList<>(); // First sprite rotations
    private ArrayList<Image> slashes1 = new ArrayList<>(); // Second sprite rotations


    public Basic_Sword() {
        this.setName("Basic Sword");
        this.setAtackDamage(25);
        this.setAtackSpeed(200); // Total animation time
        this.setCooldown(500);   // Time before next attack
        this.setHeight(70);
        this.setWidth(70);
        this.setVisible(false);
        this.setOpaque(false);
        loadTextures();
        setupTimer();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image texture = null;
        ArrayList<Image> activeSlashes = (this.getFrame()== 0) ? slashes0 : slashes1;

        if (this.getRotated() == 0) {
            texture = activeSlashes.get(0); // 0°
        } else if (this.getRotated() == 1) {
            texture = activeSlashes.get(2); // 180°
        } else if (this.getRotated() == 2) {
            texture = activeSlashes.get(3); // 270°
        } else if (this.getRotated() == 3) {
            texture = activeSlashes.get(1); // 90°
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
            File inputFile0 = new File("assets\\weaponTexture\\Basic_Sword\\slash.png");
            File inputFile1 = new File("assets\\weaponTexture\\Basic_Sword\\slash1.png");
            BufferedImage originalImage0 = ImageIO.read(inputFile0);
            BufferedImage originalImage1 = ImageIO.read(inputFile1);

            for (int angle = 0; angle <= 270; angle += 90) {
                BufferedImage rotatedImage0 = textureRotation.rotateImage(originalImage0, angle);
                BufferedImage rotatedImage1 = textureRotation.rotateImage(originalImage1, angle);

                slashes0.add(rotatedImage0.getScaledInstance(rotatedImage0.getWidth(), rotatedImage0.getHeight(), Image.SCALE_SMOOTH));
                slashes1.add(rotatedImage1.getScaledInstance(rotatedImage1.getWidth(), rotatedImage1.getHeight(), Image.SCALE_SMOOTH));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    // Call this to start the attack animation

}