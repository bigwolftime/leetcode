package leetcode;

import utils.AssertUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 频率跟踪器<br/>
 * <a href="https://leetcode.cn/problems/frequency-tracker/">...</a>
 * <br/>
 * 需要注意的是, deleteOne 方法只是降低 number 的次数, 并非完全移除
 *
 * @author liuxin
 * @date 2024/3/21 07:38
 */
public class FrequencyTracker {

    /**
     * 表示出现 key 次的数字都有哪些
     */
    private final Map<Integer, Set<Integer>> cntMap;

    /**
     * 表示一个数字 key 出现了 val 次
     */
    private final Map<Integer, Integer> numMap;


    public FrequencyTracker() {
        cntMap = new HashMap<>();
        numMap = new HashMap<>();
    }

    public void add(int number) {
        Integer cnt = numMap.get(number);
        if (cnt == null) {
            // 初始化...
            initialAdd(number);
            return;
        }

        // cnt != null
        keepAdd(number, cnt);
    }

    private void initialAdd(int number) {
        int cnt = 1;

        // 默认出现1次
        numMap.put(number, cnt);

        Set<Integer> set = cntMap.get(cnt);
        if (set == null) {
            set = new HashSet<>();
            set.add(number);
            cntMap.put(cnt, set);
        } else {
            set.add(number);
        }
    }

    private void keepAdd(int number, int cnt) {
        Set<Integer> set = cntMap.get(cnt);
        if (set != null) {
            set.remove(number);
        }

        cnt++;

        Set<Integer> set1 = cntMap.get(cnt);
        if (set1 == null) {
            set1 = new HashSet<>();
            set1.add(number);
            cntMap.put(cnt, set1);
        } else {
            set1.add(number);
        }

        numMap.put(number, cnt);
    }

    public void deleteOne(int number) {
        Integer cnt = numMap.get(number);
        if (cnt == null || cnt == 0) {
            // not exists
            return;
        }

        Set<Integer> set = cntMap.get(cnt);
        set.remove(number);

        cnt--;
        numMap.put(number, cnt);

        Set<Integer> newSet = cntMap.get(cnt);
        if (newSet == null) {
            newSet = new HashSet<>();
            newSet.add(number);
            cntMap.put(cnt, newSet);
        } else {
            newSet.add(number);
        }
    }

    public boolean hasFrequency(int frequency) {
        Set<Integer> set = cntMap.get(frequency);
        return set != null && !set.isEmpty();
    }


    public static void main(String[] args) {
        FrequencyTracker frequencyTracker = new FrequencyTracker();

        AssertUtil.eq(false, frequencyTracker.hasFrequency(1));
        frequencyTracker.add(3);
        frequencyTracker.add(1);
        AssertUtil.eq(true, frequencyTracker.hasFrequency(1));
        frequencyTracker.add(3);
        AssertUtil.eq(true, frequencyTracker.hasFrequency(2));
        frequencyTracker.add(1);
        AssertUtil.eq(true, frequencyTracker.hasFrequency(2));
        frequencyTracker.deleteOne(10);
        AssertUtil.eq(true, frequencyTracker.hasFrequency(2));
        frequencyTracker.deleteOne(6);
        frequencyTracker.add(7);
        frequencyTracker.deleteOne(10);
        AssertUtil.eq(true, frequencyTracker.hasFrequency(2));
        AssertUtil.eq(true, frequencyTracker.hasFrequency(1));
        frequencyTracker.add(1);
        frequencyTracker.add(2);
        frequencyTracker.add(3);
        AssertUtil.eq(true, frequencyTracker.hasFrequency(1));
        frequencyTracker.deleteOne(3);
        AssertUtil.eq(true, frequencyTracker.hasFrequency(2));
        AssertUtil.eq(true, frequencyTracker.hasFrequency(3));
    }

}
