package leetcode.editor.cn;

//实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 397 👎 0

public class BasicCalculator{
    public static void main(String[] args) {
        Solution solution = new BasicCalculator().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        // 数组长度
        int length = s.length();
        // 存放操作符号、括号(
        Deque<Integer> deque = new LinkedList<>();
        // 用于计算
        deque.push(1);
        // 用于计算 + 或者 -,判断数字的正负(记录当前符号)
        int sign = 1;

        int sum = 0;
        int i = 0;

        while (i < length) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = deque.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -deque.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                // 计算括号
                deque.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                // 计算括号
                deque.pop();
                i++;
            } else {
                long num = 0;
                // 这里会判断数字的下一个字符是否还是数字，是的话，就是多位数，需要 * 10
                while (i < length && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                sum += sign * num;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}