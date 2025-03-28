package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TextureRotation {
    public BufferedImage rotateImage(BufferedImage image, double angle) {
        // Check if the input image is null
        if (image == null) {
            throw new IllegalArgumentException("Input image cannot be null");
        }

        // Get the dimensions of the original image
        int width = image.getWidth();
        int height = image.getHeight();

        // Create a new BufferedImage with the same dimensions and type as the original
        BufferedImage rotatedImage = new BufferedImage(width, height, image.getType());

        // Create a Graphics2D object from the new image
        Graphics2D g2d = rotatedImage.createGraphics();

        // Enable anti-aliasing for smoother rotation (optional)
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Rotate around the center of the image (width/2, height/2)
        g2d.rotate(Math.toRadians(angle), width / 2.0, height / 2.0);

        // Draw the original image onto the rotated context
        g2d.drawImage(image, 0, 0, null);

        // Clean up the graphics object
        g2d.dispose();

        // Return the rotated image
        return rotatedImage;
    }
}