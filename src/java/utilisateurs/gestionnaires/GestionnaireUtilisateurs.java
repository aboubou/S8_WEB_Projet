/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateurs.gestionnaires;

import java.util.ArrayList;
import java.util.Collection;  
import java.util.List;
import javax.ejb.Stateless;  
import javax.persistence.EntityManager;  
import javax.persistence.PersistenceContext;  
import javax.persistence.Query;  
import utilisateurs.modeles.Abonnement;
import utilisateurs.modeles.Utilisateur;
import utilisateurs.modeles.Adresse;
import utilisateurs.modeles.Instrument;
import utilisateurs.modeles.Musique;

/**
 *
 * @author Alexandre
 */
@Stateless
public class GestionnaireUtilisateurs {
    // Ici injection de code : on n'initialise pas. L'entity manager sera créé  
    // à partir du contenu de persistence.xml  
    @PersistenceContext  
    private EntityManager em;  
  
     public void creerUtilisateursDeTest() {
        // on crée des adresses et on les insère dans la base
        Adresse biot = new Adresse("1 Avenue Angus Young","Biot", "06410");  
        em.persist(biot);  
        Adresse valbonne = new Adresse("1 Avenue Slash", "Valbonne", "06560");  
        em.persist(valbonne);  
        Adresse nice = new Adresse("1 Avenue Jimi Hendrix","Nice", "06000");  
        em.persist(nice);
        
        // Note : après un persist, les objets sont connectés
        creeUtilisateur("Lennon","John", "jlennon", "jlennon", biot);  
        creeUtilisateur("Mac Cartney", "Paul", "pmc", "pmc", biot);  
        creeUtilisateur("Starr", "Ringo" , "rstarr", "rstarr", nice);  
        creeUtilisateur("Harisson", "Georges", "georgesH", "georgesH", valbonne);  
    }  
  
     public Utilisateur creeUtilisateur(String nom, String prenom, String login, String password) {  
        Utilisateur u = new Utilisateur(nom, prenom, login, password);
        em.persist(u);  
        return u;  
    }
     
    public Utilisateur creeUtilisateur(String nom, String prenom, String login, String password, Adresse a) {
        Utilisateur u = new Utilisateur(nom, prenom, login, password);
        // on met à jour la relation, elle est déjà en base
        u.setAdresse(a);
        
        // a est déjà en bas et connectée, donc la ligne suivante modifie les
        // données pour relier l'adresse à l'utilisateur
        //a.addUtilisateur(u);
        
        // on persiste l'utilisateur, la relation est déjà en base, cela va donc
        // ajouter une ligne dans la table des utilisateurs avec une clé étrangère
        // correspondant à l'adresse
        em.persist(u);  
        return u;  
    }
    
     public Utilisateur creerUtilisateur(String pseudo, String mdp, String nom, String prenom, String adresse, String ville, String codep, String mail, ArrayList<Instrument> instruments/* String[] instruments*/, String abonnement) {
        
        
        Adresse a = new Adresse(adresse, ville, codep);
        em.persist(a);
        
        Utilisateur u = new Utilisateur(pseudo, mdp, nom, prenom, mail);
        
        u.setAdresse(a);
        
        for(int i = 0; i < instruments.size(); i++){
            u.addInstrument(instruments.get(i));
        }
        
        /*for(int i = 0; i < instruments.length; i++)
            u.addInstrument(getInstrument(instruments[i]));*/
        u.setAbonnement(getAbonnement(abonnement));
        
        
        // a est déjà en bas et connectée, donc la ligne suivante modifie les
        // données pour relier l'adresse à l'utilisateur
        a.addUtilisateur(u);
        
        // on persiste l'utilisateur, la relation est déjà en base, cela va donc
        // ajouter une ligne dans la table des utilisateurs avec une clé étrangère
        // correspondant à l'adresse
        em.persist(u);

        return u;  
    }
     
