/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bpreece.jtween;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Maintenance
 */
public class Movie extends JPanel
        implements Runnable
{
    private final static RenderingHints renderingHints;

    static
    {
        renderingHints = new RenderingHints(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_INTERPOLATION,
                           RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        renderingHints.put(RenderingHints.KEY_ANTIALIASING,
                           RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_ALPHA_INTERPOLATION,
                           RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
    }

    private final ParallelTimeline timeline;
    private final int framesPerSecond;
    private List<Tween> tweens;
    private Timer timer;
    private boolean loop = false;
    private long startTime;
    private long pauseTime;

    public Movie(int width, int height)
    {
        this(width, height, 15);
    }

    public Movie(int width, int height, int framesPerSecond)
    {
        super();
        this.setSize(width, height);
        this.setLayout(null);

        this.framesPerSecond = framesPerSecond;
        this.timeline = new ParallelTimeline();
        this.tweens = new ArrayList<Tween>();
    }

    public void addTween(Tween tween, int x, int y)
    {
        tween.setToTranslation(x, y);
        tweens.add(tween);
    }

    public void addTimeline(Timeline newTimeline)
    {
        timeline.add(newTimeline);
    }

    public void run()
    {
        pauseTime = 0;
        startTime = System.currentTimeMillis();
        int speed = 1000 / framesPerSecond;
        timer = new Timer(speed, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                timeline.step(System.currentTimeMillis() - startTime);
                repaint();
                if (!timeline.isActive())
                {
                    if (loop)
                    {
                        timeline.reset();
                    }
                    else
                    {
                        timer.stop();
                    }
                }
            }

        });
        timer.setInitialDelay(0);
        timer.setRepeats(true);
        timer.start();

    }

    public void pause()
    {
        timer.stop();
        pauseTime = System.currentTimeMillis();
    }

    public void resume()
    {
        if (pauseTime > startTime)
        {
            startTime += System.currentTimeMillis() - pauseTime;
            timer.restart();
        }
    }

    public void reset()
    {
        pauseTime = 0;
        timer.stop();
        timeline.reset();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Toolkit.getDefaultToolkit().sync();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHints(renderingHints);
        super.paintComponent(g);
        for (Tween tween : tweens)
        {
            tween.paint(g);
        }
    }

}
