package WIA2004.Lab_4;

import java.util.Scanner;

public class Lab_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of memory blocks: ");
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

        // Sort blocks (ONLY for display + efficient iteration)
        int[] sortedIdx = sortBySize(blockSize, numBlocks);

        System.out.println();
        System.out.println("=== MEMORY LIST ===");
        printMemoryTable(sortedIdx, blockSize, occupied, allocatedJob, allocatedJobSize);

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

        // ✅ Best-Fit with efficiency improvement
        for (int j = 0; j < numJobs; j++) {
            int bestIdx = -1;
            int bestDiff = Integer.MAX_VALUE;

            // 🔥 CHANGED HERE: using sortedIdx
            for (int i : sortedIdx) {
                if (!occupied[i] && blockSize[i] >= jobSize[j]) {
                    int diff = blockSize[i] - jobSize[j];
                    if (diff < bestDiff) {
                        bestDiff = diff;
                        bestIdx = i;
                    }
                }
            }

            if (bestIdx == -1) {
                jobError[j] = "Job " + (j + 1) + " (" + jobSize[j] + " KB) - no sufficient block available.";
            } else {
                occupied[bestIdx] = true;
                allocatedJob[bestIdx] = j + 1;
                allocatedJobSize[bestIdx] = jobSize[j];
                jobBlock[j] = bestIdx;
                jobError[j] = null;
            }
        }

        boolean anyError = false;
        for (String e : jobError)
            if (e != null) {
                anyError = true;
                break;
            }

        if (anyError) {
            System.out.println();
            System.out.println("=== ALLOCATION ERRORS ===");
            for (String e : jobError)
                if (e != null)
                    System.out.println("  [!] " + e);
        }

        System.out.println();
        System.out.println("=== UPDATED MEMORY LIST ===");
        printMemoryTable(sortedIdx, blockSize, occupied, allocatedJob, allocatedJobSize);

        System.out.println();
        System.out.println("=== ALLOCATION SUMMARY ===");
        printSummary(numBlocks, numJobs, blockSize, jobSize, occupied, jobBlock);

        sc.close();
    }

    static void printMemoryTable(int[] sortedIdx, int[] blockSize, boolean[] occupied, int[] allocatedJob,
            int[] allocatedJobSize) {
        System.out.printf("%-18s %-18s %-12s %-14s %-16s%n",
                "Memory Location", "Block Size (KB)", "Status", "Job No.", "Job Size (KB)");
        System.out.println(repeat("-", 80));

        for (int i : sortedIdx) {
            int loc = i + 1;
            String status = occupied[i] ? "OCCUPIED" : "FREE";
            String jobNo = occupied[i] ? "Job " + allocatedJob[i] : "-";
            String jobSz = occupied[i] ? allocatedJobSize[i] + " KB" : "-";

            System.out.printf("%-18d %-18s %-12s %-14s %-16s%n",
                    loc, blockSize[i] + " KB", status, jobNo, jobSz);
        }
    }

    static void printSummary(int numBlocks, int numJobs, int[] blockSize, int[] jobSize, boolean[] occupied,
            int[] jobBlock) {
        int totalMem = 0;
        for (int b : blockSize)
            totalMem += b;

        int allocatedJobs = 0, usedMem = 0, internalFrag = 0, freeBlocks = 0;

        for (int j = 0; j < numJobs; j++) {
            if (jobBlock[j] != -1) {
                allocatedJobs++;
                usedMem += jobSize[j];
                internalFrag += blockSize[jobBlock[j]] - jobSize[j];
            }
        }

        for (boolean o : occupied)
            if (!o)
                freeBlocks++;

        int freeMem = totalMem - usedMem - internalFrag;
        int failedJobs = numJobs - allocatedJobs;

        System.out.printf("%-35s %s%n", "Total Memory:", totalMem + " KB");
        System.out.printf("%-35s %s%n", "Total Memory Blocks:", numBlocks + " blocks");
        System.out.printf("%-35s %s%n", "Total Jobs Submitted:", numJobs + " jobs");
        System.out.printf("%-35s %s%n", "Jobs Successfully Allocated:", allocatedJobs + " jobs");
        System.out.printf("%-35s %s%n", "Jobs Failed (No Fit):", failedJobs + " jobs");
        System.out.printf("%-35s %s%n", "Memory Used by Jobs:", usedMem + " KB");
        System.out.printf("%-35s %s%n", "Internal Fragmentation:", internalFrag + " KB");
        System.out.printf("%-35s %s%n", "Free Memory Remaining:", freeMem + " KB");
        System.out.printf("%-35s %s%n", "Free Blocks Remaining:", freeBlocks + " blocks");
    }

    static int[] sortBySize(int[] blockSize, int numBlocks) {
        Integer[] idx = new Integer[numBlocks];
        for (int i = 0; i < numBlocks; i++)
            idx[i] = i;

        for (int i = 1; i < numBlocks; i++) {
            int key = idx[i];
            int j = i - 1;
            while (j >= 0 && blockSize[idx[j]] > blockSize[key]) {
                idx[j + 1] = idx[j];
                j--;
            }
            idx[j + 1] = key;
        }

        int[] result = new int[numBlocks];
        for (int i = 0; i < numBlocks; i++)
            result[i] = idx[i];
        return result;
    }

    static String repeat(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(s);
        return sb.toString();
    }

    static int readPositiveInt(Scanner sc) {
        while (true) {
            try {
                int val = Integer.parseInt(sc.nextLine().trim());
                if (val > 0)
                    return val;
                System.out.print("  Value must be greater than 0. Try again: ");
            } catch (NumberFormatException e) {
                System.out.print("  Invalid input. Enter a positive integer: ");
            }
        }
    }
}
