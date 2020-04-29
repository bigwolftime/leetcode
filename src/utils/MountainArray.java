package utils;

public class MountainArray {

    private int[] arr;

    public MountainArray() { }

    public MountainArray(int[] arr) {
        this.arr = arr;
    }

    public int get(int idx) {
        return arr[idx];
    }

    public int length() {
        return arr.length;
    }

}
