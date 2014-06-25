
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpreece.jtween;

/**
 *
 * @author Maintenance
 */
public abstract class Timeline
{
    public static enum EaseType
    {
        EASE_NONE, EASE_IN, EASE_OUT,
    }
    private EaseType ease = EaseType.EASE_NONE;
    private boolean active = true;

    public abstract void step(long now);

    public void reset()
    {
        setActive(true);
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public EaseType getEase()
    {
        return ease;
    }

    public void setEase(EaseType ease)
    {
        this.ease = ease;
    }

    double getValue(int start, int end, double progress)
    {
        return getValue((1.0 - progress) * start + progress * end);
    }

    double getValue(double start, double end, double progress)
    {
        return getValue((1.0 - progress) * start + progress * end);
    }

    double getValue(double z)
    {
        switch (ease)
        {
        default:
        case EASE_NONE:
            return easeNone(z);
        case EASE_IN:
            return easeIn(z);
        case EASE_OUT:
            return easeOut(z);
        }
    }

    double easeNone(double z)
    {
        return z;
    }

    double easeIn(double z)
    {
        return z * z;
    }

    double easeOut(double z)
    {
        return z * (2 - z);
    }

    double easeBoth(double z)
    {
        return 0.5 * (1 - Math.cos(Math.PI * z));
    }

}
