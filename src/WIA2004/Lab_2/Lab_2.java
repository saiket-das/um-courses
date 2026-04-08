package WIA2004.Lab_2;

import java.util.*;

public class Lab_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of processes/jobs
        System.out.print("\nEnter the number of processes: ");
        int n = sc.nextInt();

        int[] process = new int[n];
        int[] burstTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnAroundTime = new int[n];

        // Input burst times
        System.out.printf("Enter Burst Time for %d processes:\n", n);
        for (int i = 0; i < n; i++) {
            process[i] = i + 1;
            System.out.print("P" + process[i] + ": ");
            burstTime[i] = sc.nextInt();
        }

        // Sort processes based on burst time (SJF)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (burstTime[i] > burstTime[j]) {
                    // swap burst time
                    int temp = burstTime[i];
                    burstTime[i] = burstTime[j];
                    burstTime[j] = temp;

                    // swap process id
                    temp = process[i];
                    process[i] = process[j];
                    process[j] = temp;
                }
            }
        }

        // Calculate waiting time
        waitingTime[0] = 0;
        for (int i = 1; i < n; i++) {
            waitingTime[i] = waitingTime[i - 1] + burstTime[i - 1];
        }

        // Calculate turnaround time
        for (int i = 0; i < n; i++) {
            turnAroundTime[i] = waitingTime[i] + burstTime[i];
        }

        // Display results (formatted output)
        System.out.printf("\n%-10s %-15s %-15s %-15s\n",
                "Process", "Burst Time", "Waiting Time", "Turnaround Time");
        System.out.println("=============================================================");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s %-15s %-15s %-15s\n",
                    "P" + process[i],
                    burstTime[i],
                    waitingTime[i],
                    turnAroundTime[i]);
        }

        // Average calculations
        float totalWT = 0, totalTAT = 0;
        for (int i = 0; i < n; i++) {
            totalWT += waitingTime[i];
            totalTAT += turnAroundTime[i];
        }

        System.out.println("=============================================================\n");
        System.out.printf("Average Waiting Time: %.2f\n", totalWT / n);
        System.out.printf("Average Turnaround Time: %.2f\n\n", totalTAT / n);

        sc.close();
    }
}