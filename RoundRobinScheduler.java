public class RoundRobinScheduler {
    static class Process {
        String name;
        int burstTime;
        int remainingTime;
        
        public Process(String name, int burstTime) {
            this.name = name;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
        }
    }
    
    public static void schedule(Process[] processes, int quantum) {
        Queue<Process> queue = new ArrayQueue<>();
        
        // إضافة جميع العمليات للطابور
        for (Process p : processes) {
            queue.enqueue(p);
        }
        
        int currentTime = 0;
        System.out.println("Execution Order:");
        
        while (!queue.isEmpty()) {
            Process current = queue.dequeue();
            
            // تنفيذ العملية لمدة quantum أو حتى تنتهي
            int executeTime = Math.min(quantum, current.remainingTime);
            current.remainingTime -= executeTime;
            currentTime += executeTime;
            
            System.out.printf("Time %d: Process %s executed for %d units\n",
                            currentTime, current.name, executeTime);
            
            // إذا لم تنته العملية، أعد إضافتها للطابور
            if (current.remainingTime > 0) {
                queue.enqueue(current);
            }
        }
    }
    
    public static void main(String[] args) {
        Process[] processes = {
            new Process("P1", 10),
            new Process("P2", 5),
            new Process("P3", 8)
        };
        int quantum = 2;
        schedule(processes, quantum);
    }
} 