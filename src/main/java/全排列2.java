import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;

import java.util.ArrayList;
import java.util.List;

/**
 * //全排列算法，对个，十，百，千位上面的数字全排列
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/5/9
 * @time: 17:16
 * @description:
 **/
public class 全排列2 {


    static List<List<Integer>> result=new ArrayList<>();
    static List<Integer> list=null;
    public static List<List<Integer>> permute(int[] nums) {
        permution(nums,0,nums.length);
        return result;
    }

    public static void permution(int[] nums,int start,int len){
        if(start==len-1){
            list=new ArrayList<>();
            for(int i=0;i<len;i++){
                list.add(nums[i]);
            }
            result.add(list);
        }else{
            for(int i=start;i<len;i++){
                swap(nums,i,start);
                permution(nums,start+1,len);
                swap(nums,i,start);
            }
        }
    }

    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] b = new int[] {2, 5, 6};
        System.out.println(permute(b));
    }

}
