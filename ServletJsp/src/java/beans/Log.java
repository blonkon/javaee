/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author terlo
 */
public class Log {
    private String pseudo;
    private String mot_de_passe;
    //constructor
    public Log(String pseudo,String mot_de_passe){
        this.pseudo=pseudo;
        this.mot_de_passe=mot_de_passe;
    }
    //getters
    public String getPseudo(){
        return this.pseudo;
    }
    public String getMotDePasse(){
        return this.mot_de_passe;
    }
    //setters
    public void setPseudo(String pseudo){
        this.pseudo=pseudo;
    }
    public void setMotDePasse(String mot_de_passe){
        this.mot_de_passe=mot_de_passe;
    }
}
