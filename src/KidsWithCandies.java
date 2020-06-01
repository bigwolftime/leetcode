import java.util.ArrayList;
import java.util.List;

/**
 * 拥有最多糖果的孩子
 * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 * tag: 简单
 *
 * @author liuxin
 * @time 2020/6/1 10:00
 */
public class KidsWithCandies {

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];

        for (int i : candies) {
            max = Math.max(max, i);
        }

        List<Boolean> list = new ArrayList<>();
        for (int i : candies) {
            list.add(i + extraCandies >= max);
        }

        return list;
    }

    public static void main(String[] args) {

    }

}
