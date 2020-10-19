package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 股票价格跨度
 * https://leetcode-cn.com/problems/online-stock-span/
 *
 * 单调栈
 * 这里用了两个 list 结构. 一个存数据, 一个存跨度
 *
 * @author liuxin
 * @time 2020/10/19 15:57
 */
public class StockSpanner {

    private final List<Integer> dataList;
    private final List<Integer> spannerList;

    public StockSpanner() {
        dataList = new ArrayList<>();
        spannerList = new ArrayList<>();
    }

    public int next(int price) {
        int spanner = 1;

        if (dataList.size() == 0) {
            dataList.add(price);
            spanner = 1;
            spannerList.add(spanner);
        } else {
            int lastIdx = dataList.size() - 1;

            if (price < dataList.get(lastIdx)) {
                dataList.add(price);
                spannerList.add(1);
                return 1;
            } else {
                while (!dataList.isEmpty()) {
                    if (price >= dataList.get(lastIdx)) {
                        dataList.remove(lastIdx);
                        spanner += spannerList.remove(lastIdx);
                        lastIdx--;
                    } else {
                        break;
                    }
                }

                dataList.add(price);
                spannerList.add(spanner);
            }
        }

        return spanner;
    }

}
