import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class StatsPanel extends JPanel {
    private Image background = new ImageIcon("assets\\FrameAssets\\StatsFrame.png").getImage();

    private ImageIcon coinImage= new ImageIcon("assets\\IconAssets\\CoinIcon.png");
    private ImageIcon gemImage= new ImageIcon("assets\\IconAssets\\GemIcon.png");
    private ImageIcon levelImage= new ImageIcon("assets\\IconAssets\\LevelIcon.png");

    private JLabel statsLabel= new JLabel("Stats");

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
    private JLabel coinsLabel= new JLabel();
    private JLabel coinAmountLabel= new JLabel();


    private JLabel gemLabel= new JLabel();
    private JLabel gemAmountLabel= new JLabel();

    private JLabel levelLabel= new JLabel();
    private JLabel levelAmountLabel= new JLabel();

    private PlayerClass playerClass;

    private int coinGroupY =20;
    private int coinGroupX =20;

    private int gemGroupY =20;
    private int gemGroupX =115;

    private int levelGroupY =20;
    private int levelGroupX =210;

    public StatsPanel(PlayerClass playerClass) {
        this.playerClass = playerClass;
        setOpaque(false);
        setLayout(null);
        //ADDING COIN GROUP
        this.addCoinGroup();
        //todo: ADD GEM GROUP
        this.addGemGroup();
        //todo :ADD LEVEL GROUP
        this.addLevelGroup();
        //todo: ADD EXP BAR GROUP


        this.setBackground(Color.RED);
        this.add(statsLabel);
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
    private void addCoinGroup() {
        coinsLabel.setLocation(coinGroupX,coinGroupY);
        coinsLabel.setSize(40,40);
        coinsLabel.setIcon(coinImage);
        coinsLabel.setOpaque(false);
        this.add(coinsLabel);
        coinAmountLabel.setLocation(coinGroupX+45,coinGroupY+5);
        coinAmountLabel.setSize(60,40);
        coinAmountLabel.setForeground(Color.WHITE);
        coinAmountLabel.setOpaque(false);
        coinAmountLabel.setFont(font.deriveFont(Font.PLAIN,20));
        coinAmountLabel.setText(""+playerClass.getCoins());
        this.add(coinAmountLabel);
    }
    private void addGemGroup() {
        gemLabel.setLocation(gemGroupX,coinGroupY);
        gemLabel.setSize(40,40);
        gemLabel.setIcon(gemImage);
        gemLabel.setOpaque(false);
        this.add(gemLabel);
        gemAmountLabel.setLocation(gemGroupX+45,coinGroupY+5);
        gemAmountLabel.setSize(60,40);
        gemAmountLabel.setForeground(Color.WHITE);
        gemAmountLabel.setOpaque(false);
        gemAmountLabel.setFont(font.deriveFont(Font.PLAIN,20));
        gemAmountLabel.setText(""+playerClass.getGems()  );
        this.add(gemAmountLabel);
    }
    private void addLevelGroup() {
        levelLabel.setLocation(levelGroupX,coinGroupY);
        levelLabel.setSize(40,40);
        levelLabel.setIcon(levelImage);
        levelLabel.setOpaque(false);
        this.add(levelLabel);
        levelAmountLabel.setLocation(levelGroupX+45,coinGroupY+5);
        levelAmountLabel.setSize(60,40);
        levelAmountLabel.setForeground(Color.WHITE);
        levelAmountLabel.setOpaque(false);
        levelAmountLabel.setFont(font.deriveFont(Font.PLAIN,20));
        levelAmountLabel.setText(""+playerClass.getLevel()  );
        this.add(levelAmountLabel);
    }
}
