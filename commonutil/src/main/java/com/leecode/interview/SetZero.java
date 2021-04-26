package com.leecode.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunyiban@panda-fintech.com
 * @title: SetZero
 * @copyright: Copyright (c) 2018
 * @description: <br>
 * @company: panda-fintech
 * @created on 2020/7/13上午10:22
 */
public class SetZero {
  public void setZeroes(int[][] matrix) {
    // 遍历数组，定位0所在位置横纵坐标
    // 为零的横坐标
    Set<Integer> row = new HashSet<>();
    // 为零的纵坐标
    Set<Integer> ceil = new HashSet<>();
    // 将横纵坐标元素都设置为0
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          row.add(i);
          ceil.add(j);
        }
      }
    }

    if (row.size() == 0 && ceil.size() == 0) {
      return;
    }

    for (int i = 0; i < matrix.length; i++) {
      // 如果列包含，每一列置位0
      if (ceil.size() > 0) {
        for (int c : ceil) {
          matrix[i][c] = 0;
        }
      }

      for (int j = 0; j < matrix[0].length; j++) {
        // 如果行包含，全部置位0
        if (row.contains(i)) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix ={{0,1,2,0},{4,1,6,1}, {7,8,9,1}};
    SetZero setZero = new SetZero();
    setZero.setZeroes(matrix);

    for (int[] ii : matrix) {
      for (int i : ii) {
        System.out.print(i + ",");
      }
      System.out.println();
    }
  }
}
