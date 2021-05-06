package leetcode;

/**
 * 解码异或后的数组
 * https://leetcode-cn.com/problems/decode-xored-array/
 *
 * Since that encoded[i] = arr[i] XOR arr[i+1], then arr[i+1] = encoded[i] XOR arr[i].
 */
public class Decode {

    private static int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length + 1];
        arr[0] = first;

        for (int i = 1; i < arr.length; i++) {
            arr[i] = encoded[i - 1] ^ arr[i - 1];
        }

        return arr;
    }

    public static void main(String[] args) {

    }

}
