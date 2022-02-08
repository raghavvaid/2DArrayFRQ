package com.company;

import java.util.Arrays;

public class NitalTester {

    /** Returns true if and only if every value in arr1 appears in arr2.
     * Precondition: arr1 and arr2 are the same length.
     * Postcondition: arr1 and arr2 are unchanged.
     */
    public static boolean hasAllValues(int [] arr1, int[] arr2){

        for(int i = 0; i < arr1.length; i++){
            boolean found = false;
            for(int j = 0; j < arr2.length && !found; j++){
                if(arr1[i]==arr2[j]) found = true;
            }
            if(!found) return false;
        }
        return true;
    }

    /** Returns true if arr contains any repeated values, false otherwise.
     */
    public static boolean containsRepeats(int[]arr){
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i]==arr[j]) return true;
            }
        }
        return false;
    }

    public static int [] getColumn(int[][] arr2D, int c){
        int result[] = new int[arr2D.length];
        for (int i = 0; i < arr2D.length; i++){
            result[i] = arr2D[i][c];
            }
        return result;

    }

    /* Write the method isNital below.  You must use getColumn,
    hasAllValues and containsRepeats appropriately to receive
    full credit.
     */
    /** Returns true if square is a Nital Square as described in the
     * word doc, false otherwise.
     * Precondition: square has an equal number of rows and columns.
     *      square has at least one row.
     */
    public static boolean isNital(int[][] square){
        if (containsRepeats(square[0])) return false;
        for (int i = 0; i < square.length; i++){
            if (!hasAllValues(square[0],square[i])) return false;
        }
        for (int i = 0; i < square[0].length; i++){
            if (!hasAllValues(square[0],square[i])) return false;
        }

        return true;
    }

    public static void main(String[] args){
        int[][] n1 = {{1,2,3},{2,3,1},{3,1,2}};
        int[][] n2 = {{10,30,20,0},{0,20,30,10},{30,0,10,20},{20,10,0,30}};
        int[][] n3 = {{1,2,1},{2,1,1},{1,1,2}};
        int[][] n4 = {{1,2,3},{3,1,2},{7,8,9}};
        int[][] n5 = {{1,2},{1,2}};
        int[][] n6 = {{1,1},{2,2}};

        System.out.println(Arrays.toString(getColumn(n1, 1)));
        System.out.println(Arrays.toString(getColumn(n2,0)));
        System.out.println(Arrays.toString(getColumn(n3,2)));
        System.out.println(Arrays.toString(getColumn(n4,0)));
        System.out.println(Arrays.toString(getColumn(n5,1)));
        System.out.println(Arrays.toString(getColumn(n6,0)));

//        System.out.println(isNital(n1));
//        System.out.println(isNital(n2));
//        System.out.println(isNital(n3));
//        System.out.println(isNital(n4));
//        System.out.println(isNital(n5));
//        System.out.println(isNital(n6));


//        int [] arr1 = {1,2,3};
//        int [] arr2 = {3,1,2};
//        int [] arr3 = {2,1,2};
//        System.out.println(hasAllValues(arr1,arr2));
//        System.out.println(hasAllValues(arr1,arr3));
//        System.out.println(hasAllValues(arr3,arr2));
//        int[] arr4 = {1,2,3,4,5,6};
//        int[] arr5 = {3,2,1,2,3};
//        System.out.println(containsRepeats(arr4));
//        System.out.println(containsRepeats(arr5));
    }
}