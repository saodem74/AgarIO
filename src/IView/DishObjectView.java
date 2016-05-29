/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IView;

import GameModel.DishObject;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author tranhieu
 */
public abstract class DishObjectView implements ActionListener {
    
    protected DishObject object;
    
    private IDishObjectViewRealization realization;
    
    private final int EDGE_LINE = 2;
    
    private DishView dish;
    
    public DishObjectView(DishObject o){
        object = o;
    }
    
   
    public void setRealization(IDishObjectViewRealization r){
        realization = r;
        realization.setImage(paint());
    }
    
    private BufferedImage drawCircle(int size){
        BufferedImage bi = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB); 
        Graphics2D g2d = bi.createGraphics();
        g2d.setColor(chooseColor().darker().darker());
        g2d.fillOval(0, 0, size, size);
        g2d.setColor(chooseColor());
        g2d.fillOval(EDGE_LINE, EDGE_LINE, size-2*EDGE_LINE, size-2*EDGE_LINE);
        return bi;
    }
    
    protected BufferedImage paint(){
        return drawCircle(object.getSize());
    }
    
    public void render(Graphics2D g){
        if (this.object.getIsGrowd()){
            this.object.changeIsGrowd();
            realization.setImage(paint());
        }
        realization.render(g);
    }
    
    public void setDish(DishView d){
        dish = d;
        realization.setDish(dish);
    }
    
    public abstract Color chooseColor();
    
    public abstract void choosePicture();

    @Override
    public void actionPerformed(ActionEvent e) {
        realization.setImage(paint());
    }
    
}
