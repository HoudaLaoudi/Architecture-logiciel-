import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Copyrigh © ISII LAOUDI HOUDA
class Tache {
    private final String nom;  
    private boolean estTerminee; 
    
    public Tache(String nom) {
        this.nom = nom;
        this.estTerminee = false;
    }
    
    public String getNom() { return nom; }
    public boolean estTerminee() { return estTerminee; }
    public void marquerTerminee() { this.estTerminee = true; }
    
    @Override
    public String toString() {
        return nom + " - " + (estTerminee ? "✓ Terminée" : "◯ En cours");
    }
}

class GestionnaireTaches {
    private final List<Tache> taches; 
    
    public GestionnaireTaches() {
        this.taches  = new ArrayList<>();
        
    }
    
    public void ajouterTache(String nomTache) {
        taches.add(new Tache(nomTache));//Data abstraction
        System.out.println("✓ Tâche ajoutée : " + nomTache);
    }
    
  public void afficherTaches() {
    System.out.println("\n--- MES TÂCHES ---");
    for (int numeroTache = 0; numeroTache < taches.size(); numeroTache++) {
        System.out.println((numeroTache + 1) + ". " + taches.get(numeroTache));
    }
}
    // IMPORTANT: Cette opération est irréversible dans le contexte actuel
    public void marquerTacheTerminee(int index) {
        if (index >= 0 && index < taches.size()) {
            taches.get(index).marquerTerminee();
            System.out.println("✓ Tâche marquée comme terminée");
        }
    }
}


// Classe principale
public class CleanCode {
    public static void main(String[] args) {
        GestionnaireTaches gestionnaire = new GestionnaireTaches();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            afficherMenu(); //does one thing
            int choix = scanner.nextInt();
            scanner.nextLine(); // consommer le retour ligne
            
            switch (choix) {
                case 1:
                    System.out.print("Nom de la tâche : ");
                    String nomTache = scanner.nextLine();
                    gestionnaire.ajouterTache(nomTache); // does one thing
                    break;
                case 2:
                    gestionnaire.afficherTaches();
                    break;
                case 3:
                    System.out.print("Numéro de tâche à terminer : ");
                    int index = scanner.nextInt() - 1;
                    gestionnaire.marquerTacheTerminee(index);
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;
                default:
                    System.out.println("Option invalide");
            }
               
        }
    }
    
    private static void afficherMenu() {
        System.out.println("\n=== GESTIONNAIRE DE TÂCHES ===");
        System.out.println("1. Ajouter une tâche");
        System.out.println("2. Afficher les tâches");
        System.out.println("3. Marquer une tâche comme terminée");
        System.out.println("4. Quitter");
        System.out.print("Votre choix : ");
    }
}
