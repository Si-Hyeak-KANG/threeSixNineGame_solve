/**
 * 1) 게임횟수만큼 순회 (100회)
 * 2) 초기 시작 숫자 : 1
 * 3) 현재 숫자 do369메서드 인자로 사용
 * 4) do369 - 숫자를 문자열로 변경
 * 5) do369 - 문자열에서 3, 6, 9 라는 숫자를 갖는지 체크
 * 6) ㄴ 있으면 clap 반환, 없으면 숫자 문자형태로 반환
 * 7) 현재 숫자를 말할 사용자 선택
 * 8) (현재 숫자-1 % 4) => players 인덱스
 * 9) do369의 결과와 인덱스에 해당하는 players를 sout로 출력
 */
public abstract class ThreeSixNineGame extends Thread {

    Player[] players;
    ClapCounter clapCounter;
    String info;

    ThreeSixNineGame(Player[] players, ClapCounter clapCounter, String info) {
        this.players = players;
        this.clapCounter = clapCounter;
        this.info = info;
    }

    /**
     number 에 3,6,9가 포함되면 "clap", 아니면 입력받은 숫자를 String으로 리턴
     do369(16) -> "clap"
     do369(12) -> "12"
     do369(33) -> "clap"
     */
    public abstract String do369(int number);

    void playGame() {
        int num = 1;
        while(true) {
            int idx = (num-1)% players.length;
            Player player = players[idx];
            String result = do369(num);
            if(player.correctAnswer()) return;
            System.out.println("["+this.info+"] " + player.name+": " + result);
            if(result.contains("clap")) clapCounter.plusCount();
            num++;
        }
    }

    @Override
    public void run() {
        playGame();
    }
}


