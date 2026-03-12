// Nama : Muhammad Zakaa Shahzada
// NIM : 09021182328014
// Tugas Pemrograman Berorientasi Objek Lanjut
// Program berfungsi untuk mengganti spasi dengan underscore dalam sebuah file teks
// dibutuhkan file tambahan sebagai input, misalnya "input.txt" yang berisi teks dengan spasi, dan output akan disimpan dalam "output.txt"
import java.io.*;

public class SpasiKeUnderscore {
    public static void main(String[] args) {

        String sumber = args[0];
        String tujuan = args[1];

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Membuat koneksi input stream ke file sumber dan output stream ke file tujuan
            fis = new FileInputStream(sumber);
            fos = new FileOutputStream(tujuan);

            int temp;
            // Membaca file sumber per karakter sampai mencapai akhir file (nilai -1)
            while ((temp = fis.read()) != -1) {
                char data = (char) temp;
                
                // Jika karakter adalah spasi (' '), ubah menjadi underscore ('_')
                if (data == ' ') {
                    fos.write('_');
                } else {
                    // Tulis karakter asli jika bukan spasi
                    fos.write(temp);
                }
            }
            System.out.println("Proses selesai! Silakan periksa file: " + tujuan);

        } catch (FileNotFoundException ex) {
            // Menangani error jika file sumber tidak ditemukan atau file tujuan tidak bisa dibuat
            System.out.println("Error: File tidak ditemukan atau tidak dapat diakses.");
        } catch (IOException ex) {
            // Menangani error pada saat proses baca/tulis
            System.out.println("Error: Terjadi masalah saat membaca atau menulis file.");
        } finally {
            // Tutup untuk memori bersih
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException ex) {
                System.out.println("Error saat menutup stream.");
            }
        }
    }
}