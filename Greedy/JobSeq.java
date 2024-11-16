import java.util.Arrays;
import java.util.Comparator;

public class JobSeq {

    public JobSeq() {
       
    }

  
    public int getTotalProfit(JOB[] jobs) {
        Arrays.sort(jobs, new Comparator<JOB>() {
            public int compare(JOB firstJob, JOB secondJob) {
                return secondJob.profit - firstJob.profit; 
            }
        });
        int totalProfit = 0;
        int count = 0;
        int maxDeadline = -1;

        for (JOB job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        int[] hashMaxDeadline = new int[maxDeadline + 1];
        Arrays.fill(hashMaxDeadline, -1);

        for (JOB job : jobs) {
            for (int index = job.deadline - 1; index >= 0; index--) {
                if (hashMaxDeadline[index] == -1) {
                    count++;
                    hashMaxDeadline[index] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
       System.out.println(count);
        return totalProfit; 
    }

    public static void main(String[] args) {
        JOB[] jobs = {
            new JOB(1, 100, 2),
            new JOB(2, 19, 1),
            new JOB(3, 27, 2),
            new JOB(4, 25, 1),
            new JOB(5, 15, 3)
        };

        JobSeq js = new JobSeq();
        int totalProfit = js.getTotalProfit(jobs);
        System.out.println("Total Profit: " + totalProfit);
    }
}

class JOB {
    public int id;
    public int profit;
    public int deadline;

    public JOB(int id, int profit, int deadline) {
        this.id = id;
        this.profit = profit;
        this.deadline = deadline;
    }
}
