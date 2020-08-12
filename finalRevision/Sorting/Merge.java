import java.util.Arrays;

public class Merge {

    public static void sort(int[] arr) {
        if (arr.length == 1)
            return;
        int min = arr.length / 2;
        int[] auxarr1 = new int[min];
        int[] auxarr2 = new int[arr.length - min];
        int[] result;
        for (int i = 0; i < min; i++) {
            auxarr1[i] = arr[i];
        }
        for (int i = 0; i < auxarr2.length; i++) {
            auxarr2[i] = arr[min + i];
        }
        sort(auxarr1);
        sort(auxarr2);
        result = merge(auxarr1, auxarr2);
        System.arraycopy(result, 0, arr, 0, arr.length);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            int val1 = arr1[i];
            int val2 = arr2[j];
            if (val1 <= val2) {
                result[k] = val1;
                i++;
            } else {
                result[k] = val2;
                j++;
            }
            k++;
        }
        for (; i < arr1.length; i++) {
            result[k] = arr1[i];
            k++;
        }

        for (; j < arr2.length; j++) {
            result[k] = arr2[j];
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr2 = new int[]{1, 20, 30, 40};
        int[] arr3 = new int[]{6, 7, 8, 9, 10};
        sort(arr);
//        arr = merge(arr2, arr3);
        System.out.println(Arrays.toString(arr));
    }
}
