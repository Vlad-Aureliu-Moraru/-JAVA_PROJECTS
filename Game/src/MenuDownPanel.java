import javax.swing.*;
import java.awt.*;

public class MenuDownPanel extends JPanel {

    private Image background = new ImageIcon("assets\\FrameAssets\\MenuDown.png").getImage();
    private  JButton button = new JButton("Play");

    private ToolsPanel toolsPanel;
    private StatsPanel statsPanel;
    private DayCyclePanel dayCyclePanel;
    private SellPanel sellPanel;

    private int generalHeight = 90;
    private int toolsPanelWidth = 400;
    private int statsPanelWidth = 500;
    private int dayCyclePanelWidth = 300;
    private int sellPanelWidth = 150;
    private int gap = 30;
    private int offsetX = 30;

    private PlayerClass playerClass;

    public MenuDownPanel(PlayerClass playerClass) {
        this.playerClass = playerClass;
        toolsPanel = new ToolsPanel(playerClass);
        statsPanel = new StatsPanel(playerClass);
        dayCyclePanel = new DayCyclePanel(playerClass);
        sellPanel = new SellPanel(playerClass);



        this.setBackground(Color.red);
        this.setLayout(null);


        //ADDING PANELS
        sellPanel.setLocation(statsPanelWidth+toolsPanelWidth+dayCyclePanelWidth+gap+offsetX+30,12);
        sellPanel.setSize(sellPanelWidth,generalHeight);
        this.add(sellPanel);

        dayCyclePanel.setLocation(statsPanelWidth+toolsPanelWidth+gap+offsetX+10,12);
        dayCyclePanel.setSize(dayCyclePanelWidth,generalHeight);
        this.add(dayCyclePanel);

        statsPanel.setLocation(toolsPanelWidth+gap+offsetX-10,12);
        statsPanel.setSize(statsPanelWidth,generalHeight);
        this.add(statsPanel);

        toolsPanel.setLocation(offsetX,12);
        toolsPanel.setSize(toolsPanelWidth,generalHeight);
        this.add(toolsPanel);

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
}
