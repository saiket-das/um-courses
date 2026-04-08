package WIA2004.Lab_3;

import java.util.Scanner;

public class Lab_3 {
    public static void main(String[] args) {
        int[] disk = new int[50];

        for (int i = 0; i < disk.length; i++) {
            disk[i] = 0; // set all index to 0, not occupied
        }

        System.out.println("Sequential File Allocation:\n");
        recurse(disk);
    }

    public static void recurse(int disk[]) {

        Scanner sc = new Scanner(System.in);

        int flag = 0, startBlock, length, j, k, ch;
        System.out.println("Enter the starting block:");
        startBlock = sc.nextInt();

        System.out.println("Enter the length of the files:");
        length = sc.nextInt();

        if ((startBlock + length) >= disk.length) {
            System.out.println("The file is not allocated in the disk\n");
        }

        for (j = startBlock; j < (startBlock + length); j++) {
            if (disk[j] == 0) {
                flag++; // make sure all is 0
            }
        }

        System.out.println();
        if (length == flag) {
            for (k = startBlock; k < (startBlock + length); k++) {
                if (disk[k] == 0) {
                    disk[k] = 1;
                    System.out.print(k);
                    if (k < (startBlock + length) - 1) {
                        System.out.print(" | ");
                    }
                }
            }

            if (k != (startBlock + length - 1)) {
                System.out.println("\n\nThe file is allocated to the disk\n");
            }
        }

        else {
            System.out.println("The file is not allocated in the disk\n");
        }

        System.out.println("Do you want to enter more files?\n");
        System.out.println("Enter 1 for YES, 0 for NO: ");

        ch = sc.nextInt();
        if (ch == 1) {
            recurse(disk);
        } else {
            sc.close();
            return;
        }

        sc.close();

    }

}
