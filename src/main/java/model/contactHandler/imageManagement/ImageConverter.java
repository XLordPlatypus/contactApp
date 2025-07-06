package model.contactHandler.imageManagement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * The type Image converter.
 */
public class ImageConverter {
    /**
     * Convert image to binary string.
     *
     * @param image the image
     * @return the string
     * @throws IOException the io exception
     */
    public String convertImageToBinary(BufferedImage image) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "PNG", outputStream);
        byte[] buffer = outputStream.toByteArray();
        return Base64.getEncoder().encodeToString(buffer);
    }

    /**
     * Convert binary to image buffered image.
     *
     * @param binary the binary
     * @return the buffered image
     * @throws IOException the io exception
     */
    public BufferedImage convertBinaryToImage(String binary) throws IOException {
        byte[] image = Base64.getDecoder().decode(binary);
        return ImageIO.read(new ByteArrayInputStream(image));
    }
}
