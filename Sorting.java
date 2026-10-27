import java.util.Arrays;

public class Sorting {

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * Selection sort:
     * - Select the minimum and place at first index.
     * - On each iteration finish, one minimum will be pushed to the starting
     * - Now in next part, again Select the minimum and place at first index.
     * [9, 13, 5, 3, 7, 2]
     * --> least is 2, so swap 9 and 2, it becomes [2, 13, 5, 3, 7, 9]
     * [2, 13, 5, 3, 7, 9]
     * --> from 13,..9, least is 3, so now swap 13 and 3 and entire array becomes
     * [2, 3, 5, 13, 7, 9]
     * Next stages will be like
     * [2, 3, 5, 13, 7, 9]
     * [2, 3, 5, 13, 7, 9] ==> [2, 3, 5, 13, 7, 9]
     * [2, 3, 5, 13, 7, 9] ==> [2, 3, 5, 7, 13, 9]
     * [2, 3, 5, 7, 13, 9] ==> [2, 3, 5, 7, 9, 13]
     */
    public void SelectionSorting(int[] arr) {
        int n = arr.length;
        // iterate upto index n-2 is enough since on reaching to last element, all array
        // would be sorted.
        for (int i = 0; i < n - 1; i++) {
            // maintain this variable to track index of minimum number in rest of the array.
            int min = i;
            // to get index of min in rest of the array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }

            if (min != i) {
                this.swap(arr, i, min);
            }
        }
        for (int each : arr) {
            System.out.print(each + " ");
        }
    }

    /*
     * Adjacent swapping and push the maximum to the end.
     * - For each iteration finish, one max will be pushed to the end.
     * -> on reaching to last element it is already sorting, so outer loop will be
     * upto 0 to n-1
     * - Again for next iteration, do sorting from 0 to last before index
     * -> i=0 == 0 to n-1
     * -> i=1 == 0 to n-1-1
     * -> i=2 == 0 to n-1-2
     * -> i.e from j is from 0 to n-1-i
     */
    public void bubbleSorting(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    isSwapped = true;
                    this.swap(arr, j, j + 1);
                }
            }
            if (!isSwapped)
                break;
        }
        for (int each : arr) {
            System.out.print(each + " ");
        }
    }

    public static void main(String[] args) {
        int[] ss = { 9, 13, 5, 3, 7, 2, 10, -1, 5, -100, 100 };
        int[] bs = { 9, 13, 5, 3, 7, 2, 10, -1, 5, -100, 100 };
        Sorting sort = new Sorting();
        sort.SelectionSorting(ss);
        System.out.println();
        sort.bubbleSorting(bs);
    }
}
