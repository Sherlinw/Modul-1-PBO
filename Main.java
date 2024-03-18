package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    // Attribut array bookList berisi data buku seperti stok buku, author, id_buku, dan judul
    static String[][] bookList = {
            {"1", "belajar java untuk pemula", "taufiq ramadhan","pemrograman", " 10"},
            {"2", "belajar diskrit dengan mudah", "sofyan","pemrograman", " 8"},

    };
    // Attribut array userStudent berisi data user
    private static ArrayList<Student> userStudents = new ArrayList<>();
    private static Admin admin = new Admin("admin", "admin123");

    private static final ArrayList<Student> studentDatabase = new ArrayList<>();

    public static void main(String[] args) {
        studentDatabase.add(new Student("202310370311147", "sherlin", "Engineering", "Informatics"));
        menu();
    }

    private static void menu() { // Method untuk tampilan awal pilihan login
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("library system");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    studentLogin();
                    break;
                case 3:
                    System.out.println("Exiting program. Thankyou!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void studentLogin() { // Method untuk input NIM jika memilih user student
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your NIM: ");
        String nim = scanner.next();
        Student student = StudentDatabase.getStudentByNim(nim);

        if (student != null) { //jika user ditemukan maka akan menuju ke menu student
            student.menuStudent();
        } else {
            System.out.println("Student not found. Please try again.");
        }
    }

    public static void addStudentToDatabase(Student student) {
        studentDatabase.add(student);
    }

    private static void adminLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter admin username: ");
        String username = scanner.next();
        System.out.print("Enter admin password: ");
        String password = scanner.next();

        if (admin.validateLogin(username, password)) {
            admin.menuAdmin();
        } else {
            System.out.println("Invalid admin credentials. Please try again.");
        }
    }
}

class StudentDatabase { //class untuk menyimpan data array studentt
    private static ArrayList<Student> students = new ArrayList<>();

    static {

        students.add(new Student("202310370311147", "sherlin", "Engineering", "Informatics"));
    }

    public static Student getStudentByNim(String nim) { //Mencari dan mengembalikan objek mahasiswa berdasarkan NIM
        for (Student student : students) {
            if (student.getNim().equals(nim)) {
                return student;
            }
        }
        return null;
    }

    public static void addStudent(Student student) { //Menambahkan mahasiswa ke dalam database.
        students.add(student);
    }

    public static void displayStudents() { //Menampilkan daftar mahasiswa yang terdaftar.
        System.out.println("List of Registered Students:");
        System.out.println("NIM\tName\t\tFaculty\tProgram Studi");
        for (Student student : students) {
            System.out.println(student.getNim() + "\t" + student.name + "\t" + student.faculty + "\t" + student.programStudi);
        }
    }
}

class Student {
    private String nim;
    String name;
    String faculty;
    String programStudi;

    public Student(String nim, String name, String faculty, String programStudi) { //Menginisialisasi informasi mahasiswa dan menambahkan diri sendiri ke dalam studentDatabase melalui method addStudentToDatabase dari class Main.
        this.nim = nim;
        this.name = name;
        this.faculty = faculty;
        this.programStudi = programStudi;
        Main.addStudentToDatabase(this);
    }

    public void displayBooks() { //Menampilkan daftar buku
        System.out.println("List of Available Books:");
        System.out.printf("ID", "Title", "Author", "Category", "Stock");
        for (String[] book : Main.bookList) {
            System.out.println(book[0] + "\t" + book[1] + "\t" + book[2] + "\t" + book[3] + book[4]);
        }
    }

    public void logout() { //Menampilkan pesan keluar dan mengakhiri program.
        System.out.println("Logging out. Goodbye, " + name + "!");
        System.exit(0);
    }

    public void menuStudent() { //Menampilkan menu mahasiswa untuk menampilkan buku atau logout.
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Display Books");
            System.out.println("2. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    logout();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public String getNim() {
        return nim;
    }
}

class Admin {
    private String adminUsername;
    private String adminPassword;

    public Admin(String adminUsername, String adminPassword) {
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }

    public void addStudent(String nim, String name, String faculty, String programStudi) {
        if (nim.length() == 15) {
            Student student = new Student(nim, name, faculty, programStudi);
            StudentDatabase.addStudent(student);
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Invalid NIM length. Please enter a valid NIM.");
        }
    }

    public void displayStudent() {
        StudentDatabase.displayStudents(); //menampilkan daftar student
    }

    public boolean validateLogin(String username, String password) { //Melakukan validasi login admin.
        return this.adminUsername.equals(username) && this.adminPassword.equals(password);
    }

    public void menuAdmin() { //Menampilkan menu admin untuk menambahkan mahasiswa, menampilkan daftar mahasiswa, atau logout.
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudentMenu();
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    System.out.println("Logging out. Goodbye, Admin!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addStudentMenu() { //Meminta informasi mahasiswa dan memanggil method addStudent untuk menambahkannya ke dalam database.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student NIM: ");
        String nim = scanner.next();
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student faculty: ");
        String faculty = scanner.next();
        System.out.print("Enter student program studi: ");
        String programStudi = scanner.next();

        addStudent(nim, name, faculty, programStudi);
    }
}
