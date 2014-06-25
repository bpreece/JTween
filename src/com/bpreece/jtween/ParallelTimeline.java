/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bpreece.jtween;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Maintenance
 */
public class ParallelTimeline extends Timeline
{
    private ArrayList<Timeline> timelines = new ArrayList<Timeline>();

    public ParallelTimeline(Timeline... timelines)
    {
        this.timelines.addAll(Arrays.asList(timelines));

        setActive(false);
        for (Timeline timeline : timelines)
        {
            if (timeline.isActive())
            {
                setActive(true);
            }
        }
    }

    void add(Timeline newTimeline)
    {
        timelines.add(newTimeline);
        if (newTimeline.isActive())
        {
            setActive(true);
        }
    }

    @Override
    public void step(long now)
    {
        if (!isActive())
        {
            return;
        }

        setActive(false);
        for (Timeline timeline : timelines)
        {
            if (timeline.isActive())
            {
                timeline.step(now);
                setActive(true);
            }
        }
    }

    @Override
    public void reset()
    {
        for (Timeline timeline : timelines)
        {
            timeline.reset();
        }
    }

}
