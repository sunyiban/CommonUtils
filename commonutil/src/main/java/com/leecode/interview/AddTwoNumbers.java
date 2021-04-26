package com.leecode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunyiban@panda-fintech.com
 * @title: AddTwoNumbers
 * @copyright: Copyright (c) 2018
 * @description: <br>
 * @company: panda-fintech
 * @created on 2020/7/15下午10:03
 */
public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode cur1 = l1, cur2 = l2;
    List<Integer> val1 = new ArrayList<Integer>();
    val1.add(cur1.val);
    List<Integer> val2 = new ArrayList<Integer>();
    val2.add(cur2.val);
    while (cur1.next != null) {
      cur1 = cur1.next;
      val1.add(cur1.val);
    }

    while (cur2.next != null) {
      cur2 = cur2.next;
      val2.add(cur2.val);
    }

    int num1 = 0;
    for (int i = 0; i < val1.size(); i++) {
      num1 += (Math.pow(10, i) * val1.get(i));
    }

    int num2 = 0;
    for (int i = 0; i < val2.size(); i++) {
      num2 += (Math.pow(10, i) * val2.get(i));
    }

    int result = num2 + num1;
    ListNode resul = new ListNode(-1);
    String[] resultNum = (result + "").split("");
    for (int j = resultNum.length - 1; j >= 0; j--) {
      resul.next = new ListNode(Integer.parseInt(resultNum[j]));
      resul = resul.next;
    }

    while (resul.next != null) {
      System.out.println(resul.val);
      resul = resul.next;
    }

    return resul;
  }

  static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }


  public static void main(String[] args) {
    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
    ListNode listNode1 = new ListNode(9);
    listNode1.next = new ListNode(1);
    listNode1.next.next = new ListNode(2);

    ListNode listNode2 = new ListNode(1);
    listNode2.next = new ListNode(3);
    listNode2.next.next = new ListNode(8);

    ListNode result = addTwoNumbers.addTwoNumbers(listNode1, listNode2);

    while (result.next != null) {
      System.out.println(result.val);
      result = result.next;
    }
  }
}
