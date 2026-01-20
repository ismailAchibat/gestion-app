package org.example;

import fr.cours.info.tp.ferroviaire.cartographie.models.CheminDeFer;
import fr.cours.info.tp.ferroviaire.cartographie.models.Gare;
import fr.cours.info.tp.ferroviaire.cartographie.models.Voie;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // --- Scénario 1 ---

        // 1. Ajouter une nouvelle gare avec un quai
        Gare gareB = new Gare();
        gareB.setNom_gare("Gare B");
        gareB.setNb_quai(1);

        // 2. Associer un premier chemin de fer à une voie
        CheminDeFer cdf1 = new CheminDeFer();
        cdf1.ajouterVoie(new Voie());
        gareB.ajouterCheminDeFer(cdf1);

        // 3. Associer un deuxième chemin de fer à deux voies
        CheminDeFer cdf2 = new CheminDeFer();
        cdf2.ajouterVoie(new Voie());
        cdf2.ajouterVoie(new Voie());
        gareB.ajouterCheminDeFer(cdf2);

        // Vérification console
        System.out.println("Scénario 1 terminé pour : " + gareB.getNom_gare());
        System.out.println("Nombre de quais : " + gareB.getNb_quai());
    }
}
