package controlador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.internal.libraries.asm.commons.StaticInitMerger;

import modelo.Ciudad;
import modelo.Registro;
import vista.CiudadVista;

public class CiudadControlador {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Climat");
	EntityManager entityManager =emf.createEntityManager();
	
	public List<Ciudad> listarCiudades() {
		Query query = entityManager.createNativeQuery("select * from ciudad",Ciudad.class);
		List<Ciudad> lista = query.getResultList();
		System.out.println(lista);
		return lista;
	}
	
	public Boolean ciudad (Ciudad c) {
		int cont=0;
		try {
			entityManager =emf.createEntityManager();
			entityManager.getEntityManagerFactory().getCache().evictAll();
			Ciudad ciu = new Ciudad();
			ciu =c;
			entityManager.persist(ciu);
		}catch(NoResultException e) {
			entityManager.close();
		}
		return true;
	}
	
}	



