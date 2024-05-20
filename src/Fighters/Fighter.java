package Fighters;

import Components.Fireball;
import Components.Panel;
import utils.Constant;
import utils.Method;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

abstract public class Fighter {
    public float scale;
    public int x, y = 520, vx = Constant.vx, camera, tracker, fighterX, fighterY, code = 0, activeIndex, width, height ,direction;
    public Queue<Integer> comboAttack;
    public boolean isJumping = false, punching = false, kicking = false, attacking = false, hurt = false;
    public Fighter enemy;
    public Rectangle pushBox, hitBox;
    public BufferedImage fighter;
    public int[][][] activeFrame;
    int tick = 0;
    private int i=0, j=0, h=0, d=0;
    public int p=0;
    Panel panel;
    public int[][] fireball;
    public int[][][] walkingForward, walkingBackward, idle, crouch, jump, jumpForward, jumpBackward,
            jab, punch, lightKick, heavyKick, hurt1, hurt2;
    public int[][][][] comboSprites;
    Method[] method = new Method[]{
        this::combo1,
        this::combo2,
        this::combo3
    };

    Fighter(Panel panel, int playerPosition){
        this.panel = panel;
        this.x = playerPosition;
        this.comboAttack = new LinkedList<>();
        tracker = 0;
        scale = Constant.SIZE;

        pushBox = new Rectangle();
        hitBox = new Rectangle();
    }
    public void init(String path){
        InputStream is = getClass().getResourceAsStream(path);
        try {
            fighter = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public abstract void combo1(Graphics2D g2d);
    public abstract void combo2(Graphics2D g2d);
    public abstract void combo3(Graphics2D g2d);

    public void idle(Graphics2D g2d){
        basic(g2d, idle);
    }
    public void crouch(Graphics2D g2d){
        tick++;
        if(tick >= 1000/Constant.FPS){
            tick = 0;
            d++;
        }
        if(d >= crouch.length){
            d = crouch.length-1;
        }
        draw(g2d, crouch, d);
    }
    public void walkForward(Graphics2D g2d){
        basic(g2d, walkingForward);
    }
    public void walkBackward(Graphics2D g2d){
        basic(g2d, walkingBackward);
    }
    public void jab(Graphics2D g2d){
        attack(g2d, jab);
    }
    public void punch(Graphics2D g2d){
        attack(g2d, punch);
    }
    public void lightKick(Graphics2D g2d){
        attack(g2d, lightKick);
    }
    public void heavyKick(Graphics2D g2d){
        attack(g2d, heavyKick);
    }
    public void attack(Graphics2D g2d, int[][][] frames){
        tick++;
        if (tick >= 1000/Constant.FPS){
            tick = 0;
            p++;
        }
        if (p >= frames.length){
            p = 0;
            attacking = false;
            if(punching) punching = false;
            if(kicking) kicking = false;
            code = 0;
        }
        draw(g2d, frames, p);
    }
    public void hurt(Graphics2D g2d){
        hurt = true;
        tick++;
        int[][][] frames = enemy.kicking? hurt2: hurt1;
        if (tick >= 1000/ Constant.FPS){
            tick = 0;
            h++;
        }
        if (h >= (frames.length)){
            h = 0;
            code = 0;
            hurt = false;
            return;
        }
        draw(g2d, frames, h);
    }
    public void jumpForward(Graphics2D g2d){
        jump(g2d, jumpForward);
    }
    public void jumpBackward(Graphics2D g2d){
        jump(g2d, jumpBackward);
    }
    public void jump(Graphics2D g2d){
        jump(g2d, jump);
    }
    public void jump(Graphics2D g2d,int[][][] frame){
        tick++;
        if (tick >= 1000/Constant.FPS){
            tick = 0;
            j++;
        }
        if(j >= frame.length){
            isJumping = false;
            j = 0;
            code = 0;
        }
        draw(g2d, frame, j);
    }
    private void basic(Graphics2D g2d, int[][][] frames){
        tick++;
        if(tick >= 1000/Constant.FPS){
            tick = 0;
            i++;
        }
        if (i >= frames.length) i = 0;
        draw(g2d, frames, i);
    }
    public void draw(Graphics2D g2d, int[][][] frame,int index){
        this.activeIndex = index;
        this.activeFrame = frame;
        this.width = (int) (frame[index][0][2] * (scale * direction));
        this.height = (int) (frame[index][0][3] * scale);
        int groundGap = (int) (frame[index][0][4] * Constant.GROUNDGAP);

         this.fighterX = camera + (x-width/2);
         this.fighterY = y-(height+groundGap);

        g2d.drawImage(fighter.getSubimage(
                frame[index][0][0],
                frame[index][0][1],
                frame[index][0][2],
                frame[index][0][3]
        ), fighterX ,fighterY , width, height, null);

        setPushBox(g2d, index, frame);
        drawDimension(g2d, frame, index);

            if (attacking && !hurt) setHitBox(g2d, index, frame);

    }

    public void drawDebug(Graphics2D g2d, int x_box, int y_box, int box_width, int box_height){
        g2d.setColor(Color.green);
        g2d.drawRect(x_box, y_box, box_width, box_height);
        g2d.setColor(Color.BLUE);
        g2d.fillRect(x, y, 5,5);
    }

    public void drawDimension(Graphics2D g2d, int[][][] frame, int index){
        int x_box = (int) (direction>0? fighterX : fighterX-frame[index][0][2]*scale);
        int box_width = (int) (frame[index][0][2] * scale);
        int box_height = (int) (frame[index][0][3] * scale);

        if (((camera + x) + (box_width/2)) >= panel.getWidth()){
            x -= code==300 || code==200? (int) (vx + 1.7) : vx;
        }
        if (((camera + x) - (box_width/2)) <= 0){
            x += code==300 || code==200? (int) (vx + 1.7) : vx;
        }

        g2d.setColor(Color.magenta);
       // g2d.drawRect(x_box, fighterY, box_width, box_height);
    }


    public void drawDebugHit(Graphics2D g2d, int x_box, int y_box, int box_width, int box_height){
        g2d.setColor(Color.red);
        g2d.drawRect(x_box, y_box, box_width, box_height);
    }
    public void setPushBox(Graphics2D g2d, int index, int[][][] frame){
        int groundGap = (int) (frame[index][0][4] * Constant.GROUNDGAP);
        int x_box = camera + (int) (direction>0? x-frame[index][1][0] * scale :
                        x-((frame[index][1][2] * scale) - (frame[index][1][0] * scale)));
        int y_box = (int) (y-(frame[index][1][1] * scale + groundGap));
        int box_width = (int) (frame[index][1][2] * scale);
        int box_height = (int) (frame[index][1][3] * scale);

        pushBox.setBounds(x_box, y_box, box_width, box_height);
      //  drawDebug(g2d, x_box, y_box, box_width, box_height);
    }
    public void setHitBox(Graphics2D g2d, int index, int[][][] frame){
        int groundGap = (int) (frame[index][0][4] * Constant.GROUNDGAP);
        int x_box = camera + (int) (direction>0? x-frame[index][2][0] * scale :
                        x-((frame[index][2][2]*scale) - (frame[index][2][0]*scale)));
        int y_box = (int) (y-(frame[index][2][1] * scale + groundGap));
        int box_width = (int) (frame[index][2][2] * scale);
        int box_height = (int) (frame[index][2][3] * scale);

        hitBox.setBounds(x_box, y_box, box_width, box_height);
       // drawDebugHit(g2d,x_box, y_box, box_width, box_height);
    }

    public boolean colliding(){
        if(pushBox.intersects(enemy.pushBox)) {
            enemy.x += direction;
            return true;
        }
        return false;
    }
    public boolean hurting(){
        if (enemy.hitBox.intersects(pushBox)){
            i = 0; j = 0; p = 0;
            hurt = true;
            return true;
        }
        return false;
    }

    public boolean hitting(){
        if (hitBox.intersects(enemy.pushBox)){
            enemy.x += activeFrame==lightKick || activeFrame==jab?
                    direction * 2: direction * 50;

            enemy.code = 404;
            return  true;
        }
        return  false;
    }
    public void handleAnimation(Graphics2D g2d){
        this.direction = x >= enemy.x? -1: 1;

        switch (code) {
            case 87 -> jump(g2d);
            case 83 -> crouch(g2d);
            case 68 -> {
                if (direction > 0) walkForward(g2d);
                else walkBackward(g2d);
                if(!colliding()) x += vx;
            }
            case 65 -> {
                if (direction > 0) walkBackward(g2d);
                else walkForward(g2d);
                if(!colliding()) x -= vx;
            }
            case 200 -> {
                if (direction > 0) jumpBackward(g2d);
                else jumpForward(g2d);
                if(!colliding()) x -= (int) (vx + 1.7);
            }
            case 300 -> {
                if (direction > 0) jumpForward(g2d);
                else jumpBackward(g2d);
                if(!colliding()) x += (int) (vx + 1.7);
            }
            case 404 -> {
                hurt = true;
                hurt(g2d);
            }
            case 53 ->{
                jab(g2d);
            }
            case 54 -> punch(g2d);
            case 84 -> {
                lightKick(g2d);
            }
            case 89 -> {
                heavyKick(g2d);
            }
            default -> idle(g2d);
        }
    }
    public Stack<Fireball> fireballList = new Stack<>();
    public void handleFireBall(Graphics2D g2d){
        try {
            fireballList.forEach(fire -> {
                int fireX = camera + fire.distance;
                int fireY = fire.fireY;
                int firewidth =  (int) (fireball[fire.i][2] * direction * scale/1.5f);
                int fireheight = (int) (fireball[fire.i][3] * scale/1.5f);

                g2d.drawImage(
                        fighter.getSubimage(
                                fireball[fire.i][0],
                                fireball[fire.i][1],
                                fireball[fire.i][2],
                                fireball[fire.i][3]
                        ),
                        fireX, fireY, firewidth, fireheight, null
                );

                fireX = direction>0? fireX: (int) (fireX - (fireball[fire.i][2] * scale/1.5f));
                firewidth = Math.abs(firewidth);

                hitBox.setBounds(fireX, fireY, firewidth, fireheight);

             //   drawDebugHit(g2d, fireX, fireY, firewidth, fireheight);
                fire.update();
            });
        } catch (Exception ignored) {}
    }
    public void update(Graphics2D g2d) {
        if(code!=83) d = 0;
        if(kicking || punching) attacking = true;
        if (hurting()) hitBox.setBounds(0,0,0,0);
        colliding();
        hitting();

        for (int com = 0; com < Constant.FIGHTER_COMBO.size(); com++){
            if (Constant.FIGHTER_COMBO.get(com).equals(comboAttack)){
                method[com].execute(g2d);
                if (!attacking){
                    comboAttack.removeAll(comboAttack);
                }
                return;
            }
        }
        handleAnimation(g2d);
    }
}
