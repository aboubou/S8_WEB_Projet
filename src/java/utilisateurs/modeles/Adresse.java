/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateurs.modeles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Alexandre
 */
@Entity
public class Adresse implements Serializable {
    
      
    private static final long serialVersionUID = 1L;  
    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private int id;  
    @NotNull
    private String rue;
    @NotNull @Size(min=1)  
    private String ville;  
    @Pattern(regexp="[0-9]{5}") // On accepte les codes postaux du type "06410"  
    private String codePostal;  
    @OneToMany(mappedBy = "adresse")
    private List<Utilisateur> m_Utilisateurs = new ArrayList<>();
  
    
    /**
     * Constructeur par defaut
     */
    public Adresse() {}  
      
    /**
     * Constructeur normal
     * @param rue : rue de l'utilisateur (Ex : 25 Rue de la Paix)
     * @param ville : Ville de l'utilisateur (Ex : Paris)
     * @param codePostal : Code postal de la ville indiquee (Ex: 7500)
     */
    public Adresse(String rue, String ville, String codePostal) {  
        this.ville = ville;  
        this.codePostal = codePostal;
        this.rue = rue; 
    }  

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Accesseur de modification de la ville
     * @param ville : la ville a modifier
     */
    public void setVille(String ville) {
        this.ville = ville;
    }
    

    public String getVille() {
       return this.ville;
    }

    /**
     * Accesseur de consultation du code postal de la ville
     * @return : le code postal de la ville
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * Accesseur de modification du code postal de la ville
     * @param codePostal : le code postal de ville a modifier
     */
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * Methode permettant d'ajouter un utilisateur a cette adresse
     * @param u : l'utilisateur qui habite a cette adresse
     */
    public void addUtilisateur(Utilisateur u){
        m_Utilisateurs.add(u);
    }
    
    /**
     * Methode permettant de supprimer un utilisateur a cette adresse
     * @param u : l'utilisateur qui n'habite plus a cette adresse
     */
    public void removeUtilisateur(Utilisateur u){
        m_Utilisateurs.remove(u);
    }
    
    /**
     * Accesseur de consultation de la liste des utilisateurs habitant a cette adresse
     * @return : la liste d'utilisateur habitant a cette adresse
     */
    public List<Utilisateur> getUtilisateurs(){
        return m_Utilisateurs;
    }

    /**
     * Accesseur de consultation de la cle primaire de cette adresse
     * @return : la cle primaire
     */
    public int getId() {
        return id;
    }

    /**
     * Accesseur de consultation de la rue ou habite l'utilisateur
     * @return : la rue ou habite l'utilisateur
     */
    public String getRue() {
        return rue;
    }

    /** 
     * Accesseur de modifacation de la rue ou habite l'utilisateur
     * @param m_Rue : la nouvelle rue ou habite l'utilisateur
     */
    public void setRue(String rue) {
        this.rue = rue;
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
        if (!(object instanceof Adresse)) {
            return false;
        }
        Adresse other = (Adresse) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilisateurs.modeles.Adresse[ id=" + id + " ]";
    }
    
}
