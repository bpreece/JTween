/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bpreece.jtween;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Ly
 */
public abstract class Tween
{
    AffineTransform affineTransform = AffineTransform.getTranslateInstance(0, 0);
    AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);
    Shape clip;
    Paint paint;

    public Tween setClip(Shape clip)
    {
        this.clip = clip;
        return this;
    }

    public Tween setPaint(Paint paint)
    {
        this.paint = paint;
        return this;
    }

    public Tween setAlpha(float alpha)
    {
        alphaComposite = alphaComposite.derive(alpha);
        return this;
    }

    public Tween setAlphaRule(int rule)
    {
        alphaComposite = alphaComposite.derive(rule);
        return this;
    }

    public Tween setToRotate(double theta, double anchorX, double anchorY)
    {
        affineTransform.setToRotation(theta, anchorX, anchorY);
        return this;
    }

    public Tween setToScale(double scaleX, double scaleY)
    {
        affineTransform.setToScale(scaleX, scaleY);
        return this;
    }

    public Tween setToTranslateX(double xlateX)
    {
        affineTransform.setToTranslation(xlateX, affineTransform.getTranslateY());
        return this;
    }

    public Tween setToTranslateY(double xlateY)
    {
        affineTransform.setToTranslation(affineTransform.getTranslateX(), xlateY);
        return this;
    }

    public Tween setToTranslation(double xlateX, double xlateY)
    {
        affineTransform.setToTranslation(xlateX, xlateY);
        return this;
    }

    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(alphaComposite);
        g2d.setTransform(affineTransform);
    }

}
