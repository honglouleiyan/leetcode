/**
 *
 * 总结一下，KMP算法的实质就是以空间换时间，在匹配之前将模式串的一些信息存储起来（next数组），
 * 在随后的匹配过程中利用这些信息减少不必要的匹配次数，以提高匹配效率。在实际的应用过程中，
 * 简单模式匹配算法的执行时间常常接近于KMP算法，仅当主串与模式串有很多“部分匹配”时，KMP算法才能显著提升性能。
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2021/1/26
 * @time: 11:14
 * @description:
 **/
public class 字符串匹配KMP算法 {
    /**
     * 求出一个字符数组的next数组
     * @param t 字符数组
     * @return next数组
     *
     *
     * 字符串T的next数组的算法如下：
     *
     * next[0]=-1, next[1]=0。
     * 在求解next[j]时，令k=next[j-1]，
     * 比较T[j-1]与T[k]的值，
     * a. 若T[j-1]等于T[k]，则next[j]=k+1。
     * b. 若T[j-1]不等于T[k]，令k=next[k]，若k等于-1，则next[j]=0，否则跳至3。
     *
     *
     * 下面以模式串T=“abaabcac”为例，给出求next数组的过程：
     *
     * next[0]=-1, next[1]=0。
     * 当j=2时，k=next[j-1]=next[1]=0，由于T[j-1]=T[1]=‘b’，T[k]=T[0]=‘a’，T[j-1]不等于T[k]，令k=next[k]=next[0]=-1，因此next[2]=0。
     * 当j=3时，k=next[j-1]=next[2]=0，由于T[j-1]=T[2]=‘a’，T[k]=T[0]=‘a’，T[j-1]等于T[k]，因此next[3]=k+1=1。
     * 当j=4时，k=next[j-1]=next[3]=1，由于T[j-1]=T[3]=‘a’，T[k]=T[1]=‘b’，T[j-1]不等于T[k]，令k=next[k]=next[1]=0。此时T[k]=T[0]=‘a’，T[j-1]等于T[k]，因此next[4]=k+1=1。
     * 当j=5时，k=next[j-1]=next[4]=1，由于T[j-1]=T[4]=‘b’，T[k]=T[1]=‘b’，T[j-1]等于T[k]，因此next[5]=k+1=2。
     * 当j=6时，k=next[j-1]=next[5]=2，由于T[j-1]=T[5]=‘c’，T[k]=T[2]=‘a’，T[j-1]不等于T[k]，令k=next[k]=next[2]=0。此时T[k]=T[0]=‘a’，T[j-1]不等于T[k]，再令k=next[k]=next[0]=-1，因此next[6]=0。
     * 当j=7时，k=next[j-1]=next[6]=0，由于T[j-1]=T[6]=‘a’，T[k]=T[0]=‘a’，T[j-1]等于T[k]，因此next[7]=k+1=1。
     */
    public static int[] getNextArray(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int j = 2; j < t.length; j++) {
            k=next[j-1];
            while (k!=-1) {
                if (t[j - 1] == t[k]) {
                    next[j] = k + 1;
                    break;
                }
                else {
                    k = next[k];
                }
                //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
                next[j] = 0;
            }
        }
        return next;
    }

    /**
     * 对主串s和模式串t进行KMP模式匹配
     * @param s 主串
     * @param t 模式串
     * @return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
     */
    public static int kmpMatch(String s, String t){
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int[] next = getNextArray(t_arr);
        int i = 0, j = 0;
        while (i<s_arr.length && j<t_arr.length){
            if(j == -1 || s_arr[i]==t_arr[j]){
                i++;
                j++;
            }
            else {
                j = next[j];
            }
        }
        if(j == t_arr.length) {
            return i - j;
        }
        else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(kmpMatch("abcabaabaabcacb", "abaabcac"));
    }
}
