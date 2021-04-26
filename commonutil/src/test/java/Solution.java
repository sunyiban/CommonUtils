import java.util.Arrays;

/**
 * @author sunyiban@panda-fintech.com
 * @title: Solution
 * @copyright: Copyright (c) 2018
 * @description: <br>
 * @company: panda-fintech
 * @created on 2020/7/2下午5:16
 */
public class Solution {

  public static void main(String[] args) {
    String a = "abcdec";
    String b = "cdecab";

    int[] index = new int[128];
    System.out.println(a.charAt(1));
    System.out.println(b.charAt(1));

    index[a.charAt(1)]++;
    index[1]--;
    index['c'] = 0;

    for (int i = 0; i < index.length; i++) {
      System.out.print(index[i] + " ");
    }

  }
  public boolean CheckPermutation(String s1, String s2) {

    if (s1.length() != s2.length()) {
      return false;
    }

    if (s1.equals(s2)) {
      return false;
    }

    //将s1  s2排序
    String[] s1c = s1.split("");
    Arrays.sort(s1c);

    String[] s2c = s2.split("");
    Arrays.sort(s2c);

    //比较是否相同
    for (int i = 0; i < s1c.length; i++) {
      if (!s1c[i].equals(s2c[i])) {
        return false;
      }
    }

    return true;
  }
}
