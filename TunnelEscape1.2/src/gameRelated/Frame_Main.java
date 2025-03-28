package gameRelated;
import entities.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Frame_Main extends JFrame {

    //?PROPS
    private int HEIGHT ;
    private int WIDTH ;

    //?ADDONS
    private Panel_Stats panel_stats = new Panel_Stats();
    private Panel_Game panel_game = new Panel_Game();

    public Frame_Main() {
       settingGeneralSize();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(WIDTH,HEIGHT);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setFocusable(true);
        this.getContentPane().setBackground(Color.black);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                panel_game.keyPressed(e);
            }
            public void keyReleased(KeyEvent e) {
                panel_game.keyReleased(e);
            }
        });
        //?ADDING
        panel_game.setLocation(0,0);
        panel_game.setSize(WIDTH,HEIGHT-155);
        this.add(panel_game);

        panel_stats.setLocation(0,HEIGHT -150);
        panel_stats.setSize(WIDTH,150);
        this.add(panel_stats);
    }
    private void settingGeneralSize(){Screen_Adapter fileRW = new Screen_Adapter();
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    HEIGHT = screenSize.height;
    WIDTH = screenSize.width;
    int gamePanelHeight = HEIGHT-150;
    fileRW.writeInFile("H :" + gamePanelHeight+ " W :" + WIDTH);
    }
    public void update(){
        panel_game.update();
    }
    public Panel_Game getPanel_game() {
        return panel_game;
    }
}
