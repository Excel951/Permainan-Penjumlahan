import java.io.*;
import java.util.*;

public class ProgQuis21410100045 {
    // Membuat program kuis penjumlahan
    // menggunakan dua buah array stack
    // keduanya ditambahkan dan hasilnya dibandingkan dengan jawaban user
    // INPUTAN BERUPA INTEGER
    // hasil di akhir menampilkan list soal, hasil, jawaban user,
    // dan keterangan benar atau salah
    // hasil paling akhir juga akan menampilkan nilai yg didapat user

    public static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static int ukuran = 10, max = 10, menu = 0, ls1, ls2, tempjwb, temphasil;

    public static double grade, point;

    public static String tempsoal;

    public static Stack<Integer> varSoal1, varSoal2, answer, result;

    public static Stack<String> storage;

    public static Stack<Integer> tempanswer, tempresult;

    public static Stack<String> tempstorage;

    public static void ListSoal() {
        varSoal1 = new Stack<Integer>(); // VARIABEL SOAL 1
        varSoal2 = new Stack<Integer>(); // VARIABEL SOAL 2

        answer = new Stack<Integer>(); // STACK JAWABAN USER
        result = new Stack<Integer>(); // STACK HASIL DARI SOAL
        storage = new Stack<String>(); // STORAGE SOAL

        tempanswer = new Stack<Integer>(); // TEMPORARY STACK JAWABAN USER
        tempresult = new Stack<Integer>(); // TEMPORARY STACK HASIL DARI SOAL
        tempstorage = new Stack<String>(); // TEMPORARY STORAGE SOAL
    }

    public static void GenerateSoal(int max, int ukuran) {
        for (int i = 0; i < ukuran; i++) {
            varSoal1.push(MyMathTools.random(1, max));
            varSoal2.push(MyMathTools.random(1, max));
        }
    }

    public static void CopyOfStack() {
        int a = 0;

        do {
            tempsoal = tempstorage.pop();
            storage.push(tempsoal);

            tempjwb = tempanswer.pop();
            answer.push(tempjwb);

            temphasil = tempresult.pop();
            result.push(temphasil);

            a++;
        } while (a < ukuran);
    }

    public static void PrintResult() {
        int a = 0;

        do {
            tempsoal = storage.pop();
            tempjwb = answer.pop();
            temphasil = result.pop();

            System.out.print("\n\n" + (a + 1) + ". " + tempsoal + tempjwb + "\n\t");
            if (tempjwb == temphasil) {
                System.out.print("Benar => " + tempsoal + temphasil);
            } else {
                System.out.print("Salah => " + tempsoal + temphasil);
            }

            a++;
        } while (a < ukuran);

        EndMenu();
        System.out.println("Nilai: " + grade + "/100");
    }

    public static void InsertAnswer() throws IOException {
        grade = 0;
        point = 100 / ukuran;

        for (int i = 0; i < ukuran; i++) {
            ls1 = varSoal1.pop();
            ls2 = varSoal2.pop();
            tempresult.push(ls1 + ls2);
            tempstorage.push(ls1 + " + " + ls2 + " = ");
            System.out.print("\n" + (i + 1) + ". " + tempstorage.peek());
            tempanswer.push(Integer.parseInt(rd.readLine()));
            if (ls1 + ls2 == tempanswer.peek()) {
                grade += point;
            } else {
                grade += 0;
            }
        }
    }

    public static void EndMenu() {
        System.out.println();
        for (int i = 0; i < 20; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    public static void MenuAwal() {
        for (int j = 0; j < 2; j++) {
            if (j == 1) {
                for (int i = 0; i < 20; i++)
                    System.out.print("=");
                System.out.println();
            }
            if (j == 0)
                System.out.println("======= MENU =======");
        }
        System.out.println("\n1. MAIN\n2. TENTUKAN JUMLAH SOAL\n3. LEVEL\n4. EXIT\n");
        for (int i = 0; i < 20; i++)
            System.out.print("=");
    }

    public static int Level(int menu) {
        switch (menu) {
            case 1:
                max = 10;
                break;
            case 2:
                max = 20;
                break;
            case 3:
                max = 30;
                break;
            default:
                max = 10;
                break;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        ListSoal();
        do {
            MenuAwal();
            System.out.print("\nPilih menu (1/2/3/4): ");
            menu = Integer.parseInt(rd.readLine());
            EndMenu();
            switch (menu) {
                case 1:
                    EndMenu();
                    GenerateSoal(max, ukuran);
                    System.out.println("\nKuis Dimulai...\n\nList Soal\n");
                    InsertAnswer();
                    CopyOfStack();
                    EndMenu();
                    EndMenu();
                    EndMenu();
                    System.out.println("\n\tResult");
                    PrintResult();
                    EndMenu();
                    break;

                case 2:
                    System.out.print("\nMasukkan jumlah soal yang diinginkan: ");
                    ukuran = Integer.parseInt(rd.readLine());
                    EndMenu();
                    break;

                case 3:
                    System.out.println("\n====== LEVEL ======");
                    System.out.println("1. LEVEL 1 (1-10)");
                    System.out.println("2. LEVEL 2 (1-20)");
                    System.out.println("3. LEVEL 3 (1-30)");
                    System.out.print("Pilih level (1/2/3): ");
                    menu = Integer.parseInt(rd.readLine());
                    if (menu > 3 || menu < 1)
                        System.out.println("\nLevel tidak tersedia\nLevel akan diset ke level terendah");
                    EndMenu();
                    Level(menu);
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    break;
            }
        } while (true);
    }
}