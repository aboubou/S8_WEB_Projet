/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateurs.gestionnaires;

import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateurs.modeles.Instrument;
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
        Query q = em.createQuery("select m from Musique m where m.artiste = :artiste order by m.titre ASC");
        q.setParameter("artiste", artiste);
        return q.getResultList();
    }
    
     public Collection<Musique> getStyles(){
        Query q = em.createQuery("select distinct m.style from Musique m order by m.style asc ");
        return q.getResultList();
    }
     
    public Collection<Musique> getMusiqueParStyle(String style){
        Query q = em.createQuery("select m from Musique m where m.style = :style order by m.titre,m.artiste asc ");
        q.setParameter("style", style);
        return q.getResultList();
    }
    
    public Collection<Musique> getAllAnnees(){
        Query q = em.createQuery("select distinct m.annee from Musique m order by m.annee asc");
        return q.getResultList();
    }
    
    public Collection<Instrument> getAllInstruments(){
        Query q = em.createQuery("select distinct i.instrument from Instrument i order by i.instrument asc");
        return q.getResultList();
    }
    
    public Collection<Musique> getMusiqueParAnnee(String annee){
        int an = Integer.parseInt(annee);
        Query q = em.createQuery("select m from Musique m where m.annee = :annee order by m.titre,m.artiste asc ");
        q.setParameter("annee", an);
        return q.getResultList();
    }
    
    public Collection<Musique> getMusiqueParInstrument(String instru){
        Query q = em.createQuery("select m from Musique m where m.instrument.instrument = :instrument order by m.titre,m.artiste");
        q.setParameter("instrument", instru);
        return q.getResultList();
    }
    
    public Collection<Musique> getAllMusiques(){
        Query q = em.createQuery("select m from Musique m ");
        return q.getResultList();
    }
    
    public Collection<Musique> getTroisMusique(){
        //Query q = em.createQuery("select m from Musique m where m.titre ='Always' and  m.titre='The Day That Never Comes' and  m.titre='Question!' and m.instrument.instrument='Basse'");
        Query q = em.createQuery("select m from Musique m where m.titre = :titre");
        q.setParameter("titre", "Voodoo Child");
        return  q.getResultList(); 
    }
}
