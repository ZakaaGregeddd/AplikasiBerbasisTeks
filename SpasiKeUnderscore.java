// Nama : Muhammad Zakaa Shahzada
// NIM : 09021182328014
// Tugas Pemrograman Berorientasi Objek Lanjut
// Program berfungsi untuk mengganti spasi dengan underscore dalam sebuah file teks
// dibutuhkan file tambahan sebagai input, misalnya "input.txt" yang berisi teks dengan spasi, dan output akan disimpan dalam "output.txt"

// 2 argumen
//java SpasiKeUnderscore input.txt output.txt
import java.io.*;

class SpasiKeUnderscore {
    public static void main(String args[]) throws IOException {
        if (args.length != 2) {
            System.out.println("Gunakan format: java SpasiKeUnderscore <sumber> <tujuan>");
            return;
        }

        try (FileInputStream fis = new FileInputStream(args[0]);
             FileOutputStream fos = new FileOutputStream(args[1])) {
            
            int temp;
            while ((temp = fis.read()) != -1) {
                if (temp == ' ') {
                    fos.write('_');
                } else {
                    fos.write(temp);
                }
            }
            System.out.println("Proses konversi selesai.");
            
        } catch (FileNotFoundException ex) {
            System.out.println("File tidak ditemukan atau tidak dapat diakses.");
        } catch (IOException ex) {
            System.out.println("Error saat membaca/menulis file.");
        }
    }
}