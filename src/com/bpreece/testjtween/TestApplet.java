/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bpreece.testjtween;

import com.bpreece.jtween.AlphaTimeline;
import com.bpreece.jtween.ImageTween;
import com.bpreece.jtween.Movie;
import com.bpreece.jtween.NullTimeline;
import com.bpreece.jtween.ParallelTimeline;
import com.bpreece.jtween.ScaleTimeline;
import com.bpreece.jtween.SerialTimeline;
import com.bpreece.jtween.TextTween;
import com.bpreece.jtween.Tween;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JApplet;

/**
 *
 * @author Ly
 */
public class TestApplet extends JApplet
{
    Movie movie;

    private Image loadImage(String name)
    {
        return Toolkit.getDefaultToolkit().createImage(getClass().getResource(name));
    }

    /**
     * Called by the browser or applet viewer to inform this applet that it
     * has been loaded into the system. It is always called before the first
     * time that the start method is called.
     * <p>
     * A subclass of Applet should override this method if it has
     * initialization to perform. For example, an applet with threads would
     * use the init method to create the threads and the destroy method to
     * kill them.
     */
    @Override
    public void init()
    {
        // start asynchronous download of heavy resources

        Tween image1 = new ImageTween(loadImage("resources/Stuart_1_631x480.png")).setAlpha(0);
        Tween image2 = new ImageTween(loadImage("resources/Stuart_2_409x480.png")).setAlpha(0);
        Tween image3 = new ImageTween(loadImage("resources/Stuart_3_329x480.png")).setAlpha(0);
        Tween image4 = new ImageTween(loadImage("resources/Stuart_4_404x480.png")).setAlpha(0);
        Tween thumb1 = new ImageTween(loadImage("resources/Stuart_1_100x120.png")).setAlpha(0);
        Tween thumb2 = new ImageTween(loadImage("resources/Stuart_2_100x120.png")).setAlpha(0);
        Tween thumb3 = new ImageTween(loadImage("resources/Stuart_3_100x120.png")).setAlpha(0);
        Tween thumb4 = new ImageTween(loadImage("resources/Stuart_4_100x120.png")).setAlpha(0);
        Tween stuartImage = new ImageTween(loadImage("resources/Gilbert_Stuart.png")).setAlpha(0);
        Tween painterImage = new ImageTween(loadImage("resources/American_Painter.png")).setAlpha(0);
        Tween authorTween = new TextTween("Author: Ben Preece, 2010", new Font("SansSerif", Font.PLAIN, 10));

        // construct graphical components

        movie = new Movie(920, 460, 25);
        movie.setBackground(new Color(237, 237, 173));
        setContentPane(movie);

        movie.addTween(image1, 0, 0);
        movie.addTween(image2, 0, 0);
        movie.addTween(image3, 0, 0);
        movie.addTween(image4, 0, 0);
        movie.addTween(thumb1, 720, 290);
        movie.addTween(thumb2, 570, 290);
        movie.addTween(thumb3, 420, 290);
        movie.addTween(thumb4, 270, 290);
        movie.addTween(stuartImage, 100, 100);
        movie.addTween(painterImage, 105, 200);
        movie.addTween(authorTween, 755, 445);
        
        // start threads running

        movie.addTimeline(
                new SerialTimeline(
                    // show image 1
                    new ParallelTimeline(
                        // fade large image in and out while zooming
                        new ParallelTimeline(
                            new ScaleTimeline(image1, 1.0, 1.05, 10000),
                            new SerialTimeline(
                                new AlphaTimeline(image1, 0, 1, 4000),
                                new NullTimeline(2000),
                                new AlphaTimeline(image1, 1, 0, 4000)
                            )
                        ),
                        // add thumb
                        new SerialTimeline(
                            new NullTimeline(7000),
                            new AlphaTimeline(thumb1, 0, 1, 3000)
                        )
                    ),
                    // show image 2
                    new ParallelTimeline(
                        // fade large image in and out
                        new ParallelTimeline(
                            new ScaleTimeline(image2, 1.0, 1.05, 10000),
                            new SerialTimeline(
                                new AlphaTimeline(image2, 0, 1, 4000),
                                new NullTimeline(2000),
                                new AlphaTimeline(image2, 1, 0, 4000)
                            )
                        ),
                        // add thumb
                        new SerialTimeline(
                            new NullTimeline(7000),
                            new AlphaTimeline(thumb2, 0, 1, 3000)
                        )
                    ),
                    // show image 3
                    new ParallelTimeline(
                        // fade large image in and out
                        new ParallelTimeline(
                            new ScaleTimeline(image3, 1.0, 1.05, 10000),
                            new SerialTimeline(
                                new AlphaTimeline(image3, 0, 1, 4000),
                                new NullTimeline(2000),
                                new AlphaTimeline(image3, 1, 0, 4000)
                            )
                        ),
                        // add thumb
                        new SerialTimeline(
                            new NullTimeline(7000),
                            new AlphaTimeline(thumb3, 0, 1, 3000)
                        )
                    ),
                    // show image 4
                    new ParallelTimeline(
                        // fade large image in and out
                        new ParallelTimeline(
                            new ScaleTimeline(image4, 1.0, 1.05, 10000),
                            new SerialTimeline(
                                new AlphaTimeline(image4, 0, 1, 4000),
                                new NullTimeline(2000),
                                new AlphaTimeline(image4, 1, 0, 4000)
                            )
                        ),
                        // add thumb
                        new SerialTimeline(
                            new NullTimeline(7000),
                            new AlphaTimeline(thumb4, 0, 1, 3000)
                        )
                    ),
                    // fade in the name and caption
                    new AlphaTimeline(stuartImage, 0, 1, 2000),
                    new AlphaTimeline(painterImage, 0, 1, 2000)
                ));

        repaint();
        movie.run();
    }

    /**
     * Called by the browser or applet viewer to inform this applet that it
     * should start its execution. It is called after the init method and
     * each time the applet is revisited in a Web page.
     * <p>
     * A subclass of Applet should override this method if it has any operation
     * that it wants to perform each time the Web page containing it is
     * visited. For example, an applet with animation might want to use the
     * start method to resume animation, and the stop method to suspend the
     * animation.
     */
    @Override
    public void start()
    {
    }

    /**
     * Called by the browser or applet viewer to inform this applet that it is
     * being reclaimed and that it should destroy any resources that it has
     * allocated. The stop method will always be called before destroy.
     * <p>
     * A subclass of Applet should override this method if it has any operation
     * that it wants to perform before it is destroyed. For example, an applet
     * with threads would use the init method to create the threads and the
     * destroy method to kill them.
     */
    @Override
    public void stop()
    {
    }

    /**
     * Called by the browser or applet viewer to inform this applet that it is
     * being reclaimed and that it should destroy any resources that it has
     * allocated. The stop method will always be called before destroy.
     * <p>
     * A subclass of Applet should override this method if it has any
     * operation that it wants to perform before it is destroyed. For example,
     * an applet with threads would use the init method to create the threads
     * and the destroy method to kill them.
     */
    @Override
    public void destroy()
    {
        // TODO terminate all running threads
    }

}
