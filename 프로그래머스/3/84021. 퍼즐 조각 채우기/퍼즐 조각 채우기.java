// 조각은 한 번에 하나씩 채워 넣습니다.
// 조각을 회전시킬 수 있습니다.
// 조각을 뒤집을 수는 없습니다.
// 게임 보드에 새로 채워 넣은 퍼즐 조각과 인접한 칸이 비어있으면 안 됩니다.
import java.util.*;

class Solution {
    
    static int answer = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] game_board, int[][] table) {    
        for (int i = 0; i < 4; i++) {
            List<Block> blocksOfTable = saveBlocks(table);
            startGame(game_board, table, blocksOfTable);
            rotateTable(table);
        }
        
        return answer;
    }
    
    public static List<Block> saveBlocks(int[][] table) {
        int length = table.length;
        boolean[][] visited = new boolean[length][length];
        List<Block> blocks = new ArrayList<>();

        for(int x=0; x<length; x++) {
            for(int y=0; y<length; y++) {
                if(table[x][y] != 0 && !visited[x][y]) {
                    blocks.add(readBlock(x, y, visited, table, 0));
                }
            }
        }

        return blocks;
    }

    private static Block readBlock(int x, int y, boolean[][] visited, int[][] table, int readBlockValue) {
        Block block = new Block();
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        block.points.add(new Point(x, y));

        while(!queue.isEmpty()) {
            Point curPoint = queue.poll();
            int cx = curPoint.x;
            int cy = curPoint.y;

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(!(nx >=0 && ny >= 0 && nx < table.length && ny < table.length)) {
                    continue;
                }

                if(visited[nx][ny]) {
                    continue;
                }

                if(table[nx][ny] == readBlockValue) {
                    continue;
                }

                queue.offer(new Point(nx, ny));
                visited[nx][ny] = true;
                block.points.add(new Point(nx, ny));
            }
        }

        return block;
    }

    public static void startGame(int[][] game_board, int[][] table, List<Block> blocksOfTable) {
        int length = table.length;
        boolean[][] visitedGameBoard = new boolean[length][length];

        for(int x=0; x<length; x++) {
            for(int y=0; y<length; y++) {
                if(game_board[x][y] == 0 && !visitedGameBoard[x][y]) {
                    Block emptyBlock = readBlock(x, y, visitedGameBoard, game_board, 1);
                    fillInIfFit(emptyBlock, blocksOfTable, game_board, table);
                }
            }
        }
    }

    public static void fillInIfFit(Block emptyBlock, List<Block> blocksOfTable, int[][] game_board, int[][] table) {
        List<Block> blocks = new ArrayList<>(blocksOfTable);

        // 시작점 동일하게 변경
        Point startPoint = emptyBlock.points.get(0);

        for(int blockNum=0; blockNum<blocks.size(); blockNum++) {
            Block block = blocks.get(blockNum);
            int x = startPoint.x - block.points.get(0).x;
            int y = startPoint.y - block.points.get(0).y;
            boolean isFitBlock = true;

            if (block.points.size() != emptyBlock.points.size()) {
                continue;
            }

            for(int i=1; i<block.points.size(); i++) {
                Point point = block.points.get(i);
                Point EmptyBlockPoint = emptyBlock.points.get(i);

                if(point.x + x != EmptyBlockPoint.x || point.y + y != EmptyBlockPoint.y) {
                    isFitBlock = false;
                    break;
                }
            }

            if(isFitBlock) {
                removeBlockFromTable(table, blocksOfTable, blockNum);
                fillBlockFromGameBoard(game_board, emptyBlock);
                break;
            }
        }
    }

    public static void removeBlockFromTable(int[][] table, List<Block> blocksOfTable, int blockNum) {
        Block block = blocksOfTable.get(blockNum);

        for(Point point : block.points) {
            table[point.x][point.y] = 0;
        }

        blocksOfTable.remove(blockNum);
    }

    public static void fillBlockFromGameBoard(int[][] game_board, Block emptyBlock) {
        for(Point point : emptyBlock.points) {
            game_board[point.x][point.y] = 1;
            answer++;
        }
    }

    public static void rotateTable(int[][] table) {
        int length = table.length;
        int[][] copyTable = new int[length][length];

        for (int x = 0; x < length; x++) {
            copyTable[x] = Arrays.copyOf(table[x], table.length);
        }

        for(int x=0; x<length; x++) {
            for(int y=0; y<length; y++) {
                table[y][length - 1 - x] = copyTable[x][y];
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Block {
        List<Point> points = new ArrayList<>();
    }
}