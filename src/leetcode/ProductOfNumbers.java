package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 最后 K 个数的乘积
 * https://leetcode-cn.com/problems/product-of-the-last-k-numbers/
 *
 * 前缀积
 *
 * 当遇到0时, 前面的结果都失效了, 可以把乘积前缀清空. 当 K > productList.size() 直接返回0
 *
 * @author liuxin
 * @date 2020/8/29 8:01
 */
public class ProductOfNumbers {

    private static List<Integer> productList;

    public ProductOfNumbers() {
        productList = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 0) {
            productList.clear();
        } else {
            if (productList.size() == 0) {
                productList.add(num);
            } else {
                productList.add(productList.get(productList.size() - 1) * num);
            }
        }
    }

    public int getProduct(int k) {
        if (k > productList.size()) {
            return 0;
        }

        int index = productList.size() - k - 1;
        if (index >= 0) {
            return productList.get(productList.size() - 1) / productList.get(index);
        }

        return productList.get(productList.size() - 1);
    }


    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);

        System.err.println(productOfNumbers.getProduct(2));
        System.err.println(productOfNumbers.getProduct(3));
        System.err.println(productOfNumbers.getProduct(4));
    }
}
