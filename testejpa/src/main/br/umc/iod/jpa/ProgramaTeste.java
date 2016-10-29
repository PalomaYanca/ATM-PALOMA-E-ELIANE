package br.umc.iod.jpa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class ProgramaTeste {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minha-persistence-unit");
		
		EntityManager em = emf.createEntityManager();
		//consulta
		List<MinhaEntidade> lista = em.createQuery("FROM MinhaEntidade", MinhaEntidade.class).getResultList();
	  for (MinhaEntidade objeto : lista){
		  System.out.println("Objeto no banco: " + objeto.getNumero());
	  }
	  	MinhaEntidade objeto = new MinhaEntidade();
	  	objeto.setNumero(1234);
	  	
	  	
	  	//em.getTransaction().begin();
	  	//em.persist(objeto);//salva
	 // 	em.remove(objeto);//remove
	  	//em.merge(objeto); //atualiza
	  	
	  	
	  	
	  	//em.getTransaction().commit();
	  	
	  //	em.close();
	  //	emf.close();
	}

}
