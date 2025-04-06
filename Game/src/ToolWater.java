import javax.swing.*;
import java.awt.*;

public class ToolWater extends ToolClass{

    private Image bgOFF = new ImageIcon("assets\\ToolsAssets\\ToolWater\\ToolWaterIconOFF.png").getImage();
    private Image bgON = new ImageIcon("assets\\ToolsAssets\\ToolWater\\ToolWaterIcon.png").getImage();
    public ToolWater(PlayerClass player,ToolsPanel toolsPanel) {
        super(player,toolsPanel);

        setStateTurnOFF(bgOFF);
        setStateTurnON(bgON);

    }
}
