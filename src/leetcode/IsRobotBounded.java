package leetcode;

/**
 * 困于环中的机器人
 * https://leetcode-cn.com/problems/robot-bounded-in-circle/
 *
 * 总结个笨规律: 如果困于环中, 那么 4 次命令完成后, 一定在 (0,0) 位置且方向与初始相同
 *
 * @author liuxin
 * @time 2020/10/26 17:10
 */
public class IsRobotBounded {

    private static int DIRECT;
    private static int X;
    private static int Y;

    private static boolean isRobotBounded(String instructions) {
        DIRECT = 0;
        X = 0;
        Y = 0;

        for (int count = 0; count < 4; count++) {
            for (int i = 0; i < instructions.length(); i++) {
                execute(instructions.charAt(i));

                if (X == 0 && Y == 0 && DIRECT == 0) {
                    return true;
                }
            }
        }

        return X == 0 && Y == 0 && DIRECT == 0;
    }

    private static void execute(char c) {
        if (c == 'G') {
            move(c);
        } else {
            changeDirect(c);
        }
    }

    private static void move(char c) {
        switch (DIRECT) {
            case 0:
                X--;
                break;
            case 1:
                Y++;
                break;
            case 2:
                X++;
                break;
            case 3:
                Y--;
                break;
        }
    }

    private static void changeDirect(char c) {
        if (c == 'L') {

            if (DIRECT == 0) {
                DIRECT = 3;
            } else {
                DIRECT--;
            }

        } else {

            if (DIRECT == 3) {
                DIRECT = 0;
            } else {
                DIRECT++;
            }

        }
    }

    public static void main(String[] args) {
        isRobotBounded("GG");
    }

}
