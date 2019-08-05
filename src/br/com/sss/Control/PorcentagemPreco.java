/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sss.Control;

/**
 *
 * @author Diego Rangel  
 */
public class PorcentagemPreco {
    
    int id;
    int porcetagem;

    public PorcentagemPreco(int id, int porcetagem) {
        this.id = id;
        this.porcetagem = porcetagem;
    }

    public int getId() {
        return id;
    }

    public int getPorcetagem() {
        return porcetagem;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPorcetagem(int porcetagem) {
        this.porcetagem = porcetagem;
    }   
}
