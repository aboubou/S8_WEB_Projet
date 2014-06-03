/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateurs.gestionnaires;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modeles.Musique;

/**
 *
 * @author Alexandre
 */
@Stateless
public class GestionnaireRecherche {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    
    public Collection<Musique> getMusiqueParTitre(String titre){
        Query q = em.createQuery("select m from Musique m where m.titre = :titre");
        q.setParameter("titre", titre);
        return q.getResultList();
    }
    
    public Collection<Musique> getMusiqueParArtiste(String artiste){
        Query q = em.createQuery("select m from Musique m where m.titre = :artiste order by m.titre ASC");
        q.setParameter("artiste", artiste);
        return q.getResultList();
    }
    
     public Collection<String> getStyles(){
        Query q = em.createQuery("select m from Musique m order by m.style ASC");
        return q.getResultList();
    }
}
