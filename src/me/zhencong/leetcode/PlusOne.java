package me.zhencong.leetcode;

/**
 * @author <a href="zhencong.ouzc@taobao.com">遣怀</a>
 * @date 14/10/26.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        for (int j = 0; j < digits.length; j++) {
            int digit = digits[j];
            int x = digit + 1;
            if (x / 10  == 0) {
                digits[j] += 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
    }
}
