import java.util.Arrays;


public class Quicksort {
    public static void main(String[] args) throws CustomEx {

        int[] arr = new int[]{52, 37, 63, 14, 17, 8, 6, 25};
        System.out.println(Arrays.toString(sort(arr)));

    }

    public static int[] sort(int[] arr) throws CustomEx {
        int[] concatenated;

        try {
            if (arr.length == 0 || arr.length == 1) {
                return arr;
            } else {
                int pivot = arr[arr.length / 2];

                int[] right = Arrays.stream(arr)
                        .filter(element -> element < pivot)
                        .toArray();
                int[] left =
                        Arrays.stream(arr)
                                .filter(element -> element > pivot)
                                .toArray();

                concatenated = new int[right.length + left.length + 1];

                int[] arr1 = new int[]{pivot};

                int[] sortedRight = sort(right);
                int[] sortedLeft = sort(left);

                System.arraycopy(sortedRight, 0, concatenated, 0, sortedRight.length);
                System.arraycopy(arr1, 0, concatenated, sortedRight.length, 1);
                System.arraycopy(sortedLeft, 0, concatenated, sortedRight.length + 1, sortedLeft.length);
            }
        } catch (NullPointerException customEx) {
            throw new CustomEx();
        }


        return concatenated;

    }

    /*
 We choose an element from the list, called the pivot. We'll use it to divide the list into two sub-lists.
We reorder all the elements around the pivot – the ones with smaller value are placed before it,
and all the elements greater than the pivot after it. After this step, the pivot is in its final position.
This is the important partition step.
We apply the above steps recursively to both sub-lists on the left and right of the pivot.


Quick sort example:
[52, 37, 63, 14, 17, 8, 6, 25]
pivot = 25
[6 8 17 14] 25 [63 37 52]
pivot = 14 (left branch)
[6 8] 14 [17]
pivot = 8 (left branch)
[6] 8 []
    * */
}
