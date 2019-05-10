import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Liuxin
 * @Date 2019/5/10 14:56
 *
 * 唯一摩尔斯密码词
 * https://leetcode-cn.com/problems/unique-morse-code-words/
 *
 * 用 map 做一个映射，体力活
 */
public class UniqueMorseRepresentations {

    private static HashMap<Character, String> map = new HashMap<>(26);

    static {
        map.put('a', ".-");map.put('b', "-...");map.put('c', "-.-.");
        map.put('d', "-..");map.put('e', ".");map.put('f', "..-.");
        map.put('g', "--.");map.put('h', "....");map.put('i', "..");
        map.put('j', ".---");map.put('k', "-.-");map.put('l', ".-..");
        map.put('m', "--");map.put('n', "-.");map.put('o', "---");
        map.put('p', ".--.");map.put('q', "--.-");map.put('r', ".-.");
        map.put('s', "...");map.put('t', "-");map.put('u', "..-");
        map.put('v', "...-");map.put('w', ".--");map.put('x', "-..-");
        map.put('y', "-.--");map.put('z', "--..");
    }

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();

        StringBuilder temp = new StringBuilder();
        for (String str : words){
            for (int i = 0; i < str.length(); i++){
                temp.append(map.get(str.charAt(i)));
            }

            if (!set.contains(temp)){
                set.add(temp.toString());
            }

            temp.delete(0, temp.length());
        }

        return set.size();
    }

    public static void main(String[] args) {
        UniqueMorseRepresentations test = new UniqueMorseRepresentations();
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        System.err.println(test.uniqueMorseRepresentations(words));
    }
}
