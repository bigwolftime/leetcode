package leetcode;

/**
 * 最接近原点的 K 个点
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 *
 * 小根堆
 */
public class KClosest {

    private static int[][] kClosest(int[][] points, int K) {
        Counter[] counterArr = new Counter[points.length];

        for (int i = 0; i < points.length; i++) {
            heapBuild(counterArr, new Counter(i, points[i][0] * points[i][0] + points[i][1] * points[i][1]), i);
        }

        int heapSize = points.length;
        int[][] resArr = new int[K][2];
        int idx = 0;
        for (int i = 0; i < K; i++) {
            swap(counterArr, 0, --heapSize);
            resArr[idx++] = points[counterArr[heapSize].index];
            heapBalance(counterArr, heapSize);
        }

        return resArr;
    }

    private static void heapBuild(Counter[] counterArr, Counter counter, int index) {
        counterArr[index] = counter;
        int parentIdx;

        while (counterArr[index].distance < counterArr[parentIdx = (index - 1) / 2].distance) {
            swap(counterArr, index, parentIdx);
            index = parentIdx;
        }
    }

    private static void heapBalance(Counter[] counterArr, int heapSize) {
        int idx = 0;
        int leftChildIdx;
        while (idx < heapSize && (leftChildIdx = idx * 2 + 1) < heapSize) {
            int minChildIdx = leftChildIdx;

            int rightIdx;
            if ((rightIdx = leftChildIdx + 1) < heapSize && counterArr[leftChildIdx].distance > counterArr[rightIdx].distance) {
                minChildIdx = rightIdx;
            }

            if (counterArr[idx].distance < counterArr[minChildIdx].distance) {
                break;
            }

            swap(counterArr, idx, minChildIdx);
            idx = minChildIdx;
        }
    }

    private static class Counter {
        private int index;
        private int distance;

        public Counter(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    private static void swap(Counter[] counterArr, int idx1, int idx2) {
        Counter temp = counterArr[idx1];
        counterArr[idx1] = counterArr[idx2];
        counterArr[idx2] = temp;
    }

    public static void main(String[] args) {

    }

}
