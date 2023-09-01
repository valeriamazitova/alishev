public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{-1, 3, 5, 8, 10, 15, 16, 20}, 16));

        System.out.println(binarySearch(new int[]{-1, 3, 5, 8, 10, 15, 16, 20}, 16, 0, 7));
    }

    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (key < a[middle]) {
                high = middle - 1;
            } else if (key > a[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    // recursive method
    public static int binarySearch(int[] sortedArray, int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        int middle = low + (high - low) / 2;

        if (key < sortedArray[middle]) {
            return binarySearch(sortedArray, key, low, middle - 1);
        } else if (key > sortedArray[middle]) {
            return binarySearch(sortedArray, key, middle + 1, high);
        } else if (key == sortedArray[middle]) {
            return middle;
        }

        return -1;
    }
}
