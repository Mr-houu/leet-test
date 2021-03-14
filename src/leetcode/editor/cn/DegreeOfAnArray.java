package leetcode.editor.cn;

//给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
//
// 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1, 2, 2, 3, 1]
//输出：2
//解释：
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2,3,1,4,2]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// nums.length 在1到 50,000 区间范围内。 
// nums[i] 是一个在 0 到 49,999 范围内的整数。 
// 
// Related Topics 数组 
// 👍 279 👎 0

public class DegreeOfAnArray{
    public static void main(String[] args) {
        Solution solution = new DegreeOfAnArray().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findShortestSubArray(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            Integer integer = map.get(nums[i]);
            if (null != integer) {
                map.put(nums[i], ++integer);
            } else {
                integer = 1;
                map.put(nums[i], integer);
            }
            count = count > integer ? count : integer;
        }
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            if (map.get(integer) == count) {
                int left = 0;
                int right = length - 1;
                while (nums[left] != integer) {
                    left++;
                }
                while (nums[right] != integer) {
                    right--;
                }
                ans = (right - left + 1) < ans ? (right - left + 1) : ans;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}