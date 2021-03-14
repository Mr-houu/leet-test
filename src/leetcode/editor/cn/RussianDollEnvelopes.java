package leetcode.editor.cn;

//给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如
//同俄罗斯套娃一样。 
//
// 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 说明: 
//不允许旋转信封。 
//
// 示例: 
//
// 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出: 3 
//解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
// 
// Related Topics 二分查找 动态规划 
// 👍 321 👎 0

public class RussianDollEnvelopes{
    public static void main(String[] args) {
        Solution solution = new RussianDollEnvelopes().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int length = envelopes.length;
        if (length == 0) {
            return length;
        }
        int col = envelopes[0].length;
        if (col == 1) {
            return 1;
        }
        // 排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    // 同一列的数据，大的放前面，能避免同级比较
                    return o2[1] - o1[1];
                }
            }
        });

        // 比较
        int[] dp = new int[length];
        dp[0] = 1;
        int maxes = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxes = Math.max(maxes, dp[i]);
        }
        return maxes;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}