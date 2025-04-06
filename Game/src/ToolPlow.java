import javax.swing.*;
import java.awt.*;

public class ToolPlow extends ToolClass{
    private Image bgOFF = new ImageIcon("assets\\ToolsAssets\\ToolPlow\\ToolPlowIcon.png").getImage();
    private Image bgON = new ImageIcon("assets\\ToolsAssets\\ToolPlow\\ToolPlowIconOFF.png").getImage();
    public ToolPlow(PlayerClass player , ToolsPanel toolsPanel) {
    super(player, toolsPanel);
    setStateTurnON(bgON);
setStateTurnOFF(bgOFF);
    }
}
