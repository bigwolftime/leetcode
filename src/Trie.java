import java.time.LocalDate;
import java.util.List;

/**
 * @Author Liuxin
 * @Date 2019/3/25 19:31
 *
 */
public class Trie {

    private List<String> data;

    public Trie() { }

    public void insert(String word) {
        if (word != null){
            data.add(word);
        }
    }

    /**
     * Returns if the word is in the trie.
     * 精确查询
     */
    public boolean search(String word) {
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("app");
        System.err.println(trie.startsWith("jam"));
    }
}
