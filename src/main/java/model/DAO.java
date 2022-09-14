package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/**  Módulo de conexão *. */ 
	
	// Parâmetros de conexão 
	
	private String driver = "com.mysql.cj.jdbc.Driver"; 
	
	/** The url. */
	private String url = "jdbc:mysql://localhost:3306/agenda?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "gustavo"; 
	
	/** The password. */
	private String password = "123";
	
	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// Método de conexão 
	private Connection conectar() {
		
		Connection con = null; 
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
			
		} catch (Exception e) {
			
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	/* Crud Create */ 
	public void inserirContato(JavaBeans contato) {
		
		String create = "INSERT INTO contatos (nome, fone, email) VALUES(?, ?, ?)"; 
		
		try {
			
			// Abrir a conexão 
			Connection con = conectar();
			
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			
			// Substituir os parâmetros (?) pelo contéudo das variáveis Java Beans
			pst.setString(1, contato.getNome()); 
			pst.setString(2, contato.getFone()); 
			pst.setString(3, contato.getEmail()); 
			
			// Executar a query 
			pst.executeUpdate(); 
			
			// Encerrar a conexão com o banco 
			con.close();
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
 	}
	
	/**
	 *  Crud Read *.
	 *
	 * @return the array list
	 */ 
	public ArrayList<JavaBeans> listarContatos() {
		
		// Criando um objeto para acessar a classe JavaBeans 
		
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		
		String read = "SELECT * FROM contatos order by nome";
		
		try {
			
			Connection con = conectar(); 
			PreparedStatement pst = con.prepareStatement(read); 
			
			ResultSet rs = pst.executeQuery();
			
			// O Laço abaixo será executado enquanto houver contatos 
			while (rs.next()) {
				
				// Variáveis de apoio que recebem os dados do banco 
				String idcon = rs.getString(1); 
				String nome = rs.getString(2); 
				String fone = rs.getString(3); 
				String email = rs.getString(4); 
				
				// Populando o ArrayList 
				contatos.add(new JavaBeans (idcon, nome, fone, email));
			}
			
			con.close(); 
			
			return contatos; 
			
		} catch (Exception e) {
			
			System.out.println(e);
			return null;
		}
		
	}
	
	/**
	 *  Crud Update *.
	 *
	 * @param contato the contato
	 */ 
	// Selecionar o contato 
	public void selecionarContato(JavaBeans contato) {
		
		String read2 = "SELECT * FROM contatos WHERE idcon = ?";
		
		try {
			
			Connection con = conectar(); 
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getIdcon());
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				// Setar as variáveis JavaBeans 
				contato.setIdcon(rs.getString(1)); 
				contato.setNome(rs.getString(2)); 
				contato.setFone(rs.getString(3)); 
				contato.setEmail(rs.getString(4)); 
			}
			
			con.close();
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}
	
	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	// editar o contato 
	public void alterarContato(JavaBeans contato) {
		
		String update = "update contatos set nome = ?, fone = ?, email = ? WHERE idcon = ?"; 
		
		try {
			
			Connection con = conectar(); 
			
			PreparedStatement pst = con.prepareStatement(update);
			
			// Substituição da ? para os dados 
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			
			// Executar a atualização dos dados
			pst.executeUpdate();
			
			// Fechando a conexão
			con.close();
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}
	
	/**
	 * Remover contato.
	 *
	 * @param contato the contato
	 */
	/* Crud delete */ 
	public void removerContato(JavaBeans contato) {
		
		String delete = "DELETE FROM contatos WHERE idcon = ?"; 
		
		try {
			
			Connection con = conectar(); 
			PreparedStatement pst = con.prepareStatement(delete); 
			pst.setString(1, contato.getIdcon()); 
			
			pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}

	// Teste de conexão 
	/*public void testeConexao() {
		
		try {
			
			Connection con = conectar();
			System.out.println(con);
			con.close();
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}*/
	
}
