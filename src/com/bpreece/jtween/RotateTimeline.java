/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bpreece.jtween;

/**
 *
 * @author Ly
 */
public class RotateTimeline extends Timeline
{
    private final Tween tween;
    private final int anchorX;
    private final int anchorY;
    private final double startAngle;
    private final double endAngle;
    private final long duration;

    public RotateTimeline(Tween tween, int anchorX, int anchorY, double startAngle, double endAngle, long duration)
    {
        this.tween = tween;
        this.anchorX = anchorX;
        this.anchorY = anchorY;
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.duration = duration;
    }

    @Override
    public void step(long now)
    {
        if (now >= duration)
        {
            tween.setToRotate(anchorX, anchorY, (float) endAngle);
            setActive(false);
        }
        else
        {
            double z = (double) now / duration;
            tween.setToRotate(anchorX, anchorY, (float) getValue(startAngle, endAngle, z));
        }
    }
}
