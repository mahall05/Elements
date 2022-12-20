import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
    public class Images{
        public static BufferedImage board = null;
    
    }

    public static void loadImages(){
        try {
            Images.board = ImageIO.read(new File("Images/board.jpg"));
        } catch (IOException e) {
            System.out.println("Failed to load image");
        }
    }
}
