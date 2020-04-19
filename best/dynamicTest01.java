package zzy.leecode.best;

/**
 * 背包问题升级版：
 * 对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品装入背包，
 * 在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少呢?
 */
public class dynamicTest01 {
    // 每个物品重量weight，每个物品价值value，物品数量n，背包最大承重w
    public static int knapsack3(int[] weight, int[] value, int n, int w){
        int[][] states = new int[n][w+1];
        for (int i=0;i<n;i++){
            for (int j=0;j<w+1;j++){
                states[i][j] = -1;
            }
        }
        // 第一行状态赋值
        states[0][0] = 0;
        states[0][weight[0]] = value[0];
        for (int i=1;i<n;i++){ // 动态规划，状态转移
            // 不加入第i个物品
            for (int j=0;j<=w;j++){
                if (states[i-1][j]>=0)
                    states[i][j] = states[i-1][j];
            }
            // 加入第i个物品
            for (int j=0;j<=w-weight[i];j++){
                if (states[i-1][j]>=0){
                    int v = states[i-1][j] + value[i];
                    // 覆盖相同位置i，j+weight[i]的val,放入最大的val
                    if (v > states[i][j+weight[i]]){
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值并返回,在最后一行状态中找出最大值
        int maxval = -1;
        for (int j=0;j<=w;j++){
            if (states[n-1][j] > maxval){
                maxval = states[n-1][j];
            }
        }
        return maxval;
    }
}
