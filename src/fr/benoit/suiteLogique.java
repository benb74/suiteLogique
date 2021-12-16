package fr.benoit;

public class suiteLogique {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /*
         * L'exercice porte sur la suite de Conway L'idée repose sur la lecture
         * orale de la suite. Par exemple, au départ, nous avons 1. Si je lis ce
         * que je vois, je dirais qu'il y a un 1. --> 11. j'obtiens 11.
         * Maintenant que j'ai 11, si je lis cela, je dirais qu'il y a deux 1
         * --> 21. j'obtiens 21. Maintenant que j'ai 21, si je le lis, je dirais
         * que je vois un 2 et un 1 --> 1211. ...
         */

        /*
         * Cet exercice est basé sur la construction dynamique de chaines de
         * caractères. 3 façons de procéder sont évoquées : String,
         * StringBuilder et StringBuffer. Des détails sont donnés un peu plus bas
         */

        boolean afficherValeurs = true;
        int profondeur = 40;
        long startMs;

        // Test de la rapidité d'exécution de String.
        startMs = System.currentTimeMillis();
        testString(profondeur, afficherValeurs);
        long endMsString = System.currentTimeMillis() - startMs;
        // Test de la rapidité d'exécution de StringBuilder
        startMs = System.currentTimeMillis();
        testStringBuilder(profondeur, afficherValeurs);
        long endMsStringBuilder = System.currentTimeMillis() - startMs;
        // Test de la rapidité d'exécution de StringBuffer
        startMs = System.currentTimeMillis();
        testStringBuffer(profondeur, afficherValeurs);
        long endMsStringBuffer = System.currentTimeMillis() - startMs;
        // Affichage des temps d'exécution
        System.out.println("En utilisant String : " + endMsString);
        System.out
                .println("En utilisant StringBuilder : " + endMsStringBuilder);
        System.out.println("En utilisant StringBuffer : " + endMsStringBuffer);

    }

    /**
     * Effectue la suite logique avec un type String.
     * @String Les chaines de caractères
     * de type String sont immutables. C'est-à-dire qu'elles ne sont pas faites
     * pour être construites dynamiquement. D'ailleurs, il n'existe pas de
     * méthode rattachée à String pour cela. Il faut donc utiliser '+=' !
     *
     * @param profondeur
     *            : Profondeur de la suite
     */
    public static void testString(int profondeur, boolean afficherValeurs) {
        String valeur = "1";
        String resultat = "";
        int longeurValeur;
        char lettre;
        int compteurLettre;

        for (int i = 0; i < profondeur; i++) {
            resultat = "";
            longeurValeur = valeur.length();
            lettre = ' ';
            compteurLettre = 0;

            for (int indiceLettre = 0; indiceLettre < longeurValeur; indiceLettre++) {
                if (valeur.charAt(indiceLettre) != lettre) {
                    if (compteurLettre > 0)
                        resultat += String.valueOf(compteurLettre)
                                + String.valueOf(lettre);
                    lettre = valeur.charAt(indiceLettre);
                    compteurLettre = 1;
                } else {
                    compteurLettre++;
                }
            }

            if (compteurLettre > 0) {
                resultat += String.valueOf(compteurLettre)
                        + String.valueOf(lettre);
            }
            if (afficherValeurs) {
                System.out.println(resultat);
            }
            valeur = resultat;
        }
    }

    /**
     * Effectue la suite logique avec un StringBuffer
     * @StringBuffer Le StringBuffer est un objet permettant la construction de chaines de caractères.
     * Il possède, en outre, une méthode 'append' à cette fin.
     * Cet objet est synchronisé et thread-safe.
     * Il est donc plus sécurisé.
     * @param profondeur
     *            : Profondeur de la suite
     */
    public static void testStringBuffer(int profondeur, boolean afficherValeurs) {
        StringBuffer valeur = new StringBuffer("1");
        StringBuffer resultat;
        int longeurValeur;
        char lettre;
        int compteurLettre;

        for (int i = 0; i < profondeur; i++) {
            resultat = new StringBuffer();
            longeurValeur = valeur.length();
            lettre = ' ';
            compteurLettre = 0;

            for (int indiceLettre = 0; indiceLettre < longeurValeur; indiceLettre++) {
                if (valeur.charAt(indiceLettre) != lettre) {
                    if (compteurLettre > 0) {
                        resultat.append(compteurLettre);
                        resultat.append(lettre);
                    }
                    lettre = valeur.charAt(indiceLettre);
                    compteurLettre = 1;
                } else {
                    compteurLettre++;
                }
            }

            if (compteurLettre > 0) {
                resultat.append(compteurLettre);
                resultat.append(lettre);
            }
            if (afficherValeurs) {
                System.out.print(resultat);
            }
            valeur = resultat;
        }
    }

    /**
     * Effectue la suite logique avec un type StringBuilder
     * @StringBuilder Le StringBuilder est un objet permettant la construction de chaines de caractères.
     * Il possède, en outre, une méthode 'append' à cette fin.
     * Cet objet n'est pas synchronisé et n'est pas thread-safe.
     * Il est donc un peu plus rapide que le StringBuffer mais est moins sécurisé.
     * @param profondeur
     *            : Profondeur de la suite
     */
    public static void testStringBuilder(int profondeur, boolean afficherValeurs) {
        StringBuilder valeur = new StringBuilder("1");
        StringBuilder resultat;
        int longeurValeur;
        char lettre;
        int compteurLettre;

        for (int i = 0; i < profondeur; i++) {
            resultat = new StringBuilder();
            longeurValeur = valeur.length();
            lettre = ' ';
            compteurLettre = 0;

            for (int indiceLettre = 0; indiceLettre < longeurValeur; indiceLettre++) {
                if (valeur.charAt(indiceLettre) != lettre) {
                    if (compteurLettre > 0) {
                        resultat.append(compteurLettre);
                        resultat.append(lettre);
                    }
                    lettre = valeur.charAt(indiceLettre);
                    compteurLettre = 1;
                } else {
                    compteurLettre++;
                }
            }

            if (compteurLettre > 0) {
                resultat.append(compteurLettre);
                resultat.append(lettre);
            }

            if (afficherValeurs) {
                System.out.print(resultat);
            }
            valeur = resultat;
        }
    }
}
