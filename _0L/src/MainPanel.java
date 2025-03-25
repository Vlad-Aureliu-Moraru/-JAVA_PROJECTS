import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class MainPanel extends JPanel {
    private int multiplier = 2;
    private int LINE_LENGTH = 13*multiplier;
    private int STARTING_WIDTH = 5*multiplier;

    private ArrayList<Integer> LINE_WIDTHS = new ArrayList<>();
    private ArrayList<Integer> LAST_LINE_WIDTHS = new ArrayList<>();

    //!22
    private int changeVALUE =22;
    private ArrayList<Double> lastAngles = new ArrayList<>();
    private String toFollow;
    private Color lineColor = new Color(89, 65, 30);

    private ArrayList<Line2D.Double> lines = new ArrayList<>();
    private ArrayList<Point2D.Double> pointStack = new ArrayList<>();
    private ArrayList<Ellipse2D.Double> circles = new ArrayList<>();
    private Color circleColor = new Color(255, 5, 5);
    private double raza = 2*multiplier;
    private boolean flag = false;

    public MainPanel() {


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.WHITE);
        g2d.clearRect(0, 0, getWidth(), getHeight());
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < lines.size(); i++) {
            g2d.setColor(lineColor);
            g2d.setStroke(new BasicStroke(LINE_WIDTHS.get(i)));
            g2d.draw(lines.get(i));
        }
        for (int i = 0; i <circles.size(); i++) {
            g2d.setColor(circleColor);
            g2d.setStroke(new BasicStroke(3));
            g2d.fill(circles.get(i));
        }
    }

    public void update() {
        this.repaint();
        this.revalidate();
    }


    public void setTOFollow(String toFollow) {
        this.toFollow = toFollow;
    }

    public void generateFractal() {
        lines.clear();
        circles.clear();
        pointStack.clear();
        lastAngles.clear();;
        Point2D.Double pos = new Point2D.Double(400, 770);
        double angle = 270.0;

        for (int i = 0; i < toFollow.length(); i++) {
            char c = toFollow.charAt(i);
            if (c == 'F') {
                double x1 = pos.getX();
                double y1 = pos.getY();
                double angleRad = Math.toRadians(angle);
                double x2 = x1 + LINE_LENGTH * Math.cos(angleRad);
                double y2 = y1 + LINE_LENGTH * Math.sin(angleRad);
                lines.add(new Line2D.Double(x1, y1, x2, y2));
                LINE_WIDTHS.add(STARTING_WIDTH);
                if (STARTING_WIDTH>1 && flag == false) {
                    STARTING_WIDTH--;
                }
                pos.setLocation(x2, y2);

            } else if (c == '+') {
                angle -= changeVALUE;
            } else if (c == '-') {
                angle += changeVALUE;
            } else if (c =='[') {
                LAST_LINE_WIDTHS.add(STARTING_WIDTH);
                pointStack.add(new Point2D.Double(pos.getX(), pos.getY()));
                lastAngles.add(angle);
                flag = true;
            } else if (c ==']') {
                STARTING_WIDTH = LAST_LINE_WIDTHS.get(LAST_LINE_WIDTHS.size()-1);
                LAST_LINE_WIDTHS.remove(LAST_LINE_WIDTHS.size()-1);
                //
                angle = lastAngles.get(lastAngles.size() - 1);
                lastAngles.remove(lastAngles.size() - 1);
                //
                Point2D.Double point = pointStack.getLast();
                pos.setLocation(point.getX(), point.getY());
                pointStack.remove(pointStack.size() - 1);

                flag =false;
            } else if (c == 'C') {
                circles.add(new Ellipse2D.Double(pos.getX()-raza, pos.getY()-raza,raza*2,raza*2));
            }
        }
        this.repaint();
        this.revalidate();
    }

}