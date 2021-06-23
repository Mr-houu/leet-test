package leetcode.editor.cn;

//给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足
//：i < j < k 和 nums[i] < nums[k] < nums[j] 。 
//
// 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。 
//
// 
//
// 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false
//解释：序列中不存在 132 模式的子序列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,4,2]
//输出：true
//解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,3,2,0]
//输出：true
//解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 栈 
// 👍 344 👎 0

public class One32Pattern {
    public static void main(String[] args) {
        Solution solution = new One32Pattern().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean find132pattern(int[] nums) {
            int length = nums.length;
            Deque<Integer> dq = new LinkedList<>();
            // 从后往前维护一个单调递减的单调栈，记录被弹出的最大值，只要有值被弹出，说明数据符合132中的 32
            // 对于样例数据 [3, 1, 4, 2]，我们知道满足 132 结构的子序列是 [1, 4, 2]，其处理逻辑是（遍历从后往前）：
            // 第一步，枚举到2：2入栈，
            // 第二步，枚举到4：4入栈，由于4 > 2，不满足单调递减规则，把2弹出，k = 2
            // 第三步，枚举到1：由于1 < k = 2， 满足了132的情况，结束查找
            int k = -1000000001;
            for (int i = length - 1; i > -1; i--) {
                if (nums[i] < k) {
                    return true;
                }
                while (!dq.isEmpty() && nums[i] > dq.peek()) {
                    int temp = dq.pop();
                    k = k > temp ? k : temp;
                }
                dq.push(nums[i]);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}