public class Scoreboard {
    private int numEntries = 0;
    private GameEntry[] board;
    
    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }
    
    public void add(GameEntry e) {
        if (numEntries < board.length) {
            board[numEntries] = e;
            numEntries++;
        }
    }
    
    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= numEntries)
            throw new IndexOutOfBoundsException("Invalid index: " + i);
            
        GameEntry temp = board[i];
        board[i] = board[numEntries - 1];
        board[numEntries - 1] = null;
        numEntries--;
        return temp;
    }
}

class GameEntry {
    private String name;
    private int score;
    
    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public String getName() { return name; }
    public int getScore() { return score; }
} 