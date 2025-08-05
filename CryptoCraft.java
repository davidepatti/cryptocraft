import java.util.Scanner;

public class CryptoCraft {
    String alfabeto = "abcdefghilmnopqrstuvz";

    public void test() {
        System.out.println("Carissimo, inserisci una frase:");
        var sc = new Scanner(System.in);

        String frase = "";
        frase = sc.nextLine();

        // TODO: aggiungere altri caratteri da togliere
        frase = frase.toLowerCase();
        String frasesenzaspazi = frase.replaceAll("[^abcdefghilmnopqrstuvz]", "");

        String codificata = codificaStringa(frasesenzaspazi);
        System.out.println("LA FRASE CODIFICATA E': "+codificata);
    }

    public static void main(String[] args) {

        CryptoCraft myapp = new CryptoCraft();
        myapp.test();
    }

    // questa funzione prende una stringa e la codifica
    String codificaStringa(String originale) {
        String codificata = "";
        int lungh = originale.length();

        for (int pos =0; pos<lungh; pos=pos+1 ) {
            char carattere_attuale = originale.charAt(pos);

            // applico solo alle posizioni pari
            if (pos%2==0) {
                // converte la vecchia posizione nell'alfabeto nella nuova
                int nuova_posizione = 20 - trova_pos(carattere_attuale);
                // aggiunge il nuovo carattere alla fine
                codificata = codificata + alfabeto.charAt(nuova_posizione);
            }
            else {
                codificata = codificata+carattere_attuale;

            }
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
