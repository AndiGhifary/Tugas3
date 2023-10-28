import java.util.Scanner;

import static java.lang.Math.random;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * kelas yang mempresentasikan tebakkatagame
 */
public class TebakKataGame {

    public static void main(String[] args) {



        String[] kataKunci = {"komputer", "internet", "java", "programming", "android"};
        /**
         * @param panjangKata menghitung kata
         * @param tebakanPemain tebakan huruf
         * @param kesempatan nyawa
         * @param tebakanBenar hasil
         * @param tebakan tebakan pemain
         * @param hurufDitemukan hasil tebakan
         * @param ifelse benar/salah
         */
        String kataTebakan = kataKunci[(int) (random() * kataKunci.length)];
        int panjangKata = kataTebakan.length();
        char[] tebakanPemain = new char[panjangKata];
        /**
         * @param for pengulangan tebakan
         */
        for (int i = 0; i < panjangKata; i++) {
            tebakanPemain[i] = '_';
        }

        int kesempatan = 1;
        boolean tebakanBenar = false;
        Scanner scanner = new Scanner(in);

        out.println("Selamat datang di Game Tebak Kata!");
        out.println("Kata yang harus Anda tebak memiliki " + panjangKata + " huruf.");

        while (kesempatan > 0 && !tebakanBenar) {
            out.println("\nKata yang telah ditebak: " + new String(tebakanPemain));
            out.println("Anda memiliki " + kesempatan + " kesempatan lagi.");
            out.print("Tebakan Anda: ");
            char tebakan = scanner.next().charAt(0);

            boolean hurufDitemukan = false;
            for (int i = 0; i < panjangKata; i++) {
                if (kataTebakan.charAt(i) == tebakan) {
                    tebakanPemain[i] = tebakan;
                    hurufDitemukan = true;
                }
            }

            if (!hurufDitemukan) {
                kesempatan--;
                out.println("Huruf " + tebakan + " tidak ada dalam kata yang harus ditebak.");
            }

            if (new String(tebakanPemain).equals(kataTebakan)) {
                tebakanBenar = true;
            }
        }

        if (tebakanBenar) {
            out.println("Selamat! Anda berhasil menebak kata: " + kataTebakan);
        } else {
            out.println("Maaf, Anda kehabisan kesempatan. Kata yang benar adalah: " + kataTebakan);
        }

        scanner.close();
    }
}