
package br.com.sss.Control;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Diego Rangel  
 */

public class DataPorExtenso {
    
        // Retorna o nome do mês.
        // Parâmetros: "i" = índice para o vetor "mes"
        //             "tipo" = 0 para retornar o nome completo e
        //                      1 para o nome abreviado do mês.
        public String NomeDoMes(int i, int tipo) {
            String mes[] = {"janeiro", "fevereiro", "março", "abril",
            "maio", "junho", "julho", "agosto", "setembro", "outubro",
            "novembro", "dezembro"};
            // Java é uma linguagem com vetores zero-based: as posições do vetor
            // iniciam a numeração a partir do valor 0 (0-janeiro, 1-fevereiro, ...)
            if (tipo == 0)
               return(mes[i-1]); // extenso
            // o método "substring" retorna os 3 primeiros caracteres de "mes[i-1]"
               else return(mes[i-1].substring(0, 3)); // abreviado
        }

        // Retorna o dia da semana.
        // Parâmetros: "i" = índice para o vetor "diasem"
        //             "tipo" = 0 para retornar o nome completo e
        //                      1 para o nome abreviado do dia da semana.
        public String DiaDaSemana(int i, int tipo) {
          String diasem[] = {"domingo", "segunda-feira", "terça-feira",
            "quarta-feira", "quinta-feira", "sexta-feira", "sábado"};
          if (tipo == 0)
             return(diasem[i-1]); // extenso
            // o método "substring" retorna os 3 primeiros caracteres de "diasem[i]"
          else return(diasem[i-1].substring(0, 3));
        }

        // Retorna a data por extenso.
        // Parâmetros: "cidade" = nome da cidade; e, "dt" = data.
        public String DataPorExtenso(java.util.Date dt) {
            // retorna os valores ano, mês e dia da variável "dt"
            int d = dt.getDate();
            int m = dt.getMonth()+1;
            int a = dt.getYear()+1900;

            // retorna o dia da semana: 1=domingo, 2=segunda-feira, ..., 7=sábado
            Calendar data = new GregorianCalendar(a, m-1, d);
            int ds = data.get(Calendar.DAY_OF_WEEK);

            return(d + " de " + NomeDoMes(m, 0) + " de " + a + " (" + DiaDaSemana(ds, 1) + ").");
        }


    
}