     public Utilisateur creerUtilisateur(String pseudo, String mdp, String nom, String prenom, String adresse, String ville, String codep, String mail, ArrayList<Instrument> instruments, Abonnement abonnement) {
        
        
        Adresse a = new Adresse(adresse, ville, codep);
        em.persist(a);
        
        Utilisateur u = new Utilisateur(pseudo, mdp, nom, prenom, mail);
        
        u.setAdresse(a);
        
        for(int i = 0; i < instruments.size(); i++){
            u.addInstrument(instruments.get(i));
        }
        
        /*for(int i = 0; i < instruments.length; i++)
            u.addInstrument(getInstrument(instruments[i]));*/
        u.setAbonnement(abonnement);
        
        
        // a est déjà en bas et connectée, donc la ligne suivante modifie les
        // données pour relier l'adresse à l'utilisateur
        a.addUtilisateur(u);
        
        // on persiste l'utilisateur, la relation est déjà en base, cela va donc
        // ajouter une ligne dans la table des utilisateurs avec une clé étrangère
        // correspondant à l'adresse
        em.persist(u);

        return u;  
    }
  
     public Collection<Utilisateur> getAllUsers() {  
        // Exécution d'une requête équivalente à un select *  
        Query q = em.createQuery("select u from Utilisateur u");
        return q.getResultList();  
    } 
     
    /*public int getAllUsersTable(){
        Query q = em.createQuery("select u from Utili")
    }*/
     
    public Collection<Utilisateur> getAllUsers(int min, int max) {  
        // Exécution d'une requête équivalente à un select *  
        Query q = em.createQuery("select u from Utilisateur u");
        q.setFirstResult(min);
        q.setMaxResults(max);
        return q.getResultList();  
    }  
    // Add business logic below. (Right-click in editor and choose  
    // "Insert Code > Add Business Method")
    
    public Collection<Utilisateur> rechercheUser(String login, int min, int max){
        // Exécution de la requête équivalente à un select
        Query q = em.createQuery("select u from Utilisateur u where u.login = :login");
        q.setFirstResult(min);
        q.setMaxResults(max);
        q.setParameter("login", login);
        return q.getResultList();
    }
    
    public Collection<Utilisateur> rechercheUser(String login){
        // Exécution de la requête équivalente à un select
        Query q = em.createQuery("select u from Utilisateur u where u.login = :login");
        q.setParameter("login", login);
        return q.getResultList();
    }
    
    public int supprimerUtilisateur(String login){
        // Exécution de la requête de supression
        Query q = em.createQuery("delete from Utilisateur u where u.login = :login");
        q.setParameter("login", login);
        return q.executeUpdate();
    }
    
    public int updateUtilisateur(String login, String nom, String prenom){
        Query q = em.createQuery("update Utilisateur u set u.lastname = :nom, u.firstname = :prenom where u.login = :login");
        
        q.setParameter("nom", nom);
        q.setParameter("prenom", prenom);
        q.setParameter("login", login);
        return q.executeUpdate();
    }
    
    public Instrument getInstrument(String id){
        int idI =Integer.parseInt(id);
        Query q = em.createQuery("select i from Instrument i where i.id = :idi");
        q.setParameter("idi", idI);
        return (Instrument)q.getSingleResult(); 
    }
    
    public Abonnement getAbonnement(String id){
        int idA =Integer.parseInt(id);
        Query q = em.createQuery("select a from Abonnement a where a.id = :idA");
        q.setParameter("idA", idA);
        return (Abonnement)q.getSingleResult(); 
    }
    
   /*public Collection<Utilisateur> getUsersParVille(int idVille){
       Adresse a = em.find(Adresse.class, idVille);
       
       // a est connecté, le get va declencher un select
       return a.getUtilisateurs();
   }*/
    // Add business logic below. (Right-click in editor and choose  
    // "Insert Code > Add Business Method")  
    
    public boolean verfierExistence(String pseudo){
        Query q = em.createQuery("select u from Utilisateur u where u.login = :pseudo");
        q.setParameter("pseudo", pseudo);
        if(q.getResultList().size() < 1)
            return false;
        return true;
                
    }
    
    public Utilisateur getUtilisateurProfil(String login){
        Query q = em.createQuery("select u from Utilisateur u where u.login = :login");
        q.setParameter("login", login);
        return (Utilisateur)q.getSingleResult();
                
    }
    
     public Collection<Musique> getAllMusiques(){
        Query q = em.createQuery("select m from Musique m ");
        return q.getResultList();
                
    }
     
     public Musique getMusiqueParID(String id){
         int idI = Integer.parseInt(id);
        Query q = em.createQuery("select m from Musique m where m.id = :id");
        q.setParameter("id", idI);
        return (Musique)q.getSingleResult();
                
    }
}  
