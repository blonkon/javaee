/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moi;

/**
 *
 * @author diak.ibrahim
 */
public class Infos {
    private String prenom;
    private String nom;
    //constructeur
    public Infos(){
        this.prenom=null;
        this.nom=null;
    }
    public Infos(String prenom,String nom){
        this.prenom=prenom;
        this.nom=nom;
    }
    //setters
    public void setPrenom(String prenom){
        this.prenom=prenom;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    //getters
    public String getPrenom(){
    return this.prenom;
    }
    public String getNom(){
    return this.nom;
    }
}
