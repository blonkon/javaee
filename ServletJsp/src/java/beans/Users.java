/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author diak.ibrahim
 */
public class Users {
    private String nom;
    private String prenom;
    private String pseudo;
    private String password;
    private String email;
    //constructeur
    public Users(){
            this.nom = null;
            this.prenom = null;
            this.pseudo = null;
            this.password = null;
            this.email = null;
    } 
    //getters
    public String getNom(){
        return this.nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public String getPseudo(){
        return this.pseudo;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }
    //setters
    public void setNom(String nom){
        this.nom=nom;
    }
    public void setPrenom(String prenom){
        this.prenom=prenom;
    }
    public void setPseudo(String pseudo){
        this.pseudo=pseudo;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setEmail(String email){
        this.email=email;
    }
}
