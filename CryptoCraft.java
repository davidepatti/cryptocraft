import java.util.Scanner;

public class CryptoCraft {
    String alfabeto = "abcdefghilmnopqrstuvz";
    int chiave;
    Scanner sc = new Scanner(System.in);

    public void test() {
        System.out.println("Carissimo, inserisci una frase:");

        String frase = "";
        frase = sc.nextLine();

        // TODO: aggiungere altri caratteri da togliere
        frase = frase.toLowerCase();
        frase = frase.replaceAll("à","a");
        frase = frase.replaceAll("è","e");
        frase = frase.replaceAll("ì","i");
        frase = frase.replaceAll("ò","o");
        frase = frase.replaceAll("ù","u");
        String frasesenzaspazi = frase.replaceAll("[^abcdefghilmnopqrstuvz]", "");

        String codificata;


        codificata = codificaCesare(frasesenzaspazi);
        System.out.println("LA FRASE CODIFICATA CESARE E': "+codificata);

        codificata = codificaInutile(frasesenzaspazi);
        System.out.println("LA FRASE CODIFICATA INUTILE E': "+codificata);
    }

    public static void main(String[] args) {

        CryptoCraft myapp = new CryptoCraft();
        myapp.test();
    }

    String codificaInutile(String originale ) {
        String codificata = "MRA";
        return codificata;
    }
    // questa funzione prende una stringa e la codifica
    String codificaCesare(String originale) {

        System.out.println("inserisci un numero chiave");
        chiave = sc.nextInt();
        System.out.println("la chiave è " + chiave);
        String codificata = "";
        int lungh = originale.length();

        for (int pos =0; pos<lungh; pos=pos+1 ) {
            char carattere_attuale = originale.charAt(pos);

                // converte la vecchia posizione nell'alfabeto nella nuova
                int nuova_posizione =chiave+ trova_pos(carattere_attuale);
                while (nuova_posizione > 20) nuova_posizione = nuova_posizione - 21;
                // aggiunge il nuovo carattere alla fine
                codificata = codificata + alfabeto.charAt(nuova_posizione);
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
        System.out.println("Non e' un carattere valido");
        return -1;
    }


}
