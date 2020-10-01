package leetcode;

/**
 * 文件夹操作日志搜集器
 * https://leetcode-cn.com/problems/crawler-log-folder/
 *
 * @author liuxin
 * @time 2020/9/27 21:15
 */
public class MinOperationsFolder {

    private static int minOperations(String[] logs) {
        int level = 0;
        for (String log : logs) {
            if ("../".equals(log)) {
                if (level > 0) {
                    level -= 1;
                }
            } else if (!"./".equals(log)) {
                level += 1;
            }
        }

        return level;
    }

    public static void main(String[] args) {

    }

}
