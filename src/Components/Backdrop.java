package Components;

import Fighters.Fighter;
import utils.Constant;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Backdrop {
    private Panel panel;
    private float scale;
    private Fighter[] fighters;
    int backdropX, tick = 0, imageX = 14, imageY = 1, vx = 10, height, width, prev_backdropX;
    public BufferedImage backdrop;

    public Backdrop(String path, Panel panel){
        this.panel = panel;
        this.fighters = panel.fighter;
        this.scale = Constant.BACKDROP_SCALE;
        height =  (int) (245 * scale);
        width =  (int) (752 * scale);
        InputStream is = getClass().getResourceAsStream(path);
        try {
            backdrop = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.backdropX = -(int)(backdrop.getWidth()/1.5 - panel.getWidth());
        prev_backdropX = backdropX;
        System.out.println(backdropX);
    }

    public void drawBackdrop(Graphics2D g2d){
        tick++;
        if (tick>=1000/ Constant.FPS){
            tick = 0;
            imageY += 245 + 4;
        }
        if (imageY >= 1993) imageY = 1;

        handleCamera(g2d);

        g2d.drawImage(
             backdrop.getSubimage(
                     imageX, imageY, 752, 245
             ),
                backdropX, panel.getHeight() - height, width,
               height , null
        );
    }

    int prevX = 0;

    public void handleCamera(Graphics2D g2d){

        for (Fighter ftr: fighters){
            ftr.camera = panel.getWidth() - Math.abs(backdropX);
        }

        int dif = fighters[0].x - prevX;
        boolean atBackdropEnd = backdropX <= 0 || backdropX >= width - panel.getWidth();

        if (Math.abs(dif) > 0){
            prev_backdropX = backdropX;
            backdropX = prev_backdropX - fighters[0].x;
            prevX = fighters[0].x;
        }
    }
}
