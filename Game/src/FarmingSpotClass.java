import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;

public class FarmingSpotClass extends JPanel {
    private boolean planted =false;
    private Image state1;
    private boolean inState1 = false;
    private Image state2;
    private boolean inState2 = false;
    private Image state3;
    private boolean inState3 = false;
    private Image state4;
    private boolean inState4 = false;

    private Timer timer;
    private PlayerClass playerClass;
    private SeedsClass plantedSeed;
    public FarmingSpotClass(PlayerClass playerClass) {
        this.playerClass = playerClass;
        this.setOpaque(false);
        this.setSize(300/3-10, 65);
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (playerClass.getEquipedSeeds()!=null && planted == false  && playerClass.getEquipedTool() instanceof ToolPlant) {
                    try {
                        plantedSeed = playerClass.getEquipedSeeds().clone();
                    } catch (CloneNotSupportedException ex) {
                        throw new RuntimeException(ex);
                    }
                    playerClass.useSeedFromInventory(playerClass.getEquipedSeeds());

                    state1 = plantedSeed.getState1();
                    state2 = plantedSeed.getState2();
                    state3 = plantedSeed.getState3();
                    state4 = plantedSeed.getState4();

                    inState1 = true;
                    repaint();
                    revalidate();
                    planted = true;
                    changeStates();
                } else if (inState4 && playerClass.getEquipedTool() instanceof ToolHarvest) {
                    inState4 = false;
                    inState3 = false;
                    inState2 = false;
                    inState1 = false;
                    planted = false;
                    playerClass.addToInventoryCollected(plantedSeed, plantedSeed.getGrowthAmmount());
                    plantedSeed = null;
                    repaint();
                    revalidate();

                } else {
                    System.out.println("SELECT A SEED OR PLOT IS PLANTED");
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image background = null;
        if (inState1) {
            background = state1;
        }
        else if (inState2) {
            background = state2;
        }
        else if (inState3) {
            background = state3;
        }
        else if (inState4) {
            background = state4;
        }

        if (background != null) {
            g.drawImage(
                    background,
                    0, 0, getWidth(), getHeight(), // Stretch to fill the panel
                    this
            );
        }
    }


    private void changeStates(){
    timer = new Timer(plantedSeed.getGrowingTime(), e -> {
        if (inState1) {
            inState1 = false;
            inState2 = true;
            repaint();
            revalidate();
        }
        else if (inState2) {
            inState2 = false;
            inState3 = true;
            repaint();
            revalidate();
        }
       else if (inState3) {
            inState3 = false;
            inState4 = true;
            repaint();
            revalidate();
            timer.stop();
        }
    });
        timer.start();
    }
}
