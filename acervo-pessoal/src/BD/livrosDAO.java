package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ItensAcervo.livros;

/*
SOBRE ESSA CLASSE: 
DAO é um padrão de projetos onde um objeto que provê uma interface que abstrai o acesso 
a dados e lê e grava a partir da origem de dados.  Basicamente, nessa classe você irá 
inserir o código do SQL para quer sejá executado no banco de dados. 

É importante usar o PreparedStatement, caso contrário o código estará
vunerável (MySQL Injection). Além do PreparedStatement, também é bom saber o que é um
ResultSet. No final de cada método, é necessário fechar a conexão com o banco de dados.

OBS.: Se você não sabe o que está fazendo, não altere muito o DAO. Isso pode
causar erros futuros.
 */
public class livrosDAO {

    private Connection con = null;

    public livrosDAO() {
        con = ConnectionFactory.getConnection();
    }

    //-- Método para salvar -- //
    public boolean save(livros livros) {
        String sql = "INSERT INTO livros (nome, autor, edicao) VALUES (?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, livros.getNome());
            stmt.setString(2, livros.getAutor());
            stmt.setInt(3, livros.getEdicao());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //-- Método para pesquisar -- //
    public List<livros> encontrar(String nome) {
        String sql =  "SELECT * FROM livros";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<livros> livros = new ArrayList<>();
        if (nome != null)
            sql = sql + " WHERE nome LIKE (?) ORDER BY nome"; //+ ORDER BY nome
        else
            sql = sql + " ORDER BY nome";
        try {
            stmt = con.prepareStatement(sql);
            if (nome != null)
                stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                livros liv = new livros();
                liv.setId((rs.getInt("id")));
                liv.setNome((rs.getString("nome")));
                liv.setAutor((rs.getString("autor")));
                liv.setEdicao((rs.getInt("edicao")));
                livros.add(liv);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return livros;
    }
    
    public List<livros> encontrarAutor(String autor) {
        String sql =  "SELECT * FROM livros";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<livros> livros = new ArrayList<>();
        if (autor != null)
            sql = sql + " WHERE autor LIKE (?) ORDER BY nome"; //+ ORDER BY nome
        else
            sql = sql + " ORDER BY nome";
        try {
            stmt = con.prepareStatement(sql);
            if (autor != null)
                stmt.setString(1, "%" + autor + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                livros liv = new livros();
                liv.setId((rs.getInt("id")));
                liv.setNome((rs.getString("nome")));
                liv.setAutor((rs.getString("autor")));
                liv.setEdicao((rs.getInt("edicao")));
                livros.add(liv);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return livros;
    }

    //-- Método para editar -- //
    public boolean edição(livros livros) {
        String sql = "UPDATE livros SET nome = (?), autor = (?), edicao = (?) WHERE id = (?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, livros.getNome());
            stmt.setString(2, livros.getAutor());
            stmt.setInt(3, livros.getEdicao());
            stmt.setInt(4, livros.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao editar " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //-- Método para deletar -- //
    public boolean delete(livros livros) {
        String sql = "DELETE FROM livros WHERE id = (?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, livros.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
