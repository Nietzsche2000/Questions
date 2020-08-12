import java.util.Arrays;

public class QuickSorting {

    public static void sort(int[] arr) {
        if(arr.length <= 1)
            return;
        int lessThan = 0;
        int equal = 0;
        int greaterThan = 0;
        int pivot = arr[0];
        for (int item : arr) {
            if (item > pivot)
                greaterThan++;
            else if (item < pivot)
                lessThan++;
            else
                equal++;
        }
        int[] lessThanArr = new int[lessThan];
        int[] equalArr = new int[equal];
        int[] greaterThanArr = new int[greaterThan];

        int i = 0, j = 0, k = 0;
        for (int item : arr) {
            if (pivot > item)
                lessThanArr[i++] = item;
            else if (pivot < item)
                greaterThanArr[j++] = item;
            else
                equalArr[k++] = item;
        }
        sort(lessThanArr);
        sort(greaterThanArr);
        int[] result = append(lessThanArr, equalArr);
        result = append(result, greaterThanArr);
        System.arraycopy(result, 0, arr, 0, arr.length);
    }

    public static int[] append(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int k = 0;
        for (int value : arr1) {
            result[k++] = value;
        }
        for (int value : arr2) {
            result[k++] = value;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 100, 99, 1000, 38432, 1123, -2};
        int[] arr2 = new int[]{1, 20, 30, 40};
        int[] arr3 = new int[]{6, 7, 8, 9, 10};
        sort(arr);
//        arr = merge(arr2, arr3);
        System.out.println(Arrays.toString(arr));
    }
}
