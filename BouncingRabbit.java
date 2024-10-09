import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingRabbit extends JPanel implements ActionListener {
    private int rabbitY = 150; // Rabbit's vertical position
    private int rabbitX = 100; // Rabbit's horizontal position
    private int directionY = -1; // Direction of the bounce (up or down)
    private int horizontalSpeed = 5; // Speed of the rabbit's horizontal movement
    private Timer timer;

    public BouncingRabbit() {
        timer = new Timer(30, this); // Timer to control animation speed
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the blue sky
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight() - 200); // Sky

        // Draw the sun
        g.setColor(Color.YELLOW);
        g.fillOval(20, 20, 50, 50); // Sun

        // Draw clouds
        g.setColor(Color.WHITE);
        g.fillOval(100, 30, 60, 30); // Cloud 1
        g.fillOval(130, 25, 60, 40); // Cloud 2
        g.fillOval(200, 50, 80, 30); // Cloud 3
        g.fillOval(250, 40, 50, 30); // Cloud 4

        // Draw the green field
        g.setColor(Color.GREEN);
        g.fillRect(0, 200, getWidth(), getHeight() - 200); // Field

        // Draw more realistic flowers
        drawFlower(g, 50, 210, Color.PINK); // Flower 1
        drawFlower(g, 150, 210, Color.ORANGE); // Flower 2
        drawFlower(g, 250, 210, Color.YELLOW); // Flower 3
        drawFlower(g, 350, 210, Color.RED); // Flower 4

        // Draw the rabbit body
        g.setColor(Color.WHITE);
        g.fillOval(rabbitX, rabbitY, 40, 40); // Rabbit as a circle

        // Draw rabbit tail (on the right side)
        g.setColor(Color.WHITE);
        g.fillOval(rabbitX + 30, rabbitY + 15, 15, 15); // Rabbit tail (small circle on the right side of the body)

        // Draw rabbit ears (positioned above the head, but fitting better)
        g.fillRect(rabbitX + 8, rabbitY - 15, 8, 20);  // Left ear
        g.fillRect(rabbitX + 24, rabbitY - 15, 8, 20); // Right ear

        // Draw rabbit eyes
        g.setColor(Color.BLACK);
        g.fillOval(rabbitX + 10, rabbitY + 10, 5, 5); // Left eye
        g.fillOval(rabbitX + 20, rabbitY + 10, 5, 5); // Right eye

        // Draw rabbit nose
        g.fillOval(rabbitX + 15, rabbitY + 20, 5, 5); // Nose

        // Draw rabbit legs
        g.setColor(Color.WHITE);
        g.fillRect(rabbitX, rabbitY + 40, 10, 10); // Left leg
        g.fillRect(rabbitX + 30, rabbitY + 40, 10, 10); // Right leg

        // Draw the text in the top right corner
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 12)); // Set the font and size
        g.drawString("work by @blackmilkez", getWidth() - 150, 20); // Draw the text
    }

    private void drawFlower(Graphics g, int x, int y, Color petalColor) {
        // Draw flower stem
        g.setColor(new Color(34, 139, 34)); // Dark green for stem
        g.fillRect(x + 5, y, 3, 20); // Longer stem

        // Draw leaves on the stem
        g.setColor(new Color(50, 205, 50)); // Lighter green for leaves
        g.fillOval(x - 5, y + 5, 10, 5); // Left leaf
        g.fillOval(x + 5, y + 5, 10, 5); // Right leaf

        // Draw flower center
        g.setColor(Color.YELLOW);
        g.fillOval(x - 5, y - 15, 15, 15); // Center of the flower

        // Draw flower petals (multiple layers of petals)
        g.setColor(petalColor);
        // Petal 1 (top)
        g.fillOval(x - 10, y - 25, 15, 20);
        // Petal 2 (bottom)
        g.fillOval(x - 10, y - 5, 15, 20);
        // Petal 3 (left)
        g.fillOval(x - 20, y - 15, 20, 15);
        // Petal 4 (right)
        g.fillOval(x, y - 15, 20, 15);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update rabbit's vertical position (bouncing)
        rabbitY += directionY * 5;

        // Reverse vertical direction if it hits the ground or goes too high
        if (rabbitY <= 100 || rabbitY >= 150) {
            directionY *= -1;
        }

        // Update rabbit's horizontal position (hopping left and right)
        rabbitX += horizontalSpeed;

        // Reverse horizontal direction if the rabbit hits the left or right edge
        if (rabbitX <= 0 || rabbitX >= getWidth() - 40) {
            horizontalSpeed *= -1;
        }

        repaint(); // Repaint the panel
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
