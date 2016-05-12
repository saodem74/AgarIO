/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEView;

import GTGEModel.DishObjectSpriteGTGE;
import IView.IDishObjectViewRealization;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author tranhieu
 */
public class DishObjectViewRealizationGTGE implements IDishObjectViewRealization {
    
    private DishObjectSpriteGTGE sprite;
    
    public DishObjectViewRealizationGTGE(DishObjectSpriteGTGE s){
        sprite = s;
    }

    @Override
    public void render(Graphics2D g) {
        sprite.render(g);
    }

    @Override
    public void setImage(BufferedImage bi) {
        sprite.setImage(bi);
    }
    
}
