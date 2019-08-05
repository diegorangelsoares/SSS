/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sss.Control;

import java.util.Date;  
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.text.ParseException; 

/**
 *
 * @author Diego Rangel  
 */
public class VerificaDiferencaEntreDatas {
    
    private static DateFormat df = new SimpleDateFormat ("dd/MM/yy");  
    
    /** Calcula o número de dias entre duas datas. */  
    public static long calcular (String inicio, String fim) throws ParseException {  
        Date dtInicial = df.parse (inicio);  
        Date dtFinal = df.parse (fim);  
        return   
             (dtFinal.getTime() - dtInicial.getTime() + 3600000L) / 86400000L;  
    }  
    
    public long retornaDiferencaEmDias (String DataInicial, String DataFinal) throws Exception {  
        long dias = VerificaDiferencaEntreDatas.calcular (DataInicial, DataFinal);  
        return dias;
    } 
    
    
}
