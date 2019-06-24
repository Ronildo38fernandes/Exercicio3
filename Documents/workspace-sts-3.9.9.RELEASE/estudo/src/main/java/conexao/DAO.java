package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
public class DAO {




	public Connection Conectabd() {
		
		//toda conexão tem que estar dentro de um try catch
		try {
			Connection con = DriverManager.getConnection(
					//aqui vai a url obs caminho apos o nome do banco apos o usuario e apos a senha
					"jdbc:postgresql://localhost:5432/crude","postgres","0508"
					);
			System.out.println("conectado");
			//retornando a conexao
			return con;

		}
		catch(Exception e) {
			//caso der erro de conexao irar parar a conexao e não vai mostra esse printf
			e.printStackTrace();
			System.out.println("erro de conexão");

		}
		return null;

	}
	public void Criartabela(String nomeDatabela)throws Exception {

		Connection conexao = Conectabd();
		String sql = "create table if not exists " + nomeDatabela +"("
				+ "id integer not null primary key,"
				+ "nome varchar(255) not null unique,"
				+ "sobrenome varchar(255) not null"
				+ ")";
		Statement Statement = conexao.createStatement();
		Statement.execute(sql);
		Statement.close();
	}
	public void IncerirDados(Integer id,String nome,String sobrenome)throws Exception{
		Connection conexao = Conectabd();
		String sql = "insert into pessoa (id,nome,sobrenome) values(?,?,?)";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, id);
		statement.setString(2, nome);
		statement.setString(3,sobrenome);
		
		statement.execute();
		statement.close();
		
	}
	public  void excluirTodas() throws Exception {
		Connection conexao = Conectabd();
		String sql = "delete from pessoa";
		Statement statement = conexao.createStatement();
		statement.execute(sql);
		statement.close();		
	}
	public  void atualizarPessoa( Integer id, String nome, String sobrenome) throws Exception {
		
		Connection conexao = Conectabd();
		String sql = "update pessoa set nome = ?,  sobrenome = ? where id = ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(3, id);
		statement.setString(1, nome);
		statement.setString(2,sobrenome);
		
		statement.execute();
		statement.close();
	}

}
