class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[0]));
        int freeDays = meetings[0][0] - 1;
        int latestEnd = meetings[0][1];

        for (int i = 1; i < meetings.length; i++) {
            // if (latestEnd < meetings[i][0]) {
            //     freeDays += meetings[i][0] - latestEnd -1;
            // }
            freeDays += (latestEnd < meetings[i][0]) ? meetings[i][0] - latestEnd - 1 : 0;
            latestEnd = (latestEnd < meetings[i][1]) ? meetings[i][1] : latestEnd;
        }

        return freeDays + (days - latestEnd);
    }
}
// prefix sum approach
// class Solution {
//     public int countDays(int days, int[][] meetings) {
//         int[] dayMap = new int[days + 2];
//         int freeDays = 0;

//         for (int i = 0; i < meetings.length; i++) {
//             dayMap[meetings[i][0]] += 1;
//             dayMap[meetings[i][1] + 1] -= 1;
//         }

//         for (int i = 1; i <= days; i++) {
//             dayMap[i] += dayMap[i - 1];
//         }

//         for (int i = 1; i <=days; i++) {
//             if (dayMap[i] == 0) {
//                 freeDays++;
//             }
//         }

//         return freeDays;
//     }
// }

// brute force approach
// class Solution {
//     public int countDays(int days, int[][] meetings) {
//         int countDays = 0;
//         boolean[] meeting = new boolean[days];

//         // iterate through each meeting, and marking true whenever a scheduled meeting is found, until every meeting has been explored
//         for (int i = 0; i < meetings.length; i++) {
//             for (int j = meetings[i][0]; j <= meetings[i][1]; j++) {
//                 meeting[j - 1] = true;
//             }
//         }

//         for (boolean check : meeting) {
//             if (check == false) {
//                 countDays++;
//             }
//         }

//         return countDays;
//     }
// }