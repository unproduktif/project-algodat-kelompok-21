import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedListNasabah LLnasabah = new LinkedListNasabah();
        LLnasabah.daftar("Valerine","Mataram","valerine","erin",370000);
        LLnasabah.daftar("Dodi Wijaya","Kekalik Jaya","dodi","dod",150000);
        LLnasabah.daftar("Agus Setiawan","Narmada","agus","agus123",200000);
        Scanner scanner = new Scanner(System.in);
        MenuAwal.tampilkanMenu(LLnasabah, scanner);
    }
}