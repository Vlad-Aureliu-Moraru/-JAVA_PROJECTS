import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SellPanel extends JPanel {
    private JLabel label = new JLabel("Print Inventory");

    private JButton button = new JButton("Add Random Vegetable");
    private JButton button2 = new JButton("Clear Inventory");

    private PlayerClass player;
    public SellPanel(PlayerClass player) {
        this.player = player;
        this.setBackground(Color.GREEN);
        this.add(label);
        this.add(button);
        this.add(button2);


        SeedsCarrot seedsCarrot = new SeedsCarrot();
        SeedsPotato seedsPotato = new SeedsPotato();
        SeedsLettuce seedsLettuce = new SeedsLettuce();
        SeedsTomato seedsTomato = new SeedsTomato();
        SeedsCucumber seedsCucumber = new SeedsCucumber();
        SeedsOnion seedsOnion = new SeedsOnion();

        player.addToInventory(new SeedsOnion(),45);
        player.addToInventory(seedsCarrot,22);
        player.addToInventory(seedsLettuce,15);
        player.addToInventory(seedsTomato,15);
        player.addToInventory(seedsCucumber,15);

        System.out.println(player.getInventory());
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Inventory"+player.getInventoryCollected());
            }
        });
        button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               player.addToInventoryCollected(new SeedsCarrot(),12);
            }
        });
        button2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                player.clearInventory();
            }
        });
    }
}
