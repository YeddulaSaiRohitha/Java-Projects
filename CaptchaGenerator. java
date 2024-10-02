import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class CaptchaGenerator {

    // Generate a random CAPTCHA string
    private static String generateCaptchaText(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random random = new Random();
        StringBuilder captchaText = new StringBuilder();
        for (int i = 0; i < length; i++) {
            captchaText.append(chars.charAt(random.nextInt(chars.length())));
        }
        return captchaText.toString();
    }

    // Generate the CAPTCHA image
    private static BufferedImage generateCaptchaImage(String captchaText) {
        int width = 200;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.getGraphics();

        // Set background color
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // Set CAPTCHA text color and font
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 40));

        // Draw the CAPTCHA text
        g.drawString(captchaText, 30, 40);

        // Add some random noise (optional)
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            g.drawLine(x, y, x, y);
        }

        g.dispose(); // Release resources
        return image;
    }

    // Save the CAPTCHA image to a file
    private static void saveCaptchaImage(BufferedImage image, String filePath) throws IOException {
        File file = new File(filePath);
        ImageIO.write(image, "png", file);
        System.out.println("CAPTCHA image saved at: " + filePath);
    }

    public static void main(String[] args) {
        // Generate a random CAPTCHA text
        String captchaText = generateCaptchaText(6);

        // Generate CAPTCHA image
        BufferedImage captchaImage = generateCaptchaImage(captchaText);

        // Save the CAPTCHA image to a file
        try {
            saveCaptchaImage(captchaImage, "captcha.png");
        } catch (IOException e) {
            System.out.println("Error saving CAPTCHA image: " + e.getMessage());
        }
    }
}
