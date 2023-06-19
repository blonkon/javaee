/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import moi.Infos;
/**
 *
 * @author diak.ibrahim
 */
public class Database {
    private Connection connexion;
    private Statement statement;
    private ResultSet resultat;
    private final String url;
    private final String username;
    private final String password;
    
    //private Users user = new Users();
     
     // valeur par defaut du constructeur
     /* url="jdbc:mysql://localhost:3310/javaee";
        username="root";
        password="";
     */
     // constructeur de ma classe database
     
    public Database(String url, String username, String password){
            this.connexion =null;
            this.statement=null;
            this.resultat=null;
            this.url=url;
            this.username=username;
            this.password=password;
     }
     
     // fonction load pour se connecter a la database
    public String load(){
         
         try {
             try {
                 Class.forName("com.mysql.cj.jdbc.Driver");
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
             }
             this.connexion = DriverManager.getConnection(url,username,password);
         } catch (SQLException e) {
             return e.getMessage(); 
         }
         return null;
     }
     
     //fonction pour ajouter un utilisateur a la base de donnee
    public boolean addUser(Users user) {
    try {
        String query = "INSERT INTO personne (nom, prenom, pseudo, mot_de_passe, email) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = this.connexion.prepareStatement(query);
        //Nous avons utiliser des requete prepare pour pouvoir passer des variables en parametres
        preparedStatement.setString(1, user.getNom());
        preparedStatement.setString(2, user.getPrenom());
        preparedStatement.setString(3, user.getPseudo());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getEmail());

        preparedStatement.executeUpdate();
        return true;
    } catch (SQLException e) {
        return false;
    }
}
    //fonction pour verifier que une pseudo est unique retourne faux si aucun pseudo ná ete trouve
    public boolean checkPseudo(String pseudo){
        String test=null;
    try{
        String queryy="Select pseudo from personne where personne.pseudo=?";
        PreparedStatement preparedStatementt = this.connexion.prepareStatement(queryy);
        preparedStatementt.setString(1, pseudo);
        this.resultat = preparedStatementt.executeQuery();
        resultat.next();
        test = resultat.getString("pseudo");
    }catch(SQLException e){}
    
         return test != null;
    }
    
    //Fonction pour la verification de login retourne vrai si  log correspondant
    public boolean checkLog(Log log){
     String test=null;
    try{
        String queryyy="Select mot_de_passe from personne where personne.mot_de_passe=?";
        PreparedStatement preparedStatementtt = this.connexion.prepareStatement(queryyy);
        preparedStatementtt.setString(1, log.getMotDePasse());
        this.resultat = preparedStatementtt.executeQuery();
        resultat.next();
        test = resultat.getString("mot_de_passe");
    }catch(SQLException e){}
    
    if(test==null){return false;}else{
         return checkPseudo(log.getPseudo())==true;
    }
    }
    
    public void closeDatabase(){try {
        this.connexion.close();
         } catch (SQLException ex) {
             Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         }
}
    
    //fonction cense fournir la liste des elements de la database
    
    public void userList(List<Infos> liste){
            
            
         try {
             statement = connexion.createStatement();
             resultat = statement.executeQuery("select nom,prenom from personne");
            while(resultat.next()){
            Infos user = new Infos(resultat.getString("prenom"),resultat.getString("nom"));
            //petite test pour verifier que les information ne sont pas null
            liste.add(user);
            }
         } catch (SQLException ex) {
             Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
             //resultat.next();
             //String Nom = resultat.getString("nom");
             //return Nom;
    
        
}
