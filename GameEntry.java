public class GameEntry {
    private int score;
    
    public GameEntry(int score) {
        this.score = score;
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public static void main(String[] args) {
        // Create array A
        GameEntry[] A = new GameEntry[5];
        for(int i = 0; i < 5; i++) {
            A[i] = new GameEntry(i * 100);
        }
        
        // Clone array A to B
        GameEntry[] B = A.clone();
        
        // Change A[4].score
        A[4].setScore(550);
        
        // Print both scores to demonstrate they reference the same object
        System.out.println("A[4] score: " + A[4].getScore());
        System.out.println("B[4] score: " + B[4].getScore());
    }
} 