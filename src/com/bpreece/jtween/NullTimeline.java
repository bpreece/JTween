/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpreece.jtween;

/**
 *
 * @author Maintenance
 */
public class NullTimeline extends Timeline
{
    private final long delay;

    public NullTimeline(long delay)
    {
        this.delay = delay;
    }

    @Override
    public void step(long now)
    {
        if (now >= delay) {
            setActive(false);
        }
    }

    @Override
    public void reset()
    {
    }
}
