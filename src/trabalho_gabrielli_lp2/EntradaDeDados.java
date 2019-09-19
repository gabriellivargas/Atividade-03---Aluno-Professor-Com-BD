/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_gabrielli_lp2;

import Modelo.Aluno;
import Modelo.Pessoa;
import Modelo.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author laboratorioDM
 */
public class EntradaDeDados {
    
    ArrayList< Pessoa > listaDePessoas =  new  ArrayList <> ();
      DAO Dao = new DAO();

    public void entradaPessoa(String opcao) throws SQLException {
         String nome = "Joana";//JOptionPane.showInputDialog("Nome: ");
         String sexo = "Feminino";//JOptionPane.showInputDialog("Sexo: ");
         long cpf = 0213;//Long.parseLong(JOptionPane.showInputDialog("CPF: "));
         int idade = 28;//Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
        if (opcao.equals("1")) {  
         Aluno aluno = new Aluno(nome,sexo, cpf, idade);
         aluno.setRa(123);//Integer.parseInt(JOptionPane.showInputDialog("RA: ")));
         Dao.salvarNoBD(aluno);
           
        } 
        if(opcao.equals("2")){
        
        }
        if (opcao.equals("3")){
        }
 
        if(opcao.equals("4")){
              //Professor professor = new Professor(nome, sexo, cpf, idade);
            //professor.setSiape(01234);//(Long.parseLong(JOptionPane.showInputDialog("SIAPE: ")));
            //Dao.salvarNoBD(professor);
        }
    }
    
    
     public  void  exibirTodos ( String  opcao ) throws SQLException, SQLException {
        Dao.exibirTodos(opcao);
    }
     
      void exibirUm(String opcao) throws SQLException {
        String nome = JOptionPane.showInputDialog("Digite o nome: ");
        Dao.exibirUm(opcao, nome);
    }
     
      public void remover(String opcao) throws SQLException{
        String cpf = JOptionPane.showInputDialog("Entre com o cpf de quem deseja remover: ");
        
        if(opcao.equals("3")){
            Dao.remover(Long.parseLong(cpf), opcao);
        }
        else{
            Dao.remover(Long.parseLong(cpf), opcao);
        }
    }
       
   public void alterar(String opcao) throws SQLException{
        String nome = JOptionPane.showInputDialog("Digite o nome: ");
        
        if(opcao.equals("4")){
            String sexo = JOptionPane.showInputDialog("Sexo: ");
            long cpf = Long.parseLong(JOptionPane.showInputDialog("CPF: "));
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
            Aluno aluno = new Aluno(nome, sexo, cpf, idade);
            aluno.setRa(Integer.parseInt(JOptionPane.showInputDialog("RA: ")));
            //Dao.alterarAluno(aluno);
        }
        else{
            String sexo = JOptionPane.showInputDialog("Sexo: ");
            long cpf = Long.parseLong(JOptionPane.showInputDialog("CPF: "));
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
            Professor professor = new Professor(nome, sexo, cpf, idade);
            professor.setSiape(Integer.parseInt(JOptionPane.showInputDialog("SIAPE: ")));
            Dao.alterarProfessor(professor);
        }
    }
}



 