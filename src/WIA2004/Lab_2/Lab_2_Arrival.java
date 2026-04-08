package WIA2004.Lab_2;

import java.util.*;

class Process {
    int pid, arrivalTime, burstTime, waitingTime, turnAroundTime;

    Process(int pid, int at, int bt) {
        this.pid = pid;
        this.arrivalTime = at;
        this.burstTime = bt;
    }
}

public class Lab_2_Arrival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\n\nEnter number of processes: ");
        int n = sc.nextInt();

        Process[] p = new Process[n];

        // Input
        for (int i = 0; i < n; i++) {
            System.out.println("\nProcess P" + (i + 1));
            System.out.print("Arrival Time: ");
            int at = sc.nextInt();
            System.out.print("Burst Time: ");
            int bt = sc.nextInt();

            p[i] = new Process(i + 1, at, bt);
        }

        boolean[] completed = new boolean[n];
        int completedCount = 0;
        int currentTime = 0;

        float totalWT = 0, totalTAT = 0;

        while (completedCount < n) {
            int idx = -1;
            int minBT = Integer.MAX_VALUE;

            // Find shortest job among arrived processes
            for (int i = 0; i < n; i++) {
                if (!completed[i] && p[i].arrivalTime <= currentTime) {
                    if (p[i].burstTime < minBT) {
                        minBT = p[i].burstTime;
                        idx = i;
                    }
                }
            }

            if (idx == -1) {
                currentTime++; // no process arrived yet
            } else {
                p[idx].waitingTime = currentTime - p[idx].arrivalTime;
                currentTime += p[idx].burstTime;
                p[idx].turnAroundTime = p[idx].waitingTime + p[idx].burstTime;

                totalWT += p[idx].waitingTime;
                totalTAT += p[idx].turnAroundTime;

                completed[idx] = true;
                completedCount++;
            }
        }

        // Display results
        System.out.printf("\n%-10s %-15s %-15s %-15s %-15s\n",
                "Process", "Arrival Time", "Burst Time", "Waiting Time", "Turnaround Time");
        System.out.println("========================================================================");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s %-15d %-15d %-15d %-15d\n",
                    "P" + p[i].pid,
                    p[i].arrivalTime,
                    p[i].burstTime,
                    p[i].waitingTime,
                    p[i].turnAroundTime);
        }

        System.out.println("========================================================================");
        System.out.printf("Average Waiting Time: %.2f\n", totalWT / n);
        System.out.printf("Average Turnaround Time: %.2f\n\n", totalTAT / n);

        sc.close();
    }
}
