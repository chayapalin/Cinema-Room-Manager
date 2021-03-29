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
