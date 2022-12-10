package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ItensAcervo.discos;

/*
SOBRE ESSA CLASSE: 
DAO é um padrão de projetos onde um objeto que provê uma interface que abstrai o acesso 
a dados e lê e grava a partir da origem de dados. Basicamente, nessa classe você irá 
inserir o código do SQL para quer sejá executado no banco de dados. 

É importante usar o PreparedStatement, caso contrário o código estará
vunerável (MySQL Injection). Além do PreparedStatement, também é bom saber o que é um
ResultSet. No final de cada método, é necessário fechar a conexão com o banco de dados.

OBS.: Se você não sabe o que está fazendo, não altere muito o DAO. Isso pode
causar erros futuros.
 */
public class discosDAO {

    // ATRIBUTOS //
    private Connection con = null;

    // METODOS //
    public discosDAO() {
        con = ConnectionFactory.getConnection();
    }

    //-- Método para salvar -- //
    public boolean save(discos disco_cd) {
        String sql = "INSERT INTO discos (nome, artista, disco) VALUES (?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, disco_cd.getNome());
            stmt.setString(2, disco_cd.getAutor());
            stmt.setBoolean(3, disco_cd.isDisco());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<discos> encontrar(boolean discos, boolean CD, String nome) {
        String sql = "SELECT * FROM discos";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<discos> disco_cd = new ArrayList<>();
        if (nome != null) 
            sql = sql + " WHERE nome LIKE (?) ORDER BY nome";
        else if ((CD == true && discos == true) == false) {
            if (discos == true) {
                sql = sql + " WHERE disco = TRUE ORDER BY nome";
            } else
                sql = sql + " WHERE disco = FALSE ORDER BY nome";
        }                       
        
        try {
            stmt = con.prepareStatement(sql);
            if (nome != null)
                stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                discos dvdcd = new discos();
                dvdcd.setId((rs.getInt("id")));
                dvdcd.setNome((rs.getString("nome")));
                dvdcd.setAutor((rs.getString("artista")));
                dvdcd.setDisco((rs.getBoolean("disco")));
                disco_cd.add(dvdcd);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return disco_cd;
    }
    
    public List<discos> encontrarAutor(boolean discos, boolean CD, String autor) {
        String sql = "SELECT * FROM discos";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<discos> disco_cd = new ArrayList<>();
        if (autor != null) 
            sql = sql + " WHERE artista LIKE (?) ORDER BY nome";
        else if ((CD == true && discos == true) == false) {
            if (discos == true) {
                sql = sql + " WHERE disco = TRUE ORDER BY nome";
            } else
                sql = sql + " WHERE disco = FALSE ORDER BY nome";
        }                       
        
        try {
            stmt = con.prepareStatement(sql);
            if (autor != null)
                stmt.setString(1, "%" + autor + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                discos dvdcd = new discos();
                dvdcd.setId((rs.getInt("id")));
                dvdcd.setNome((rs.getString("nome")));
                dvdcd.setAutor((rs.getString("artista")));
                dvdcd.setDisco((rs.getBoolean("disco")));
                disco_cd.add(dvdcd);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return disco_cd;
    }

    //-- Método para editar -- //
    public boolean edição(discos disco_cd) {
        String sql = "UPDATE discos SET nome = (?), artista = (?), disco = (?) WHERE id = (?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, disco_cd.getNome());
            stmt.setString(2, disco_cd.getAutor());
            stmt.setBoolean(3, disco_cd.isDisco());
            stmt.setInt(4, disco_cd.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //-- Método para deletar -- //
    public boolean delete(discos disco_cd) {
        String sql = "DELETE FROM discos WHERE id = (?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, disco_cd.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean deleteTudo(discos disco_cd) {
        String sql = "TRUNCATE TABLE discos";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, disco_cd.getId());
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
