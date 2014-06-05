/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateurs.gestionnaires;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;  
import java.util.Date;
import java.util.List;
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
     
    public boolean verifierAbonnement(Date date, String paramLog){
        Query q = em.createQuery("select u.abonnement.duree, u.dateAbo from  Utilisateur u where u.login = :paramLog");
        q.setParameter("paramLog", paramLog);
        List result = q.getResultList();
        
        Date dateAbo = new Date();
        float duree=0;
        for(Object lignes : result){
            Object[] ligne = (Object[])lignes ;
            
            dateAbo = (Date)ligne[1];
            duree = (float)ligne[0];
        }
        /*ResultSet result = (ResultSet)q.getSingleResult(); q.
        Date dateAbo = result.getDate("dateAbo");
        int duree = result.getInt("duree");*/
        
        if((date.getTime() - dateAbo.getTime()) > (duree*24*60*60*1000)){
            return false;
        }
        return true;
        /*if(result.size()!=0)
            return false;
        
        return true;*/
        
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
