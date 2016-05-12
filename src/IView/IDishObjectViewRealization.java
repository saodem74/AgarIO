/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IView;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author tranhieu
 */
public interface IDishObjectViewRealization {
    public void render(Graphics2D g);
    public void setImage(BufferedImage bi);
}
