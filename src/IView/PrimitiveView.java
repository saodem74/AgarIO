/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IView;

import GameModel.DishObject;
import GameModel.primitives.*;
import java.awt.Color;

/**
 *
 * @author tranhieu
 */
public class PrimitiveView extends DishObjectView {

    public PrimitiveView(IDishObjectViewRealization r, DishObject o) {
        super(r,o);
    }

    @Override
    public Color chooseColor() {
        if(object instanceof Agar) return Color.red;
        else if(object instanceof Water) return Color.blue;
        else if(object instanceof Light) return Color.yellow;
        else if(object instanceof O2) return Color.white;
        else return Color.gray; //CO2
    }

    @Override
    public void choosePicture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
