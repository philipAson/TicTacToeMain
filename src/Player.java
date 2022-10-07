public class Player {
    // Ändra till private.
    String name;
    char symbol;
    int playerNum;
    int winCount;
    // Constructor
    public Player(String name, char symbol, int playerNum) {
        this.name = name;
        this.symbol = symbol;
        this.playerNum = playerNum;
        this.winCount = 0;
    }
    // setters N getters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public char getSymbol() {return symbol;}
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public int getPlayerNum() {return playerNum;}
    public void setPlayerNum(int playerNum) {this.playerNum = playerNum;}
    public int getWinCount() {return winCount;}

    // method that adds 1 to players winCount each time its called
    void addWin() {
        this.winCount = winCount + 1;
    }
}
