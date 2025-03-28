package entities;

import gameRelated.Screen_Adapter;

import java.awt.*;

public class Entity_Door extends entity {
    private Screen_Adapter screen = new Screen_Adapter();
    private int Height;
    private int Width;
    public Entity_Door(int x,int y) {
       super(x,y);
       this.setBackground(Color.RED);
       this.setOpaque(true);
        this.setHasCollision(false);
        Height = (int)screen.getH()/16;
        Width = (int)screen.getW()/32;
        this.setH(Height);
        this.setW(Width);
    }
}
