package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import Model.JPAUtil;
import Model.Usuario;
import interfaces.Operations;

public class UsuarioDAO implements Operations<Usuario>{
	
	//Realiza conexão com o MySQL
	EntityManagerFactory emf;
	
	//Realizar as operações de CRUD
	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	
	//Metodo para cadastrar Usuarios
	@Override
	public String addUser(Usuario user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		JPAUtil.shutdown();
		return "Usuario cadastrado!";
	}

	//Metodo para Editar Usuarios
	@Override
	public String editUser(Usuario user) {
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		JPAUtil.shutdown();
		return "Usuario Editado com sucesso!";
	}
	
	//Metodo para Buscar Usuarios
	@Override
	public Usuario searchUser(int idUser) {
		Usuario user = new Usuario();
		user = em.find(Usuario.class, idUser);
		JPAUtil.shutdown();
		return user;
	}
	
	//Metodo para Listar todos os Usuarios
	@Override
	public List<Usuario> obeterUsuarios() {
		List<Usuario> listUser = new ArrayList<>();
		Query q = em.createQuery("SELECT user FROM usuario user");
		listUser = q.getResultList();
		return listUser;
	}
	
	//Metodo para remover os usuarios
	@Override
	public void removeUser(int id) {
		Usuario user = new Usuario();
		user = em.find(Usuario.class, id);
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
	}

}
