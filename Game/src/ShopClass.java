import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShopClass extends JPanel {
    private GamePanel gamePanel;
    private PlayerClass playerClass;
    private InventoryCollectedPanel inventoryCollectedPanel;
    private Image background = new ImageIcon("assets\\BuildingsAssets\\Shop.png").getImage();
    public ShopClass(GamePanel gamePanel , PlayerClass playerClass) {
        this.gamePanel = gamePanel;
        this.playerClass = playerClass;
        inventoryCollectedPanel = new InventoryCollectedPanel(playerClass);
        this.setOpaque(false);
        this.setSize(200,150);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event){
                gamePanel.AddPanel(inventoryCollectedPanel);
                inventoryCollectedPanel.updateInventory();
            }
        });

    }
    public InventoryCollectedPanel getInventoryCollectedPanel() {
        return inventoryCollectedPanel;
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
