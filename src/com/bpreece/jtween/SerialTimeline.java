/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bpreece.jtween;

import java.util.Arrays;

/**
 *
 * @author Ly
 */
public class SerialTimeline extends Timeline
{
    private final Timeline[] timelines;
    private int index = 0;
    private long elapsedTime = 0;

    public SerialTimeline(Timeline... timelines)
    {
        this.timelines = Arrays.copyOf(timelines, timelines.length);
    }

    @Override
    public void step(long now)
    {
        timelines[index].step(now - elapsedTime);
        while (index < timelines.length && ! timelines[index].isActive()) {
            index++;
            elapsedTime = now;
        }
    }

    @Override
    public boolean isActive()
    {
        return (index < timelines.length && timelines[index].isActive());
    }

    @Override
    public void reset()
    {
        index = 0;
        elapsedTime = 0;
        for (Timeline timeline : timelines) {
            timeline.reset();
        }
    }
}
