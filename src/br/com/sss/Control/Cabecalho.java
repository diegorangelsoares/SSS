
package br.com.sss.Control;

import br.com.model.Empresa;

/**
 *
 * @author Diego Rangel  
 */

public class Cabecalho {
    
    public String imprimeEmpresaCompleto(Empresa e){
        String textoCompleto;
        textoCompleto = ""
                + "NOME: "+e.getNome()+"\n"
                + "RAZAO SOCIAL: "+e.getNome()+"\n"
                + "RUA: "+e.getNome()+"  Nº: "+e.getNumero()+"\n"
                + "BAIRRO: "+e.getNome()+"    CIDADE:"+e.getCidade()+"  UF:"+e.getEstado()+"  CEP:"+e.getCep()+"\n"
                + "CPF / CNPJ: "+e.getCnpj()+"\n"
                + "INSCRIÇÃO ESTADUAL: "+e.getInsc_estadual()+"\n"
                + "TELEFONE FIXO: "+e.getTelefone_fixo()+"\n"
                + "TELEFONE CELULAR: "+e.getTelefone_movel()+"\n"
                + "EMAIL: "+e.getEmail()+"\n"
                + "DATA DE NASCIMENTO: "+e.getData_nascimento()+"\n"
                + "";
        return textoCompleto;
    }
    
}
