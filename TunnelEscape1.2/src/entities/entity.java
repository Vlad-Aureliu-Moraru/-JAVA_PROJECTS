package entities;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class entity extends JPanel {
    //?PROPS
    private boolean hasCollision;
    private int X,Y;
    private int Height,Width;
    private static int HEIGHT,WIDTH;
    private ArrayList<Image> textures = new ArrayList<>();

    //?CONSTRUCTOR
    public entity(int x, int y) {
        this.X = x;
        this.Y = y;

    } public int getY() {
        return Y;
    }

    //?METHODS

    public ArrayList<Image> getTextures() {
        return textures;
    }
    public void addTexture(Image texture) {
        textures.add(texture);
    }
    public void setYCoord(int y) {
        this.Y= y;
    }
    public int getX() {
        return X;
    }
    public void setXCoord(int x) {
        this.X = x;
    }
    public int getHeight() {
        return Height;
    }
    public void setH(int Height) {
        this.Height = Height;
        HEIGHT = Height;
    }
    public int getWidth() {
        return Width;
    }
    public void setW(int Width) {
        this.Width = Width;
        WIDTH = Width;
    }
    public boolean hasCollision() {
        return hasCollision;
    }
    public void setHasCollision(boolean hasCollision) {
        this.hasCollision = hasCollision;
    }
    public Rectangle getHitBox() {
        return new Rectangle(X,Y,Width,Height);
    }
    public boolean collide(entity e) {
        Rectangle hitBox = getHitBox();
        Rectangle collidedBox = e.getHitBox();
        return hitBox.intersects(collidedBox);
    }
    public boolean intersects(int x,int y,int width,int height) {
        Rectangle hitBox = getHitBox();
        Rectangle otherHitBox = new Rectangle(x,y,width,height);
        return hitBox.intersects(otherHitBox);
    }
    public static int getGeneralWidth() {
        return WIDTH;
    }
    public static int getGeneralHeight() {
        return HEIGHT;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(this.getClass().getName());
        return str.toString();
    }
}

