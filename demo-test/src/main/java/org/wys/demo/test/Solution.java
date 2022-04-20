package org.wys.demo.test;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[][] img = new int[][]{{100,200,100},{200,50,200},{100,200,100}};
        Solution solution = new Solution();
        int[][] ints = solution.imageSmoother(img);
        for(int i = 0;i<ints.length;i++) {
            for(int j=0;i<ints[i].length;j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int[][] imageSmoother(int[][] img) {
        int[][] resArr = new int[img.length][];
        for(int i=0;i<img.length;i++) {
            resArr[i] = new int[img[i].length];
        }
        if (img.length == 1) {
            return img;
        } else if (img.length == 2) {
            int res = (img[0][0] = img[0][1] + img[1][0] + img[1][1]) / 4;
            for (int[] ints : img) {
                Arrays.fill(ints, res);
            }
        } else {
            for (int i = 0; i < img.length; i++) {
                for (int j = 0; j < img[i].length; j++) {
                    if (i == 0) {
                        if (j == 0) {
                            resArr[i][j] = (img[i][j] + img[i][j + 1] + img[i + 1][j] + img[i + 1][j + 1]) / 4;
                        } else if (j == img[i].length - 1) {
                            resArr[i][j] = (img[i][j] + img[i][j - 1] + img[i + 1][j] + img[i + 1][j - 1]) / 4;
                        } else {
                            resArr[i][j] = (img[i][j] + img[i][j - 1] + img[i][j + 1] + img[i + 1][j] + img[i + 1][j + 1]
                                    + img[i + 1][j - 1]) / 6;
                        }
                    } else if (i == img.length - 1) {
                        if (j == 0) {
                            resArr[i][j] = (img[i][j] + img[i][j + 1] + img[i - 1][j] + img[i - 1][j + 1]) / 4;
                        } else if (j == img[i].length - 1) {
                            resArr[i][j] = (img[i][j] + img[i][j - 1] + img[i - 1][j] + img[i - 1][j - 1]) / 4;
                        } else {
                            resArr[i][j] = (img[i][j] + img[i][j - 1] + img[i][j + 1] + img[i - 1][j] + img[i - 1][j + 1]
                                    + img[i - 1][j - 1]) / 6;
                        }
                    } else {
                        if (j == 0) {
                            resArr[i][j] = (img[i][j] + img[i][j + 1] + img[i - 1][j + 1] + img[i + 1][j]
                                    + img[i + 1][j + 1] + img[i - 1][j]) / 6;
                        } else if (j == img[i].length - 1) {
                            resArr[i][j] = (img[i][j] + img[i][j - 1] + img[i - 1][j] + img[i - 1][j - 1]
                                    + img[i + 1][j] + img[i + 1][j - 1]) / 6;
                        } else {
                            resArr[i][j] = (img[i][j] + img[i][j - 1] + img[i][j + 1] + img[i - 1][j] + img[i - 1][j - 1]
                                    + img[i - 1][j + 1] + img[i + 1][j - 1] + img[i + 1][j] + img[i + 1][j + 1]) / 9;
                        }
                    }
                }
            }
        }
        return resArr;
    }

}