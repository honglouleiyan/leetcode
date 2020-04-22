/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/4/21
 * @time: 11:20
 * @description:
 **/
public class 最小堆 {

    private int[] data;

    public 最小堆(int[] data) {
        this.data = data;
    }

    public void createHeap() {
        for (int i = (data.length) / 2 - 1; i >= 0; i--) {
            heapIfy(i);
        }
    }

    public void heapIfy(int value) {
        int lchild = left(value);
        int rchild = right(value);
        int smallest = value;
        if (lchild < data.length && data[lchild] < data[value]) {
            smallest = lchild;
        }
        if (rchild < data.length && data[rchild] < data[smallest]) {
            smallest = rchild;
        }
        if (value == smallest) {
            return;
        }
        swap(value, smallest);
        heapIfy(smallest);
    }

    public int left(int value) {
        return ((value + 1) << 1) - 1;
    }

    public int right(int value) {
        return (value + 1) << 1;
    }

    public void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public void setRoot(int value) {
        data[0] = value;
        heapIfy(0);
    }

    public static void main(String[] args) {
        int[] value = { 10, 100, 12, 73, 45, 32, 11, 23, 55, 34, 90, 21 };
        最小堆 heap = new 最小堆(value);
        heap.createHeap();
        for (int i = 0; i < value.length; i++) {
            System.out.print(heap.data[i] + " ");
        }
        //添加一个数
//        System.out.println();
//        heap.setRoot(64);
//        for (int i = 0; i < value.length; i++) {
//            System.out.print(heap.data[i] + " ");
//        }
//        System.out.println();
    }

}
