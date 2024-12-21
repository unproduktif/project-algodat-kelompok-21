import java.util.Scanner;

public class MenuAwal {
    public static void tampilkanMenu(LinkedListNasabah LLnasabah, Scanner scanner) {
        boolean running =true;
        while(running){
            System.out.println("\n=======================================");
            System.out.println("||          SELAMAT DATANG           ||");
            System.out.println("||           DI TransSmart           ||");
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
                System.out.println("\n===========================================");
                System.out.println("||               LOGIN                   ||");
                System.out.println("===========================================");
                    System.out.print("Masukkan username: ");
                    String username = scanner.next();
                    System.out.print("Masukkan password: ");
                    String password = scanner.next();
                    if(username.equals("csbank")&&password.equals("admin123")){
                        System.out.println("Login Admin berhasil!");
                        scanner.nextLine();
                        scanner.nextLine();
                        Admin admin=new Admin(LLnasabah, scanner);
                        admin.menuAdmin();
                    }else if(LLnasabah.login(username, password)){//Method login buat ngecek apakah ada username dan password di database, klo ketemu return true
                        System.out.println("\u001B[32mLogin berhasil!\u001B[0m");
                        scanner.nextLine();
                        scanner.nextLine();
                        NodeNasabah temp=LLnasabah.head;
                        while(temp!=null){
                            if(temp.data.username.equals(username)&&temp.data.password.equals(password)){
                                temp.data.menuNasabah(scanner, LLnasabah);
                                break;
                            }
                            temp=temp.next;
                        }
                    } else {
                        System.out.println("\u001B[31mLogin gagal!\u001B[0m");
                    }
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 2:
                System.out.println("\n===========================================");
                System.out.println("||               DAFTAR                  ||");
                System.out.println("===========================================");
                    System.out.print("Masukkan nama\t\t: ");
                    String newName = scanner.nextLine();
                    System.out.print("Masukkan alamat\t\t: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Masukkan username\t: ");
                    String newUsername = scanner.next();
                    System.out.print("Masukkan password\t: ");
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
                    scanner.nextLine();
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