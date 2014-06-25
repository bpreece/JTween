/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bpreece.jtween;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Ly
 */
public class TextTween extends Tween
{
    private final String text;
    private Font font;

    public TextTween(String text)
    {
        this.text = text;
    }

    public TextTween(String text, Font font)
    {
        this.text = text;
        setFont(font);
    }

    public void setFont(Font font)
    {
        this.font = font;
    }

    public String getText()
    {
        return text;
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(font);
        g2d.drawString(text, 0, 0);
    }
}
