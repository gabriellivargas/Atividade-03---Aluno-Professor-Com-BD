/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_gabrielli_lp2;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author laboratorioDM
 */
public class Main {

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) {
        EntradaDeDados entrada = new EntradaDeDados();

        String menu = "0- Sair\n1 - Salvar Aluno\n2 - Exibir Alunos"
                + "\n3 - Remover Aluno\n4- Alterar Aluno\n"
                + "5 - Salvar Professores\n6 - Exibir Professores\n7 - Remover Professor\n8 - Alterar Professor";

        String opt = "";
        String opcao = "";
        do {
            try {
                opt = JOptionPane.showInputDialog(menu);
                switch (opt) {
                    case "0":
                        break;
                    case "1":
                       entrada.entradaPessoa(opt);
                        break;
                    case "2":
                        opcao = JOptionPane.showInputDialog("1-Buscar todos\n2-Buscar apenas um");
                    if(opcao.equals("1")){
                        entrada.exibirTodos(opt);
                    }
                    else{
                        entrada.exibirUm(opt);
                    }
                        break;
                    case "3":
                        entrada.remover(opt);
                        break;
                    case "4":
                        entrada.alterar(opt);
                        break;
                     case "5":
                        entrada.entradaPessoa(opt);
                        break;
                    case "6":
                        entrada.exibirTodos(opt);
                        break;
                    case "7":
                        entrada.remover(opt);
                        break;
                    case "8":
                         entrada.alterar(opt);
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (!opt.equals("0"));
    }

}
