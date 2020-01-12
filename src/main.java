import java.util.Random;
import java.util.Scanner;

public class main {
    static double  ObliczFunkcje(double a,double b,double c,double d,int x){
        double wynik=0;
        wynik= (a*(x*x*x))+(b*(x*x))+(c*x)+d;
        return wynik;
    }
    static int RandomGenerator(int min,int max)
    {
        Random generator=new Random();
        return generator.nextInt((max-min)+1)+min;
    }
    static double Procent(double suma,double x){
        double wynik=0;
        wynik=(x/suma)*100;
        return wynik;
    }

    public static void main(String[] args) {

        Random rd = new Random();
        double Pk, PkLosowe, Pm, PmLosowe, a, b, c, d,max=0,maxtemp=0,warunek,odpowiedz = 0,licznikmax=0;
        int L,licznik=0;
        int fenotyp[] = new int[6];
        int PierwszeDec[]=new int[6];
        String PierwszeBin[]=new String[6];
        double fgenotyp[] = new double[6];
        double Procenty[] = new double[6];
        String ChString[] = new String[6];
        String Ruletka[]=new String[100];
        String ChWymieszane[] = new String[6];
        Scanner sc = new Scanner(System.in);
        System.out.print("Pk = ");
        Pk = sc.nextDouble();
        System.out.print("Pm = ");
        Pm = sc.nextDouble();
        System.out.print("a = ");
        a = sc.nextDouble();
        System.out.print("b = ");
        b = sc.nextDouble();
        System.out.print("c = ");
        c = sc.nextDouble();
        System.out.print("d = ");
        d = sc.nextDouble();
        //System.out.print("Warunek aby zakonczyc [ilosc iteracji] : ");
        //warunek =sc.nextDouble();

        for (int i = 0; i < 6; i++) {
            fenotyp[i] = RandomGenerator(1, 31);
            PierwszeDec[i]=fenotyp[i];
            PierwszeBin[i]=Integer.toBinaryString(fenotyp[i]);
            while (PierwszeBin[i].length() < 5) {
                PierwszeBin[i] = "0" + PierwszeBin[i];
            }
        }

        do {
            System.out.print("Fenotyp : ");
            for (int i = 0; i <6; i++) {
                System.out.print("[" + fenotyp[i] + "] ");
            }
            System.out.println();
            System.out.print("Fgenotyp : ");
            double sumaF = 0;
            for (int i = 0; i < 6; i++) {
                int x;
                x = fenotyp[i];
                fgenotyp[i] = ObliczFunkcje(a, b, c, d, x);
                System.out.print("[" + fgenotyp[i] + "] ");
                sumaF += fgenotyp[i];
            }

            System.out.println();
            System.out.println("Suma: " + sumaF);
            System.out.print("Procenty : ");

            for (int i = 0; i < 6; i++) {
                double x;
                x = fgenotyp[i];
                Procenty[i] = Procent(sumaF, x);
                System.out.print("[" + Procenty[i] + " %" + "] ");
            }
            maxtemp=max;
            for(int i = 1; i < fgenotyp.length;i++)
            {
                if(fgenotyp[i] > max)
                {
                    max = fgenotyp[i];
                    odpowiedz=fenotyp[i];
                }
            }
            if(maxtemp==max) licznikmax++;
            System.out.println();
            System.out.print("Binarnie : ");

            for (int i = 0; i < 6; i++) {
                int x;
                x = fenotyp[i];
                ChString[i] = Integer.toBinaryString(x);
                while (ChString[i].length() < 5) {
                    ChString[i] = "0" + ChString[i];
                }
                System.out.print("[" + ChString[i] + "] ");
            }

            System.out.println();
            System.out.print("Losowe Pary :");
            int zakres1=0;
            int zakres2=0;
            for (int i = 0; i <6 ; i++)
            {

                if(i==0){
                    zakres2=(int)Procenty[i]+1;
                    for (int j = zakres1; j <zakres2 ; j++) {
                        Ruletka[j]=ChString[i];
                    }
                    zakres1=zakres2;
                    zakres2=(int)Procenty[i+1]+zakres1;
                }
                if(i==1){
                    for (int j = zakres1; j <zakres2 ; j++) {
                        Ruletka[j]=ChString[i];
                    }
                    zakres1=zakres2;
                    zakres2=(int)Procenty[i+1]+zakres1;
                }
                if(i==2){

                    for (int j = zakres1; j <zakres2 ; j++) {
                        Ruletka[j]=ChString[i];
                    }
                    zakres1=zakres2;
                    zakres2=(int)Procenty[i+1]+zakres1;
                }
                if(i==3){

                    for (int j = zakres1; j <zakres2 ; j++) {
                        Ruletka[j]=ChString[i];
                    }
                    zakres1=zakres2;
                    zakres2=(int)Procenty[i+1]+zakres1;
                }
                if(i==4){

                    for (int j = zakres1; j <zakres2 ; j++) {
                        Ruletka[j]=ChString[i];
                    }
                    zakres1=zakres2;
                    zakres2=(int)Procenty[i+1]+zakres1;
                }
                if(i==5){
                    for (int j = zakres1; j <100 ; j++) {
                        Ruletka[j]=ChString[i];
                    }

                }
            }


            for (int i = 0; i < 6; i++) {
                ChWymieszane[i] = Ruletka[RandomGenerator(1, 100) - 1];
                System.out.print("[" + ChWymieszane[i] + "] ");
            }

            System.out.println();
            for (int i = 0; i < 6; i++) {
                L = RandomGenerator(1, 4);
                PkLosowe = rd.nextDouble();
                System.out.print("Pk=" + PkLosowe);
                System.out.println(" L=" + L);

                if (PkLosowe < Pk * 100) {
                    ChString[i] = ChWymieszane[i].substring(0, L) + (ChWymieszane[i + 1].substring(L, ChWymieszane[i].length()));
                    ChString[i + 1] = (ChWymieszane[i + 1].substring(0, L)) + (ChWymieszane[i].substring(L, ChWymieszane[i].length()));
                } else {
                    ChString[i] = ChWymieszane[i];
                    ChString[i + 1] = ChWymieszane[i + 1];
                }

                System.out.println((i + 1) + "." + ChString[i]);
                System.out.println((i + 2) + "." + ChString[i + 1]);

                i++;
            }
            for (int i = 0; i < 6; i++) {
                String temp;
                L = RandomGenerator(1, 5);
                PmLosowe = rd.nextDouble();
                System.out.print("Pm= " + PmLosowe);
                System.out.println(" L= " + L);
                System.out.println("Stare:" + ChString[i]);
                if (PmLosowe < Pm) {
                    if (ChString[i].charAt(L - 1) == '0') {
                        StringBuffer s = new StringBuffer(ChString[i]);
                        s.replace(L - 1, L, "1");
                        ChString[i] = s.toString();
                    } else if (ChString[i].charAt(L - 1) == '1') {
                        StringBuffer s = new StringBuffer(ChString[i]);
                        s.replace(L - 1, L, "0");
                        ChString[i] = s.toString();
                    }
                }
                System.out.println("Nowe:" + ChString[i]);
                fenotyp[i]=Integer.parseInt(ChString[i],2);
            }
            licznik++;
        }
        while(licznikmax<=10);
        System.out.println();
        System.out.print("Pula Początkowa Bin : ");
        for (int i = 0; i <6 ; i++) {
            System.out.print("["+PierwszeBin[i]+"] ");
        }
        System.out.println();
        System.out.print("Pula Początkowa Dec : ");
        for (int i = 0; i <6 ; i++) {
            System.out.print("["+PierwszeDec[i]+"] ");
        }
        System.out.println();
        System.out.println("Ilość Iteracji : "+licznik);
        System.out.println("Chromosom x : "+odpowiedz);
        System.out.println("Maximum Funkcji : "+max);
    }
}