package entities;

import gameRelated.Screen_Adapter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Entity_Wall extends entity{
    private String texturePath = "assets\\mapTexture\\wallTexture\\mainWallTexture.png";
    private Image texture1;
    private Screen_Adapter screen = new Screen_Adapter();
    private int Height;
    private int Width;
    private TexturePicker texturePicker = new TexturePicker();
    public Entity_Wall(int x, int y) {
        super(x, y);
        Height = (int)(screen.getH())/16;
        Width = (int)screen.getW()/32;
        this.setH(Height);
        this.setW(Width);
        this.setHasCollision(true);
        this.setBackground(Color.GRAY);
        loadTextures();
    }
    private void loadTextures(){
        BufferedImage image = texturePicker.getRandomTexture(texturePath,this.Width,this.Height);
      texture1 = image.getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
      Image texture = texture1;

        if (texture!= null) {
            g.drawImage(texture, 0, 0, getWidth(), getHeight(), null);
        } else {
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
