package WIA2004.Lab_5;

import java.util.Scanner;

public class Lab_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\n\nEnter total number of memory blocks: ");
        int numBlocks = readPositiveInt(sc);

        int[] blockSize = new int[numBlocks];
        boolean[] occupied = new boolean[numBlocks];
        int[] allocatedJob = new int[numBlocks];
        int[] allocatedJobSize = new int[numBlocks];

        System.out.println();
        for (int i = 0; i < numBlocks; i++) {
            System.out.printf("  Block %d size (KB): ", i + 1);
            blockSize[i] = readPositiveInt(sc);
            occupied[i] = false;
            allocatedJob[i] = -1;
            allocatedJobSize[i] = 0;
        }

        System.out.println();
        System.out.println("=== MEMORY LIST ===");
        printMemoryTable(blockSize, occupied, allocatedJob, allocatedJobSize);

        System.out.println();
        System.out.print("Enter total number of jobs: ");
        int numJobs = readPositiveInt(sc);

        int[] jobSize = new int[numJobs];
        int[] jobBlock = new int[numJobs];
        String[] jobError = new String[numJobs];

        System.out.println();
        for (int j = 0; j < numJobs; j++) {
            System.out.printf("  Job %d size (KB): ", j + 1);
            jobSize[j] = readPositiveInt(sc);
            jobBlock[j] = -1;
        }

        // ✅ First-Fit Algorithm (NO SORTING)
        for (int j = 0; j < numJobs; j++) {
            boolean allocated = false;

            for (int i = 0; i < numBlocks; i++) {
                if (!occupied[i] && blockSize[i] >= jobSize[j]) {
                    occupied[i] = true;
                    allocatedJob[i] = j + 1;
                    allocatedJobSize[i] = jobSize[j];
                    jobBlock[j] = i;
                    jobError[j] = null;
                    allocated = true;
                    break;
                }
            }

            if (!allocated) {
                jobError[j] = "Job " + (j + 1) + " (" + jobSize[j] + " KB) - no sufficient block available.";
            }
        }

        // Print Errors
        boolean anyError = false;
        for (String e : jobError) {
            if (e != null) {
                anyError = true;
                break;
            }
        }

        if (anyError) {
            System.out.println();
            System.out.println("=== ALLOCATION ERRORS ===");
            for (String e : jobError) {
                if (e != null) {
                    System.out.println("  [!] " + e);
                }
            }
        }

        System.out.println();
        System.out.println("=== UPDATED MEMORY LIST ===");
        printMemoryTable(blockSize, occupied, allocatedJob, allocatedJobSize);

        System.out.println();
        System.out.println("=== ALLOCATION SUMMARY ===");
        printSummary(numBlocks, numJobs, blockSize, jobSize, occupied, jobBlock);

        sc.close();
    }

    // ✅ MEMORY TABLE
    static void printMemoryTable(int[] blockSize, boolean[] occupied,
            int[] allocatedJob, int[] allocatedJobSize) {

        System.out.printf("%-18s %-18s %-12s %-14s %-16s%n",
                "Block No.", "Block Size (KB)", "Status", "Job No.", "Job Size (KB)");
        System.out.println(repeat("-", 80));

        for (int i = 0; i < blockSize.length; i++) {
            String status = occupied[i] ? "OCCUPIED" : "FREE";
            String jobNo = occupied[i] ? "Job " + allocatedJob[i] : "-";
            String jobSz = occupied[i] ? allocatedJobSize[i] + " KB" : "-";

            System.out.printf("%-18d %-18s %-12s %-14s %-16s%n",
                    i + 1, blockSize[i] + " KB", status, jobNo, jobSz);
        }
    }

    // ✅ SUMMARY + STATISTICS
    static void printSummary(int numBlocks, int numJobs, int[] blockSize,
            int[] jobSize, boolean[] occupied, int[] jobBlock) {

        System.out.printf("%-10s %-14s %-14s %-18s%n",
                "Job No.", "Job Size", "Block No.", "Fragmentation");
        System.out.println(repeat("-", 60));

        int totalMem = 0;
        int usedMem = 0; // actual used by jobs
        int freeMem = 0;
        int internalFrag = 0;
        int allocatedJobs = 0;
        int freeBlocks = 0;

        // Total memory
        for (int size : blockSize) {
            totalMem += size;
        }

        // Job allocation table
        for (int j = 0; j < numJobs; j++) {
            int jb = jobBlock[j];

            if (jb == -1) {
                System.out.printf("%-10s %-14s %-14s %-18s%n",
                        "Job " + (j + 1), jobSize[j] + " KB",
                        "NOT ALLOCATED", "---");
            } else {
                int frag = blockSize[jb] - jobSize[j];
                internalFrag += frag;
                usedMem += jobSize[j];
                allocatedJobs++;

                String fragStr = (frag == 0) ? "None" : frag + " KB";

                System.out.printf("%-10s %-14s %-14s %-18s%n",
                        "Job " + (j + 1), jobSize[j] + " KB",
                        "Block " + (jb + 1), fragStr);
            }
        }

        // Free memory & blocks
        for (int i = 0; i < numBlocks; i++) {
            if (!occupied[i]) {
                freeMem += blockSize[i];
                freeBlocks++;
            }
        }

        int failedJobs = numJobs - allocatedJobs;

        // ✅ FINAL STATISTICS
        System.out.println();
        System.out.println("=== MEMORY STATISTICS ===");

        System.out.printf("%-35s %s%n", "Total Memory:", totalMem + " KB");
        System.out.printf("%-35s %s%n", "Total Memory Blocks:", numBlocks + " blocks");
        System.out.printf("%-35s %s%n", "Total Jobs Submitted:", numJobs + " jobs");
        System.out.printf("%-35s %s%n", "Jobs Successfully Allocated:", allocatedJobs + " jobs");
        System.out.printf("%-35s %s%n", "Jobs Failed (No Fit):", failedJobs + " jobs");
        System.out.printf("%-35s %s%n", "Memory Used by Jobs:", usedMem + " KB");
        System.out.printf("%-35s %s%n", "Internal Fragmentation:", internalFrag + " KB");
        System.out.printf("%-35s %s%n", "Free Memory Remaining:", freeMem + " KB");
        System.out.printf("%-35s %s%n%n%n", "Free Blocks Remaining:", freeBlocks + " blocks");
    }

    // Utility
    static String repeat(String s, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++)
            sb.append(s);
        return sb.toString();
    }

    static int readPositiveInt(Scanner sc) {
        int value;
        while (true) {
            try {
                value = sc.nextInt();
                if (value > 0)
                    return value;
                System.out.print("  Invalid input! Enter a positive integer: ");
            } catch (Exception e) {
                sc.nextLine();
                System.out.print("  Invalid input! Enter a positive integer: ");
            }
        }
    }
}