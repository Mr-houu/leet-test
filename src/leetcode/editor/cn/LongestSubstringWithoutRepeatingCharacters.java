package leetcode.editor.cn;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5197 👎 0

public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        // 定义左指针
        int left = 0;
        // 定义右指针
        int right = 0;
        // 存放数据
        Map<Character, Integer> map = new HashMap<>();
        // 存入第一个节点
        map.put(s.charAt(left), 1);
        // 计数
        int sum = 1;
        while (right < length - 1) {
            right++;
            // 判断新滑入的元素是否在map中存在
            char c = s.charAt(right);
            int num = map.getOrDefault(c, 0);
            // 新滑入的数据不存在，写入map，计数
            if (num == 0) {
                map.put(c, 1);
                sum = sum > map.size() ? sum : map.size() ;
            } else {
                char l;
                while((l = s.charAt(left)) != c) {
                    map.remove(l);
                    left++;
                }
                // 去掉相等的那一个char
                left++;
                map.put(c, 1);
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}