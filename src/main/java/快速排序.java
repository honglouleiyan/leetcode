/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/11/30
 * @time: 17:22
 * @description:
 **/
public class 快速排序 {


    //冒泡排序
    public static int[] maopao(int[] a) {
        for(int i = 1; i < a.length; i++) {
            for(int j= 0; j < a.length - i;j++) {
                if(a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }

        return a;
    }

    //插入排序
    public void insertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int currentNumber = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > currentNumber) {
                data[j + 1] = data[j];
                j--;
            }
            data[j+1] = currentNumber;
        }
    }

    //归并排序
    public void mergeSort(int[] data) {
        int[] temp = new int[data.length];
        subMergeSort(data, 0, data.length - 1, temp);
    }


    public void subMergeSort(int[] data, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            subMergeSort(data, left, mid, temp);
            subMergeSort(data, mid + 1, right, temp);
            merge(data, left, mid, right, temp);
        }
    }

    public void merge(int[] data, int left, int mid, int right, int[] temp) {
        int i = left;
        int k = mid + 1;
        int t = 0;
        while (i <= mid && k <= right) {
            if (data[i] < data[k]) {
                temp[t++] = data[i++];
            } else {
                temp[t++] = data[k++];
            }
        }

        while (i <= mid) {
            temp[t++] = data[i++];
        }

        while (k <= right) {
            temp[t++] = data[k++];
        }

        t = 0;
        while (left <= right) {
            data[left++] = temp[t++];
        }

    }


    /**
     * 快速排序演示
        /**
         * @param arr        待排序列
         * @param leftIndex  待排序列起始位置
         * @param rightIndex 待排序列结束位置
         */
        private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
            if (leftIndex >= rightIndex) {
                return;
            }

            int left = leftIndex;
            int right = rightIndex;
            //待排序的第一个元素作为基准值
            int key = arr[left];

            //从左右两边交替扫描，直到left = right
            while (left < right) {
                while (right > left && arr[right] >= key) {
                    //从右往左扫描，找到第一个比基准值小的元素
                    right--;
                }

                //找到这种元素将arr[right]放入arr[left]中
                arr[left] = arr[right];

                while (left < right && arr[left] <= key) {
                    //从左往右扫描，找到第一个比基准值大的元素
                    left++;
                }

                //找到这种元素将arr[left]放入arr[right]中
                arr[right] = arr[left];
            }

            //基准值归位
            arr[left] = key;
            //对基准值左边的元素进行递归排序
            quickSort(arr, leftIndex, left - 1);
            //对基准值右边的元素进行递归排序。
            quickSort(arr, right + 1, rightIndex);
        }

    public static void main(String[] args) {
        int[] a = {1,5,2,3,7,4,3,0};
        int[] b = maopao(a);
        for(int i = 0; i < a.length; i++) {
            System.out.print(b[i]);
        }
    }

}
