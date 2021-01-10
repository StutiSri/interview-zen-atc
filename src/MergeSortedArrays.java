import javax.sound.midi.Soundbank;

public class MergeSortedArrays {
    public int[] merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] mergedArr = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m){
            if(arr1[i] < arr2[j]){
                mergedArr[k] = arr1[i];
                i++;;
            }else {
                mergedArr[k] = arr2[j];
                j++;;
            }
            k++;
        }

        while (i < n){
            mergedArr[k++] = arr1[i++];
        }

        while (j < m){
            mergedArr[k++] = arr2[j++];
        }

        return mergedArr;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{1, 1, 2};

        int[] mergedArray = new MergeSortedArrays().merge(arr1, arr2);
        int[] expectedMergedArr = new int[]{1, 1, 1, 2, 2, 3};
        for (int i = 0; i < mergedArray.length; i++) {
            assert mergedArray[i] == expectedMergedArr[i];
        }
        System.out.println("Case 1 is passed");

        arr1 = new int[]{1, 2, 3};
        arr2 = new int[]{2, 4, 6};

        mergedArray = new MergeSortedArrays().merge(arr1, arr2);
        expectedMergedArr = new int[]{1, 2, 2, 3, 4, 6};
        for (int i = 0; i < mergedArray.length; i++) {
            assert mergedArray[i] == expectedMergedArr[i];
        }
        System.out.println("Case 2 is passed");

        arr1 = new int[]{1, 2, 3, 4};
        arr2 = new int[]{2, 4, 6};

        mergedArray = new MergeSortedArrays().merge(arr1, arr2);
        expectedMergedArr = new int[]{1, 2, 2, 3, 4, 4, 6};
        for (int i = 0; i < mergedArray.length; i++) {
            assert mergedArray[i] == expectedMergedArr[i];
        }
        System.out.println("Case 3 is passed");
    }
}



