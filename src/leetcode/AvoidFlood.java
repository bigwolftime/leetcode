package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 避免洪水泛滥
 * https://leetcode-cn.com/problems/avoid-flood-in-the-city/
 *
 * lcp 194 第三题
 *
 * @author liuxin
 * @date 2020/6/25 15:27
 */
public class AvoidFlood {

    private static int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> fullMap = new HashMap<>();
        ArrayList<Integer> zeroList = new ArrayList<>();

        int[] res = new int[rains.length];
        Arrays.fill(res, 1);

        int temp;
        // 是否找到空窗期
        boolean flag = false;
        boolean searchFlag;
        for (int i = 0; i < rains.length; i++) {
            flag = true;
            temp = rains[i];

            if (temp == 0) {
                // 空窗期, 记录位置下标
                zeroList.add(i);
                continue;
            }

            // 非空窗期不能操作湖泊, 只能填 -1
            res[i] = -1;

            Integer fullIdx = fullMap.get(temp);
            if (fullIdx == null) {
                // 湖泊此前是干涸的, 此次已满
                fullMap.put(temp, i);
                continue;
            }

            if (zeroList.isEmpty()) {
                // 没有满足的空窗期 -> 结束
                flag = false;
                break;
            }

            searchFlag = false;
            // 寻找空窗期, 寻找范围: (fullIdx, i)
            for (int j = 0; j < zeroList.size(); j++) {
                if (zeroList.get(j) > fullIdx && zeroList.get(j) < i) {
                    // 这里可以优化为二分
                    // 找到了
                    res[zeroList.get(j)] = temp;
                    zeroList.remove(j);
                    fullMap.put(temp, i);

                    searchFlag = true;
                    break;
                }
            }

            if (!searchFlag) {
                flag = false;
                break;
            }
        }

        return flag ? res : new int[0];
    }

    public static void main(String[] args) {
        int[] ints = avoidFlood(new int[]{2,3,0,0,3,1,0,1,0,2,2});
        for (int i : ints) {
            System.err.println(i);
        }
    }

}
