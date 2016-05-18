/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IView;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 *
 * @author tranhieu
 */
public abstract class DishObjectView implements ActionListener {
    
    private IDishObjectViewRealization realization;
    
    private final int EDGE_LINE = 2;
    
    private DishView dish;
    
    public DishObjectView(IDishObjectViewRealization r, int size){
        realization = r;
        realization.setImage(createCircle(size));
    }
    
    private BufferedImage createCircle(int size){
        BufferedImage bi = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB); 
        Graphics2D g2d = bi.createGraphics();
        g2d.setColor(chooseColor().darker().darker());
        g2d.fillOval(0, 0, size, size);
        g2d.setColor(chooseColor());
        g2d.fillOval(EDGE_LINE, EDGE_LINE, size-2*EDGE_LINE, size-2*EDGE_LINE);
        return bi;
    }
    
    public void render(Graphics2D g){
        realization.render(g);
    }
    
    public void setDish(DishView d){
        dish = d;
        realization.useBackground(dish);
    }
    
    public abstract Color chooseColor();
    
    public abstract void choosePicture();

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
