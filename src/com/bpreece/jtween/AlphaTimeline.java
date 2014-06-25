/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpreece.jtween;

/**
 *
 * @author Maintenance
 */
public class AlphaTimeline extends Timeline
{
    private final Tween tween;
    private final double startAlpha;
    private final double endAlpha;
    private final long duration;

    public AlphaTimeline(Tween tween, double startAlpha, double endAlpha, long duration)
    {
        this.tween = tween;
        this.startAlpha = startAlpha;
        this.endAlpha = endAlpha;
        this.duration = duration;
    }

    @Override
    public void step(long now)
    {
        if (now >= duration) {
            tween.setAlpha((float) endAlpha);
            setActive(false);
        } else {
            double z = (double) now / duration;
            tween.setAlpha((float) getValue(startAlpha, endAlpha, z));
        }
    }
}
