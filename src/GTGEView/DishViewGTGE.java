/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GTGEView;

import Game.AbstractFabric;
import IView.DishView;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.background.ImageBackground;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author tranhieu
 */
public class DishViewGTGE extends DishView {

    private PlayField field = new PlayField();
    private Background back;
    
    public DishViewGTGE(AbstractFabric f) {
        super(f);
//        field = new PlayField();
    }

    @Override
    public void setBackground(String picture) {
        try {
            BufferedImage in = ImageIO.read(new File(picture));
            back = new ImageBackground(in);
            back.setClip(0, 0, 800, 600);
            field.setBackground(back);
        } catch (IOException ex) {
            System.err.println("Cannot load background image:");
            System.err.println(ex.getMessage());
            field.setBackground(null);
        }
    }
    
    @Override
    public void render(Graphics2D g){
        field.render(g);
        super.render(g);
    }
    
}
