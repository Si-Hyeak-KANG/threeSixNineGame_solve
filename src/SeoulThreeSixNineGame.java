public class SeoulThreeSixNineGame extends ThreeSixNineGame {

    public SeoulThreeSixNineGame(Player[] players, ClapCounter clapCounter) {
        super(players,clapCounter,"seoul");
    }

    /**
     number 에 3,6,9가 포함되면 "clap", 아니면 입력받은 숫자를 String으로 리턴
     do369(16) -> "clap"
     do369(12) -> "12"
     do369(33) -> "clap"
     */
    public String do369(int number) {
        String toString = String.valueOf(number);
        if(toString.matches(".*[369].*")) return "clap";
        else return toString;
    }
}
