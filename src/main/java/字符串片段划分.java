/**
 *
 * 2110年美团外卖火星第3000号配送站点有26名骑手，分别以大写字母A-Z命名，因此可以称呼这些骑手为黄家骑士特工A，黄家骑士特工B…黄家骑士特工Z
 * ，某美团黑珍珠餐厅的外卖流水线上会顺序产出一组包裹，美团配送调度引擎已经将包裹分配到骑手，并在包裹上粘贴好骑手名称，
 * 如RETTEBTAE代表一组流水线包裹共9个，同时分配给了名字为A B E R T的5名骑手。请在不打乱流水线产出顺序的情况下，
 * 把这组包裹划分为尽可能多的片段，同一个骑手只会出现在其中的一个片段，返回一个表示每个包裹片段的长度的列表。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2021/2/20
 * @time: 11:51
 * @description:
 **/
public class 字符串片段划分 {

    /**
     * 典型的滑动窗口，先判断当前字符的最后一个位置在哪，在不断的更新另一个指针使得开始指针与结尾指针满中间没有的元素在后面不会出现。
     * @param args
     */
    public static void main(String[] args){
        String s="MPMPCPMCMDEFEGDEHINHKLIN";
        int n = s.length();
        int max_i = s.lastIndexOf(s.charAt(0));
        int ans = 1;
        for(int i = 1; i < n; i++){
            char c = s.charAt(i);
            int index = s.lastIndexOf(c);
            if(i <= max_i){
                ans++;
                if(index>max_i) max_i=index;
            }else{
                System.out.print(ans+" ");
                ans = 1;
                max_i = index;
            }
        }
        System.out.print(ans+" ");
        System.out.println();
    }
}
