import java.util.*;

public class FirstAndLastposition {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 7, 8, 10};
        int target = 7;
        System.out.println(Arrays.toString(searchRange(arr, target)));
    }
    static int[] searchRange(int[] arr, int target) {
        int[] ans = {-1, -1};

        ans[0] = search(arr, target, true);
        if (ans[0] != -1)
            ans[1] = search(arr, target, false);

        return ans;

    }
    // function to return the index of the target
    static int search(int[] arr, int target, boolean findStartIndex) {
        int ans = -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                //potential answer is found
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }return ans;
    }
}
