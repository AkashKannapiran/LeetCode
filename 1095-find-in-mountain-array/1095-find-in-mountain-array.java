/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakElement(mountainArr);
        int firstHalf = orderAgnosticBS(mountainArr, target, 0, peak);

        if (firstHalf != -1) {
            return firstHalf;
        }

        return orderAgnosticBS(mountainArr, target, peak + 1, mountainArr.length() - 1);
    }

    private int peakElement(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    private int orderAgnosticBS(MountainArray mountainArr, int target, int start, int end) {
        boolean isAsc = mountainArr.get(start) < mountainArr.get(end);

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midElement = mountainArr.get(mid);

            if (midElement == target) {
                return mid;
            }

            if (isAsc) {
                if (target < midElement) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > midElement) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}