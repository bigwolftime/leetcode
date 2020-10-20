package leetcode;

/**
 * 在线选举
 * https://leetcode-cn.com/problems/online-election/
 *
 * 需要额外的两个结构: 最高票数 list 和 每个人的票数 list
 * 然后二分
 *
 * @author liuxin
 * @time 2020/10/20 10:53
 */
public class TopVotedCandidate {

    private final int[] timeArr;
    private final int[] topArr;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.timeArr = times;

        int len = times.length;
        int[] voteArr = new int[len];
        topArr = new int[len];

        // 最高票数
        int maxVote = 0;
        for (int i = 0; i < len; i++) {
            int curPerson = persons[i];

            // 票数自增
            voteArr[curPerson]++;

            // 当前票数
            int curVote = voteArr[curPerson];

            if (curVote >= maxVote) {
                topArr[i] = curPerson;
                maxVote = curVote;
            } else {
                topArr[i] = topArr[i - 1];
            }
        }
    }

    public int q(int t) {
        // 二分, 查找索引位置.
        int index = binarySearch(t);
        return topArr[index];
    }

    private int binarySearch(int t) {
        int p = 0, q = timeArr.length - 1;
        int mid;

        while (q - p > 1) {
            mid = p + ((q - p) >> 1);

            if (timeArr[mid] > t) {
                q = mid;
            } else if (timeArr[mid] < t) {
                p = mid;
            } else {
                return mid;
            }
        }
        return t >= timeArr[q] ? q : p;
    }

    public static void main(String[] args) {
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{ 0,1,2,2,1 }, new int[]{ 20,28,29,54,56 });

        int i = topVotedCandidate.binarySearch(55);
        System.err.println(i);
    }

}
