

package br.com.sss.Control;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Rangel  
 */
public class GeraHora {
    
    public String RetornaHoraAtual(){
        Calendar cal = Calendar.getInstance();
        String horaAtual= new SimpleDateFormat("HH:mm:ss").format(cal.getTime());
        return horaAtual;   
    }
    
    public String diminuiMinutosDoHorario(int minutos){
        Calendar cal = Calendar.getInstance();        
        cal.add(Calendar.MINUTE, -minutos);
        String horaAtual= new SimpleDateFormat("HH:mm:ss").format(cal.getTime());
        return horaAtual; 
    }
    
    public String RetornaHoraAtualHoraMinuto(){
        Calendar cal = Calendar.getInstance();
        String horaAtual= new SimpleDateFormat("HH:mm").format(cal.getTime());
        return horaAtual;   
    }
    
    public String RetornaHoraAtualHoraMinutoSegundoSemPontos(){
        Calendar cal = Calendar.getInstance();
        String horaAtual= new SimpleDateFormat("HHmmss").format(cal.getTime());
        return horaAtual;   
    }
    
    public String RetornaApenasHora(){
        Calendar cal = Calendar.getInstance();
        String horaAtual= new SimpleDateFormat("HH").format(cal.getTime());
        return horaAtual;   
    }
    
    public String RetornaHoraSemOsPontos(String horaComPontos){
            //Converter a hora digitada 14:00 em 1400 - sem os pontos
            Date data = new Date();
            SimpleDateFormat sdfData = new SimpleDateFormat("HH:mm");
            SimpleDateFormat sdfDt = new SimpleDateFormat("HHmm");
            data = null;
            String dataAConverter = horaComPontos;
            try {
                data = sdfData.parse(dataAConverter);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data: "+ex);
            }
            String dataConvertida = sdfDt.format(data);
            return dataConvertida;
    }
    
    public Date RetornaHoraSemOsPontos2(String horaComPontos){
            //Converter a hora digitada 14:00 em 1400 - sem os pontos
            Date data = new Date();
            //Como veio
            SimpleDateFormat sdfData = new SimpleDateFormat("HH:mm");
            //Como vai ficar
            SimpleDateFormat sdfDt = new SimpleDateFormat("HH:mm");
            data = null;
            String dataAConverter = horaComPontos;
            try {
                data = sdfData.parse(dataAConverter);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao converter data: "+ex);
            }
            String dataConvertida = sdfDt.format(data);
            return data;
            
    }
    
    public String RetornaHoraAtualSemPontos(){
        Calendar cal = Calendar.getInstance();
        String horaAtual= new SimpleDateFormat("HHmmss").format(cal.getTime());
        return horaAtual;   
    }
    
    public String retornaDiferencaEntreHoras(String horaInicial, String horaFinal){
        //Recebe os 2 horarios
        String hora1 = horaInicial;
        String hora2 = horaFinal;
        //Cria as variaveis do tipo data
        Date hora11 = new Date();;
        Date hora22 = new Date();;
        
        //Cria uma formato para converter a string 
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm"); 

        //converte o digitado para data
        try 
        { 
            hora11 = formatoHora.parse(hora1); 
            hora22 = formatoHora.parse(hora2); 
        } 
        catch(ParseException p) 
        { 
            System.out.println (p.getMessage ()); 
        } 
        //Calcula a diferenca
        long difMilli = hora22.getTime() - hora11.getTime();  
        int timeInSeconds = (int)difMilli / 1000;  
        int hours, minutes, seconds;  
        hours = timeInSeconds / 3600;  
        timeInSeconds = timeInSeconds - (hours * 3600);  
        minutes = timeInSeconds / 60;  
        timeInSeconds = timeInSeconds - (minutes * 60);  
        seconds = timeInSeconds;  
        //retorna
        //campoResposta.setText((hours + " hour(s) " + minutes + " minute(s) " + seconds + " second(s)"));
        return (hours + " hour(s) " + minutes + " minute(s) " + seconds + " second(s)");
    }
    
    public String retornaDiferencaEntreHorasEmMinutos(String horaInicial, String horaFinal){
        //Recebe os 2 horarios
        String hora1 = horaInicial;
        String hora2 = horaFinal;
        //Cria as variaveis do tipo data
        Date hora11 = new Date();;
        Date hora22 = new Date();;
        
        //Cria uma formato para converter a string 
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm"); 

        //converte o digitado para data
        try 
        { 
            hora11 = formatoHora.parse(hora1); 
            hora22 = formatoHora.parse(hora2); 
        } 
        catch(ParseException p) 
        { 
            System.out.println (p.getMessage ()); 
        } 
        //Calcula a diferenca
        long difMilli = hora22.getTime() - hora11.getTime();  
        int timeInSeconds = (int)difMilli / 1000;  
        int hours, minutes, seconds;  
        
        hours = timeInSeconds / 3600;  
        timeInSeconds = timeInSeconds - (hours * 3600);  
        //minutes = timeInSeconds / 60;  
        //timeInSeconds = timeInSeconds - (minutes * 60);  
        //seconds = timeInSeconds;  
        
        return timeInSeconds+"";
    }
    
    public String diferenteHoraEmMinutos(String horaInicial, String horaFinal){
        
        String hora1 = horaInicial;
        String hora2 = horaFinal;
        //Cria as variaveis do tipo data
        Date hora11 = new Date();;
        Date hora22 = new Date();;
        
        //Cria uma formato para converter a string 
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm"); 

        //converte o digitado para data
        try 
        { 
            hora11 = formatoHora.parse(hora1); 
            hora22 = formatoHora.parse(hora2); 
        } 
        catch(ParseException p) 
        { 
            System.out.println (p.getMessage ()); 
        }
        
        long difference = Math.abs(hora11.getTime() - hora22.getTime());  

        long minutes = difference / (1000 * 60); // pega os minutos  
        difference -= minutes * 60000; // desconta o valor já retirado  
        long seconds = difference / 1000; // pega os segundos  
        
        return minutes+"";
    }

}
