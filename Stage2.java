// Objectives
// In this stage, you need to read two positive integer numbers from the input: the number of rows and the number of seats in each row. The ticket price is determined by the following rules:

// If the total number of seats in the screen room is not more than 60, then the price of each ticket is 10 dollars.
// In a larger room, the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half. Please note that the number of rows can be odd, for example, 9 rows. In this case, the first half is the first 4 rows, and the second half is the rest 5 rows.
// Calculate the profit from the sold tickets depending on the number of seats and print the result as shown in the examples below. After that, your program should stop. Note that in this project, the number of rows and seats won't be greater than 9.

// Examples
// The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

// Example 1
// Enter the number of rows:
// > 4
// Enter the number of seats in each row:
// > 5
// Total income:
// $200

// Example 2
// Enter the number of rows:
// > 8
// Enter the number of seats in each row:
// > 9
// Total income:
// $648

// Example 3
// Enter the number of rows:
// > 9
// Enter the number of seats in each row:
// > 7
// Total income:
// $560

// package cinema;

import java.util.Scanner;

public class Stage2 {

    static Scanner scanner = new Scanner(System.in);

    static int rows;
    static int seats;
    static int price10 = 10;
    static int price8 = 8;
    static int frontHalfRowsPrice;
    static int backHalfRowsPrice;
    static int largeRoomIncome;

    public static void calculateIncome(int rows, int seats) {
        System.out.println("Total income:");
        if (rows * seats <= 60) {
            int smallRoomIncome = rows * seats * price10;
            System.out.println("$" + smallRoomIncome);
        } else {
            if (rows % 2 == 0) {
                frontHalfRowsPrice = (rows / 2) * seats * price10;
                backHalfRowsPrice = (rows / 2) * seats * price8;
                largeRoomIncome = frontHalfRowsPrice + backHalfRowsPrice;
                System.out.println("$" + largeRoomIncome);
            } else {
                frontHalfRowsPrice = (rows / 2) * seats * price10;
                backHalfRowsPrice = (rows - (rows / 2)) * seats * price8;
                largeRoomIncome = frontHalfRowsPrice + backHalfRowsPrice;
                System.out.println("$" + largeRoomIncome);
            }
        }
    }

    public static int askSeats() {
        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();
        return seats;
    }

    public static int askRows() {
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        return rows;
    }

    public static void printSeats() {
        System.out.println("Cinema:");
        System.out.println("  1 2 3 4 5 6 7 8");
        for (int i = 1; i < 8; i++) {
            System.out.println(i + " S S S S S S S S");
        }
    }
    public static void main(String[] args) {
        //printSeats();
        askRows();
        askSeats();
        calculateIncome(rows, seats);
    }
}
