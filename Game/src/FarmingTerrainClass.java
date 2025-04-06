import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.jar.JarEntry;

public class FarmingTerrainClass extends JPanel {

    private Image background = new ImageIcon("assets\\FarmingAssets\\FarmingTerrain.png").getImage();

   private FarmingSpotClass[] farmingSpotClass = new FarmingSpotClass[3];
   private int limit = 3;
   private int placed = 0;
   private int generalWidth = 90;
   private int offsetX =14;

  PlayerClass player;
    public FarmingTerrainClass(PlayerClass player) {
        this.player = player;
        this.setSize(300, 80);
        this.setLayout(null);
        this.setOpaque(false);
       placeFarmingSpot();

    }@Override
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
    private void placeFarmingSpot() {
        farmingSpotClass[placed] = new FarmingSpotClass(player);
        farmingSpotClass[placed].setLocation((offsetX*placed+1)+generalWidth*placed+5, 5);
        farmingSpotClass[placed].setVisible(true);
        this.add(farmingSpotClass[placed]);
        placed++;
        farmingSpotClass[placed] = new FarmingSpotClass(player);
        farmingSpotClass[placed].setLocation((offsetX*placed+1)+generalWidth*placed, 5);
        farmingSpotClass[placed].setVisible(true);
        this.add(farmingSpotClass[placed]);
        placed++;
        farmingSpotClass[placed] = new FarmingSpotClass(player);
        farmingSpotClass[placed].setLocation((offsetX*placed+1)+generalWidth*placed-5, 5);
        farmingSpotClass[placed].setVisible(true);
        this.add(farmingSpotClass[placed]);

    }
}
