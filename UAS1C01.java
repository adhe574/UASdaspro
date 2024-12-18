//Nama : Adhe Widya G.K
//NIM : 244107060067
//Kelas : SIB 1C
//Absen: 01

import java.util.Scanner;

public class UAS1C01 {
    static Scanner sc01 = new Scanner(System.in);
    static int jumlahTim01 = (67 % 3) + 4;
    static String[] namaTim01 = new String[jumlahTim01];
    static int[][] skor01 = new int[jumlahTim01][2];
    static int[] totalSkor01 = new int[jumlahTim01];

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Input Data Skor Tim");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara");
            System.out.println("4. Keluar");

            System.out.print("Pilih menu (1-4): ");
            pilihan = sc01.nextInt();
            sc01.nextLine();

            switch (pilihan) {
                case 1:
                    inputDataSkorTim();
                    break;
                case 2:
                    tampilkanTabelSkor();
                    break;
                case 3:
                    tentukanJuara();
                    break;
                case 4:
                    System.out.println("\n=== PROGRAM SELESAI. TERIMA KASIH! ===\n");
                    break;
                default:
                    System.out.println("\nPilihan tidak valid. Silakan coba lagi!\n");
            }
        } while (pilihan !=4);
    }

    static void inputDataSkorTim() {
        for (int i = 0; i < jumlahTim01; i++) {
            System.out.print("\nMasukkan Nama Tim ke-" + (i + 1) + " : ");
            namaTim01[i] = sc01.nextLine();
        
            while (true) {
                System.out.print("Masukkan skor " + namaTim01[i] + " untuk Level 1: ");
                int skorLevel1 = sc01.nextInt();
                if (skorLevel1 < 0) {
                    System.out.println("Skor tidak valid!");
                } else if (skorLevel1 < 35) {
                    skor01[i][0] = 0;
                    break;
                } else {
                    skor01[i][0] = skorLevel1;
                    break;
                }
            }

            while (true) {
                System.out.print("Masukkan skor " + namaTim01[i] + " untuk Level 2: ");
                int skorLevel2 = sc01.nextInt();
                if (skorLevel2 < 0) {
                    System.out.println("Skor tidak valid!.");
                } else {
                    skor01[i][1] = skorLevel2;
                    break;
                }
            }
            sc01.nextLine();
            totalSkor01[i] = skor01[i][0] + skor01[i][1];
        }
    }

    static void tampilkanTabelSkor() {
        System.out.println("\nTabel Skor Turnamen:");
        System.out.printf("%-10s %-7s %-7s %-7s%n", "Nama Tim", "Level 1", "Level 2", "Total Skor01");

        for (int i = 0; i < jumlahTim01; i++) {
            System.out.printf("%-10s %-7d %-7d %-7d%n", namaTim01[i], skor01[i][0], skor01[i][1], totalSkor01[i]);
        }
    }

    static void tentukanJuara() {
        if (namaTim01[0] == null) {
            System.out.println("\nTidak ada data yang bisa ditampilkan.");
            return;
        }

        int maxSkor01 = totalSkor01[0];
        String juara01 = namaTim01[0];
        boolean seri01 = false;

        for (int i = 1; i < jumlahTim01; i++) {
            if (totalSkor01[i] > maxSkor01) {
                maxSkor01 = totalSkor01[i];
                juara01 = namaTim01[i];
                seri01 = false;
            } else if (totalSkor01[i] == maxSkor01) {
                if (skor01[i][1] > skor01[0][1]) {
                    juara01 = namaTim01[i];
                    seri01 = false;
                } else if (skor01[i][1] == skor01[0][1]) {
                    seri01 = true;
                }
            }
        }

        if (seri01) {
            System.out.println("\nTurnamen seri antara Tim " + juara01 + " dan Tim " + namaTim01[0]);
        } else {
            System.out.println("\nSelamat kepada Tim " + juara01 + " yang telah memenangkan kompetisi!");
        }
    }
}