import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;

public class InventoryPane extends JPanel {
    private Image background = new ImageIcon("assets\\FrameAssets\\InventoryPane.png").getImage();
    private Color backgroundColor = new Color(0, 0, 0, 87);
    private Font font;

    {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT,new File("assets\\Font.otf"));
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ImageIcon equipIcon = new ImageIcon("assets\\ButtonAssets\\EquipButton.png");
    private ImageIcon equipedIcon = new ImageIcon("assets\\ButtonAssets\\EquipedButton.png");

    private JLabel inventoryObjectLabel = new JLabel();
    private JLabel equipButtonLabel = new JLabel();

    private JLabel ammountLabel = new JLabel();
    private JLabel nameLabel = new JLabel();

    private boolean equipButtonPressed = false;


    public InventoryPane(SeedsClass seedsClass , PlayerClass playerClass,InventoryPanel inventoryPanel,boolean collected) {
    this.setBackground(backgroundColor);
    this.setLayout(null);
    this.setSize(450, 70);

        if (seedsClass.getState0()!=null && !collected){
            inventoryObjectLabel.setIcon(new ImageIcon(seedsClass.getState0()));
        }
    inventoryObjectLabel.setOpaque(false);
    inventoryObjectLabel.setLocation(10, 10);
    inventoryObjectLabel.setSize(50, 50);
    this.add(inventoryObjectLabel);

    ammountLabel.setForeground(Color.white);
    ammountLabel.setText(" X " + seedsClass.getAmmount());
    ammountLabel.setFont(font.deriveFont(Font.PLAIN, 12));
    ammountLabel.setLocation(60,25);
    ammountLabel.setSize(150, 50);
    this.add(ammountLabel);

    nameLabel.setForeground(Color.WHITE);
    nameLabel.setText(""+seedsClass.getName());
    nameLabel.setFont(font.deriveFont(Font.PLAIN,15.0f));
    nameLabel.setLocation(65,0);
    nameLabel.setSize(150, 50);
    this.add(nameLabel);


    equipButtonLabel.setIcon(equipIcon);
    equipButtonLabel.setOpaque(false);
    equipButtonLabel.setLocation(390, 10);
    equipButtonLabel.setSize(50, 50);
    this.add(equipButtonLabel);


    equipButtonLabel.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if (equipButtonPressed) {
                playerClass.setEquipedSeeds(null);
                System.out.println(playerClass.getEquipedSeeds());
                setEquipButtonPressed(false);
                equipButtonLabel.setIcon(equipIcon);
            }else {
                inventoryPanel.unEquipAll();
                setEquipButtonPressed(true);
                playerClass.setEquipedSeeds(seedsClass);
                System.out.println(playerClass.getEquipedSeeds());

            }
        }
    });

    }

    public InventoryPane(SeedsClass seedsClass , PlayerClass playerClass,InventoryCollectedPanel inventoryCollectedPanel,boolean collected) {
        this.setBackground(backgroundColor);
        this.setLayout(null);
        this.setSize(450, 70);

        if (seedsClass.getState0()!=null && !collected){
            inventoryObjectLabel.setIcon(new ImageIcon(seedsClass.getState0()));
        }else {
            inventoryObjectLabel.setIcon(new ImageIcon(seedsClass.getState5()));
        }
        inventoryObjectLabel.setOpaque(false);
        inventoryObjectLabel.setLocation(10, 10);
        inventoryObjectLabel.setSize(50, 50);
        this.add(inventoryObjectLabel);


        ammountLabel.setForeground(Color.white);
        ammountLabel.setText(" X " + seedsClass.getAmmount());
        ammountLabel.setFont(font.deriveFont(Font.PLAIN, 12));
        ammountLabel.setLocation(60,25);
        ammountLabel.setSize(150, 50);
        this.add(ammountLabel);

        nameLabel.setForeground(Color.WHITE);
        nameLabel.setText(""+seedsClass.getName());
        nameLabel.setFont(font.deriveFont(Font.PLAIN,15.0f));
        nameLabel.setLocation(65,0);
        nameLabel.setSize(150, 50);
        this.add(nameLabel);



    }




    public void setEquipButtonPressed(boolean equipButtonPressed) {
        this.equipButtonPressed = equipButtonPressed;
        if (equipButtonPressed) {
            equipButtonLabel.setIcon(equipedIcon);
        }else {
            equipButtonLabel.setIcon(equipIcon);
        }

    }

    public boolean isEquipButtonPressed() {
        return equipButtonPressed;
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
