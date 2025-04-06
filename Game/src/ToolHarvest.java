import javax.swing.*;
import java.awt.*;

public class ToolHarvest extends ToolClass{
    private Image bgOFF = new ImageIcon("assets\\ToolsAssets\\ToolHarvest\\ToolHarvestIcon.png").getImage();
    private Image bgON = new ImageIcon("assets\\ToolsAssets\\ToolHarvest\\ToolHarvestIconOFF.png").getImage();

    public ToolHarvest(PlayerClass playerClass, ToolsPanel toolsPanel) {
        super(playerClass , toolsPanel);
        setStateTurnON(bgON);
        setStateTurnOFF(bgOFF);
    }
}
