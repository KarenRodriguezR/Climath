package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import modelo.Ciudad;
import modelo.Registro;

public class RegistroControlador {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Climat");
	EntityManager em = emf.createEntityManager();

	public int auto() {
		int maximo=0;	
			TypedQuery<Registro> query = em.createQuery("select t from Registro t",Registro.class);
			List<Registro> lista = query.getResultList();
			for(Registro t:lista) {
				maximo=t.getIdregistro();				
			}
		return maximo;
	}
	
	public boolean create(int codigo,Registro muestra) {
		String cod= String.valueOf(codigo);
		EntityManager em = emf.createEntityManager();
		Ciudad city = new Ciudad();
		city=em.find(Ciudad.class,codigo);
		System.out.println(city.getNombre());
		Registro Ob= muestra;
		Ob.setCiudad(city);
		int Maxid=auto()+1;
		Ob.setIdregistro(Maxid);
		try {
		em.getTransaction().begin();
		em.persist(Ob);
		em.getTransaction().commit();
		} catch (Exception e) {
	        e.printStackTrace();
	   }finally {
		   em.close();
	   }
		return true;
	}
}

	

