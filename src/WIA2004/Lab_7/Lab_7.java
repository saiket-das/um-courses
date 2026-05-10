package WIA2004.Lab_7;

import java.util.Scanner;

public class Lab_7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter number of frames: ");
        int frames = sc.nextInt();

        System.out.print("Enter number of pages: ");
        int pages = sc.nextInt();

        int[] frame = new int[frames];
        int[] reference = new int[pages];

        System.out.println("Enter page reference string:");
        for (int i = 0; i < pages; i++) {
            reference[i] = sc.nextInt();
        }

        // Initialize frames
        for (int i = 0; i < frames; i++) {
            frame[i] = -1;
        }

        int pageFaults = 0;
        int pageHits = 0;
        int index = 0;

        // Table Header
        System.out.println("\nStep\tPage\tFrames\t\tStatus");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < pages; i++) {

            boolean found = false;

            // Check for hit
            for (int j = 0; j < frames; j++) {
                if (frame[j] == reference[i]) {
                    found = true;
                    pageHits++;
                    break;
                }
            }

            String status;

            // If not found → Page Fault
            if (!found) {
                frame[index] = reference[i];
                index = (index + 1) % frames;
                pageFaults++;
                status = "Fault";
            } else {
                status = "Hit";
            }

            // Print row
            System.out.print((i + 1) + "\t" + reference[i] + "\t");

            for (int j = 0; j < frames; j++) {
                if (frame[j] == -1) {
                    System.out.print("_ ");
                } else {
                    System.out.print(frame[j] + " ");
                }
            }

            System.out.println("\t\t" + status);
        }

        System.out.println("--------------------------------------------------");
        System.out.println("\nTotal Page Faults = " + pageFaults);
        System.out.println("Total Page Hits   = " + pageHits + "\n");

        sc.close();
    }
}