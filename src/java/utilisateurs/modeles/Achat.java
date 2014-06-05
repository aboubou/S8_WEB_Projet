/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateurs.modeles;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Alexandre
 */
@Entity
public class Achat implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /* identifiant de la musique achetée */
    private int musique;
    /* identifiant de l'acheteur */
    private int acheteur;
    /* date d'achat*/
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAchat;

    
    public Achat(){}
    
    public Achat(int musique, int acheteur){
        this.dateAchat = new Date();
        this.musique = musique;
        this.acheteur = acheteur;
    }
    
    public Achat(int musique, int acheteur, Date date){
        this.dateAchat = date;
        this.musique = musique;
        this.acheteur = acheteur;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMusique() {
        return musique;
    }

    public void setMusique(int musique) {
        this.musique = musique;
    }

    public int getAcheteur() {
        return acheteur;
    }

    public void setAcheteur(int acheteur) {
        this.acheteur = acheteur;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
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
        if (!(object instanceof Achat)) {
            return false;
        }
        Achat other = (Achat) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilisateurs.modeles.Achat[ id=" + id + " ]";
    }
    
}
