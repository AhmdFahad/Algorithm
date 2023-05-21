public class BinaryArrayRegions {
    private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int[][] findRegions(int[][] binaryArray) {
        int[][] regions = new int[binaryArray.length][binaryArray[0].length];
        int regionCount = 1;

        for (int i = 0; i < binaryArray.length; i++) {
            for (int j = 0; j < binaryArray[i].length; j++) {
                if (binaryArray[i][j] == 1 && regions[i][j] == 0) {
                    exploreRegion(binaryArray, regions, i, j, regionCount);
                    regionCount++;
                }
            }
        }

        return regions;
    }

    private static void exploreRegion(int[][] binaryArray, int[][] regions, int row, int col, int regionCount) {
        regions[row][col] = regionCount;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newRow < binaryArray.length &&
                    newCol >= 0 && newCol < binaryArray[newRow].length &&
                    binaryArray[newRow][newCol] == 1 && regions[newRow][newCol] == 0) {
                exploreRegion(binaryArray, regions, newRow, newCol, regionCount);
            }
        }
    }

    public static void main(String[] args) {
        int[][] binaryArray = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 1, 0}
        };

        int[][] regions = findRegions(binaryArray);

        for (int[] row : regions) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
