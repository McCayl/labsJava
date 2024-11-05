package dice;

public class Player implements IPlayer{
    private String name;
    private int wins;

    public Player(String name) {
        this.name = name;
        this.wins = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getWins() {
        return wins;
    }

    @Override
    public void addWin() {
        this.wins++;
    }
}
