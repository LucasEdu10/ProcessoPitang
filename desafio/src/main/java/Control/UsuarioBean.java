package Control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import Dao.UsuarioDAO;
import Model.Usuario;

@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioBean {
	
	public List<Usuario> obeterUsuarios(){
//		UsuarioDAO users = new UsuarioDAO();
		List<Usuario> listUsers = new ArrayList<>();
		Usuario user1 = new Usuario();
		user1.setId(1);
		user1.setNome("Lucas");
		user1.setEmail("Lucas@gmail.com");
		user1.setSenha("123");
		user1.setTelefone("XXXXXXX");
		Usuario user2 = new Usuario();
		user2.setId(2);
		user2.setNome("Rayana");
		user2.setEmail("Rayana@gmail.com");
		user2.setSenha("123");
		user2.setTelefone("XXXXXXX");
		
		listUsers.add(user1);
		listUsers.add(user2);
		
//		return users.obeterUsuarios();
		return listUsers;
	}
	
	public String saveUser (Usuario user) {
		//Salvar a registro
		UsuarioDAO userDao = new UsuarioDAO();
		userDao.addUser(user);
		return  "/faces/index.xhtml";
	}
	
	
	// editar usuario
	public String editUser(int id) {
		UsuarioDAO userDao = new UsuarioDAO();
		Usuario user = new Usuario();
		user = userDao.searchUser(id);
		System.out.println("******************************************");
		System.out.println(user);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", user);
		return "/faces/editar.xhtml";
	}
	
	public String actualizar(Usuario user) {
		//Salva a actualizacion
		UsuarioDAO userDao = new UsuarioDAO();
		userDao.editUser(user);
		return "/faces/index.xhtml";
	}

	// eliminar um usuario
	public String eliminar(int id) {
		UsuarioDAO userDao = new UsuarioDAO();
		userDao.removeUser(id);
		System.out.println("Usuario Excluido...");
		return "/faces/index.xhtml";
	}

}
