package WIA2004.Lab_1;

import java.util.Scanner;

public class Lab_1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Read the number of processes/jobs
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        int[] arrivalTime = { 0, 0, 0 }; // All processes arrive at the same time
        int[] burstTime = new int[n];
        int[] completionTime = new int[n];
        int[] turnAroundTime = new int[n];
        int[] waitingTime = new int[n];

        // Read CPU Burst Times (for each processes)
        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time for Process " + (i + 1) + ": ");
            burstTime[i] = scanner.nextInt();
        }

        // Calculate the Completion Time
        completionTime[0] = burstTime[0]; // CT P1 = BT P1

        for (int i = 1; i < n; i++) {
            // Completion Time = Completion Time of previous process + Burst Time
            completionTime[i] = completionTime[i - 1] + burstTime[i];
        }

        for (int i = 1; i < n; i++) {
            // Completion Time = Completion Time of previous process + Burst Time
            System.out.printf("%-10s ", completionTime[i]);
        }

        // Calculate Turnaround Time
        for (int i = 0; i < n; i++) {
            // Turnaround Time = Completion Time - Arrival Time
            turnAroundTime[i] = completionTime[i] - arrivalTime[i];
        }

        // Calculate Waiting Time
        waitingTime[0] = 0; // Waiting Time for first process is 0

        for (int i = 0; i < n; i++) {
            // Waiting time = Turnaround Time - Burst Time
            waitingTime[i] = turnAroundTime[i] - burstTime[i];
        }

        // Display results (Process, Burst Time, Waiting Time, Turnaround Time)
        System.out.printf("\n%-10s %-15s %-15s %-15s\n", "Process", "Burst Time", "Waiting Time", "Turnaround Time");
        System.out.println("=============================================================");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s %-15s %-15s %-15s\n", (i + 1), burstTime[i], waitingTime[i], turnAroundTime[i]);
        }

        scanner.close();
    }
}