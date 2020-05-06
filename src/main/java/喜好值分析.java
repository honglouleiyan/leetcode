import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2020/5/5
 * @time: 11:05
 * @description:
 **/
public class 喜好值分析 {


        public static void main(String[] args)
        {
            Scanner in=new Scanner(System.in);
            int n=in.nextInt();
            HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int temp=in.nextInt();
                if(map.containsKey(temp))
                {
                    map.get(temp).add(i+1);
                }
                else
                {
                    ArrayList<Integer> list=new ArrayList<>();
                    list.add(i+1);
                    map.put(temp, list);
                }
            }
            int q=in.nextInt();
            for(int i=0;i<q;i++)
            {
                int l=in.nextInt();
                int r=in.nextInt();
                int k=in.nextInt();
                int count=0;
                ArrayList<Integer> templist=map.get(k);
                if(templist!=null)
                {
                    for(int index:templist)
                    {
                        if(index>=l&&index<=r) {
                            count++;
                        }

                    }
                }
                System.out.println(count);
            }
        }
}
