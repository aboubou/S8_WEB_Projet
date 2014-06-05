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
    private int m_IdMusique;
    /* identifiant de l'acheteur */
    private int m_IdAcheteur;
    /* date d'achat*/
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date m_DateAchat;

    
    public Achat(){}
    
    public Achat(int musique, int acheteur, String date){
        this.m_DateAchat = new Date(date);
        this.m_IdMusique = musique;
        this.m_IdAcheteur = acheteur;
    }
    
    public Achat(int musique, int acheteur, Date date){
        this.m_DateAchat = date;
        this.m_IdMusique = musique;
        this.m_IdAcheteur = acheteur;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMusique() {
        return m_IdMusique;
    }

    public void setIdMusique(int m_IdMusique) {
        this.m_IdMusique = m_IdMusique;
    }

    public int getIdAcheteur() {
        return m_IdAcheteur;
    }

    public void setIdAcheteur(int m_IdAcheteur) {
        this.m_IdAcheteur = m_IdAcheteur;
    }

    public Date getDateAchat() {
        return m_DateAchat;
    }

    public void setDateAchat(Date m_DateAchat) {
        this.m_DateAchat = m_DateAchat;
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
