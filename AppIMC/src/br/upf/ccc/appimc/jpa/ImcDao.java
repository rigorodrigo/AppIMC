/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.upf.ccc.appimc.jpa;
import br.upf.ccc.appimc.model.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author rodri
 */
public class ImcDao {
    
     static EntityManagerFactory factory = Persistence.createEntityManagerFactory(
            "AppIMCPU");
     
     public List<Pessoa> getLista(){
        EntityManager em = factory.createEntityManager();
        try{
           return em.createQuery("select o from Pessoa o").getResultList();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
     
         public void salvar(Pessoa o) throws Exception{
        EntityManager em = factory.createEntityManager();
        try{
           em.getTransaction().begin();
           em.merge(o);
           em.getTransaction().commit();
        } catch (Exception e){
            throw e;
        } finally {
            em.close();
        }        
    }
         
         public void excluir(Pessoa o) throws Exception{
        EntityManager em = factory.createEntityManager();
        try{
           em.getTransaction().begin();
           em.remove( em.merge(o) );
           em.getTransaction().commit();
        } catch (Exception e){
            throw e;
        } finally {
            em.close();
        }        
    }
}
