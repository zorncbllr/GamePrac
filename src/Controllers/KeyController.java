package Controllers;

import Components.InputHandler;
import Components.Panel;
import Fighters.Fighter;
import utils.Constant;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

public class KeyController extends KeyAdapter{
    private Panel panel;
    private List<Queue<Integer>> comboAttack;
    private InputHandler inputHandler;
    private List<List<Integer>> FIGHTERCONTROLS;
    List<Fighter> fighter;
    public KeyController(Panel panel){
        this.panel = panel;
        this.fighter = Arrays.asList(panel.fighter[0], panel.fighter[1]);
        this.inputHandler = new InputHandler(fighter.get(0));
        this.comboAttack = Arrays.asList(fighter.get(0).comboAttack, fighter.get(1).comboAttack);
        this.FIGHTERCONTROLS = Arrays.asList(Constant.FIGHTER_CONTROLS_1, Constant.FIGHTER_CONTROLS_2);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        e.getExtendedKeyCode();
        int keyCode = e.getKeyCode();

        if (FIGHTERCONTROLS.get(0).contains(keyCode)) {
                comboAttack.get(0).add(keyCode);
                if(comboAttack.get(0).size()>3) comboAttack.get(0).poll();
        }

        inputHandler.handleInputs(keyCode);
//
//        switch (keyCode) {
//            case 38 -> {
//                if (!fighter.get(1).attacking){
//                    fighter.get(1).isJumping = true;
//                    fighter.get(1).code = 87;
//                }
//            }
//            case 40 -> {
//                if (!fighter.get(1).isJumping && !fighter.get(1).attacking) fighter.get(1).code = 83;
//            }
//            case 39 -> {
//                if(!fighter.get(1).attacking){
//                    if (fighter.get(1).isJumping) {
//                        fighter.get(1).code = 300;
//                    } else fighter.get(1).code = 68;
//                }
//            }
//            case 37 -> {
//                if(!fighter.get(1).attacking){
//                    if (fighter.get(1).isJumping) {
//                        fighter.get(1).code = 200;
//                    }
//                    else fighter.get(1).code = 65;
//                }
//            }
//        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        int keyCode = e.getKeyCode();

        for (int i=0; i< 2; i++){
            if (FIGHTERCONTROLS.get(i).contains(keyCode)){
                if(!fighter.get(i).isJumping && !fighter.get(i).attacking)
                    fighter.get(i).code = 0;
            }
        }

    }
}
