/**
 * @created with IntelliJ IDEA.
 * @author: heaven
 * @date: 2021/2/5
 * @time: 10:00
 * @description:
 * 如何JAVA使用多线程实现累加求和, 麻烦给一个代码
 * 比如说从1加到100,创建10个线程,第一个从1加到10,第2个从11加到20...线程同步执行,最后再把十个线程结果相加
 **/


class Test extends Thread {
        static int n = 0;
        private int startNum = 0 ;
        public Test (int sn)
        {
            this.startNum = sn ;
        }
        public static synchronized void addSum (int num)
        {
            n += num ;
        }


        @Override
        public void run() {
            int sum = 0 ;
            for (int i = 0; i < 10; ++i) {
                sum += sum + i ;
            }
            addSum (sum) ;
        }




    public static void main(String[] args) throws InterruptedException {
        Thread [] thList = new Thread [10] ;
        for (int i = 0; i < 10; i ++) {
            thList [i] = new Test(i * 10 + 1) ;
            thList [i].start();
        }
        for (int i = 0 ; i < 10 ; i ++)
        {
            thList[i].join() ;
        }
        System.out.println ("Sum is : " + n) ;
    }

    }

