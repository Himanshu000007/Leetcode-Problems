import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startR = 0;
        int startC = 0;

        // Har litter ko ek number denge
        int[][] litterId = new int[m][n];
        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        int totalLitter = 0;

        // Start aur Litter find karo
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (classroom[i].charAt(j) == 'S') {
                    startR = i;
                    startC = j;
                }

                if (classroom[i].charAt(j) == 'L') {
                    litterId[i][j] = totalLitter;
                    totalLitter++;
                }
            }
        }

        // Saara litter collect ho gaya
        int targetMask = (1 << totalLitter) - 1;

        /*
            State:
            row
            col
            energy
            mask
        */
        Queue<int[]> queue = new LinkedList<>();

        // [row, col, energy, mask, moves]
        queue.offer(new int[]{startR, startC, energy, 0, 0});

        /*
            visited[row][col][energy][mask]

            Energy maximum 50
            Litter maximum 10
        */
        boolean[][][][] visited =
                new boolean[m][n][energy + 1][1 << totalLitter];

        visited[startR][startC][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];
            int currEnergy = current[2];
            int mask = current[3];
            int moves = current[4];

            // Saara litter collect ho gaya
            if (mask == targetMask) {
                return moves;
            }

            // Energy khatam hai
            if (currEnergy == 0) {
                continue;
            }

            // 4 directions
            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                // Boundary check
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                // Obstacle
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                int newEnergy = currEnergy - 1;
                int newMask = mask;

                // Agar litter mila
                if (classroom[nr].charAt(nc) == 'L') {

                    int id = litterId[nr][nc];

                    newMask = mask | (1 << id);
                }

                // Reset area
                if (classroom[nr].charAt(nc) == 'R') {
                    newEnergy = energy;
                }

                // Agar ye state pehle visit nahi hui
                if (!visited[nr][nc][newEnergy][newMask]) {

                    visited[nr][nc][newEnergy][newMask] = true;

                    queue.offer(new int[]{
                            nr,
                            nc,
                            newEnergy,
                            newMask,
                            moves + 1
                    });
                }
            }
        }

        return -1;
    }
}