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
public class Professor extends Pessoa{
    private int siape;

    public Professor(String nome, String sexo, long cpf, int idade){
        super.setNome(nome);
        super.setSexo(sexo);
        super.setCpf(cpf);
        super.setIdade(idade);
    }

    public Professor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getSiape() {
        return siape;
    }

    public void setSiape(int siape) {
        this.siape = siape;
    }
}
