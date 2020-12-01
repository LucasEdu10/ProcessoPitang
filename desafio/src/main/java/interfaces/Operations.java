package interfaces;

import java.util.List;

public interface Operations<Usuario> {
	
	public String addUser(Usuario user);
	public String editUser(Usuario user);
	public Usuario searchUser(int idUser);
	public List<Usuario> obeterUsuarios();
	public void removeUser(int id);

}