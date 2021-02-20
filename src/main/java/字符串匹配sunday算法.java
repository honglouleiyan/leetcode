/**
 *
 *
 * 在匹配过程中，模式串首先按从左向右进行逐个匹配，当发现有不匹配的字符时，
 * 当前匹配的位置就跳过尽可能大的步长，再进行下一轮的匹配，从而达到提高匹配效率的目的。
 * Sunday算法匹配失败时，判断主串中参加匹配的最末位字符的下一位字符是否在模式串中出现。
 * 如果未出现，跳转步长为模式串长度加1；如果出现，其跳转步长为模式串中最右端的该字符到末尾的距离加1。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2021/1/26
 * @time: 11:22
 * @description:
 **/
public class 字符串匹配sunday算法 {

    public static void main(String[] args) {
        String s="abcdebcdbcdegbcde";
        String p="bcdeg";
        Sunday(s, p);

    }
    //注意每次都是从后向前
    public static int contains(char[] str,char ch){
        for(int i=str.length-1;i>=0;i--){
            if(str[i]==ch){
                return i;
            }
        }
        return -1;
    }
    public static void Sunday(String s,String p){
        char[] sarray = s.toCharArray();
        char[] parray = p.toCharArray();
        int slen=s.length();
        int plen=p.length();
        int i=0,j=0;
        while(i<=slen-plen+j){//这句话控制索引i,j的范围
            if(sarray[i]!=parray[j]){//假如主串的sarry[i]与模式串的parray[j]不相等
                if(i==slen-plen+j){//
                    break;//假如主串的sarry[i]与模式串的parray[j]不相等,并且i=slen-plen+j,说明这已经
                    //是在和主串中最后可能相等的字符段比较了,并且不相等,说明后面就再也没有相等的了,所以
                    //跳出循环,结束匹配
                }
                //假如是主串的中间字段与模式串匹配，且结果不匹配
                //则就从模式串的最后面开始,(注意是从后向前)向前遍历,找出模式串的后一位在对应的母串的字符是否在子串中存在
                int pos=contains(parray, sarray[i+plen-j]);
                if(pos==-1){//表示不存在
                    i=i+plen+1-j;
                    j=0;
                }else{
                    i=i+plen-pos-j;
                    j=0;
                }
            }else{//假如主串的sarry[i]与模式串的parray[j]相等,则继续下面的操作
                if(j==plen-1){//判断模式串的索引j是不是已经到达模式串的最后位置，
                    //j==plen-1证明在主串中已经找到一个模式串的位置,
                    //且目前主串尾部的索引为i,主串首部的索引为i-j,打印模式串匹配的第一个位置
                    System.out.println("the start pos is "+(i-j)+" the end pos is "+i);
                    //然后主串右移一个位置,再和模式串的首字符比较,从而寻找下一个匹配的位置
                    i=i-j+1;
                    j=0;
                }else{
                    //假如模式串的索引j!=plen-1,说明模式串还没有匹配完,则i++,j++继续匹配,
                    i++;
                    j++;
                }
            }
        }
    }
}
