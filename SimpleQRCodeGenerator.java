import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class SimpleQRCodeGenerator {

    public static void main(String[] args) {
        String data = "https://www.example.com"; // Data to encode in the QR code
        String filePath = "QRCode.png"; // Output file path
        int size = 300; // Size of the QR code image

        // Generate QR Code
        BufferedImage qrCode = generateSimpleQRCode(data, size);

        // Save the image to a file
        try {
            ImageIO.write(qrCode, "png", new File(filePath));
            System.out.println("QR Code generated: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage generateSimpleQRCode(String data, int size) {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        // Create a simple pattern for the QR code
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                // Randomly set black or white pixels (for demonstration purposes)
                if ((x + y) % 20 < 10) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(x, y, 1, 1);
            }
        }

        g.dispose();
        return image;
    }
}

