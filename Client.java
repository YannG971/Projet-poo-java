package Personne;

import ConnexionBDD.ConnexionBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Client {
    //attributs
    int id;
    String nom;
    String email;
    String mdp;

    //partie connexion bdd
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Projet ";
    static final String USER = "root"; //differe d'un oridnateur à un autre
    static final String PASS = "";


    //constructeur
    public Client(String nom, String email, String mdp){
        this.nom=nom;
        this.email=email;
        this.mdp=mdp;
    }
    public void inscription(){
        // Connexion à la BDD
        ConnexionBDD connexionBDD = new ConnexionBDD();
        connexionBDD.connexion();

        // Ajouter le médecin à la base de données
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO Clients (nom,email,mdp) VALUES (?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,nom);
            statement.setString(2,email);
            statement.setString(3,mdp);
            statement.executeUpdate();
            System.out.println("Client ajouté avec succès !");
            statement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

}
