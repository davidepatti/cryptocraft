import java.util.InputMismatchException;
import java.util.Scanner;

public class CryptoCraft {
    String alfabeto = "abcdefghilmnopqrstuvz";
    int chiave;
    Scanner sc = new Scanner(System.in);

    public void test() {
        System.out.println("Carissimo, inserisci una frase:");

        String frase = "";
        frase = sc.nextLine();
        frase = frase.toLowerCase();
        frase = frase.replaceAll("à","a");
        frase = frase.replaceAll("è","e");
        frase = frase.replaceAll("ì","i");
        frase = frase.replaceAll("ò","o");
        frase = frase.replaceAll("ù","u");
        String frasesenzaspazi = frase.replaceAll("[^abcdefghilmnopqrstuvz]", "");

        String codificata_cesare;
        String codificata_tabite;

        codificata_cesare = codificaCesare(frasesenzaspazi);
        System.out.println("LA FRASE CODIFICATA CESARE E': "+codificata_cesare);

        codificata_tabite = codificaTabite(frasesenzaspazi);
        System.out.println("LA FRASE CODIFICATA TABITE E': "+codificata_tabite);
    }

    public static void main(String[] args) {

        CryptoCraft myapp = new CryptoCraft();
        myapp.test();
    }


    String codificaTabite(String originale ) {
        String risultato = "";
        int lettino = originale.length();
        for (int il = 0; il < lettino ; il++) {
            int pos_old = trova_pos(originale.charAt(il));
            int pos_new = 20 - pos_old;
            if (il%2==0)
            risultato = risultato + alfabeto.charAt(pos_new);
            else risultato = risultato + alfabeto.charAt(pos_old);

        }

        return risultato;


    }
    // questa funzione prende una stringa e la codifica
    String codificaCesare(String originale) {

        boolean chiave_ok = false;
        //mentre chiave non e' giusta...
        while (!chiave_ok) {
            try {
                System.out.println("inserisci un numero chiave:");
                chiave = sc.nextInt();
                chiave_ok = true;
            } catch (InputMismatchException e) {
                System.out.println("Ma sei fornito di sci ?");
                chiave_ok = false;
                sc.nextLine();
            }
        }


        String codificata = "";
        int lungh = originale.length();

        for (int pos =0; pos<lungh; pos=pos+1 ) {
            char carattere_attuale = originale.charAt(pos);

                // converte la vecchia posizione nell'alfabeto nella nuova
                int nuova_posizione_cesare =chiave+ trova_pos(carattere_attuale);
                while (nuova_posizione_cesare > 20) nuova_posizione_cesare = nuova_posizione_cesare - 21;
                // aggiunge il nuovo carattere alla fine
                codificata = codificata + alfabeto.charAt(nuova_posizione_cesare);
        }
        return codificata;
    }

    // dato un carattere, trova la sua posizione nell'alfabeto
    int trova_pos(char c) {

        for (int p=0;p<alfabeto.length();p++) {
            if (alfabeto.charAt(p)==c) {
                return p;
            }
        }
        System.out.println("ERROREEEEEEEEEEEEEEEEEEEEEEEEEEEE!!!!!!!!!!!!!!!!!!");
        return -1;
    }
}
