
package br.com.sss.Control;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Rangel  
 */

public class GeraData {
    
    private String data2;
    private int dia;
    private int mes;
    private int ano;
    
    public String RetornaDataAtual(){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yy");
        return formatador.format(data);   
    }
    
    public String RetornaDataAtualSemBarra(){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMdd");
        return formatador.format(data);   
    }
    
    public String RetornaMesAtual(){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("MM");
        return formatador.format(data);   
    }
    
    public String RetornaAnoAtualYYYY(){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy");
        return formatador.format(data);   
    }
    
    public String RetornaAnoAtualYY(){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("yy");
        return formatador.format(data);   
    }
    
    public String RetornaDiaAtual(){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd");
        return formatador.format(data);   
    }
    
    /**
    public Date TransformaDataStringEmDate (String dataParaConverter){
            //Converter a data digitada no campo com a barra para guardar no banco sem a barra
            Date data = new Date();
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yy");
            SimpleDateFormat sdfDt = new SimpleDateFormat("dd/MM/yy");
            data = null;
            String dataAConverter = dataParaConverter;
            try {
                data = sdfData.parse(dataAConverter);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data: "+ex);
            }
            Date dataConvertida = sdfDt.format(data);
            return dataConvertida;
    }
    */ 
    
    public String RetornaDataAtualFormatoSefaz(){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");   //HH:mm:ss")
        SimpleDateFormat formatadorHora = new SimpleDateFormat("HH:mm:ss");   //HH:mm:ss")
        //"2017-05-18T17:46:03-03:00"
        String dataa = formatador.format(data);
        String horaa = formatadorHora.format(data);
        return dataa+"T"+horaa+"-03:00";   
    }
    
    public String TransformaDataStringEmDataYYYMMDD (JFormattedTextField j){
            //Converter a data digitada no campo com a barra para guardar no banco sem a barra
            Date data = new Date();
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yy");
            SimpleDateFormat sdfDt = new SimpleDateFormat("yyyyMMdd");
            data = null;
            String dataAConverter = (String) j.getText();
            try {
                data = sdfData.parse(dataAConverter);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data: "+ex);
            }
            String dataConvertida = sdfDt.format(data);
            return dataConvertida;
    }
    
    public String TransformaDataComBarraEmSemBarra (String dataComBarras){
            //Converter a data digitada no campo com a barra para guardar no banco sem a barra
            Date data = new Date();
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yy");
            SimpleDateFormat sdfDt = new SimpleDateFormat("yyyyMMdd");
            data = null;
            String dataAConverter = dataComBarras;
            try {
                data = sdfData.parse(dataAConverter);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data: "+ex);
            }
            String dataConvertida = sdfDt.format(data);
            return dataConvertida;
    }
    
    public String TransformaDataComTracoEmComBarra (String dataComtraco){
            //Converter a data digitada no campo com a traço para guardar no banco com a barra
            Date data = new Date();
            SimpleDateFormat sdfData = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdfDt = new SimpleDateFormat("dd/MM/yy");
            data = null;
            String dataAConverter = dataComtraco;
            try {
                data = sdfData.parse(dataAConverter);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data: "+ex);
            }
            String dataConvertida = sdfDt.format(data);
            return dataConvertida;
    }
    
    public String TransformaAnoDaData (String dataComBarra){
            //Converter a data digitada no campo com a barra para guardar no banco sem a barra
            Date data = new Date();
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yy");
            SimpleDateFormat sdfDt = new SimpleDateFormat("yyyy");
            data = null;
            String dataAConverter = dataComBarra;
            try {
                data = sdfData.parse(dataAConverter);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data: "+ex);
            }
            String dataConvertida = sdfDt.format(data);
            return dataConvertida;
    }
    
    public String TransformaMesDaData (String dataComBarra){
            //Converter a data digitada no campo com a barra para guardar no banco sem a barra
            Date data = new Date();
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yy");
            SimpleDateFormat sdfDt = new SimpleDateFormat("MM");
            data = null;
            String dataAConverter = dataComBarra;
            try {
                data = sdfData.parse(dataAConverter);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data: "+ex);
            }
            String dataConvertida = sdfDt.format(data);
            return dataConvertida;
    }
    
    public String TransformaDiaDaData (String dataComBarra){
            //Converter a data digitada no campo com a barra para guardar no banco sem a barra
            Date data = new Date();
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yy");
            SimpleDateFormat sdfDt = new SimpleDateFormat("dd");
            data = null;
            String dataAConverter = dataComBarra;
            try {
                data = sdfData.parse(dataAConverter);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data: "+ex);
            }
            String dataConvertida = sdfDt.format(data);
            return dataConvertida;
    }
    
    public String RetornaDataPorExtenso(String dataComBarra){
        
        String dia = TransformaDiaDaData(dataComBarra);
        String mes = TransformaMesDaData(dataComBarra);
        String ano = TransformaAnoDaData(dataComBarra);
        if (mes.equals("01")){
            mes = "Janeiro";
        }
        if (mes.equals("02")){
            mes = "Fevereiro";
        }
        if (mes.equals("03")){
            mes = "Março";
        }
        if (mes.equals("04")){
            mes = "Abril";
        }
        if (mes.equals("05")){
            mes = "Maio";
        }
        if (mes.equals("06")){
            mes = "Junho";
        }
        if (mes.equals("07")){
            mes = "Julho";
        }
        if (mes.equals("08")){
            mes = "Agosto";
        }
        if (mes.equals("09")){
            mes = "Setembro";
        }
        if (mes.equals("10")){
            mes = "Outubro";
        }
        if (mes.equals("11")){
            mes = "Novembro";
        }
        if (mes.equals("12")){
            mes = "Dezembro";
        }        
        return dia+" de "+mes+" de "+ano;        
    }
    
    public String TransformaDataStringEmDataYYYMMDD2 (String dataString){
            //Converter a data digitada no campo com a barra para guardar no banco sem a barra
            Date data = new Date();
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yy");
            SimpleDateFormat sdfDt = new SimpleDateFormat("yyyyMMdd");
            data = null;
            String dataAConverter = dataString;
            try {
                data = sdfData.parse(dataAConverter);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data: "+ex);
            }
            String dataConvertida = sdfDt.format(data);
            return dataConvertida;
    }
    
    
    public Date transformaDatadigitadaEmDate (String dataString){
            //Converter a data digitada no campo com a barra para guardar no banco sem a barra
            Date data = new Date();
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yy");
            SimpleDateFormat sdfDt = new SimpleDateFormat("yyyyMMdd");
            data = null;
            String dataAConverter = dataString;
            try {
                data = sdfData.parse(dataAConverter);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data: "+ex);
            }
            return data;
    }
    
    public Date transformaDatadigitadaEmDatePassandoDataHora (String dataString){
            //Converter a data digitada no campo com a barra para guardar no banco sem a barra
            Date data = new Date();
            SimpleDateFormat sdfData = new SimpleDateFormat("yyMMddMMHH");
            //SimpleDateFormat sdfDt = new SimpleDateFormat("yyyyMMdd");
            data = null;
            String dataAConverter = dataString;
            try {
                data = sdfData.parse(dataAConverter);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data: "+ex);
            }
            return data;
    }
    
    //Transforma data dd/mm/aaaa em dd/mm/aa
    public String TransformaDataComBarraEYYYYEmDataYY (String dataComYYYY){
            //Converter a data digitada no campo com a barra para guardar no banco sem a barra
            Date data = new Date();
            //Como está
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
            //Como vai ficar
            SimpleDateFormat sdfDt = new SimpleDateFormat("dd/MM/yy");
            data = null;
            String dataAConverter = dataComYYYY;
            try {
                data = sdfData.parse(dataAConverter);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data: "+ex);
            }
            String dataConvertida = sdfDt.format(data);
            return dataConvertida;
    }
    
    public String TransformaDataComBarraEmSemBarra2 (String dataDigitadaComBarras){
            //Converter a data digitada no campo com a barra para guardar no banco sem a barra
            Date data = new Date();
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yy");
            SimpleDateFormat sdfDt = new SimpleDateFormat("yyyyMMdd");
            data = null;
            String dataAConverter = dataDigitadaComBarras;
            try {
                data = sdfData.parse(dataAConverter);
            } catch (ParseException ex) {
                //Logger.getLogger(FormTestes.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao converter data: "+ex);
            }
            String dataConvertida = sdfDt.format(data);
            return dataConvertida;
    }
    
    //Função verifica se a data é válida  
    public boolean isDataValida(String date){  
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");  
        df.setLenient(false);  
            try {  
                df.parse(date);  
                return true;  
            } catch (ParseException ex) {  
                return false;  
            }  
    }
    
    
            //Checa mês verificando se é maior que zero e menor que 12
    public int checaMes(int mesTemp) {
        if(mesTemp > 0 && mesTemp <= 12) {
            return mesTemp;
        } else {
            return -1;
        }
    }

    //Checa dia tendo uma variavel inteira como array "ultimoDiaMes" com os valores do ultimo dia
    //de cada mes. Verifica também se o ano é Bissexto
    public int checaDia(int diaTemp) {
        int ultimoDiaMes[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        if(diaTemp > 0 && diaTemp <= ultimoDiaMes[mes]) {
            return diaTemp;
        } else if (mes == 2 && diaTemp == 29 && (ano % 400 == 0 && (ano % 4 == 0 && ano % 100 != 0 ))) {
            return diaTemp;
        } else {
            return -1;
        }
    }
    
    public boolean validaData(String dataTemp) {        
        int mesTemp;
        int diaTemp;
        data2 = dataTemp.replace("/","");
        dia = Integer.parseInt(data2.trim().substring(0,2));
        mes = Integer.parseInt(data2.trim().substring(2,4));
        ano = Integer.parseInt(data2.trim().substring(4,6));
        mesTemp = checaMes(mes);
        if( mesTemp != -1 ) {
            mes = mesTemp;
            diaTemp = checaDia(dia);
            if(diaTemp != -1) {
                dia = diaTemp;
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
    
    public String retornaDiaDaSemana(String dataComBarra){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            Date ontem = null;
            try {
                ontem = sdf.parse(dataComBarra);
            } catch (ParseException ex) {
                Logger.getLogger(GeraData.class.getName()).log(Level.SEVERE, null, ex);
            }
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(ontem);
            int diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);
            //JOptionPane.showMessageDialog(null, "Dia da semana: "+diaDaSemana);
            String dia = "";
            //domingo é 1    segunda é 2 .....
            if (diaDaSemana == 1){
                dia = "Dom";
            }
            if (diaDaSemana == 2){
                dia = "Seg";
            }
            if (diaDaSemana == 3){
                dia = "Ter";
            }
            if (diaDaSemana == 4){
                dia = "Qua";
            }
            if (diaDaSemana == 5){
                dia = "Qui";
            }
            if (diaDaSemana == 6){
                dia = "Sex";
            }
            if (diaDaSemana == 7){
                dia = "Sab";
            }
            return dia;
            
    }
    
    public String retornaAnoAA(String dataAConverter){
        
            //Converter a data digitada no campo com a barra para guardar no banco sem a barra
            Date data = new Date();
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yy");
            SimpleDateFormat sdfDt = new SimpleDateFormat("yy");
            data = null;
            try {
                data = sdfData.parse(dataAConverter);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data: "+ex);
            }
            String dataConvertida = sdfDt.format(data);
            return dataConvertida;
          
    }
    
    public String retornaMesMM(String dataAConverter){
            //Converter a data digitada no campo com a barra para guardar no banco sem a barra
            Date data = new Date();
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yy");
            SimpleDateFormat sdfDt = new SimpleDateFormat("MM");
            data = null;
            try {
                data = sdfData.parse(dataAConverter);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data: "+ex);
            }
            String dataConvertida = sdfDt.format(data);
            return dataConvertida; 
    }
    
    public Date retornaDataEhoraJuntos(String dataComBarra, String horaComPontos){
        //Converter a data digitada no campo com a barra para guardar no banco sem a barra
            Date data = new Date();
            SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm:ss");   //"HH-mm-ss"
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yy");
            data = null;
            String dataAConverter = dataComBarra+horaComPontos;
            try {
                data = sdfData.parse(dataAConverter);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data: "+ex);
            }
            return data;
    }


}
