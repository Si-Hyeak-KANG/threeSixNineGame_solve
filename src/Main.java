import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) {
        Player[] players = new Player[]{
                Player.of("강시혁", 3),
                Player.of("이수정", 5),
                Player.of("땡이", 5),
                Player.of("스프링", 1)
        };
        ClapCounter clapCounter = new ClapCounter();

        Thread1 t1 = new Thread1(players,clapCounter,new SeoulThreeSixNineGame());
        Thread1 t2 = new Thread1(players,clapCounter,new BusanThreeSixNineGame());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            clapCounter.printClapCount();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Thread1 extends Thread {

        Player[] players;
        ClapCounter clapCounter;
        ThreeSixNineGame threeSixNineGame;

        public Thread1(Player[] players, ClapCounter clapCounter, ThreeSixNineGame threeSixNineGame) {
            this.players = players;
            this.clapCounter = clapCounter;
            this.threeSixNineGame = threeSixNineGame;
        }

        @Override
        public void run() {
            threeSixNineGame.playGame(players, clapCounter);
        }
    }

    static class Thread2 extends Thread {

        Player[] players;
        ClapCounter clapCounter;
        ThreeSixNineGame threeSixNineGame;

        public Thread2(Player[] players, ClapCounter clapCounter, ThreeSixNineGame threeSixNineGame) {
            this.players = players;
            this.clapCounter = clapCounter;
            this.threeSixNineGame = threeSixNineGame;
        }

        @Override
        public void run() {
            threeSixNineGame.playGame(players, clapCounter);
        }
    }
}
