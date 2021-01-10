import org.junit.jupiter.api.Test;

class MergeSortedArraysTest {
    @Test
    void shouldMergeSortedArrays() {
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{};

        int[] merge = new MergeSortedArrays().merge(arr1, arr2);
        for (int num : merge) {
            System.out.print(num + " ");
        }
    }
}