/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bpreece.jtween;

/**
 *
 * @author Ly
 */
public class ScaleTimeline extends Timeline
{
    private final Tween tween;
    private final double startX;
    private final double startY;
    private final double endX;
    private final double endY;
    private final long duration;

    public ScaleTimeline(Tween tween, double startX, double startY, double endX, double endY, long duration)
    {
        this.tween = tween;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.duration = duration;
    }

    public ScaleTimeline(Tween tween, double start, double end, long duration)
    {
        this(tween, start, start, end, end, duration);
    }

    @Override
    public void step(long now)
    {
        if (now >= duration)
        {
            tween.setToScale(endX, endY);
            setActive(false);
        }
        else
        {
            double z = (double) now / duration;
            tween.setToScale(getValue(startX, endX, z), getValue(startY, endY, z));
        }
    }
}
