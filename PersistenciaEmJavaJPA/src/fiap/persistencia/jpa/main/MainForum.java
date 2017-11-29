package fiap.persistencia.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fiap.persistencia.jpa.Helper.ForumHelper;
import fiap.persistencia.jpa.modelo.Forum;
import fiap.persistencia.jpa.modelo.Usuario;

public class MainForum {
	public static void main(String[] args) {
	
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenciaEmJavaJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		ForumHelper dao = new ForumHelper(entityManager);
		Forum forum = new Forum(); forum.setAssunto("JPA"); 
		forum.setDescricao("Java Persistence API");
		System.out.println(dao.salvar(forum));
		
		Usuario usuario = new Usuario(); 
		usuario.setNome("Joaquim"); 
		usuario.setEmail("joaquim@fiap.com.br");
		System.out.println(dao.adicionarUsuario(forum.getId(), usuario));
		
		entityManager.close();
		entityManagerFactory.close();
	} 
}

