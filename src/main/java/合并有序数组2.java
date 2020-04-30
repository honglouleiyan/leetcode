/**
 *
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/4/27
 * @time: 20:17
 * @description:
 **/
public class 合并有序数组2 {
    public static void merge(int[] arrayA,int sizeA,int[] arrayB,int sizeB,int[] arrayC){
        int a = 0,b = 0,c = 0;
        while (a < sizeA && b < sizeB){
            if (arrayA[a] < arrayB[b]){
                arrayC[c] = arrayA[a];
                c++;
                a++;
            }else{
                arrayC[c] = arrayB[b];
                c++;
                b++;
            }
        }
        while (a < sizeA){
            arrayC[c++] = arrayA[a++];
        }
        while (b < sizeB){
            arrayC[c++] = arrayB[b++];
        }
    }

    public static void display(int[] theArray){
        for (int i = 0; i < theArray.length; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println("");
    }

    // 测试一下
    public static void main(String[] args) {

        int[] arrayA = {23,47,81,95};
        int[] arrayB = {7,14,39,59,62,74};
        int[] arrayC = new int[arrayA.length + arrayB.length ];

        merge(arrayA, arrayA.length, arrayB, arrayB.length, arrayC);
        display(arrayC);
    }
}
