package zerotohero;

/**
 *
 * @author Conde
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Timer;

public class ImageComponent extends JComponent {
    private BufferedImage image;
    private int width;
    private int height;
    private int xCoor = 0;
    private int yCoor = 0;
    public ImageComponent(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
            this.width = image.getWidth();
            this.height = image.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ImageComponent(String imagePath, int width, int height) {
        this.width = width;
        this.height = height;
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ImageComponent(String imagePath, int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.xCoor = x;
        this.yCoor = y;
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(this.image, this.xCoor, this.yCoor, this.width, this.height, this);
        }
    }
     @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
    
    public BufferedImage getImage() {
        return image;
    }
    public void moveUpDown() {
        Timer moveUp = new Timer(20, null);
        moveUp.addActionListener(evt -> {
            if (this.yCoor > -20) {
                this.yCoor -= 2;
                repaint();
            } else {
                moveUp.stop();
                Timer moveDown = new Timer(20, null);
                moveDown.addActionListener(evt2 -> {
                    if (this.yCoor < 0) {
                        this.yCoor += 2;
                        repaint();
                    } else {
                        moveDown.stop();
                    }
                });
                moveDown.start();
            }
        });
        moveUp.start();
    }
    
//    public void moveRight() {
//        Timer moveRight = new Timer(50, null);
//        moveRight.addActionListener(evt -> {
//            
//        })
//    }
}