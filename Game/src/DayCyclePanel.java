import javax.swing.*;
import java.awt.*;

public class DayCyclePanel extends JPanel {
    private JLabel dayLabel = new JLabel("Day/Night");

    private Image background = new ImageIcon("assets\\FrameAssets\\DayNightFrame.png").getImage();

    private PlayerClass playerClass;
    public DayCyclePanel(PlayerClass playerClass) {
        this.playerClass = playerClass;
        setOpaque(false);
        this.add(dayLabel);
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
}
