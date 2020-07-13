package com.leecode.interview;

/**
 * @author sunyiban@panda-fintech.com
 * @title: Rotate
 * @copyright: Copyright (c) 2018
 * @description: <br>
 * @company: panda-fintech
 * @created on 2020/7/13上午9:53
 */
public class Rotate {
  public void rotate(int[][] matrix) {
    // 规律 纵向逆转变为横向坐标
    int[][] result = new int[matrix.length][matrix[0].length];
    // 倒序遍历外层矩阵
    for (int i = matrix.length - 1; i >= 0; i--) {
      int[] inside = matrix[i];
      // 每个数组中的元素都是新矩阵的第n（层）个元素
      for (int j = 0; j < inside.length; j++) {
        result[j][matrix.length-i-1] = inside[j];
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        matrix[i][j] = result[i][j];
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix ={{1,2,3},{4,5,6}, {7,8,9}};
    Rotate rotate = new Rotate();
    rotate.rotate(matrix);

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + ", ");
      }
      System.out.println();
    }
  }
}
