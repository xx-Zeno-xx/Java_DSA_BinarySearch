public class MountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 6, 5, 4};
        int target = 4;
        System.out.println(searchInMountain(arr, target));

    }
    static int mountainPeak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }return end;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        if (arr[start] < arr[end]) {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (target < arr[mid]) {
                    end = mid - 1;
                } else if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
        } else {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (target > arr[mid]) {
                    end = mid - 1;
                } else if (target < arr[mid]) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
        }return -1;
    }
    static int searchInMountain(int[] arr, int target) {
        int peak = mountainPeak(arr);
        int firstTry = binarySearch(arr, target, 0, peak);

        if (firstTry != -1) {
            return firstTry;
        }
        return binarySearch(arr, target, peak + 1, arr.length - 1);
    }
}
