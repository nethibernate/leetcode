package com.gyoomi.ImplementStrStr;

/**
 * 28. 实现strStr()
 *     实现 strStr() 函数。
 *     给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 *     说明:
 *         当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *         对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 *     方法一：
 *           暴力破解法
 *     方法二：
 *          Sunday算法
 *
 *
 * @author Leon
 * @version 2019/7/5 21:47
 */
public class Main {

    public static void main(String[] args) {

    }

}


class Solution {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        char[] hayArray = haystack.toCharArray();
        char[] needArray = needle.toCharArray();
        // 主串的位置
        int i = 0;
        // 模式串的位置
        int j = 0;
        while (i < hayArray.length && j < needArray.length) {
            if (hayArray[i] == needArray[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == needArray.length) {
            return i - j;
        } else {
            return -1;
        }
    }
}


class Solution2 {

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int[] occ = getOCC(needle);
        int jump = 0;
        for (int i = 0; i <= m - n; i+=jump) {
            int j = 0;
            while (j < n && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == n) {
                return i;
            }
            jump = i + n < m ? n - occ[haystack.charAt(i + n)] : 1;
        }
        return -1;
    }

    public int[] getOCC(String p) {
        int[] occ = new int[128];
        for (int i = 0; i < occ.length; i++) {
            occ[i] = -1;
        }
        for (int i = 0; i < p.length(); i++) {
            occ[p.charAt(i)] = i;
        }
        return occ;
    }
}
















