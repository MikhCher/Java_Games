package drago;

import java.util.Random;

public class Element {
    private Random rand = new Random();

    public class Cloud {
        private int posY = 300 - rand.nextInt(5) * 50;
        private int posX;

        public Cloud(int x) {
            posX = x;
        }

        public Cloud() {
            posX = 1000;
        }

        public int getPosY() {
            return posY;
        }

        public int getPosX() {
            return posX -= 5;
        }
    }

    public class Cactus {
        private int count = rand.nextInt(3);
        private int height = 125 - 25 * count;
        private int width = 50 + 30 * count;
        private int posX;

        public Cactus() {
            posX = 1000;
        }

        public Cactus(int posX) {
            this.posX = posX;
        }

        public int getCount() {
            return count;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        public int getPosX() {
            return posX -= 30;
        }

        public int getPosX(int mod) {
            return posX;
        }
    }
}
