import java.util.Scanner;

public class Kubus extends BangunRuang{
    Scanner scanner = new Scanner(System.in);
    private double sisi;

    public Kubus(String name){
        super(name);
    }
    
    @Override
    public void inputNilai(){
        super.inputNilai();
        System.out.print("Input sisi: "); // system.o saya ganti jadi system.out.print

        sisi = scanner.nextDouble(); // saya ganti nextnext() jadi nextDouble() karena angka input bentuknya desimal

    }

    @Override
    public void luasPermukaan(){
        double hasil = 6 * sisi * sisi;
        super.luasPermukaan(); //saya ganti jadi luaspermukaan karena nama methodnya luaspermukaan bukan luasaan
        System.out.println("Hasil luas permukaan: " + hasil);// o.println kurang lengkap jadi saya ganti jadi system.out.print

    }

    @Override
    public void volume(){
        double hasil = Math.pow(sisi, 3); // kurang tipe data jadi saya tambahkan tipe data double
        super.volume();
        System.out.println("Hasil volume: " + hasil);// tulisan +hasil error karena sebelumnya tidak ada tipe data double setelah diberi tipe data maka jadi tidak error

    }
}
