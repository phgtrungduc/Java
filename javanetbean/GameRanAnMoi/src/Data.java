
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Data {
    public static Image imageHeadUp ;
    public static Image imageHeadDown ;
    public static Image imageHeadLeft ;
    public static Image imageHeadRight ;
    public static Image imageFood;
    public static Image imageBody ;
    public static void loadImage(){
        try {
            imageHeadUp = ImageIO.read(new File("res/upmouth.png") );
            imageHeadDown = ImageIO.read(new File("res/downmouth.png") );
            imageHeadLeft = ImageIO.read(new File("res/leftmouth.png") );
            imageHeadRight = ImageIO.read(new File("res/rightmouth.png") );
            imageFood = ImageIO.read(new File("res/burger1.png") );
            imageBody = ImageIO.read(new File("res/snakeimage.png") );
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
