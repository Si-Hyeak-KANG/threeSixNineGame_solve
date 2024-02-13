public class BusanThreeSixNineGame extends ThreeSixNineGame {

    public BusanThreeSixNineGame(Player[] players, ClapCounter clapCounter) {
        super(players, clapCounter, "busan");
    }

    @Override
    public String do369(int number) {
        String toString = String.valueOf(number);
        StringBuilder sb = new StringBuilder();
        char[] clapNumbers = {'3','6','9'};
        for(char ch : toString.toCharArray()) {
            for(char clapNum : clapNumbers) {
                if(clapNum==ch) {
                    sb.append("clap");
                    break;
                }
            }
        }
        if(toString.matches(".*[369].*")) return sb.toString();
        else return toString;
    }
}
