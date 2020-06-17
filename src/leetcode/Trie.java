package leetcode;

/**
 * 实现 leetCode.Trie(前缀树)
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 *
 * @Author Liuxin
 * @Date 2019/3/25 19:31
 *
 */
public class Trie {

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return false;
    }



    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("app");
        System.err.println(trie.startsWith("jam"));
    }
}
