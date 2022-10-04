public class Player {
    // Ändra till private.
    String name;
    char symbol;
    int playerNum;
    int winCount;



    public Player(String name, char symbol, int playerNum, int winCount) {
        this.name = name;
        this.symbol = symbol;
        this.playerNum = playerNum;
        this.winCount = 0;
    }
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
    public void setWinCount(int winCount) {this.winCount = winCount;}

    void addWin() {
        this.winCount = winCount + 1;
    }
}

