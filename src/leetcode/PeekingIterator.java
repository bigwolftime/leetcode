package leetcode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 顶端迭代器
 * https://leetcode-cn.com/problems/peeking-iterator/
 *
 * 迭代，把数据换个地方存储
 */
public class PeekingIterator implements Iterator<Integer> {

    private final LinkedList<Integer> list;
    private int index;

    public PeekingIterator(Iterator<Integer> iterator) {
        index = 0;
        list = new LinkedList<>();

        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    public Integer peek() {
        if (index >= list.size()) {
            return null;
        }

        return list.get(index);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Integer next() {
        if (index >= list.size()) {
            return null;
        }
        return list.get(index++);
    }

}
