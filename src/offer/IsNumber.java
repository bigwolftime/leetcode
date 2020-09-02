package offer;

/**
 * 表示数值的字符串
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 *
 * 编译原理中的自动机
 *
 * @author liuxin
 * @date 2020/9/2 15:39
 */
public class IsNumber {

    private enum StateEnum {

        /**
         * 失效
         */
        INVALID,

        /**
         * 空串
         */
        EMPTY,

        /**
         * 正负状态
         */
        SIGNED,

        /**
         * 数值
         */
        SIGNED_NUMBER,

        /**
         * 指数
         */
        INDEX,

        /**
         * 指数 负号状态
         */
        INDEX_SIGNED,

        /**
         * 指数数值
         */
        INDEX_NUMBER,

        /**
         * 浮点状态
         */
        FLOAT,

        /**
         * 浮点数值
         */
        FLOAT_NUMBER,
    }


    private static boolean isNumber(String s) {
        s = s.trim();

        char c;
        StateEnum state = StateEnum.EMPTY;
        StateEnum lastState;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            lastState = state;

            // 匹配状态
            state = matchState(c, state);

            if (state == StateEnum.INVALID) {
                if (i == s.length() - 1 && c == ' ') {
                    return lastState == StateEnum.SIGNED_NUMBER || lastState == StateEnum.INDEX_NUMBER || lastState == StateEnum.FLOAT_NUMBER;
                }
                return false;
            }
        }

        return state == StateEnum.SIGNED_NUMBER || state == StateEnum.INDEX_NUMBER || state == StateEnum.FLOAT_NUMBER;
    }

    private static StateEnum matchState(char c, StateEnum curState) {
        if (c == ' ') {
            if (curState == StateEnum.SIGNED_NUMBER) {
                return StateEnum.INVALID;
            } else if (curState == StateEnum.SIGNED) {
                return StateEnum.INVALID;
            } else if (curState == StateEnum.FLOAT) {
                return StateEnum.INVALID;
            }
        } else if (curState == StateEnum.EMPTY) {
            // 当前为空字符串, 可接受: +, -, 0-9
            if (isNumber(c)) {
                return StateEnum.SIGNED_NUMBER;
            } else if (c == '-'  || c == '+') {
                return StateEnum.SIGNED;
            } else if (c == '.') {
                return StateEnum.FLOAT;
            }

        } else if (curState == StateEnum.SIGNED) {
            // 当前为 +, -, 可接受: 0-9
            if (isNumber(c)) {
                return StateEnum.SIGNED_NUMBER;
            } else if (c == '.') {
                return StateEnum.FLOAT;
            }

        } else if (curState == StateEnum.SIGNED_NUMBER) {
            // 当前为数值: 可接受 0-9, ., e
            if (isNumber(c)) {
                return curState;
            } else if (c == '.') {
                return StateEnum.FLOAT_NUMBER;
            } else if (c == 'e' || c == 'E') {
                return StateEnum.INDEX;
            }

        } else if (curState == StateEnum.INDEX) {
            // 当前为 指数状态, 可接受: 正负号, 0-9
            if (isNumber(c)) {
                return StateEnum.INDEX_NUMBER;
            } else if (c == '-' || c == '+') {
                return StateEnum.INDEX_SIGNED;
            }

        } else if (curState == StateEnum.INDEX_SIGNED) {
            // 当前为 指数状态 可接受: 0-9
            if (isNumber(c)) {
                return StateEnum.INDEX_NUMBER;
            }
        } else if (curState == StateEnum.INDEX_NUMBER) {
            // 当前为 指数数值, 可接受: 0-9
            if (isNumber(c)) {
                return curState;
            }

        } else if (curState == StateEnum.FLOAT) {
            // 当前为浮点状态, 可接受: 0-9
            return isNumber(c) ? StateEnum.FLOAT_NUMBER : StateEnum.INVALID;
        } else if (curState == StateEnum.FLOAT_NUMBER) {
            // 当前为 浮点数值, 可接受 0-9, e
            if (isNumber(c)) {
                return curState;
            } else if (c == 'e' || c == 'E') {
                return StateEnum.INDEX;
            }
        }

        return StateEnum.INVALID;
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        System.err.println(isNumber("1e.66"));
    }

}
