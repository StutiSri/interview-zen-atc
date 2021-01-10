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
}



