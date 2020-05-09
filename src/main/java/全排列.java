import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/5/5
 * @time: 11:36
 * @description:
 **/
public class 全排列 {
    public static int a[] = new int[10];
    public static int q = 0;
    public static int x[] = new int[30];

    public static int allSort(int an) {
        int ans = an;
        int i = 0;
        while (true) {                //求出给定的数字中的个，十，百，千，各个位上的数，并放到数组中
            if (an > 10) {
                a[i] = an % 10;
                an /= 10;
            } else {
                a[i] = an;
                break;
            }
            i++;
        }
        pailie(0, i);
        return search(ans);
    }


    public static void pailie(int i, int j) {        //全排列算法，对个，十，百，千位上面的数字全排列
        if (i == j) {
            int e = 0;
            for (int m = 0; m <= j; m++) {
                //对全排列之后每种的情况放到运算之后得到对应的数字放到x[]数组中
                x[q] += a[m] * Math.pow(10, e);
                e++;
            }
            System.out.println(x[q]);
            q++;
        } else {
            for (int p = i; p <= j; p++) {
                swap(p, i);
                pailie(i + 1, j);
                swap(p, i);
            }
        }
    }

    public static void swap(int i, int j) {
        int z = a[i];
        a[i] = a[j];
        a[j] = z;
    }

    public static int search(int ans) {        //对x[]数组中的数字进行直接排序
        for (int i = 0; i < q; i++) {
            for (int j = i + 1; j < q; j++) {
                if (x[i] > x[j]) {
                    int x1 = x[i];
                    x[i] = x[j];
                    x[j] = x1;
                }
            }
        }
        for (int h = 0; h < q; h++) {        //找出题目要求的数字
            if (x[h] > ans) {
                return x[h];
            }

        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(allSort(7834));
    }


}
