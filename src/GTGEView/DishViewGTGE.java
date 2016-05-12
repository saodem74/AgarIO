/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEView;

import GTGEGame.GTGEFabric;
import Game.AbstractFabric;
import IView.DishView;
import com.golden.gamedev.Game;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.background.ImageBackground;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author tranhieu
 */
public class DishViewGTGE extends DishView {

    private PlayField field;
    private GTGEFabric fabric;
    
    public DishViewGTGE(AbstractFabric f) {
        super(f);
        fabric = (GTGEFabric)f;
        field = new PlayField();
    }

    @Override
    public void setBackground(String picture) {
        fabric.getGameGTGEObject().getImage(picture);
        field.setBackground(null); //TO DO 
    }
    
    public void render(Graphics2D g){
        field.render(g);
    }
    
}
