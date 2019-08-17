
package br.com.sss.Control;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego Rangel  
 */

public class BackupSql {

        ControllerGeral co = new ControllerGeral();
        //boolean Eh64bit = co.verificaSeTemPasta64bits();
        private static String MYSQL_PATH ="C:\\Program Files\\MySQL\\MySQL Server 5.1\\bin\\";                
        private static String VERSION = "4.0.3";
        private static String SEPARATOR = File.separator;
        private static String PRESENTATION =
          "==========================================================\n" +
          "  Backup do banco de dados MySQL - Versao " + VERSION + "\n" +
          "  Autor: Diego Rangel\n\n" +
          "  DSistema, 2016\n" +
          "==========================================================\n\n";

        private static String DATABASES = "receitas";

        private List<String> dbList = new ArrayList<String>();

        public BackupSql (String caminhoDoArquivo) {
            
//            if (Eh64bit == true){
//                MYSQL_PATH ="C:\\Program Files (x86)\\MySQL\\MySQL Server 5.1\\bin\\";
//            }

            String command = MYSQL_PATH + "mysqldump.exe";

            String[] databases = DATABASES.split(" ");

            for (int i = 0; i < databases.length; i++)
                  dbList.add(databases[i]);

            // Mostra apresentação

            System.out.println(PRESENTATION);

            System.out.println("Iniciando backups...\n\n");

            // Contador

            int i = 1;

            // Tempo

            long time1, time2, time;

            // Início

            time1 = System.currentTimeMillis();

            for (String dbName : dbList) {

              //ProcessBuilder pb = new ProcessBuilder( command,"--user=root","--password=123456", dbName,"--result-file=" + "." + SEPARATOR + "Backup" + SEPARATOR + dbName + ".sql");
              ProcessBuilder pb = new ProcessBuilder( command,"--user=root","--password=123456", dbName,"--result-file="+caminhoDoArquivo);

              try {

                System.out.println("Backup do banco de dados (" + i + "): " + dbName + " ...");
                pb.start();

              }

            catch (Exception e) {
                e.printStackTrace();
            }
            i++;

            }

            // Fim
            time2 = System.currentTimeMillis();
            // Tempo total da operação
            time = time2 - time1;
            // Avisa do sucesso

            System.out.println("\nBackups realizados com sucesso.\n\n");
            System.out.println("Tempo total de processamento: " + time + " ms\n");
            System.out.println("Finalizando...");

            try {
                // Paralisa por 2 segundos
                Thread.sleep(2000);
            }
            catch (Exception e) {}
            // Termina o aplicativo
            //System.exit(0);
          }


}
