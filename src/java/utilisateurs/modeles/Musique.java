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
    private String titre;
    /* artiste */
    private String artiste;
    /* instrument */
    private Instrument instrument;
    /* Prix */
    private int piste;
    /* Année */
    private int annee;
    /* Difficultés */
    private int difficulte;
    
    private String style;
    
    public Musique(){}
    
    public Musique(String titre, String artiste, int piste, Instrument instru, String style, int annee, int difficulte){
        this.titre = titre;
        this.artiste = artiste;
        this.piste = piste;
        this.instrument = instru;
        this.annee = annee;
        this.difficulte = difficulte;
        this.style = style;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public int getPiste() {
        return piste;
    }

    public void setPiste(int piste) {
        this.piste = piste;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }
    
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
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
