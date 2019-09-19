/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author laboratorioDM
 */
public class Aluno extends Pessoa{
    private int ra;
   

    public Aluno(String nome, String sexo, long cpf, int idade){
        super.setNome(nome);
        super.setSexo(sexo);
        super.setCpf(cpf);
        super.setIdade(idade);
    }

    public Aluno(String nome, long cpf, int idade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Aluno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

   
}