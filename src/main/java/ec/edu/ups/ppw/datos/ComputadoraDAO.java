package ec.edu.ups.ppw.datos;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.ppw.modelo.Computadora;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Stateless
public class ComputadoraDAO implements Serializable{
	
	
	
	@PersistenceContext
	private EntityManager em;
	
	public void setEntityManager(EntityManager em) {
        this.em = em;
    	}
	
	
	public void insert(Computadora computadora) {
		em.persist(computadora);
	}
	
	
	public void update(Computadora computadora) {
		em.merge(computadora);
	}
	public Computadora read(int idComputadora) {
		Computadora c = em.find(Computadora.class, idComputadora);
		return c;
	}
	public void delete(int idComputadora) {
		Computadora c = em.find(Computadora.class, idComputadora);
		em.remove(c);
	}
	public List<Computadora> getAll(){
	String jpql = "SELECT c FROM Computadora c";
	Query q = em.createQuery(jpql);
	return q.getResultList();
	}

}
