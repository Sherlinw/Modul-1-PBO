public class BangunRuang {
    private String name;

    BangunRuang(String name){
        this.name = name;
    }

    public void inputNilai(){
        System.out.println("Input nilai");
    }

    public void luasPermukaan(){
        System.out.println("Menghitung luas permukaan bangun" + name);
    }

    public void volume(){
        System.out.println("Menghitung volume bangun" + name);
    }

    public void setName(String name){ // awalnya huruf pertama (S) pada String bukan huruf kapital jadi saya ubah menjadi huruf kapital
        this.name = name;
    }

    public String getName(){
        return name;
    }//nama atributnya saya ganti jadi name karena bukan your

}
