//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串 👍 1747 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

class longestCommonPrefix {
    //2021-08-27 17:22:25
    //最长公共前缀
    //编号：[14]

    public static void main(String[] args) {
        Solution solution = new longestCommonPrefix().new Solution();
        // TO TEST
        String[] strs = {"flower", "flower", "flower"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 1) {
                return strs[0];
            }

            String middle = getCommon(strs[0], strs[1]);

            if (strs.length >= 3) {
                for (int j = 2; j < strs.length; j++) {
                    middle = getCommon(middle, strs[j]);
                }
            }

            return middle;
        }

        public String getCommon(String str1, String str2) {
            for (int i = 1; i <= Math.min(str1.length(), str2.length()); i++) {
                if (!str1.substring(0, i).equals(str2.substring(0, i))) {
                    return str1.substring(0, i - 1);
                }
            }
            return str1.length() < str2.length() ? str1 : str2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}