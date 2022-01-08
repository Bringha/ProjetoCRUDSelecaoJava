/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author fabio
 */
public class Aluno extends Pessoa{
    
    private Float notaFinal;

    public Aluno(Float notaFinal){
        this.notaFinal = notaFinal;
    }

    public Float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Float notaFinal) {
        this.notaFinal = notaFinal;
    }
    
}
