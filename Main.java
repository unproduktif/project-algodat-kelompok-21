import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedListNasabah LLnasabah = new LinkedListNasabah();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Login");
        System.out.println("2. Daftar");
        int n = scanner.nextInt();
        switch(n){
            case 1:
                System.out.println("Masukkan username:");
                String username = scanner.next();
                System.out.println("Masukkan password:");
                String password = scanner.next();
                if(LLnasabah.login(username, password)){//Method login buat ngecek apakah ada username dan password di database, klo ketemu return true
                    System.out.println("Login berhasil!");
                } else {
                    System.out.println("Login gagal!");
                }
                break;
            case 2:
                System.out.println("Masukkan nama:");
                String newName = scanner.next();
                System.out.println("Masukkan alamat:");
                String newAddress = scanner.next();
                System.out.println("Masukkan username baru:");
                String newUsername = scanner.next();
                System.out.println("Masukkan password baru:");
                String newPassword = scanner.next();
                if(LLnasabah.daftar(newName, newAddress, newUsername, newPassword)){//Method daftar buat ngecek apakah ada username dan password di database, klo ketemu return false
                    System.out.println("Pendaftaran berhasil!");
            } else {
                    System.out.println("Pendaftaran gagal!");
                }
                break;
            default:
                System.out.println("Pilihan yang anda pilih salah!");
                break;
        }
    scanner.close();
    }
}