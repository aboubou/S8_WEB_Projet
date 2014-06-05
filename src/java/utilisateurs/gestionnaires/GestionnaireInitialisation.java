/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateurs.gestionnaires;

import java.util.ArrayList;
import java.util.Collection;  
import java.util.Date;
import javax.ejb.Stateless;  
import javax.persistence.EntityManager;  
import javax.persistence.PersistenceContext;  
import javax.persistence.Query;
import utilisateurs.modeles.Adresse;
import utilisateurs.modeles.Instrument;
import utilisateurs.modeles.Abonnement;
import utilisateurs.modeles.Musique;
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author Alexandre
 */
@Stateless
public class GestionnaireInitialisation {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    // Ici injection de code : on n'initialise pas. L'entity manager sera créé  
    // à partir du contenu de persistence.xml  
    @PersistenceContext  
    private EntityManager em; 
    
    public void initialiserBD() {
        
         // --- Création des instruments
         //
         Instrument guitare = new Instrument("Guitare");  
         em.persist(guitare);
         Instrument guitareSolo = new Instrument("Guitare solo");  
         em.persist(guitareSolo);
         Instrument basse = new Instrument("Basse");  
         em.persist(basse);
         Instrument chant = new Instrument("Chant");
         em.persist(chant);
         Instrument batterie = new Instrument("Batterie");
         em.persist(batterie);
         
         // --- Craétion des abonnements
         //
         Abonnement mois = new Abonnement("Abonnement d'un mois", 30, 15);
         em.persist(mois);
         Abonnement an = new Abonnement("Abonnement d'un an", 365, 150);
         em.persist(an);
         Abonnement vie = new Abonnement("Abonnement à vie", 36500 , 3500);
         em.persist(vie);
         
         // --- Création des musiques
         //
         Musique hth_1 = new Musique("Highway To Hell", "AC-DC", 1, guitare, "Hard-Rock", 1979, 3);
         em.persist(hth_1);
         Musique hth_2 = new Musique("Highway To Hell", "AC-DC", 2, guitareSolo, "Hard-Rock", 1979, 4);
         em.persist(hth_2);
         Musique hth_3 = new Musique("Highway To Hell", "AC-DC", 3, basse, "Hard-Rock", 1979, 2);
         em.persist(hth_3);
         Musique hth_4 = new Musique("Highway To Hell", "AC-DC", 4, batterie, "Hard-Rock", 1979, 2);
         em.persist(hth_4);
         Musique hth_5 = new Musique("Highway To Hell", "AC-DC", 5, chant, "Hard-Rock", 1979, 4);
         em.persist(hth_5);
         
         Musique hb_1 = new Musique("Hell's Bells", "AC-DC", 1, guitare, "Hard-Rock", 1980, 3);
         em.persist(hb_1);
         Musique hb_2 = new Musique("Hell's Bells", "AC-DC", 2, guitareSolo, "Hard-Rock", 1980, 3);
         em.persist(hb_2);
         Musique hb_3 = new Musique("Hell's Bells", "AC-DC", 3, basse, "Hard-Rock", 1980, 2);
         em.persist(hb_3);
         Musique hb_4 = new Musique("Hell's Bells", "AC-DC", 4, batterie, "Hard-Rock", 1980, 2);
         em.persist(hb_4);
         Musique hb_5 = new Musique("Hell's Bells", "AC-DC", 5, chant, "Hard-Rock", 1980, 3);
         em.persist(hb_5);
         
         Musique bb_1 = new Musique("Back In Black", "AC-DC", 1, guitare, "Hard-Rock", 1980, 3);
         em.persist(bb_1);
         Musique bb_2 = new Musique("Back In Black", "AC-DC", 2, guitareSolo, "Hard-Rock", 1980, 3);
         em.persist(bb_2);
         Musique bb_3 = new Musique("Back In Black", "AC-DC", 3, basse, "Hard-Rock", 1980, 2);
         em.persist(bb_3);
         Musique bb_4 = new Musique("Back In Black", "AC-DC", 4, batterie, "Hard-Rock", 1980, 2);
         em.persist(bb_4);
         Musique bb_5 = new Musique("Back In Black", "AC-DC", 5, chant, "Hard-Rock", 1980, 4);
         em.persist(bb_5);
         
         Musique ltbr_1 = new Musique("Let There Be Rock", "AC-DC", 1, guitare, "Hard-Rock", 1980, 5);
         em.persist(ltbr_1);
         Musique ltbr_2 = new Musique("Let There Be Rock", "AC-DC", 2, basse, "Hard-Rock", 1980, 2);
         em.persist(ltbr_2);
         Musique ltbr_3 = new Musique("Let There Be Rock", "AC-DC", 3, batterie, "Hard-Rock", 1980, 4);
         em.persist(ltbr_3);
         Musique ltbr_4 = new Musique("Let There Be Rockk", "AC-DC", 4, chant, "Hard-Rock", 1980, 3);
         em.persist(ltbr_4);
         
         Musique vc_1 = new Musique("Voodoo Child", "Jimi Hendrix", 1, guitare, "Rock psychédélique", 1968, 5);
         em.persist(vc_1);
         Musique vc_2 = new Musique("Voodoo Child", "Jimi Hendrix", 2, batterie, "Rock psychédélique", 1968, 2);
         em.persist(vc_2);
         Musique vc_3 = new Musique("Voodoo Child", "Jimi Hendrix", 3, chant, "Rock psychédélique", 1968, 2);
         em.persist(vc_3);
         
         Musique caya_1 = new Musique("Come As You Are", "Nirvana", 1, guitare, "Grunge", 1991, 1);
         em.persist(caya_1);
         Musique caya_2 = new Musique("Come As You Are", "Nirvana", 2, batterie, "Grunge", 1991, 2);
         em.persist(caya_2);
         Musique caya_3 = new Musique("Come As You Are", "Nirvana", 3, guitareSolo, "Grunge", 1991, 2);
         em.persist(caya_3);
         Musique caya_4 = new Musique("Come As You Are", "Nirvana", 4, chant, "Grunge", 1991, 1);
         em.persist(caya_4);
         
         Musique slts_1 = new Musique("Smells Like Teen Spirit", "Nirvana", 1, guitare, "Grunge", 1991, 3);
         em.persist(slts_1);
         Musique slts_2 = new Musique("Smells Like Teen Spirit", "Nirvana", 2, batterie, "Grunge", 1991, 3);
         em.persist(slts_2);
         Musique slts_3 = new Musique("Smells Like Teen Spirit", "Nirvana", 3, guitareSolo, "Grunge", 1991, 3);
         em.persist(slts_3);
         Musique slts_4 = new Musique("Smells Like Teen Spirit", "Nirvana", 4, chant, "Grunge", 1991, 1);
         em.persist(slts_4);
         
         Musique a_1 = new Musique("Always", "Blink-182", 1, guitare, "Punk", 2003, 3);
         em.persist(a_1);
         Musique a_2 = new Musique("Always", "Blink-182", 2, batterie, "Punk", 2003, 3);
         em.persist(a_2);
         Musique a_3 = new Musique("Always", "Blink-182", 3, chant, "Punk", 2003, 1);
         em.persist(a_3);
         
         Musique scom_1 = new Musique("Sweet Child O Mine", "Guns N' Roses", 1, guitare, "Hard-Rock", 1987, 4);
         em.persist(scom_1);
         Musique scom_2 = new Musique("Sweet Child O Mine", "Guns N' Roses", 2, guitareSolo, "Hard-Rock", 1987, 5);
         em.persist(scom_2);
         Musique scom_3 = new Musique("Sweet Child O Mine", "Guns N' Roses", 3, batterie, "Hard-Rock", 1987, 3);
         em.persist(scom_3);
         Musique scom_4 = new Musique("Sweet Child O Mine", "Guns N' Roses", 4, chant, "Hard-Rock", 1987, 2);
         em.persist(scom_4);
         
         Musique kohd_1 = new Musique("Knockin' on Heaven's Door", "Guns N' Roses", 1, guitare, "Hard-Rock", 1991, 4);
         em.persist(scom_1);
         Musique kohd_2 = new Musique("Knockin' on Heaven's Door", "Guns N' Roses", 2, guitareSolo, "Hard-Rock", 1991, 4);
         em.persist(kohd_2);
         Musique kohd_3 = new Musique("Knockin' on Heaven's Door", "Guns N' Roses", 3, batterie, "Hard-Rock", 1991, 3);
         em.persist(kohd_3);
         Musique kohd_4 = new Musique("Knockin' on Heaven's Door", "Guns N' Roses", 4, chant, "Hard-Rock", 1991, 3);
         em.persist(kohd_4);
         
         Musique cs_1 = new Musique("Chop Suey!", "System Of A Down", 1, guitare, "Metal", 2001, 4);
         em.persist(cs_1);
         Musique cs_2 = new Musique("Chop Suey!", "System Of A Down", 2, basse, "Metal", 2001, 4);
         em.persist(cs_2);
         Musique cs_3 = new Musique("Chop Suey!", "System Of A Down", 3, batterie, "Metal", 2001, 4);
         em.persist(cs_3);
         Musique cs_4 = new Musique("Chop Suey!", "System Of A Down", 4, chant, "Metal", 2001, 5);
         em.persist(cs_4);
         
         Musique q_1 = new Musique("Question!", "System Of A Down", 1, guitare, "Metal", 2005, 4);
         em.persist(q_1);
         Musique q_2 = new Musique("Question!", "System Of A Down", 2, basse, "Metal", 2005, 4);
         em.persist(q_2);
         Musique q_3 = new Musique("Question!", "System Of A Down", 3, batterie, "Metal", 2005, 4);
         em.persist(q_3);
         Musique q_4 = new Musique("Question!", "System Of A Down", 4, chant, "Metal", 2004, 3);
         em.persist(q_4);
         
         Musique es_1 = new Musique("Enter Sandman", "Metallica", 1, guitare, "Metal", 1991, 3);
         em.persist(es_1);
         Musique es_2 = new Musique("Enter Sandman", "Metallica", 2, basse, "Metal", 1991, 4);
         em.persist(es_2);
         Musique es_3 = new Musique("Enter Sandman", "Metallica", 3, batterie, "Metal", 1991, 3);
         em.persist(es_3);
         Musique es_4 = new Musique("Enter Sandman", "Metallica", 4, chant, "Metal", 1991, 2);
         em.persist(es_4);
         
         Musique tdtnc_1 = new Musique("The Day That Never Comes", "Metallica", 1, guitare, "Metal", 2008, 3);
         em.persist(tdtnc_1);
         Musique tdtnc_2 = new Musique("The Day That Never Comes", "Metallica", 2, guitareSolo, "Metal", 2008, 4);
         em.persist(tdtnc_2);
         Musique tdtnc_3 = new Musique("The Day That Never Comes", "Metallica", 3, basse, "Metal", 2008, 4);
         em.persist(tdtnc_3);
         Musique tdtnc_4 = new Musique("The Day That Never Comes", "Metallica", 4, batterie, "Metal", 2008, 3);
         em.persist(tdtnc_4);
         Musique tdtnc_5 = new Musique("The Day That Never Comes", "Metallica", 5, chant, "Metal", 2008, 2);
         em.persist(tdtnc_5);
         
         ArrayList<Instrument> instrud = new ArrayList();
         instrud.add(guitare);
         instrud.add(basse);
         
         Utilisateur admin = new Utilisateur("admin", "admin","admin", "admin", "1 rue de l'admin", "Admin", "99999", "admin@admin.com", instrud, vie);
         em.persist(admin);
         
        
       
         Utilisateur adminDesabo = new Utilisateur("ud", "ud","Utilisateur désabonné", "Utilisateur désabonné", "1 rue du désabonnement", "Desabonnement","99999", "desabonne@desabonne.com", instrud, mois );
         Date dateDesabo = new Date(1999, 12, 12);
         adminDesabo.setDateAbo(dateDesabo);
         em.persist(adminDesabo);

    }
    
    public Collection<Instrument> getAllInstrument(){
        Query q = em.createQuery("select i from Instrument i");
        return q.getResultList();  
    }
    
    public Collection<Abonnement> getAllAbonnement(){
        Query q = em.createQuery("select a from Abonnement a");
        return q.getResultList(); 
    }
    
     public Collection<Musique> getTroisMusique(){
        Query q = em.createQuery("select m from Musique where m.titre ='Always' and  m.titre='The Day That Never Comes' and  m.titre='Question!' and m.instrument.instrument='basse'");
        return q.getResultList(); 
    }
    
}
