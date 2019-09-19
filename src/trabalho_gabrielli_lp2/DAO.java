/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_gabrielli_lp2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Modelo.Aluno;
import Modelo.Pessoa;
import Modelo.Professor;
import java.sql.ResultSet;

/**
 *
 * @author Frank
 */
public class DAO {

    List<Pessoa> listaDePessoas = new ArrayList<>();

        public void salvarP(Pessoa pessoa) {
       listaDePessoas.add(pessoa);
    }
   
    public void salvarNoBD(Professor professor) throws SQLException{
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/aluno_professor","root","");
            String sql = "insert into professor (idpessoa, nome, idade,cpf, siape) " +
                    "values(1,?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, professor.getNome());
            ps.setInt(2, professor.getIdade());
            ps.setLong(3, professor.getCpf());
            ps.setInt(4, professor.getSiape());
            int retorno = ps.executeUpdate();
            if (retorno >0) {
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso !");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
        }
    }
    
    
     public void salvarNoBD(Aluno aluno) throws SQLException{
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/aluno_professor","root","");
            String sql = "insert into aluno (idpessoa, nome, idade,cpf, ra) " +
                    "values(1,?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setInt(2, aluno.getIdade());
            ps.setLong(3, aluno.getCpf());
            ps.setInt(4, aluno.getRa());
            int retorno = ps.executeUpdate();
            if (retorno >0) {
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso !");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
        }
    } 
    
    public void remover (long cpf,String opcao ) throws SQLException {  
        boolean remove =  false;
            for( Pessoa pessoa : listaDePessoas) {
                if (pessoa.getCpf ()==cpf) {
                    if ((opcao . equals ( " 3 " ) && pessoa instanceof  Aluno )|| (opcao.equals ( " 6 " ) && pessoa instanceof  Professor )) {
                    listaDePessoas.remove(pessoa);
                     JOptionPane . showMessageDialog ( null , pessoa . getClass () . getSimpleName ()
                            +  " Removido com sucesso! " );
                        remove =  false ;
                    }
                }
            }

        if ( !remove) {
            JOptionPane . showMessageDialog ( null , " CPF não encontrado " );
        }

    }
 
   
    public void exibirTodos(String opcao) throws SQLException, SQLException {
        String msg = " ";
        if (opcao.equals("2")) {
            for (int i = 0; i < listaDePessoas.size(); i++) {
                if (listaDePessoas.get(i) instanceof Aluno) {
                    Aluno aluno = (Aluno) listaDePessoas.get(i);
                    msg += aluno.getNome() + " - RA: " + aluno.getRa() + "\n";
                }
            }
        } else {
            for (int i = 0; i < listaDePessoas.size(); i++) {
                if (listaDePessoas.get(i) instanceof Professor) {
                    Professor professor = (Professor) listaDePessoas.get(i);
                    msg = professor.getNome() + " - SIAPE: " + professor.getSiape();
                }
            }
        }
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public void exibirUm(String opcao, String nome) throws SQLException{
        String msg = "";
        if (opcao.equals("2")) {
            Aluno aluno;
            aluno = buscarAlunoNome(nome);
            msg += aluno.getNome() + " - RA: " + aluno.getRa() + "\n";
        } else {
            Professor professor;
            professor = buscarProfessorNome(nome);
            msg += professor.getNome() + " - Siape: " + professor.getSiape() + "\n";
        }
        JOptionPane.showMessageDialog(null, msg);
    }
    
    /*
    public List<Aluno> buscarTodos()  throws ClassNotFoundException{
        Connection conexao = null;

        ArrayList<Aluno> aluno = new ArrayList<Aluno>();
              
        try{
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/aluno_professor","root","");
            String sql = "select * from aluno";
            PreparedStatement ps = conexao.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Aluno alunos = new Aluno();
                
                alunos.setNome(rs.getString("nome"));
                alunos.setCpf(rs.getLong("cpf"));
                alunos.setIdade(rs.getInt("idade"));
                alunos.setRa(rs.getInt("ra"));
                aluno.add(alunos);
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + ex.getMessage());
        }
        return aluno;
    }
    */
    
       public List<Professor> buscarTodos() throws ClassNotFoundException{
        Connection conexao = null;

        ArrayList<Professor> professor = new ArrayList<Professor>();
              
        try{
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/aluno_professor","root","");
            String sql = "select * from professor";
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ResultSet rs = null;
            
            rs = ps.executeQuery();
            while(rs.next()){
                Professor professores = new Professor();
                
                professores.setNome(rs.getString("nome"));
                professores.setCpf(rs.getLong("cpf"));
                professores.setIdade(rs.getInt("idade"));
                professores.setSiape((int) rs.getLong("siape"));
                professor.add(professores);
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + ex.getMessage());
        }
        return professor;
    }
    
  public void alterarAluno(Aluno aluno) throws SQLException{
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/aluno_professor","root","");
            String sql = "UPDATE aluno SET sexo = ?, SET cpf = ?, SET idade = ?, SET  ra = ? where nome = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1, aluno.getSexo());
            ps.setLong(2, aluno.getCpf());
            ps.setInt(3, aluno.getIdade());
            ps.setInt(4, aluno.getRa());
            ps.setString(5, aluno.getNome());
            
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Atualizado com Sucesso !");
            }
            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
        }
    }
    
    public void alterarProfessor(Professor professor) throws SQLException{
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lp2alunoprofessor", "nbuser", "nbuser");
            String sql = "UPDATE \"professor\" SET \"sexo\" = ?, \"cpf\" = ?, \"idade\" = ?, \"siape\" = ? where \"nome\" = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1, professor.getSexo());
            ps.setLong(2, professor.getCpf());
            ps.setInt(3, professor.getIdade());
            ps.setLong(4, professor.getSiape());
            ps.setString(5, professor.getNome());
            
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Atualizado com Sucesso !");
            }
            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
        }
    }

    private Aluno buscarAlunoNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Professor buscarProfessorNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}    
