package Personne;


public abstract class Personne {
    //attributs
    int id;
    String nom;
    String email;
    String mdp;

    //constructeur
    public Personne(int id, String nom, String email, String mdp){
        this.id=id;
        this.nom=nom;
        this.email=email;
        this.mdp=mdp;
    }
    void inscription() {}

    void afficher() {}
}
