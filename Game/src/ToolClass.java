import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToolClass extends JPanel {

    private Image stateTurnON;
    private Image stateTurnOFF;
    private boolean state = false;
    private PlayerClass player;
    private ToolsPanel toolsPanel;
    public ToolClass(PlayerClass player , ToolsPanel toolsPanel) {
        this.player = player;
        this.toolsPanel = toolsPanel;
        setSize(60, 60);
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(state==true){
                    state = false;
                    player.setEquipedTool(null);
                    ToolClass.this.repaint();
                    ToolClass.this.revalidate();

                }else{
                    toolsPanel.unEquipAllTools();
                    state = true;
                    player.setEquipedTool(ToolClass.this);
                    ToolClass.this.repaint();
                    ToolClass.this.revalidate();
                }
            }
        });
    }

    public void setPlayer(PlayerClass player) {
        this.player = player;
    }

    public void setState(boolean state) {
        this.state = state;
        repaint();
        revalidate();
    }

    public boolean isState() {
        return state;
    }

    public void setStateTurnOFF(Image stateTurnOFF) {
        this.stateTurnOFF = stateTurnOFF;
    }

    public void setStateTurnON(Image stateTurnON) {
        this.stateTurnON = stateTurnON;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image background = state==true?stateTurnON:stateTurnOFF;
        if (background!= null) {
            g.drawImage(
                    background,
                    0, 0, getWidth(), getHeight(), // Stretch to fill the panel
                    this
            );
        }
    }
}
