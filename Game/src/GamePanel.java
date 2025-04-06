import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {


    private Image background = new ImageIcon("assets\\BackgroundAssets\\grass.png").getImage();

    //FARMIN STUFF
    private FarmingTerrainClass farmingTerrainClass;
    private BarnClass barnClass ;
    private ShopClass shopClass ;

    PlayerClass playerClass;

    public GamePanel(PlayerClass playerClass) {
        this.playerClass = playerClass;
        this.setLayout(null);
        farmingTerrainClass = new FarmingTerrainClass(playerClass);

        playerClass.setGamePanel(this);

        farmingTerrainClass.setLocation(5, 10);

        this.add(farmingTerrainClass);


        this.addingBuildings();

        this.addingPanels();

        this.add(shopClass);
        this.add(barnClass);

    }
    public void AddPanel(JPanel panel) {
        panel.setVisible(true);
    }
    public BarnClass getBarnClass() {
        return barnClass;
    }

    private void addingBuildings(){
        barnClass = new BarnClass(GamePanel.this,playerClass);
        barnClass.setLocation(550, -5);

        shopClass = new ShopClass(GamePanel.this,playerClass);
        shopClass.setLocation(1250, 500);
    }
    private void addingPanels(){
        barnClass.getInventoryPanel().setLocation(500,100);
        this.add(barnClass.getInventoryPanel());
        this.repaint();
        this.revalidate();

        shopClass.getInventoryCollectedPanel().setLocation(420,100);
        this.add(shopClass.getInventoryCollectedPanel());
        this.repaint();
        this.revalidate();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (background != null) {
            g.drawImage(
                    background,
                    0, 0, getWidth(), getHeight(), // Stretch to fill the panel
                    this
            );
        }
    }
}
