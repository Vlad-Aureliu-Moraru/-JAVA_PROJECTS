import javax.swing.*;
import java.awt.*;

public class ToolsPanel extends JPanel {
    private JLabel label = new JLabel("Tools");
    private Image background = new ImageIcon("assets\\FrameAssets\\ToolsFrame.png").getImage();
    private PlayerClass player;

    private ToolHarvest toolHarvest;
    private ToolPlant toolPlant;
    private ToolPlow toolPlow;
    private ToolWater toolWater;

    private int genericToolWIDTH = 60;
    private int offsetX = 50;
    private int gap = 0;
    private int gapValue = 20;
    public ToolsPanel(PlayerClass playerClass) {
        this.add(label);
        player = playerClass;
        this.setLayout(null);
        //ADDING TOOLS
        addTools();
        this.setOpaque(false);

    }
    public void unEquipAllTools() {
        toolHarvest.setState(false);
        toolPlant.setState(false);
        toolPlow.setState(false);
        toolWater.setState(false);
    }
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
    private void addTools(){

        toolHarvest = new ToolHarvest(player,this);
        toolHarvest.setLocation(offsetX, 15);
        this.add(toolHarvest);

        gap+=gapValue;

        toolPlant = new ToolPlant(player,this);
        toolPlant.setLocation(offsetX+genericToolWIDTH+gap, 15);
        this.add(toolPlant);

        gap+=gapValue;

        toolPlow = new ToolPlow(player,this);
        toolPlow.setLocation(offsetX+genericToolWIDTH*2+gap, 15);
        this.add(toolPlow);

        gap+=gapValue;

        toolWater = new ToolWater(player,this);
        toolWater.setLocation(offsetX+genericToolWIDTH*3+gap, 15);
        this.add(toolWater);

        gap+=gapValue;
    }
}
