/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateurs.modeles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Alexandre
 */
@Entity
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; 
    private String login;
    private String password;
    private String firstname;  
    private String lastname;  
    private String mail;
    @ManyToOne
    private Adresse adresse;
    //@OneToOne
    private Abonnement abonnement;
    //@OneToMany(mappedBy = "utilisateur")
    private List<Instrument> instruments = new ArrayList<Instrument>();

    //@OneToMany(mappedBy = "utilisateur")
    private List<Achat> achats = new ArrayList<Achat>();
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAbo;
    
    public Utilisateur() {  
    }  
  
    public Utilisateur(final String lastname, final String firstname, final String login, final String password) {  
        this.login = login;  
        this.lastname = lastname;  
        this.firstname = firstname;
        this.password = password;
    }
    
    public Utilisateur(final String pseudo, final String mdp, final String nom, final String prenom, final String mail) {  
        this.login = pseudo;
        this.password = mdp;
        this.lastname = nom;  
        this.firstname = prenom;
        this.mail = mail;
        this.dateAbo = new Date();

        
    } 
    
    public Utilisateur(String log, String mdp, String nom, String prenom, Adresse a, String mail, List<Instrument> instru, Abonnement abo ){
        this.login = log;
        this.password = mdp;
        this.lastname = nom;  
        this.firstname = prenom;
        this.mail = mail;
        this.adresse = a;
        this.dateAbo = new Date();
        this.instruments = instru;
        this.abonnement = abo;
        
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getMail(){
        return mail;
    }
    
    public void setMail(String mail){
        this.mail = mail;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    
     public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }
    
    public List<Achat> getAchats() {
        return achats;
    }

    public void setAchats(List<Achat> achats) {
        this.achats = achats;
    }
    
     public Date getDateAbo() {
        return dateAbo;
    }

    public void setDateAbo(Date dateAbo) {
        this.dateAbo = dateAbo;
    }
    
     /*public ArrayList<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(ArrayList<Instrument> instruments) {
        this.instruments = instruments;
    }*/
    
    public void addInstrument(Instrument instrument) {
        this.instruments.add(instrument);
    }
    
    public void addAchat(Achat achat) {
        this.achats.add(achat);
    }
    
    public void removeInstrument(Instrument instrument) {
        this.instruments.remove(instrument);
    }
    
     public Abonnement getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilisateurs.modeles.Utilisateur[ id=" + id + " ]";
    }
    
}
