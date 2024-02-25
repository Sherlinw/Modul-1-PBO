import java.util.Scanner;

public class Library {
    private static User[] users = {
            new Admin("sherlin", "oggy"),
            new Student("sherlin", "student", "202310370311147")
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("Library System");
            System.out.println("1. Login sebagai siswa");
            System.out.println("2. Login sebagai admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi (1-3): ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    loggedIn = loginAsStudent(scanner);
                    break;
                case 2:
                    loggedIn = loginAsAdmin(scanner);
                    break;
                case 3:
                    System.out.println("sukses keluar");
                    break;
                default:
                    System.out.println("opsi tidak valid");
            }
        }
    }

    private static boolean loginAsStudent(Scanner scanner) {
        System.out.print("Masukkan nim: ");
        String nim = scanner.nextLine();

        for (User user : users) {
            if (user.isStudent() && user.getNim().equals(nim)) {
                System.out.println("Berhasil login sebagai mahasiswa");
                return true;
            }
        }

        System.out.println("User tidak ditemukan");
        return false;
    }

    private static boolean loginAsAdmin(Scanner scanner) {
        System.out.print("Masukkan username admin: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password admin: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.isAdmin() && user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Berhasil login sebagai admin");
                return true;
            }
        }

        System.out.println("User admin tidak ditemukan!!");
        return false;
    }
}
