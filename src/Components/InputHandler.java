package Components;

import Fighters.Fighter;
import utils.Constant;

import java.util.Random;

public class InputHandler {
    private Fighter fighter;
    public InputHandler(Fighter fighter){
        this.fighter = fighter;
    }
    public void handleInputs(int input){

        switch (input) {
            // fighter 1 controls
            case 87 -> {
                if (!fighter.attacking && !fighter.hurt){
                    fighter.isJumping = true;
                    fighter.code = 87;
                }
            }
            case 83 -> {
                if (!fighter.isJumping && !fighter.attacking && !fighter.hurt) fighter.code = 83;
            }
            case 68 -> {
                if(!fighter.attacking && !fighter.hurt){
                    if (fighter.isJumping) {
                        fighter.code = 300;
                    } else fighter.code = 68;
                }
            }
            case 65 -> {
                if(!fighter.attacking && !fighter.hurt){
                    if (fighter.isJumping) {
                        fighter.code = 200;
                    }
                    else fighter.code = 65;
                }
            }
            case 53 -> {
                if (!fighter.isJumping && !fighter.attacking && !fighter.hurt){
                    fighter.punching = true;
                    fighter.code = 53;
                }
            }
            case 54 -> {
                if(!fighter.isJumping && !fighter.attacking && !fighter.hurt){
                    fighter.punching = true;
                    fighter.code = 54;
                }
            }
            case 84 -> {
                if(!fighter.isJumping && !fighter.attacking && !fighter.hurt) {
                    fighter.kicking = true;
                    fighter.code = 84;
                }
            }
            case 89 -> {
                if(!fighter.isJumping && !fighter.attacking && !fighter.hurt) {
                    fighter.kicking = true;
                    fighter.code = 89;
                }
            }
        }
    }

    Random rand = new Random();
    int i = 0, tick = 0;
    public void handleComputerMove(){

        tick++;
        if (tick >= 1000/ Constant.FPS){
            tick = 0;

            int distance =  Math.abs(fighter.x - fighter.enemy.x);
            int computerMove = Constant.FIGHTER_CONTROLS_1.get(rand.nextInt(0,Constant.FIGHTER_CONTROLS_1.size()));
            int walk = fighter.direction>0? 68: 65;
            computerMove = distance >= 180? walk: computerMove;

            if (!fighter.hurt)  {
                this.handleInputs(computerMove);
            }
        }
    }
}
