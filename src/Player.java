//이름과 오답율을 가지고 있는 클래스 만들기
public class Player {
    String name;
    double errorRate; // % 저장

    protected Player(){}

    private Player(String name, double errorRate) {
        this.name = name;
        this.errorRate = errorRate;
    }

    static Player of(String name, double errorRate) {
        return new Player(name, errorRate);
    }

    public boolean correctAnswer() {
        double randomValue = Math.random() * 100; 
        return randomValue <= errorRate;
    }
}
