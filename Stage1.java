public class Stage1 {

    public static void printSeats() {
        System.out.println("Cinema:");
        System.out.println("  1 2 3 4 5 6 7 8");
        for (int i = 1; i < 8; i++) {
            System.out.println(i + " S S S S S S S S");
        }
    }
    public static void main(String[] args) {
        // Write your code here
        printSeats();
    }
}