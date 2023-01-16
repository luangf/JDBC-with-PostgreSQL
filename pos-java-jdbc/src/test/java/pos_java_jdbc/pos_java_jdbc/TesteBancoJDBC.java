package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJDBC {
	
	@Test
	public void initBanco() { //insert
		UserPosDAO userPosDAO=new UserPosDAO();
		Userposjava userposjava=new Userposjava();
		
		userposjava.setNome("Amelia");
		userposjava.setEmail("amelia@gmail.com");
		
		userPosDAO.salvar(userposjava);
	}
	
	@Test
	public void initListar() {
		UserPosDAO dao=new UserPosDAO(); 
		try {
			List<Userposjava> list=dao.listar();
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("---------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscar() {
		UserPosDAO dao=new UserPosDAO();
		try {
			Userposjava userposjava=dao.buscar(3L);
			System.out.println(userposjava);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initAtualizar() {
		try {
			UserPosDAO dao=new UserPosDAO();
			Userposjava objetoBanco=dao.buscar(3L);
			objetoBanco.setNome("Amelia 2.0");
			dao.atualizar(objetoBanco);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initDeletar() {
		try {
			UserPosDAO dao=new UserPosDAO();
			dao.deletar(6L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeInsertTelefone() {
		Telefone telefone=new Telefone();
		telefone.setNumero("(51) 9 1111-1111");
		telefone.setTipo("Casa");
		telefone.setUsuario(7L);
		UserPosDAO dao=new UserPosDAO();
		dao.salvarTelefone(telefone);
	}
	
	@Test
	public void testeCarregaFonesUser() {
		UserPosDAO dao=new UserPosDAO();
		List<BeanUserFone> beanUserFones=dao.listaUserFone(7L);
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("-----------------------------");
		}
	}
	
	@Test
	public void testeDeleteUserFone() {
		UserPosDAO dao=new UserPosDAO();
		dao.deleteFonesEUser(7L);
	}
}