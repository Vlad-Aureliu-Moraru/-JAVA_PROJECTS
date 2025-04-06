import javax.swing.*;
import java.awt.*;

public class ToolPlant extends ToolClass{
    private Image bgOFF = new ImageIcon("assets\\ToolsAssets\\ToolPlant\\ToolPlantIcon.png").getImage();
    private Image bgON = new ImageIcon("assets\\ToolsAssets\\ToolPlant\\ToolPlantIconOFF.png").getImage();

    public ToolPlant(PlayerClass playerClass ,ToolsPanel toolsPanel) {
        super(playerClass,toolsPanel);
       // this.setBackground(Color.GREEN);
        setStateTurnOFF(bgOFF);
        setStateTurnON(bgON);


    }
}
