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

    //快速排序
    public static int[] quick(int[] a,int low,int high) {
      if(low > high) {
        return a;
      }

      int tmp = a[low];


        return a;
    }


    public static void main(String[] args) {
        int[] a = {1,5,2,3,7,4,3,0};
        int[] b = maopao(a);
        for(int i = 0; i < a.length; i++) {
            System.out.print(b[i]);
        }
    }

}
