package 算法;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode-cn.com/problems/clumsy-factorial/
 * @author ：Good_M
 * @date ：Created in 2021 2021/4/1 21:42
 */
public class L1006笨阶乘 {


    /**
     * 整体思路，将每个1、2、3位置上的数据先做乘法和除法，生成新的结果
     * 再和原阶乘中的数据统一放入一个集合中
     * 再对集合中的数据以此做加减法
     * @param N
     * @return
     */
    public static int clumsy(int N) {
        List<Integer> temp = new ArrayList<>();
        int tempResult = 0;
        for (int i = 1; N > 0; i++) {
            switch (i%4) {
                case 1 :
                    tempResult = N;
                    break;
                case 2 :
                    tempResult *= N;
                    break;
                case 3 :
                    tempResult /= N;
                    break;
                case 0 :
                    //被四整除，则保存前面的计算结果和本位置上的数到暂存结果集中，并清零前三位计算结果
                    temp.add(tempResult);
                    temp.add(N);
                    tempResult = 0;
                    break;
            }
            N--;
        }
        //如果不为0说明计算惩处计算到一般阶乘就结束了，则将最后结果放入缓存
        if (tempResult != 0) {
            temp.add(tempResult);
        }
        //以此加减计算
        tempResult = temp.get(0);
        for (int i = 1; i < temp.size(); i++) {
            tempResult = i%2 == 1 ? tempResult + temp.get(i) : tempResult - temp.get(i);
        }
        return tempResult;

    }

    public int clumsy2(int N) {
        if(N<=2)return N;
        if(N==3)return 6;
        int sum=N*(N-1)/(N-2)+N-3;
        N-=4;
        while(N>=4){
            sum+=(-N*(N-1)/(N-2)+N-3);
            N-=4;
        }
        return sum-clumsy(N);
    }



}
