package leetcode.editor.cn;

//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,1] 
//
// 示例 2: 
//
// 输入: 5
//输出: [0,1,1,2,1,2] 
//
// 进阶: 
//
// 
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为O(n)。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。 
// 
// Related Topics 位运算 动态规划 
// 👍 559 👎 0

public class CountingBits{
    public static void main(String[] args) {
        Solution solution = new CountingBits().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countBits(int num) {
        int[] temp = new int[num + 1];
        // java内置函数
/*        for (int i = 0; i <= num; i++) {
            temp[i] = Integer.bitCount(i);
        }*/

        // 去掉末尾的1
/*        for (int i = 0; i <= num; i++) {
            temp[i] = bitCount(i);
        }*/

        // 动态规划，最高有效位
        int hightBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                hightBit = i;
            }
            temp[i] = temp[i - hightBit] + 1;
        }
        return temp;
    }

    // 去掉末尾的1
/*    public int bitCount(int i) {
        int nums = 0;
        while (i > 0) {
            // 去掉末尾的1
            i = i & (i - 1);
            nums ++;
        }
        return nums;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}