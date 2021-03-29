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