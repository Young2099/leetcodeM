package letcodeReview.guihua;

public class MaxProfit121 {
    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        int a = new MaxProfit121().maxProfit(nums);
        System.out.println(a);

    }

    public int maxProfit(int[] prices) {
        int minPrices = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrices ){
                minPrices = prices[i];
            }else if ((prices[i] - minPrices)>maxProfit){
                maxProfit  = prices[i] -minPrices;
            }
        }
        return maxProfit;
    }
}
