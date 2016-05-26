/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IView;

import GameModel.DishObject;
import java.awt.Color;

/**
 *
 * @author tranhieu
 */
public class BacteryView extends DishObjectView {

    public BacteryView(DishObject o) {
        super(o);
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
