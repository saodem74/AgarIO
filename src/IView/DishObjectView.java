/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tranhieu
 */
public abstract class DishObjectView implements ActionListener {
    
    private IDishObjectViewRealization realization;
    
    public DishObjectView(IDishObjectViewRealization r){
        realization = r;
    }
    
    public void render(){
    
    }
    
    public abstract void chooseColor();
    
    public abstract void choosePicture();

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
