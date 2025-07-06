package model.contactHandler.imageManagement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The type Image importer.
 */
public class ImageImporter {
    /**
     * Import image buffered image.
     *
     * @param fullPath the full path
     * @return the buffered image
     * @throws IOException the io exception
     */
    public BufferedImage importImage(String fullPath) throws IOException {
        File file = new File(fullPath);
        return ImageIO.read(file);
    }
}
