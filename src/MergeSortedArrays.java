public class MergeSortedArrays {
    public int[] merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] mergedArr = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                mergedArr[k] = arr1[i];
                i++;
                ;
            } else {
                mergedArr[k] = arr2[j];
                j++;
                ;
            }
            k++;
        }

        while (i < n) {
            mergedArr[k++] = arr1[i++];
        }

        while (j < m) {
            mergedArr[k++] = arr2[j++];
        }

        return mergedArr;
    }

    public static void main(String[] args) {

        mergeArrays(new int[]{1, 2, 3}, new int[]{1, 2, 3});

        mergeArrays(new int[]{1, 2, 3}, new int[]{2, 4, 6});

        mergeArrays(new int[]{1, 2, 3, 4}, new int[]{2, 4, 6});

    }

    private static void mergeArrays(int[] arr1, int[] arr2) {
        int[] mergedArray = new MergeSortedArrays().merge(arr1, arr2);
        for (int value : mergedArray) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}



