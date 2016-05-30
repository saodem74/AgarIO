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

/**
 *
 * @author tranhieu
 */
public class BolidView extends DishObjectView {

    public BolidView(DishObject o) {
        super(o);
    }

    @Override
    public Color chooseColor() {
        return Color.CYAN;
    }
    
    @Override
    protected BufferedImage paint(){
        BufferedImage bi = super.paint();
        BufferedImage avatar = BacteryView.images.get(object.getType());
        if(avatar != null){
            Graphics2D g2d = bi.createGraphics();
            g2d.drawImage(avatar, 0, 0, object.getSize(), object.getSize(), null);
            g2d.dispose();
        }
        return bi;
    }
}
