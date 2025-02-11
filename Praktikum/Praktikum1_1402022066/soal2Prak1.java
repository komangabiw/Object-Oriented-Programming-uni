import java.util.Random;
public class soal2Prak1 {
    public static void main(String[] args) {
        String[] buah = {"Buah 1", "Buah 2", "Buah 3", "Buah 4", "Buah 5", "Buah 6", "Buah 7", "Buah 8", "Buah 9", "Buah 10"};
        int random = new Random().nextInt(buah.length);
        System.out.println(buah[random]);
    }
}