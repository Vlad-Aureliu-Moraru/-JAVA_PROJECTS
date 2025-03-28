package gameRelated;

public class GeneratedMap {
    private int height;
    private int width;
    private int[][] map;

    public GeneratedMap(int height, int width) {
        this.height = height;
        this.width = width;
        this.map = new int[height][width];
        generateMap();
    }

    public GeneratedMap() {
        this(16, 32);
    }

    private void generateMap() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x == 0 || y == 0 || x == width - 1 || y == height - 1) {
                    map[y][x] = 1; // Walls
                } else {
                    map[y][x] = 0; // Floor
                }
                if (x == width - 1 && y == height / 2) {
                    map[y][x] = 2;// Door
                   map[y-1][x] = 2;
                }
                if (x == width/5 && y == (height / 2)-1) {
                    map[y][x] = 3;// PLAYER
                }

            }
        }
    }

    public int[][] getMap() {
        return map;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                sb.append(map[y][x]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
}
