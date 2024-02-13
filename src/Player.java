public class Player {
    //이름과 오답율을 가지고 있는 클래스 만들기
    String name;
    int errorRate; // % 저장

    protected Player(){}

    private Player(String name, int errorRate) {
        this.name = name;
        this.errorRate = errorRate;
    }

    static Player of(String name, int errorRate) {
        return new Player(name, errorRate);
    }

    public boolean correctAnswer() {
        double v = Math.random() * 100;

        return v <= errorRate;
    }
}
