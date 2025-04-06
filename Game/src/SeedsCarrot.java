import javax.swing.*;
import java.awt.*;

public class SeedsCarrot extends SeedsClass{
  private Image state0 =  new ImageIcon("assets\\SeedClassAssets\\CarrotAssets\\CarrotIcon0.png").getImage();
  private Image state1 =  new ImageIcon("assets\\SeedClassAssets\\CarrotAssets\\CarrotIcon1.png").getImage();
  private Image state2 =  new ImageIcon("assets\\SeedClassAssets\\CarrotAssets\\CarrotIcon2.png").getImage();
  private Image state3 =  new ImageIcon("assets\\SeedClassAssets\\CarrotAssets\\CarrotIcon3.png").getImage();
  private Image state4 =  new ImageIcon("assets\\SeedClassAssets\\CarrotAssets\\CarrotIcon4.png").getImage();
  private Image state5 =  new ImageIcon("assets\\SeedClassAssets\\CarrotAssets\\CarrotIcon5.png").getImage();
  public SeedsCarrot(){
        setName("Carrot");
        setState0(state0);
        setState1(state1);
        setState2(state2);
        setState3(state3);
        setState4(state4);
        setState5(state5);
        setMaxGrowth(5);
        setMinGrowth(3);


        setGrowingTime(1000);
    }
}
