package LeetCode;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-21 19:36
 * @description: 对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，
 * 则认为字符串 s1 和 s2 的 相似度为 k 。
 * 给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。
 **/
public class Q854 {
    public static void main(String[] args) {
        int arr = Solution845.kSimilarity("abac", "baca");

     /*   for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }*/

        System.out.println(arr);
    }

}

class Solution845 {
    public static int kSimilarity(String s1, String s2) {
        int[] arr = new int[s1.length()];
        int num = 0;
        int len = 0;

        for (int i = 0; i < s1.length(); i++) {
            arr[i] = s1.indexOf(s2.charAt(i));

        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    ++num;
                }
            }
        }
        return num;
    }
}