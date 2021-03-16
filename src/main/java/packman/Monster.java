package packman;

import java.util.Random;

public class Monster {
    private int ver;
    private int hor;

    private int mapX;
    private int mapY;

    private Direction dir = Direction.NONE;;

    public Monster(int ver, int hor, int x, int y) {
        this.ver = ver;
        this.hor = hor;
        this.mapX = x;
        this.mapY = y;
    }
    public int getMapX() {
        return mapX;
    }
    public int getMapY() {
        return mapY;
    }

    public void move(Integer[][] field) {
        int left = field[ver][hor - 1];
        int right = field[ver][hor + 1];
        int up = field[ver - 1][hor];
        int down = field[ver + 1][hor];

        int free = 0;
        if (left != 1) free++;
        if (right != 1) free++;
        if (down != 1) free++;
        if (up != 1) free++;

        if (dir == Direction.NONE
                || (dir == Direction.LEFT && (left == 1 || free > 2))
                || (dir == Direction.RIGHT && (right == 1 || free > 2))
                || (dir == Direction.UP && (up == 1 || free > 2))
                || (dir == Direction.DOWN && (down == 1 || free > 2))) {
                boolean[] ways = new boolean[4];
                ways[0] = left != 1;
                ways[1] = right != 1;
                ways[2] = up != 1;
                ways[3] = down != 1;

                Random rand = new Random();

                int index;

                do {
                    index = rand.nextInt(4);
                    if (index == 0) {
                        dir = Direction.LEFT;
                    } else if (index == 1) {
                        dir = Direction.RIGHT;
                    } else if (index == 2) {
                        dir = Direction.UP;
                    } else {
                        dir = Direction.DOWN;
                    }
                } while (!ways[index]);

        }

        int speed = 50;
        switch(dir) {
            case UP:
                ver--;
                mapY-= speed;
                break;
            case DOWN:
                ver++;
                mapY+= speed;
                break;
            case LEFT:
                hor--;
                mapX-= speed;
                break;
            case RIGHT:
                hor++;
                mapX+= speed;
                break;
            default:
                break;
        }
    }

    public boolean eat(Player player) {
        return hor == player.getHor() && ver == player.getVer();
    }
}
