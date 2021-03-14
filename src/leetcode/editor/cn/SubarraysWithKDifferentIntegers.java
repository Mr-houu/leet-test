package leetcode.editor.cn;

//给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。 
//
// （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。） 
//
// 返回 A 中好子数组的数目。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,2,1,2,3], K = 2
//输出：7
//解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
// 
//
// 示例 2： 
//
// 输入：A = [1,2,1,3,4], K = 3
//输出：3
//解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20000 
// 1 <= A[i] <= A.length 
// 1 <= K <= A.length 
// 
// Related Topics 哈希表 双指针 Sliding Window 
// 👍 211 👎 0

public class SubarraysWithKDifferentIntegers{
    public static void main(String[] args) {
        Solution solution = new SubarraysWithKDifferentIntegers().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        // 计算数量
        int sum = 0;
        // 左指针
        int left = 0;
        // 右指针
        int right = left;
        // 获取数组长度，避免重复拿去数据
        int length = A.length;
        // 存放当前数据出现次数
        int[] news = new int[length + 1];
        // 窗口中包含的数字个数
        int count = 0;
        // 放入第一个数字
        news[A[0]] = 1;
        count = 1;
        while (left <= length - K) {
            // 没放满
            if (count < K) {
                // 右指针移动
                right++;
                // 超界则结束循环
                if (right == length) {
                    break;
                }
                // 判断是否是新数
                if (news[A[right]]++ == 0) {
                    count++;
                }
            } else if (count == K) {
                sum++;
                int i = right + 1;
                while (i < length) {
                    if (news[A[i]] == 0) {
                        break;
                    } else {
                        i++;
                        sum++;
                    }
                }
                // 移动左指针
                if (--news[A[left]] == 0) {
                    count--;
                }
                left++;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}