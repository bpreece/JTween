/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpreece.jtween;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Maintenance
 */
public class ImageTween extends Tween
{
    private final Image object;

    public ImageTween(Image image)
    {
        this.object = image;
    }

    public Image getImage()
    {
        return object;
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(object, 0, 0, null);
    }
}
