// Objectives
// Now your menu should look like this:

// 1. Show the seats
// 2. Buy a ticket
// 3. Statistics
// 0. Exit

// When the item Statistics is chosen, your program should print the following information:

// The number of purchased tickets;
// The number of purchased tickets represented as a percentage. Percentages should be rounded to 2 decimal places;
// Current income;
// The total income that shows how much money the theatre will get if all the tickets are sold.

// The rest of the menu items should work the same way as before, except the item Buy a ticket shouldn't allow a user to buy a ticket that has already been purchased.
// If a user chooses an already taken seat, print That ticket has already been purchased! and ask them to enter different seat coordinates until they pick an available seat. Of course, you shouldn't allow coordinates that are out of bounds. If this happens, print Wrong input! and ask to enter different seat coordinates until the user picks an available seat.

// Examples
// The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

// Enter the number of rows:
// > 6
// Enter the number of seats in each row:
// > 6

// 1. Show the seats
// 2. Buy a ticket
// 3. Statistics
// 0. Exit
// > 3

// Number of purchased tickets: 0
// Percentage: 0.00%
// Current income: $0
// Total income: $360

// 1. Show the seats
// 2. Buy a ticket
// 3. Statistics
// 0. Exit
// > 2

// Enter a row number:
// > 1
// Enter a seat number in that row:
// > 1

// Ticket price: $10

// 1. Show the seats
// 2. Buy a ticket
// 3. Statistics
// 0. Exit
// > 3

// Number of purchased tickets: 1
// Percentage: 2.78%
// Current income: $10
// Total income: $360

// 1. Show the seats
// 2. Buy a ticket
// 3. Statistics
// 0. Exit
// > 2

// Enter a row number:
// > 1
// Enter a seat number in that row:
// > 1

// That ticket has already been purchased!

// Enter a row number:
// > 10
// Enter a seat number in that row:
// > 20

// Wrong input!

// Enter a row number:
// > 4
// Enter a seat number in that row:
// > 4

// Ticket price: $10

// 1. Show the seats
// 2. Buy a ticket
// 3. Statistics
// 0. Exit
// > 1

// Cinema:
//   1 2 3 4 5 6
// 1 B S S S S S
// 2 S S S S S S
// 3 S S S S S S
// 4 S S S B S S
// 5 S S S S S S
// 6 S S S S S S

// 1. Show the seats
// 2. Buy a ticket
// 3. Statistics
// 0. Exit
// > 3

// Number of purchased tickets: 2
// Percentage: 5.56%
// Current income: $20
// Total income: $360

// 1. Show the seats
// 2. Buy a ticket
// 3. Statistics
// 0. Exit
// > 0

// package cinema;

import java.util.Scanner;

public class Stage5 {

    static Scanner scanner = new Scanner(System.in);
    static int rows, chosenRow;
    static int seats, chosenSeat;
    public static final int PRICE_10 = 10;
    public static final int PRICE_8 = 8;
    static int ticketPrice;
    static boolean enterAgain = false;
    static int purchasedTickets = 0;
    static double percentage = 0.0;
    static int currentIncome = 0;
    static int totalIncome = 0;

    public static int calculateTotalIncome(int rows, int seats) {
        int frontHalfRowsPrice;
        int backHalfRowsPrice;
        if (rows * seats <= 60) {
            totalIncome = rows * seats * PRICE_10;
        } else {
            if (rows % 2 == 0) {
                frontHalfRowsPrice = (rows / 2) * seats * PRICE_10;
                backHalfRowsPrice = (rows / 2) * seats * PRICE_8;
                totalIncome = frontHalfRowsPrice + backHalfRowsPrice;
            } else {
                frontHalfRowsPrice = (rows / 2) * seats * PRICE_10;
                backHalfRowsPrice = (rows - (rows / 2)) * seats * PRICE_8;
                totalIncome = frontHalfRowsPrice + backHalfRowsPrice;
            }
        }
        return totalIncome;
    }

    public static int calculateCurrentIncome(int ticketPrice) {
        currentIncome = currentIncome + ticketPrice;
        return currentIncome;
    }

    public static double calculatePercentage(int rows, int seats) {
        percentage = (double) (100 * purchasedTickets) / (rows * seats);
        return percentage;
    }

    public static int calculatePurchasedTickets(int purchasedTickets) {
        return purchasedTickets;
    }

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

    public static int calculatePrice(int rows, int seats, int chosenRow, int chosenSeat) {
        
        if (rows * seats <= 60) {
            ticketPrice = PRICE_10;
        } else if (chosenRow <= rows / 2 ) {
            ticketPrice = PRICE_10;
        } else {
            ticketPrice = PRICE_8;
        }

        System.out.println();
        System.out.println("Ticket price: $" + ticketPrice);
        System.out.println();
        purchasedTickets++; // if the ticket price is printed, it means the ticket has been purchased then count the purchased ticket.
        return ticketPrice;
    }

    public static boolean checkInput(String[][] seatPlan, int rows, int seats, int chosenRow, int chosenSeat) {
        
        if (chosenRow > rows || chosenSeat > seats) {
            System.out.println("Wrong input!");
            System.out.println();
            enterAgain = false;
        } else if (seatPlan[chosenRow][chosenSeat] != "S"){
            System.out.println("That ticket has already been purchased!");
            System.out.println();
            enterAgain = false;
        } else {
            enterAgain = true;
        }
        return enterAgain;
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
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int chooseMenu = scanner.nextInt();
            System.out.println();

            switch (chooseMenu) {
                case 1:
                    printSeatPlan(seatPlan, rows, seats, chosenRow, chosenSeat);
                    break;
                case 2:
                    while (!enterAgain) {
                        System.out.println("Enter a row number:");
                        chosenRow = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        chosenSeat = scanner.nextInt();
                        checkInput(seatPlan, rows, seats, chosenRow, chosenSeat);
                    }
                    seatPlan[chosenRow][chosenSeat] = "B";
                    enterAgain = false;
                    calculatePrice(rows, seats, chosenRow, chosenSeat);
                    calculateCurrentIncome(ticketPrice);
                    calculatePercentage(rows, seats);
                    break;
                case 3:
                    calculatePurchasedTickets(purchasedTickets);
                    calculateTotalIncome(rows, seats);
                    System.out.println("Number of purchased tickets: " + purchasedTickets);
                    System.out.printf("Percentage: %.2f%%%n", percentage);
                    System.out.println("Current income: $" + currentIncome);
                    System.out.println("Total income: $" + totalIncome);
                    System.out.println();
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
