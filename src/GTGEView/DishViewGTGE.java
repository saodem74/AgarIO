/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEView;

import Game.AbstractFabric;
import GameModel.Dish;
import IView.*;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.background.ImageBackground;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author tranhieu
 */
public class DishViewGTGE extends DishView {

    private PlayField field;
    
    public DishViewGTGE(Dish d, AbstractFabric f, int w, int h) {
        super(d,f,w,h);
        field = new PlayField();
    }

    @Override
    public void setBackground(String picture) {
        try {
            BufferedImage in = ImageIO.read(new File(picture));
            Background back = new ImageBackground(in);
            field.setBackground(back);
        } catch (IOException ex) {
            System.err.println("Cannot load background image:");
            System.err.println(ex.getMessage());
        }
        field.getBackground().setSize(dish.getWidth(), dish.getHeight());
        field.getBackground().setClip(0, 0, width, height);
    }
    
    @Override
    public void render(Graphics2D g){
        field.render(g);
        super.render(g);
    }

    @Override
    protected void centerBackground() {
        if(mainPlayer == null)
            return;
        Point mpPos = mainPlayer.getPosition();
        field.getBackground().setToCenter(mpPos.x,mpPos.y,mainPlayer.getSize(),
                        mainPlayer.getSize());
    }
    
    public Background getBackground(){
        return field.getBackground();
    }
}
