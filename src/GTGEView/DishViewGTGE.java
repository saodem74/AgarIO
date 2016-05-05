/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEView;

import Game.AbstractFabric;
import IView.DishView;
import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.background.ImageBackground;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author tranhieu
 */
public class DishViewGTGE extends DishView {

    PlayField field;
    
    public DishViewGTGE(AbstractFabric f) {
        super(f);
        field = new PlayField();
    }

    @Override
    public void setBackground(String picture) {
//        ImageBackground back = new ImageBackground(new BufferedImage());
//        field.setBackground(back);
    }
    
}
