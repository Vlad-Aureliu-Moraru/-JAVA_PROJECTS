import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InventoryCollectedPanel extends JPanel {
        private JLabel closeButton = new JLabel();
        private ImageIcon closeButtonIcon = new ImageIcon("assets\\ButtonAssets\\CloseButton.png");
        private Image background = new ImageIcon("assets\\PanelAssets\\ShopPanel.png").getImage();

        private InventoryPane[] inventoryPane = new InventoryPane[10];
        private InventoryCollected inventory;
        private int offsetY = 80;

        private PlayerClass playerClass;

        public InventoryCollectedPanel(PlayerClass playerClass) {

            this.playerClass = playerClass;
            inventory = playerClass.getInventoryCollected();
            playerClass.setInventoryCollectedPanel(this);
            this.setLayout(null);
            this.setSize(700, 500);
            this.setBackground(Color.GREEN);
            this.setVisible(false);

            updateInventory();


            closeButton.setIcon(closeButtonIcon);
            closeButton.setSize(50, 50);
            closeButton.setLocation(630, 15);

            closeButton.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    InventoryCollectedPanel.this.setVisible(false);
                }
            });
        } @Override
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
        public void updateInventory(){
            this.removeAll();
            this.add(closeButton);
            for (int i = 0; i < inventory.getSeeds().size(); i++){
                inventoryPane[i] = new InventoryPane(inventory.getSeeds().get(i),playerClass,InventoryCollectedPanel.this ,true);
                inventoryPane[i].setLocation(25,offsetY*(i+1));
                this.add(inventoryPane[i]);
            }
            this.revalidate();
            this.repaint();
        }
        public void unEquipAll(){
            for (int i = 0; i < inventory.getSeeds().size(); i++){
                if (inventoryPane[i].isEquipButtonPressed()){
                    inventoryPane[i].setEquipButtonPressed(false);
                }
            }
        }


    }


