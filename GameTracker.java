import java.util.*;

public class GameTracker {
    private final int n;  // عدد اللاعبين
    private boolean[][] meetings;  // مصفوفة لتتبع المقابلات
    private int[] meetingCount;  // عداد المقابلات لكل لاعب
    private Set<Integer> winners;  // مجموعة الفائزين
    
    public GameTracker(int numberOfPlayers) {
        this.n = numberOfPlayers;
        this.meetings = new boolean[n][n];
        this.meetingCount = new int[n];
        this.winners = new HashSet<>();
    }
    
    public void meet(int i, int j) {
        if (i == j || i < 0 || j < 0 || i >= n || j >= n) {
            throw new IllegalArgumentException("Invalid player indices");
        }
        
        if (!meetings[i][j]) {  // تحقق من عدم وجود مقابلة سابقة
            meetings[i][j] = meetings[j][i] = true;
            meetingCount[i]++;
            meetingCount[j]++;
            
            // التحقق من الفوز
            checkWinner(i);
            checkWinner(j);
        }
    }
    
    private void checkWinner(int player) {
        if (meetingCount[player] == n - 1 && !winners.contains(player)) {
            winners.add(player);
            System.out.println("Player " + player + " has won!");
        }
    }
    
    public Set<Integer> getWinners() {
        return new HashSet<>(winners);
    }
    
    public int getMeetingCount(int player) {
        return meetingCount[player];
    }
} 