import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BarnClass extends JPanel {

    private Image background = new ImageIcon("assets\\BuildingsAssets\\Barn.png").getImage();
    private InventoryPanel inventoryPanel;
    private GamePanel gamePanel;
    private PlayerClass playerClass;
    public BarnClass(GamePanel gamePanel , PlayerClass playerClass) {
        this.gamePanel = gamePanel;
        this.playerClass = playerClass;
        inventoryPanel = new InventoryPanel(playerClass);
        this.setSize(400, 200);
        this.setOpaque(false);

        //ADDING FUNCTIONALITY
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event){
                gamePanel.AddPanel(inventoryPanel);
                inventoryPanel.updateInventory();
            }
        });


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
    public InventoryPanel getInventoryPanel() {
        return inventoryPanel;
    }
}
