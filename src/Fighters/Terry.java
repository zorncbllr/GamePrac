package Fighters;

import Components.Fireball;
import Components.Panel;

import java.awt.*;

public class Terry extends  Fighter{

    private int[][][] groundEffects;
    public Terry(Panel panel, int playerPosition) {
        super(panel, playerPosition);
        super.init("/Terry.png");
        super.idle = new int[][][]{
                {{7, 10, 71, 105, 0}, {17, 90, 33, 90}, {0,0,0,0}},
                {{97, 12, 70, 103, 0}, {17, 90, 33, 90}, {0,0,0,0}},
                {{193, 12, 70, 103, 0}, {17, 90, 33, 90}, {0,0,0,0}},
                {{288, 13, 70, 102, 0}, {17, 90, 33, 90}, {0,0,0,0}},
                {{379, 15, 70, 100, 0}, {17, 90, 33, 90}, {0,0,0,0}},
                {{470, 16, 70, 99, 0},  {17, 90, 33, 90}, {0,0,0,0}},
                {{566, 16, 70, 99, 0}, {17, 90, 33, 90}, {0,0,0,0}},
                {{656, 13, 70, 102, 0}, {17, 90, 33, 90}, {0,0,0,0}}
        };
        super.walkingForward = new int[][][]{
                {{8, 653, 63, 101, 0}, {23, 91, 37, 91}, {0,0,0,0}},
                {{94, 650, 61, 104, 0}, {20, 92, 38, 91}, {0,0,0,0}},
                {{171, 645, 54, 109, 0}, {22, 93, 36, 91}, {0,0,0,0}},
                {{240, 641, 51, 113, 3}, {22, 95, 36, 91}, {0,0,0,0}},
                {{309, 645, 50, 109, 0}, {23, 94, 37, 91}, {0,0,0,0}},
                {{381, 649, 56, 105, 0}, {23, 92, 37, 91}, {0,0,0,0}},
                {{452, 653, 63, 101, 0}, {23, 91, 37, 91}, {0,0,0,0}},
        };
        super.walkingBackward = new int[][][]{
                {{559, 651, 63, 103, 0}, {25, 91, 37, 90}, {0,0,0,0}},
                {{640, 648, 56, 106, 0}, {26, 94, 39, 94}, {0,0,0,0}},
                {{713, 644, 48, 110, 0}, {25, 98, 39, 98}, {0,0,0,0}},
                {{778, 640, 47, 114, 3}, {24, 101, 38, 101}, {0,0,0,0}},
                {{840, 643, 44, 111, 0}, {21, 99, 36, 99}, {0,0,0,0}},
                {{905, 648, 49, 106, 0}, {23, 92, 37, 92}, {0,0,0,0}},
                {{971, 651, 63, 103, 0}, {25, 91, 40, 91}, {0,0,0,0}},
        };
        super.crouch = new int[][][]{
                {{656, 13, 70, 102, 0}, {19, 62, 36, 62}, {0,0,0,0}},
                {{752, 36, 63, 79, 0},  {19, 62, 36, 62}, {0,0,0,0}},
                {{837, 42, 63, 73, 0},  {19, 62, 36, 62}, {0,0,0,0}},
                {{921, 42, 63, 73, 0},  {19, 62, 36, 62}, {0,0,0,0}}
        };
        super.jump = new int[][][]{
                {{7, 201, 63, 80, 0}, {20, 70, 35, 70}, {0,0,0,0}},
                {{90, 208, 63, 73, 0}, {22, 65, 37, 65}, {0,0,0,0}},
                {{174, 146, 44, 135, 12}, {21, 152, 38, 58}, {0,0,0,0}},
                {{174, 146, 44, 135, 50}, {21, 152, 38, 58}, {0,0,0,0}},
                {{174, 146, 44, 135, 70}, {21, 152, 38, 58}, {0,0,0,0}},
                {{236, 172, 43, 109, 91}, {21, 100, 33, 55}, {0,0,0,0}},
                {{297, 191, 55, 90, 101}, {22, 100, 35, 40}, {0,0,0,0}},
                {{366, 183, 49, 98, 91}, {22, 100, 38, 50}, {0,0,0,0}},
                {{436, 144, 62, 136, 70}, {24, 100, 36, 61}, {0,0,0,0}},
                {{511, 144, 60, 137, 50}, {24, 100, 36, 61}, {0,0,0,0}},
                {{511, 144, 60, 137, 5}, {24, 100, 36, 61}, {0,0,0,0}},
                {{588, 208, 64, 73, 0}, {22, 65, 37, 65}, {0,0,0,0}},
                {{672, 201, 63, 80, 0}, {20, 70, 35, 70}, {0,0,0,0}},
        };
        super.jumpForward = new int[][][]{
                {{7, 201, 63, 80, 0}, {20, 70, 35, 70}, {0,0,0,0}},
                {{90, 208, 63, 73, 0}, {22, 65, 37, 65}, {0,0,0,0}},
                {{168, 354, 55, 90, 50}, {23, 56, 48, 38}, {0,0,0,0}},
                {{240, 374, 55, 50, 91}, {23, 48, 45, 48}, {0,0,0,0}},
                {{309, 365, 50, 55, 98}, {23, 39, 52, 39}, {0,0,0,0}},
                {{374, 378, 62, 44, 100}, {21, 58, 40, 48}, {0,0,0,0}},
                {{451, 363, 44, 62, 97}, {23, 95, 37, 78}, {0,0,0,0}},
                {{508, 346, 49, 98, 70}, {24, 100, 36, 61}, {0,0,0,0}},
                {{511, 144, 60, 137, 50}, {24, 100, 36, 61}, {0,0,0,0}},
                {{511, 144, 60, 137, 5}, {24, 100, 36, 61}, {0,0,0,0}},
                {{588, 208, 64, 73, 0}, {22, 65, 37, 65}, {0,0,0,0}},
                {{672, 201, 63, 80, 0}, {20, 70, 35, 70}, {0,0,0,0}},
        };
        super.jumpBackward = new int[][][]{
                {{7, 201, 63, 80, 0}, {20, 70, 35, 70}, {0,0,0,0}},
                {{90, 208, 63, 73, 0}, {22, 65, 37, 65}, {0,0,0,0}},
                {{168, 354, 55, 90, 50}, {23, 56, 48, 38}, {0,0,0,0}},
                {{374, 378, 62, 44, 91}, {21, 58, 40, 48}, {0,0,0,0}},
                {{309, 365, 50, 55, 98}, {23, 39, 52, 39}, {0,0,0,0}},
                {{240, 374, 55, 50, 100}, {23, 48, 45, 48}, {0,0,0,0}},
                {{451, 363, 44, 62, 97}, {23, 95, 37, 78}, {0,0,0,0}},
                {{508, 346, 49, 98, 70}, {24, 100, 36, 61}, {0,0,0,0}},
                {{511, 144, 60, 137, 50}, {24, 100, 36, 61}, {0,0,0,0}},
                {{511, 144, 60, 137, 5}, {24, 100, 36, 61}, {0,0,0,0}},
                {{588, 208, 64, 73, 0}, {22, 65, 37, 65}, {0,0,0,0}},
                {{672, 201, 63, 80, 0}, {20, 70, 35, 70}, {0,0,0,0}},
        };
        super.jab = new int[][][]{
                {{7, 1150, 69, 104, 0}, {12, 94, 31, 94}, {0,0,0,0}},
                {{96, 1150, 94, 104, 0}, {24, 94, 34, 94}, {4, 103, 58, 26}},
                {{96, 1150, 94, 104, 0}, {24, 94, 34, 94}, {4, 103, 58, 26}},
                {{7, 1150, 69, 104, 0}, {12, 94, 31, 94}, {0,0,0,0}},
                {{210, 1150, 70, 104, 0}, {20, 93, 36, 93}, {0,0,0,0}},
        };
        super.punch = new int[][][] {
                {{7, 1150, 69, 104, 0}, {12, 94, 31, 94}, {0,0,0,0}},
                {{430, 1152, 70, 102, 0}, {2, 90, 29, 90}, {0,0,0,0}},
                {{430, 1152, 70, 102, 0}, {2, 90, 29, 90}, {0,0,0,0}},
                {{522, 1161, 117, 93, 0}, {17, 85, 35, 85}, {5, 93, 72, 33}},
                {{658, 1159, 117, 95, 0}, {15, 85, 31, 85}, {0, 95, 63, 32}},
                {{522, 1161, 117, 93, 0}, {17, 85, 35, 85}, {5, 93, 72, 33}},
                {{658, 1159, 117, 95, 0}, {15, 85, 31, 85}, {0, 95, 63, 32}},
                {{794, 1160, 94, 94, 0}, {12, 86, 31, 86}, {0, 81, 49, 25}},
                {{794, 1160, 94, 94, 0}, {12, 86, 31, 86}, {0,0,0,0}},
                {{907, 1159, 80, 95, 0}, {9, 86, 29, 86}, {0,0,0,0}},
                {{1009, 1150, 71, 104, 0}, {12, 96, 29, 96}, {0,0,0,0}},
                {{1102, 1150, 70, 104, 0}, {19, 92, 36, 92}, {0,0,0,0}}
        };
        super.lightKick = new int[][][]{
                {{430, 1152, 70, 102, 0}, {2, 90, 29, 90}, {0,0,0,0}},
                {{8, 1281, 46, 101, 0}, {19, 94, 33, 94}, {0,0,0,0}},
                {{71, 1277, 115, 105, 0}, {33, 96, 35, 96}, {17, 97, 79, 40}},
                {{205, 1276, 116, 106, 0}, {37, 94, 36, 94}, {20, 88, 82, 39}},
                {{8, 1281, 46, 101, 0}, {19, 94, 33, 94}, {0,0,0,0}},
                {{8, 1281, 46, 101, 0}, {19, 94, 33, 94}, {0,0,0,0}},
                {{430, 1152, 70, 102, 0}, {2, 90, 29, 90}, {0,0,0,0}},
                {{7, 1150, 69, 104, 0}, {12, 94, 31, 94}, {0,0,0,0}},
                {{492, 1278, 70, 104, 0}, {20, 93, 35, 93}, {0,0,0,0}}
        };
        super.heavyKick = new int[][][] {
                {{222, 2135, 62, 102, 0}, {25, 95, 33, 95}, {0,0,0,0}},
                {{13, 1409, 44, 101, 0}, {17, 97, 30, 97}, {0,0,0,0}},
                {{77, 1409, 61, 101, 0}, {18, 93, 36, 93}, {0,0,0,0}},
                {{158, 1411, 112, 99, 0}, {45, 95, 36, 95}, {20, 100, 81, 43}},
                {{289, 1410, 110, 100, 0}, {41, 97, 40, 97}, {22, 111, 83, 51}},
                {{289, 1410, 110, 100, 0}, {41, 97, 40, 97}, {22, 111, 85, 51}},
                {{420, 1407, 86, 103, 0}, {33, 97, 36, 97}, {12, 109, 61, 52}},
                {{525, 1407, 71, 103, 0}, {22, 97, 33, 97}, {0,0,0,0}},
                {{563, 2136, 69, 101, 0}, {23, 97, 34, 97}, {0,0,0,0}},
                {{651, 2132, 51, 105, 0}, {18, 94, 33, 94}, {0,0,0,0}},
                {{8, 2272, 74, 101, 0}, {18, 94, 35, 94}, {0,0,0,0}},
                {{722, 2138, 52, 99, 0}, {16, 92, 32, 92}, {0,0,0,0}},
                {{722, 2138, 52, 99, 0}, {16, 92, 32, 92}, {0,0,0,0}},
                {{793, 2133, 70, 104, 0}, {21, 93, 38, 93}, {0,0,0,0}}

        };
        super.hurt1 = new int[][][] {
                {{571, 8842, 90, 91, 0}, {32, 88, 42, 88}, {0,0,0,0}},
                {{455, 8838, 99, 95, 0}, {26, 86, 40, 86}, {0,0,0,0}},
                {{571, 8842, 90, 91, 0}, {32, 88, 42, 88}, {0,0,0,0}},
                {{571, 8842, 90, 91, 0}, {32, 88, 42, 88}, {0,0,0,0}},
                {{680, 8835, 82, 98, 0}, {33, 91, 41, 91}, {0,0,0,0}},
                {{680, 8835, 82, 98, 0}, {33, 91, 41, 91}, {0,0,0,0}},
                {{780, 8832, 65, 101, 0}, {27, 91, 36, 91}, {0,0,0,0}}
        };
        super.hurt2 = new int[][][] {
                {{105, 8845, 67, 88, 0}, {25, 83, 39, 83}, {0,0,0,0}},
                {{13, 8845, 75, 88, 0}, {28, 87, 47, 87}, {0,0,0,0}},
                {{13, 8845, 75, 88, 0}, {28, 87, 47, 87}, {0,0,0,0}},
                {{105, 8845, 67, 88, 0}, {25, 83, 39, 83}, {0,0,0,0}},
                {{189, 8840, 64, 93, 0}, {25, 87, 32, 87}, {0,0,0,0}},
                {{272, 8835, 63, 98, 0}, {24, 90, 33, 90}, {0,0,0,0}},
                {{351, 8828, 70, 105, 0}, {21, 96, 33, 96}, {0,0,0,0}}
        };
        super.comboSprites = new int[][][][] {
                {
                        {{8, 2272, 74, 101, 0}, {14, 95, 35, 95}, {0,0,0,0}},
                        {{102, 2266, 85, 107, 0}, {17, 92, 35, 92}, {0,0,0,0}},
                        {{212, 2259, 82, 114, 0}, {19, 94, 29, 94}, {0,0,0,0}},
                        {{313, 2271, 80, 102, 0}, {19, 86, 31, 86}, {0,0,0,0}},
                        {{414, 2280, 81, 93, 0}, {17, 84, 34, 84}, {0,0,0,0}},
                        {{518, 2293, 103, 80, 0}, {12, 73, 48, 73}, {0,0,0,0}},
                        {{637, 2293,103, 80, 0}, {4, 71, 40, 71}, {0,0,0,0}},
                        {{756, 2293, 103, 80, 0}, {7, 69, 42, 69}, {0,0,0,0}},
                        {{876, 2293, 103, 80, 0}, {7, 71, 44, 71}, {0,0,0,0}},
                        {{994, 2293, 103, 80, 0}, {2, 70, 37, 70}, {0,0,0,0}},
                        {{1116, 2305, 70, 68, 0}, {19, 64, 41, 64}, {0,0,0,0}},
                        {{7, 2406, 65, 85, 0}, {19, 79, 33, 79}, {0,0,0,0}},
                        {{91, 2387, 70, 104, 0}, {21, 93, 36, 93}, {0,0,0,0}}
                }
        };
        super.fireball = new int[][] {
                {202, 2410, 72, 62},
                {295, 2409, 71, 62},
                {385, 2409, 72, 62},
                {472, 2414, 73, 57},
                {560, 2414, 74, 58},
                {651, 2416, 69, 55}
        };
        this.groundEffects = new int[][][] {
                {{61, 2532, 64, 10, 0}, {-2,0,0,0}, {0,0,0,0}},
                {{138, 2531, 64, 9, 0}, {-1,0,0,0}, {0,0,0,0}},
                {{220, 2531, 64, 8, 0}, {-1,0,0,0}, {0,0,0,0}},
                {{303, 2528, 80, 10, 0}, {-2,0,0,0}, {0,0,0,0}},
                {{399, 2526, 100, 13, 0}, {-3,0,0,0}, {0,0,0,0}},
                {{515, 2524, 112, 14, 0}, {-3,0,0,0}, {0,0,0,0}},
                {{642, 2522, 128, 16, 0}, {-3,0,0,0}, {0,0,0,0}},
                {{787, 2521, 128, 16, 0}, {-3,0,0,0}, {0,0,0,0}},
                {{932, 2520, 128, 16, 0}, {-3,0,0,0}, {0,0,0,0}}
        };
    }

    @Override
    public void combo1(Graphics2D g2d) {
        if (attacking) {
            super.attack(g2d, comboSprites[0]);
        }

        tracker++;
        if (tracker==45){
            fireballList.push(new Fireball(this, panel, y - fireball[5][3]*2));
        }
        if (p>=10) tracker = 0;
    }

    @Override
    public void combo2(Graphics2D g2d) {

    }

    @Override
    public void combo3(Graphics2D g2d) {

    }

}
