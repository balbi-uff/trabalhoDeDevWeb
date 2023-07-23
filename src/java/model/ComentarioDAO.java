package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidade.Comentario;

/*
--
-- Estrutura da tabela `comentarios`
--

CREATE TABLE IF NOT EXISTS `comentarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comentario` varchar(255) NOT NULL,
  `data` date DEFAULT NULL,
  `idusuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_usuario` (`idusuario`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

 */

public class ComentarioDAO implements Dao<Comentario> {

    @Override
    public Comentario get(int id) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Comentarios WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            Comentario comentario = new Comentario();

            if (resultado != null) {
                while (resultado.next()) {
                    comentario.setId(Integer.parseInt(resultado.getString("ID")));
                    comentario.setComentario(resultado.getString("COMENTARIO"));
                    comentario.setData(resultado.getString("DATA"));
                    comentario.setId(Integer.parseInt(resultado.getString("IDUSUARIO")));
                }
            }
            return comentario;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get comentario) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public void insert(Comentario comentario) {

        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO Comentarios (COMENTARIO, DATA, IDCATEGORIA, IDUSUARIO) VALUES (?,?,?,?)");
            sql.setString(1, comentario.getComentario());
            sql.setString(2, comentario.getData());
            sql.setInt(3, comentario.getIdcategoria());
            sql.setInt(4, comentario.getIdusuario());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de insert (comentario) incorreta: " + e);
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public void update(Comentario comentario) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE Comentarios SET COMENTARIO = ?, DATA = ?, IDCATEGORIA = ? ,IDUSUARIO = ?  WHERE ID = ? ");
            sql.setString(1, comentario.getComentario());
            sql.setString(2, comentario.getData());
            sql.setInt(3, comentario.getIdcategoria());
            sql.setInt(4, comentario.getIdusuario());
            sql.setInt(5, comentario.getId());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar comentario) incorreta "+ e);
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public void delete(int id) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM Comentarios WHERE ID = ? ");
            sql.setInt(1, id);
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir comentario) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    @Override
    public ArrayList<Comentario> getAll() {

        ArrayList<Comentario> meusComentarios = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM Comentarios";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Comentario Comentario = new Comentario(resultado.getInt("ID"),resultado.getString("COMENTARIO"),
                            resultado.getString("DATA"),
                            resultado.getInt("IDUSUARIO"),
                            resultado.getInt("IDCATEGORIA")
                    );
                    meusComentarios.add(Comentario);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (GetAll) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return meusComentarios;
    }
}
