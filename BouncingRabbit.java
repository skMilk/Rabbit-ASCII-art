import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingRabbit extends JPanel implements ActionListener {
    private int rabbitY = 150;
    private int rabbitX = 100;
    private int directionY = -1;
    private int horizontalSpeed = 5;
    private Timer timer;

    public BouncingRabbit() {
        timer = new Timer(30, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight() - 200);

        g.setColor(Color.YELLOW);
        g.fillOval(20, 20, 50, 50);

        g.setColor(Color.WHITE);
        g.fillOval(100, 30, 60, 30);
        g.fillOval(130, 25, 60, 40);
        g.fillOval(200, 50, 80, 30);
        g.fillOval(250, 40, 50, 30);

        g.setColor(Color.GREEN);
        g.fillRect(0, 200, getWidth(), getHeight() - 200);

        drawFlower(g, 50, 210, Color.PINK);
        drawFlower(g, 150, 210, Color.ORANGE);
        drawFlower(g, 250, 210, Color.YELLOW);
        drawFlower(g, 350, 210, Color.RED);

        g.setColor(Color.WHITE);
        g.fillOval(rabbitX, rabbitY, 40, 40);
        g.fillOval(rabbitX + 30, rabbitY + 15, 15, 15);
        g.fillRect(rabbitX + 8, rabbitY - 15, 8, 20);
        g.fillRect(rabbitX + 24, rabbitY - 15, 8, 20);

        g.setColor(Color.BLACK);
        g.fillOval(rabbitX + 10, rabbitY + 10, 5, 5);
        g.fillOval(rabbitX + 20, rabbitY + 10, 5, 5);
        g.fillOval(rabbitX + 15, rabbitY + 20, 5, 5);

        g.fillRect(rabbitX, rabbitY + 40, 10, 10);
        g.fillRect(rabbitX + 30, rabbitY + 40, 10, 10);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString("work by @blackmilkez", getWidth() - 150, 20);
    }

    private void drawFlower(Graphics g, int x, int y, Color petalColor) {
        g.setColor(new Color(34, 139, 34));
        g.fillRect(x + 5, y, 3, 20);
        g.setColor(new Color(50, 205, 50));
        g.fillOval(x - 5, y + 5, 10, 5);
        g.fillOval(x + 5, y + 5, 10, 5);
        g.setColor(Color.YELLOW);
        g.fillOval(x - 5, y - 15, 15, 15);
        g.setColor(petalColor);
        g.fillOval(x - 10, y - 25, 15, 20);
        g.fillOval(x - 10, y - 5, 15, 20);
        g.fillOval(x - 20, y - 15, 20, 15);
        g.fillOval(x, y - 15, 20, 15);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rabbitY += directionY * 5;

        if (rabbitY <= 100 || rabbitY >= 150) {
            directionY *= -1;
        }

        rabbitX += horizontalSpeed;

        if (rabbitX <= 0 || rabbitX >= getWidth() - 40) {
            horizontalSpeed *= -1;
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Rabbit");
        BouncingRabbit bouncingRabbit = new BouncingRabbit();
        frame.add(bouncingRabbit);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
