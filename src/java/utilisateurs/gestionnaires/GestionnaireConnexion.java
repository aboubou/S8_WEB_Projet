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
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author Alexandre
 */
@Stateless
public class GestionnaireConnexion {

     // Ici injection de code : on n'initialise pas. L'entity manager sera créé  
    // à partir du contenu de persistence.xml  
    @PersistenceContext  
    private EntityManager em;
    
     public int identifierUtilisateur(String login, String password){
        Query q = em.createQuery("select u from Utilisateur u where u.login = :login and u.password = :password");
        q.setParameter("login", login);
        q.setParameter("password", password);
        return q.getResultList().size();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
