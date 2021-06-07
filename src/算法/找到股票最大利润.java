package 算法;

/**
 * @author ：Good_M
 * @date ：Created in 2021 2021/6/7 11:54
 */
public class 找到股票最大利润 {
    /**
     * 数据内为每天股票价格，只能买进卖出一次，找打利润最大的值
     * [1,6,3]，利润最大为5，[4,3,2,8,1,3],利润最大为6
     * @param prices
     * @return
     */
    public static int maxProfit (int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int lowestPrice = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > lowestPrice && prices[i] - lowestPrice > res) {
                res = prices[i] - lowestPrice;
            } else if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }
        }
        return res;
    }

}
