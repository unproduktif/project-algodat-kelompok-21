import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedListNasabah LLnasabah = new LinkedListNasabah();
        Scanner scanner = new Scanner(System.in);
        MenuAwal.tampilkanMenu(LLnasabah, scanner);
    }
}