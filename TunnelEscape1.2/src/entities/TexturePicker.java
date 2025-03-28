package entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class TexturePicker {
    public BufferedImage getRandomTexture(String imagePath, int subWidth, int subHeight) {
        // Load the large image
        try {
            BufferedImage largeImage = ImageIO.read(new File(imagePath));

            // Get the dimensions of the large image
            int largeWidth = largeImage.getWidth();
            int largeHeight = largeImage.getHeight();

            // Validate subimage size
            if (subWidth > largeWidth || subHeight > largeHeight) {
                throw new IllegalArgumentException("Subimage size exceeds the dimensions of the large image.");
            }

            // Create a Random object for generating random coordinates
            Random random = new Random();

            // Generate random x and y coordinates for the top-left corner of the subimage
            int x = random.nextInt(largeWidth - subWidth + 1); // Ensure the subimage fits within the large image
            int y = random.nextInt(largeHeight - subHeight + 1);

            // Extract the subimage
            return largeImage.getSubimage(x, y, subWidth, subHeight);
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
