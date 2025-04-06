import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private GamePanel gamePanel;
    private MenuDownPanel menuDownPanel;

    private int WINDOW_HEIGHT = 830;
    private int WINDOW_WIDTH = 1600;

    private PlayerClass playerClass;

    public MainFrame() {
        super("Game");
        this.playerClass = new PlayerClass();
        //ADDING PLAYER TO ALL
        gamePanel = new GamePanel(playerClass);
        menuDownPanel = new MenuDownPanel(playerClass);
        //MAIN FRAME ADJUSTMENTS
        this.setSize( WINDOW_WIDTH, WINDOW_HEIGHT );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        //MAIN FRAME ADDING
        gamePanel.setLocation(0,0);
        gamePanel.setSize(WINDOW_WIDTH,WINDOW_HEIGHT-150);
        this.add(gamePanel,BorderLayout.CENTER);
        menuDownPanel.setLocation(0,WINDOW_HEIGHT-150);
        menuDownPanel.setSize(WINDOW_WIDTH-71,113);
        this.add(menuDownPanel,BorderLayout.SOUTH);

    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }
}
