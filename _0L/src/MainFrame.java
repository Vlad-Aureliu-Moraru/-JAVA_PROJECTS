import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {
    private OL ol = new OL();
    private MainPanel mp = new MainPanel();
    private String result;
    private Timer timer;
    private int step = 0;
    //?
    private int HEIGHT = 800;
    private int WIDTH = 800;

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(HEIGHT,WIDTH);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

//        ol.setOmega("F+F+F+F");
        ol.setOmega("F");
//        Rule rule = new Rule("F","F[-FC][+FC]");
        Rule rule = new Rule("F","FF-[-F+F+F+C]+[+F-F-FC]");
        //F[-F[F][+F[-F]]][+F-F+FF]
//        Rule rule = new Rule("F","F[-F[F][+F[-F]]][+F-F+FF]");
//        Rule rule = new Rule("F","FF+F+F+F+FF");
        ol.getRules().addRule(rule);
        this.add(mp);
//        ol.generateResult(4);
            timer = new Timer(1000, new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   ol.generateResult(step);
                   result = ol.getResult();
                   System.out.println(result);
                   mp.setTOFollow(result);
                   mp.generateFractal();
                   mp.update();
                   step++;
                   if (step>3){
                       timer.stop();
                   }
               }
            });
    timer.start();
    }
}
