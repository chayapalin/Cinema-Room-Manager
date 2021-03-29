// Objectives
// At the start, your program should read two positive integer numbers that represent the number of rows and seats in each row. Then, it should print a menu with the following three items:

// Show the seats should print the current seating arrangement. The empty seats should be marked with an S symbol, and taken seats are marked with a B symbol.
// Buy a ticket should read the seat coordinates from the input and print the ticket price like in the previous stage. After that, the chosen seat should be marked with a B when the item Show the seats is called.
// Exit should stop the program.

// Example
// The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

// Enter the number of rows:
// > 7
// Enter the number of seats in each row:
// > 7

// 1. Show the seats
// 2. Buy a ticket
// 0. Exit
// > 1

// Cinema:
//   1 2 3 4 5 6 7
// 1 S S S S S S S
// 2 S S S S S S S
// 3 S S S S S S S
// 4 S S S S S S S
// 5 S S S S S S S
// 6 S S S S S S S
// 7 S S S S S S S

// 1. Show the seats
// 2. Buy a ticket
// 0. Exit
// > 2

// Enter a row number:
// > 4
// Enter a seat number in that row:
// > 5
// Ticket price: $10

// 1. Show the seats
// 2. Buy a ticket
// 0. Exit
// > 1

// Cinema:
//   1 2 3 4 5 6 7
// 1 S S S S S S S
// 2 S S S S S S S
// 3 S S S S S S S
// 4 S S S S B S S
// 5 S S S S S S S
// 6 S S S S S S S
// 7 S S S S S S S

// 1. Show the seats
// 2. Buy a ticket
// 0. Exit
// > 2

// Enter a row number:
// > 6
// Enter a seat number in that row:
// > 6
// Ticket price: $10

// 1. Show the seats
// 2. Buy a ticket
// 0. Exit
// > 1

// Cinema:
//   1 2 3 4 5 6 7
// 1 S S S S S S S
// 2 S S S S S S S
// 3 S S S S S S S
// 4 S S S S B S S
// 5 S S S S S S S
// 6 S S S S S B S
// 7 S S S S S S S

// 1. Show the seats
// 2. Buy a ticket
// 0. Exit
// > 0

// package cinema;

import java.util.Scanner;

public class Stage4 {

    static Scanner scanner = new Scanner(System.in);
    static int rows, chosenRow;
    static int seats, chosenSeat;

    public static void printSeatPlan(String[][] seatPlan, int rows, int seats,int chosenRow, int chosenSeat) {
        System.out.println("Cinema:");
        
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                System.out.print(seatPlan[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void calculatePrice(int rows, int seats, int chosenRow, int chosenSeat) {
        int ticketPrice;
        int price10 = 10;
        int price8 = 8;
        
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

    public static int askReservedSeats() {
        System.out.println("Enter a seat number in that row:");
        chosenSeat = scanner.nextInt();
        return chosenSeat;
    }

    public static int askReservedRows() {
        System.out.println("Enter a row number:");
        chosenRow = scanner.nextInt();
        return chosenRow;
    }

    public static void printMenu(String[][] seatPlan) {
        boolean stopProgram = false;
        
        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");
            int chooseMenu = scanner.nextInt();
            System.out.println();

            switch (chooseMenu) {
                case 1:
                    printSeatPlan(seatPlan, rows, seats, chosenRow, chosenSeat);
                    break;
                case 2:
                    askReservedRows();
                    askReservedSeats();
                    seatPlan[chosenRow][chosenSeat] = "B";
                    calculatePrice(rows, seats, chosenRow, chosenSeat);
                    break;
                case 0:
                    stopProgram = true;
                    break;
                default:
                    break;
            }
        } while (!stopProgram);
    }

    public static String[][] createSeatPlan(String[][] seatPlan, int rows, int seats) {
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                if (i == 0 && j == 0) {
                    seatPlan[i][j] = " ";
                } else if (i == 0) {
                    seatPlan[i][j] = String.valueOf(j);
                } else if (j == 0) {
                    seatPlan[i][j] = String.valueOf(i);
                } else {
                    seatPlan[i][j] = "S";
                }
            }
        }
        return seatPlan;
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
        String[][] seatPlan = new String[rows + 1][seats + 1];
        createSeatPlan(seatPlan, rows, seats);
        printMenu(seatPlan);
    }
}
