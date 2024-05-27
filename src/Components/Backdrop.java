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
    int backdropX, tick = 0, imageX = 14, imageY = 1, vx = 10, height, width;
    public BufferedImage backdrop;
    public Backdrop(String path, Panel panel){
        this.panel = panel;
        this.fighters = panel.fighter;
        this.scale = Constant.BACKDROP_SCALE;
        InputStream is = getClass().getResourceAsStream(path);
        try {
            backdrop = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.backdropX = -752;
    }
    public void drawBackdrop(Graphics2D g2d){
        tick++;
        if (tick>=1000/ Constant.FPS){
            tick = 0;
            imageY += 245 + 4;
            handleCamera(g2d);
        }
        if (imageY >= 1993) imageY = 1;

        height =  (int) (245 * scale);
        width =  (int) (752 * scale);

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

        int dif = Math.abs(fighters[0].x - prevX);

        if (dif > 0){
            backdropX -= (fighters[0].x - prevX);
            prevX = fighters[0].x;
        }
    }
}
