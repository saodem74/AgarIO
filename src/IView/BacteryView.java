/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IView;

import GameModel.DishObject;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author tranhieu
 */
public class BacteryView extends DishObjectView {

    HashMap<String,BufferedImage> images;
    
    {
        images = new HashMap<>();
        try {
            images.put("SimpleBactery", ImageIO.read(new File("resources/avatars/INITIAL_BACTERIUM.png")));
            images.put("BacteriumBuffalo", ImageIO.read(new File("resources/avatars/BACTERIUM_BUFFALO.png")));
            images.put("BacteriumMoss", ImageIO.read(new File("resources/avatars/BACTERIUM_MOSS.png")));
            images.put("BacteriumTiger", ImageIO.read(new File("resources/avatars/BACTERIUM_TIGER.png")));
            images.put("OmnivoreAnimal", ImageIO.read(new File("resources/avatars/OMNIVORE_ANIMAL.png")));
            images.put("ParasitePlant", ImageIO.read(new File("resources/avatars/PARASITE_PLANT.png")));
            images.put("PhytophagousAnimal", ImageIO.read(new File("resources/avatars/PHYTOPHAGOUS_ANIMAL.png")));
            images.put("PredatorAnimal", ImageIO.read(new File("resources/avatars/PREDATOR_ANIMAL.png")));
            images.put("PredatorPlant", ImageIO.read(new File("resources/avatars/PREDATOR_PLANT.png")));
            images.put("PrimitiveAnimal", ImageIO.read(new File("resources/avatars/PRIMITIVE_ANIMAL.png")));
            images.put("PrimitivePlant", ImageIO.read(new File("resources/avatars/PRIMITIVE_PLANT.png")));
        } catch (IOException ex) {
            Logger.getLogger(BacteryView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BacteryView(DishObject o) {
        super(o);
    }
    
    @Override
    protected BufferedImage paint(){
        BufferedImage bi = super.paint();
        BufferedImage avatar = images.get(object.getType());
        if(avatar != null){
            Graphics2D g2d = bi.createGraphics();
            g2d.drawImage(avatar, 0, 0, object.getSize(), object.getSize(), null);
            g2d.dispose();
        }
        return bi;
    }

    @Override
    public Color chooseColor() {
        return Color.GREEN;
    }

    @Override
    public void choosePicture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
