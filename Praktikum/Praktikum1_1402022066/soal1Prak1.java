import java.util.Scanner;
public class soal1Prak1{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String masuk = scan.next();
        if (masuk.charAt(0)>=48 && masuk.charAt(0)<=57) {
            System.out.println("Karakter adalah angka");
        } else if (masuk.equalsIgnoreCase("A") || masuk.equalsIgnoreCase("i") || masuk.equalsIgnoreCase("u") || masuk.equalsIgnoreCase("e") || masuk.equalsIgnoreCase("o")) {
            System.out.println("Karakter adalah huruf vokal");
        } else if (masuk.charAt(0)>=66 && masuk.charAt(0)<=68 || masuk.charAt(0)>=70 && masuk.charAt(0)<=72 || masuk.charAt(0)>=74 && masuk.charAt(0)<=78 || masuk.charAt(0)>=80 && masuk.charAt(0)<=84 || masuk.charAt(0)>=86 && masuk.charAt(0)<=90)  {
            System.out.println("Karakter adalah huruf konsonan");
        } else {
            System.out.println("Karakter selain alfabet dan angka");
        }
    }
}