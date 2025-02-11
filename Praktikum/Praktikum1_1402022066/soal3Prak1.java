public class soal3Prak1 {
    public static void main(String[] args) {
        System.out.println(jumlahkanAngka("b4l1 d3np4s4r"));
        System.out.println(jumlahkanAngka("xx33zz22"));
        System.out.println(jumlahkanAngka("Bunny sweety"));
    }
    public static int jumlahkanAngka(String masuk) {
        int out = 0;
        for (int i = 0; i < masuk.length(); i++) {
            String tampung = "";
            if (masuk.charAt(i)>='0' && masuk.charAt(i)<='9') {
                tampung += masuk.charAt(i);
                int angka = Integer.parseInt(tampung);
                out += angka;
            }
        }
        return out;
    }
}