package leetcode;

import java.util.Stack;

/**
 * 简化路径
 * https://leetcode-cn.com/problems/simplify-path/
 *
 * @author liuxin
 * @time 2020/6/19 17:42
 */
public class SimplifyPath {

    private static String simplifyPath(String path) {
        String[] pathArr = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String str : pathArr) {
            if (str.length() == 0 || ".".equals(str)) {
                continue;
            }

            if ("..".equals(str)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }

        StringBuilder resBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            resBuilder.insert(0, stack.pop()).insert(0, "/");
        }

        if (resBuilder.length() == 0) {
            resBuilder.append("/");
        }

        return resBuilder.toString();
    }

    public static void main(String[] args) {
        System.err.println(simplifyPath("/a//b////c/d//././/.."));
    }

}
