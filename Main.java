import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedListNasabah LLnasabah = new LinkedListNasabah();
        Scanner scanner = new Scanner(System.in);
        boolean running =true;
        while(running){
            System.out.println("\n=======================================");
            System.out.println("||          SELAMAT DATANG           ||");
            System.out.println("||           DI TRANS SMART          ||");
            System.out.println("=======================================");
            System.out.println("|| 1. Login                          ||");
            System.out.println("|| 2. Daftar                         ||");
            System.out.println("|| 3. Keluar                         ||");
            System.out.println("=======================================");
            System.out.print("Pilih menu (1-3): ");
            int n = scanner.nextInt();
            scanner.nextLine();
            switch(n){
                case 1:
                    System.out.print("Masukkan username: ");
                    String username = scanner.next();
                    System.out.print("Masukkan password: ");
                    String password = scanner.next();
                    if(username.equals("csbank")&&password.equals("admin123")){
                        System.out.println("Login Admin berhasil!");
                        Admin admin=new Admin(LLnasabah, scanner);
                        admin.menuAdmin();
                    }else if(LLnasabah.login(username, password)){//Method login buat ngecek apakah ada username dan password di database, klo ketemu return true
                        System.out.println("Login berhasil!");
                        NodeNasabah temp=LLnasabah.head;
                        while(temp!=null){
                            if(temp.data.username.equals(username)&&temp.data.password.equals(password)){
                                temp.data.menuNasabah(scanner);
                                break;
                            }
                            temp=temp.next;
                        }
                    } else {
                        System.out.println("Login gagal!");
                    }
                    break;
                case 2:
                    System.out.print("Masukkan nama: ");
                    String newName = scanner.nextLine();
                    System.out.print("Masukkan alamat: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Masukkan username baru: ");
                    String newUsername = scanner.next();
                    System.out.print("Masukkan password baru: ");
                    String newPassword = scanner.next();
                    if(LLnasabah.usernameTerdata(newUsername)){
                        System.out.println("Pendaftaran gagal! Username sudah digunakan.");
                        break;
                    }
                    System.out.print("Masukkan saldo awal (min. 100.000): ");
                    double saldo=scanner.nextDouble();
                    scanner.nextLine();

                    if(saldo<100000){
                        System.out.println("Pendaftaran gagal! Saldo awal tidak memenuhi syarat.");
                    }else if(LLnasabah.daftar(newName, newAddress, newUsername, newPassword, saldo)){//Method daftar buat ngecek apakah ada username dan password di database, klo ketemu return false
                        System.out.println("Pendaftaran berhasil!");
                        NodeNasabah temp= LLnasabah.head;
                        while(temp!=null){
                            if(temp.data.username.equals(newUsername)){
                                System.out.println("Nomor rekening Anda: "+temp.data.noRekening);
                                break;
                            }
                            temp=temp.next;
                        }
                    } else {
                        System.out.println("Pendaftaran gagal!");
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan Trans Smart. Sampai jumpa!");
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan yang anda pilih salah!");
                    break;
            }
        }
    scanner.close();
    }
}