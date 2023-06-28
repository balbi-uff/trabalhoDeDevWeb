
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexao {
    
    private Connection conexao;

    public Conexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://bdserver.ic.uff:3306/", "aluno", "banco@dados17");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível conectar com o banco");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Não foi possível encontrar a classe referente" + "Verifique o driver");
        }

    }

    
    //public Conexao getConexao(){
      //  return this.conexao;
    //}
   
}


