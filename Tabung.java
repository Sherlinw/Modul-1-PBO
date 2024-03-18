import java.util.Scanner;

public class Tabung extends BangunRuang{
    Scanner scanner = new Scanner(System.in);
    private double tinggi;
    private double jariJari;

    public Tabung(String name) {
        super(name);
    }

    @Override
    public void inputNilai(){
        super.inputNilai();
        System.out.print("Input tinggi: ");
        tinggi = scanner.nextDouble(); // tidak ada nama objek scanner nya jadi saya tambahin nama objek scanner sebelum nextdouble
        System.out.print("Input jari-jari: ");
        jariJari = scanner.nextDouble();//tanda (_) pada jari jari saya hapus karena sebelumnya tidak sama seperti nama atribut yang di atas

    }

    @Override
    public void luasPermukaan(){
        double hasil = 2 * Math.PI * jariJari * (jariJari + tinggi);//tanda (_) pada jari jari saya hapus karena sebelumnya tidak sama seperti nama atribut yang di atas
        super.luasPermukaan(); // saya tambahkan parameter

        System.out.println("Hasil luas permukaan: " + hasil);
    }

    @Override
    public void volume(){
        double hasil = Math.PI * Math.pow(jariJari, 2) * tinggi;//tanda (_) pada jari jari saya hapus karena sebelumnya tidak sama seperti nama atribut yang di atas

        super.volume();
        System.out.println("Hasil volume: " + hasil);
    }
}