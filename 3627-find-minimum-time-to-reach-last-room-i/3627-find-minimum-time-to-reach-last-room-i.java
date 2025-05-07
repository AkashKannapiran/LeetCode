class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int row = moveTime.length;
        int column = moveTime[0].length;
        int[][] minTime = new int[row][column];

        for (int[] time : minTime) {
            Arrays.fill(time, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.steps - b.steps);
        pq.add(new Pair(-1, 0, 0));
        minTime[0][0] = 0;

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int i = top.i;
            int j = top.j;
            int nextSteps = top.steps + 1;

            if (i + 1 < row) {
                update(i + 1, j, pq, nextSteps,moveTime, minTime);
            }

            if (i - 1 >= 0) {
                update(i - 1, j, pq, nextSteps,moveTime, minTime);
            }

            if (j + 1 < column) {
                update(i, j + 1, pq, nextSteps,moveTime, minTime);
            }

            if (j - 1 >= 0) {
                update(i, j - 1, pq, nextSteps,moveTime, minTime);
            }
        }

        return minTime[row - 1][column - 1] + 1;
    }

    private void update(int i, int j, PriorityQueue<Pair> pq, int nextSteps, int[][] moveTime, int[][] minTime) {
        if (nextSteps < moveTime[i][j]) {
            nextSteps = moveTime[i][j];
        }

        if (minTime[i][j] > nextSteps) {
            pq.add(new Pair(nextSteps, i, j));
            minTime[i][j] = nextSteps;
        }
    }
}

class Pair {
    int steps;
    int i;
    int j;

    Pair(int steps, int i, int j) {
        this.steps = steps;
        this.i = i;
        this.j = j;
    }
}