package IOC_BE.SS13.BaiTap02_SS13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        run(sc);
    }

    private static void run(Scanner sc) {
        StudentMenu.showMenu(sc);
    }
}