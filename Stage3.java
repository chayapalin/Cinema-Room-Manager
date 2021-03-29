// Objectives
// Read two positive integer numbers that represent the number of rows and seats in each row and print the seating arrangement like in the first stage. Then, read two integer numbers from the input: a row number and a seat number in that row. These numbers represent the coordinates of the seat according to which the program should print the ticket price. The ticket price is determined by the same rules as the previous stage:

// If the total number of seats in the screen room is not more than 60, then the price of each ticket is 10 dollars.
// In a larger room, the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half. Please note that the number of rows can be odd, for example, 9 rows. In this case, the first half is the first 4 rows, and the second half is the rest 5 rows.
// After that, the program should print out all the seats in the screen room as shown in the example and mark the chosen seat by the B symbol. Finally, it should print the ticket price and stop. Note that in this project, the number of rows and seats won't be greater than 9.

// Examples
// The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

// Example 1
// Enter the number of rows:
// > 7
// Enter the number of seats in each row:
// > 8

// Cinema:
//   1 2 3 4 5 6 7 8
// 1 S S S S S S S S
// 2 S S S S S S S S
// 3 S S S S S S S S
// 4 S S S S S S S S
// 5 S S S S S S S S
// 6 S S S S S S S S
// 7 S S S S S S S S

// Enter a row number:
// > 3
// Enter a seat number in that row:
// > 6

// Ticket price: $10

// Cinema:
//   1 2 3 4 5 6 7 8
// 1 S S S S S S S S
// 2 S S S S S S S S
// 3 S S S S S B S S
// 4 S S S S S S S S
// 5 S S S S S S S S
// 6 S S S S S S S S
// 7 S S S S S S S S

// Example 2
// Enter the number of rows:
// > 8
// Enter the number of seats in each row:
// > 9

// Cinema:
//   1 2 3 4 5 6 7 8 9
// 1 S S S S S S S S S
// 2 S S S S S S S S S
// 3 S S S S S S S S S
// 4 S S S S S S S S S
// 5 S S S S S S S S S
// 6 S S S S S S S S S
// 7 S S S S S S S S S
// 8 S S S S S S S S S

// Enter a row number:
// > 6
// Enter a seat number in that row:
// > 5

// Ticket price: $8

// Cinema:
//   1 2 3 4 5 6 7 8 9
// 1 S S S S S S S S S
// 2 S S S S S S S S S
// 3 S S S S S S S S S
// 4 S S S S S S S S S
// 5 S S S S S S S S S
// 6 S S S S B S S S S
// 7 S S S S S S S S S
// 8 S S S S S S S S S


// package cinema;

import java.util.Scanner;

public class Stage3 {

    static Scanner scanner = new Scanner(System.in);

    static int rows, chosenRow;
    static int seats, chosenSeat;
    static String[][] seatPlan;
    static int price10 = 10;
    static int price8 = 8;

    public static void printChosenSeat(int chosenRow, int chosenSeat) {
        System.out.println("Cinema:");

        int rowCounter = 1;
        int colCounter = 1;

        seatPlan = new String[rows + 1][seats + 1];
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                if (i == 0 && j == 0) {
                    seatPlan[i][j] = "  ";
                    System.out.print(seatPlan[i][j]);
                } else if (i == 0) {
                    seatPlan[i][j] = colCounter + " ";
                    System.out.print(seatPlan[i][j]);
                    colCounter++;
                } else if (j == 0) {
                    seatPlan[i][j] = rowCounter + " ";
                    System.out.print(seatPlan[i][j]);
                    rowCounter++;
                } else if (i == chosenRow && j == chosenSeat) {
                    seatPlan[chosenRow][chosenSeat] = "B";
                    System.out.print(seatPlan[chosenRow][chosenSeat] + " ");
                } else {
                    seatPlan[i][j] = "S";
                    System.out.print(seatPlan[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void calculatePrice(int rows, int seats, int chosenRow, int chosenSeat) {
        int ticketPrice;
        
        if (rows * seats <= 60) {
            ticketPrice = price10;
        } else if (chosenRow <= rows / 2 ) {
            ticketPrice = price10;
        } else {
            ticketPrice = price8;
        }

        System.out.println("Ticket price: $" + ticketPrice);
        System.out.println();
    }

    public static void calculateIncome(int rows, int seats) {
        int frontHalfRowsPrice;
        int backHalfRowsPrice;
        int largeRoomIncome;

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

    public static int askReservedSeats() {
        System.out.println("Enter a seat number in that row:");
        chosenSeat = scanner.nextInt();
        System.out.println();
        return chosenSeat;
    }

    public static int askReservedRows() {
        System.out.println("Enter a row number:");
        chosenRow = scanner.nextInt();
        return chosenRow;
    }

    public static void printSeatPlan(int rows, int seats) {
        System.out.println("Cinema:");

        int rowCounter = 1;
        int colCounter = 1;

        seatPlan = new String[rows + 1][seats + 1];
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                if (i == 0 && j == 0) {
                    seatPlan[i][j] = "  ";
                    System.out.print(seatPlan[i][j]);
                } else if (i == 0) {
                    seatPlan[i][j] = colCounter + " ";
                    System.out.print(seatPlan[i][j]);
                    colCounter++;
                } else if (j == 0) {
                    seatPlan[i][j] = rowCounter + " ";
                    System.out.print(seatPlan[i][j]);
                    rowCounter++;
                } else {
                    seatPlan[i][j] = "S";
                    System.out.print(seatPlan[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int askSeats() {
        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();
        System.out.println();
        return seats;
    }

    public static int askRows() {
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        return rows;
    }

    public static void main(String[] args) {   
        askRows();
        askSeats();
        printSeatPlan(rows, seats);
        askReservedRows();
        askReservedSeats();
        //calculateIncome(rows, seats);
        calculatePrice(rows, seats, chosenRow, chosenSeat);
        printChosenSeat(chosenRow, chosenSeat);
    }
}
