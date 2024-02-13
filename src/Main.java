import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) {
        Player[] players = new Player[]{
                Player.of("광수", 3),
                Player.of("재석", 5),
                Player.of("석진", 5),
                Player.of("하하", 1)
        };
        ClapCounter clapCounter = new ClapCounter();

        ThreeSixNineGame t1 = new SeoulThreeSixNineGame(players, clapCounter);
        ThreeSixNineGame t2 = new BusanThreeSixNineGame(players, clapCounter);
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
}
