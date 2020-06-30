package 正则表达式;


import java.util.regex.Pattern;

/**
 * @program: _1
 * @description: 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。  '.' 匹配任意单个字符 '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * @author: mooncake
 * @create: 2020-06-20 19:16
 **/
public class Solution {
    public boolean isMatch(String s, String p) {
        int pointer = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==s.charAt(pointer)){

            }else {
                return false;
            }
        }
        return  true;
    }
}
