import javax.swing.*;
import java.awt.*;

public class SeedsTomato extends SeedsClass{
    private Image state0 =  new ImageIcon("assets\\SeedClassAssets\\TomatoAssets\\TomatoIcon0.png").getImage();
    private Image state1 =  new ImageIcon("assets\\SeedClassAssets\\TomatoAssets\\TomatoIcon1.png").getImage();
    private Image state2 =  new ImageIcon("assets\\SeedClassAssets\\TomatoAssets\\TomatoIcon2.png").getImage();
    private Image state3 =  new ImageIcon("assets\\SeedClassAssets\\TomatoAssets\\TomatoIcon3.png").getImage();
    private Image state4 =  new ImageIcon("assets\\SeedClassAssets\\TomatoAssets\\TomatoIcon4.png").getImage();
    private Image state5 =  new ImageIcon("assets\\SeedClassAssets\\TomatoAssets\\TomatoIcon5.png").getImage();
    public SeedsTomato(){
        setName("Tomato");
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
