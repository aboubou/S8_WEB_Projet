/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateurs.modeles;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Alexandre
 */
@Entity
public class Abonnement implements Serializable {
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /* Description de l'abonnement */
    private String m_Description;
    /* Durée */
    private int m_Duree;
    /* Prix */
    private double m_Prix;

   /**
     * Constructeur par defaut
     */
    public Abonnement() {}
    
    public Abonnement(String description, int duree, double prix){
        this.m_Description = description;
        this.m_Duree = duree;
        this.m_Prix = prix;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return m_Description;
    }

    public void setDescription(String m_Description) {
        this.m_Description = m_Description;
    }

    public int getDuree() {
        return m_Duree;
    }

    public void setDuree(int m_Duree) {
        this.m_Duree = m_Duree;
    }

    public double getPrix() {
        return m_Prix;
    }

    public void setPrix(double m_Prix) {
        this.m_Prix = m_Prix;
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
        if (!(object instanceof Abonnement)) {
            return false;
        }
        Abonnement other = (Abonnement) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilisateurs.modeles.Abonnement[ id=" + id + " ]";
    }
    
}
