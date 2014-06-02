/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateurs.gestionnaires;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modeles.Instrument;

/**
 *
 * @author Alexandre
 */
@Stateless
public class GestionnaireInstrument {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext  
    private EntityManager em;
    
    public Instrument getInstrument(String id){
        int idI = Integer.parseInt(id);
        
        Query q = em.createQuery("select i from Instrument i where i.id = :idi");
        q.setParameter("idi", idI);
        return (Instrument)q.getSingleResult(); 
    }
}
