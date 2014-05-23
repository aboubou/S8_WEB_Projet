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
public class Musique implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /* titre */
    private String m_Titre;
    /* artiste */
    private String m_Artiste;
    /* Prix */
    private double m_Prix;
    /* instrument */
    private Instrument m_Instrument;
    /* Style */
    private String m_Style;
    /* Année */
    private int m_Annee;
    /* Difficultés */
    private int m_Difficulte;
    
    public Musique(){}
    
    public Musique(String titre, String artiste, double prix, Instrument instru, String style, int annee, int difficulte){
        this.m_Titre = titre;
        this.m_Artiste = artiste;
        this.m_Prix = prix;
        this.m_Instrument = instru;
        this.m_Style = style;
        this.m_Annee = annee;
        this.m_Difficulte = difficulte;
    }

    public String getTitre() {
        return m_Titre;
    }

    public void setTitre(String m_Titre) {
        this.m_Titre = m_Titre;
    }

    public String getArtiste() {
        return m_Artiste;
    }

    public void setArtiste(String m_Artiste) {
        this.m_Artiste = m_Artiste;
    }

    public double getPrix() {
        return m_Prix;
    }

    public void setPrix(double m_Prix) {
        this.m_Prix = m_Prix;
    }

    public Instrument getInstrument() {
        return m_Instrument;
    }

    public void setInstrument(Instrument m_Instrument) {
        this.m_Instrument = m_Instrument;
    }

    public String getStyle() {
        return m_Style;
    }

    public void setStyle(String m_Style) {
        this.m_Style = m_Style;
    }

    public int getAnnee() {
        return m_Annee;
    }

    public void setAnnee(int m_Annee) {
        this.m_Annee = m_Annee;
    }

    public int getDifficulte() {
        return m_Difficulte;
    }

    public void setDifficulte(int m_Difficulte) {
        this.m_Difficulte = m_Difficulte;
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
        if (!(object instanceof Musique)) {
            return false;
        }
        Musique other = (Musique) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilisateurs.modeles.Musique[ id=" + id + " ]";
    }
    
}
