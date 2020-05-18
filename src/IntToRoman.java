import java.util.HashMap;

/**
 * 整数转罗马数字
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class IntToRoman {

    private static final HashMap<Integer, String> map;
    private static final HashMap<Integer, String> specialMap;

    static {
        specialMap = new HashMap<>();
        specialMap.put(4, "IV");
        specialMap.put(9, "IX");
        specialMap.put(40, "XL");
        specialMap.put(90, "XC");
        specialMap.put(400, "CD");
        specialMap.put(900, "CM");

        map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
    }

    private static String intToRoman(int num) {
        StringBuilder resBuilder = new StringBuilder();

        int tail;
        int ratio = 10;
        while (num > 0) {
            StringBuilder sb = new StringBuilder();
            tail = num % ratio;
            recursive(tail, sb);

            resBuilder.insert(0, sb);

            num -= tail;
            ratio *= 10;
        }


        return resBuilder.toString();
    }

    private static void recursive(int num, StringBuilder sb) {
        if (num == 0) {
            return;
        }

        if (specialMap.get(num) != null) {
            sb.append(specialMap.get(num));
            return;
        }

        int nextMin = getNextMin(num);
        sb.append(map.get(nextMin));
        recursive(num - nextMin, sb);
    }


    private static int getNextMin(int num) {
        if (num >= 1000) {
            return 1000;
        } else if (num >= 500) {
            return 500;
        } else if (num >= 100) {
            return 100;
        } else if (num >= 50) {
            return 50;
        } else if (num >= 10) {
            return 10;
        } else if (num >= 5) {
            return 5;
        } else {
            return 1;
        }
    }


    public static void main(String[] args) {
        intToRoman(3);
    }

}
