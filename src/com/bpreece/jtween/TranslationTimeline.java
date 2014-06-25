/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bpreece.jtween;

/**
 *
 * @author Ly
 */
public class TranslationTimeline extends Timeline
{
    private final Tween tween;
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;
    private final long duration;

    public TranslationTimeline(Tween tween, int startX, int startY, int endX, int endY, long duration)
    {
        this.tween = tween;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.duration = duration;
    }

    @Override
    public void step(long now)
    {
        if (now >= duration)
        {
            tween.setToTranslation(endX, endY);
            setActive(false);
        }
        else
        {
            double z = (double) now / duration;
            tween.setToTranslation(getValue(startX, startY, z), getValue(startY, startY, z));
        }
    }
}
