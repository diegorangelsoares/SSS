/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sss.Control;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author Diego Rangel  
 */
public class ImprimirPDF {
    
    
    public void Imprimir(String caminhoDoPdf) throws FileNotFoundException, IOException, PrinterException {
        //Nosso arquivo pdf 
        File f = new File(caminhoDoPdf);
        FileInputStream fis = new FileInputStream(f);

        FileChannel fc = fis.getChannel();

        //
        MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

        //PDFFile pdffile = new PDFFile(bb); //Cria PDF para impressão

        //PDFPrintPage pages = new PDFPrintPage((pdffile));//pagina PDF

        //Print JOB 
        PrinterJob pjob = PrinterJob.getPrinterJob();

        //Formato da página
        //PageFormat pf = PrinterJob.getPrinterJob().defaultPage();

        //nome do job
        //pjob.setJobName(f.getName());

        //classe coleção para vários documentos
        //Book book = new Book();

        //associa o documento para impressão
        //book.append(pages, pf, pdffile.getNumPages());

        //seta o documento
        //pjob.setPageable(book);

        //recebe true/false do dialogo
        boolean imprimiu = pjob.printDialog();

        //verifica se usuario apertou o botao imprimir
        if(imprimiu){
            try{
                //imprime
                pjob.print();
            }catch(Exception e){
                //erro
                System.out.println("Erro de impressão: " + e.getMessage());
            }
        }
    }
    
}
