
package br.com.sss.model;

/**
 *
 * @author Diego Rangel  
 */
public class Cliente {
    
    private int id;
    private String nome;
    private String razao;
    private String rua;
    private String numero;
    private String telefone;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String cnpj;
    private String ie;
    private String email;
    private String observacao;
    private String dataNascimento;
    private String codigo_municipio;
    private String tel_trabalho;
    private String pai;
    private String mae;
    private String matricula;
    private String descricaoContrato;
    private String valorInstalacao;
    private String valorMensalidade;
    private String numeroDeMensalidades;
    private String vencimentoMensalidade;
    private String celular;
    public String Integrado;
    public String DataIntegracao;
    public String EstadoCivil;
    
    public String Profissao;
    public String Sexo;
    public String RendaFamiliar;
    public String Vendedor;
    public String Loteamento;
    public String EnderecoLoteamento;
    public String RegistroLoteamento;
    public String Quadra;
    public String Lote;
    public String NumeroContrato;
    public String Area;
    public String Medicoes;
    public String ValorDaCompra;
    public String ValorEntrada;
    public String PrimeiraParcela;
    public String SegundaParcela;
    public String TerceiraParcela;
    public String QuartaParcela;
    public String QuantidadeDeParcelas;
    public String ValorDaParcela;
    public String DiaVencimento;
    public String SituacaoPagamento;
    public String DataContrato;
    
    public String RuaCobranca;
    public String NumeroCobranca;
    public String BairroCobranca;
    public String CidadeCobranca;
    public String UfCobranca;
    public String CEPCobranca;
    public String NomeConjugue;
    public String IdentidadeConjugue;
    public String ProfissaoConjugue;
    public String NascimentoConjugue;
    public String CPFConjugue;
    
    public String DataInicioDaUtilizacaoDoSistema;
    public String Perfil;
    
    //adicionado para perfil de academia
    public String Graduacao;
    public String QuantidadeDeGraus;
    public String Tipo;
    public String Idade;
    public String Nacionalidade;
    public String NacionalidadeConugue;
    public String TelefoneConjugue;
    public String ValorDaCompraPorExtenso;
    public String DataDoContratoPorExtenso;
    public String DescricaoFrente;
    public String DEscricaoFundos;
    public String MedicaoFrente;
    public String MedicaoFundos;
    public String DescricaoLD;
    public String DescricaoLE;
    public String MedicaoLD;
    public String MedicaoLE;
    public String TotalParcelado;
    public String StatusCadastro;

    public Cliente(int id, String nome, String rua, String numero, String telefone, String bairro, String cidade, String estado, String cep, String cnpj,String ie, String email, String observacao,String dataNascimento,String codigo_municipio,String tel_trabalho,String pai,String mae,String matricula,String descricaoContrato,String valorInstalacao,String valorMensalidade,String numeroDeMensalidades,String vencimentoMensalidade,String celular,String razao,String Integrado,String DataIntegracao,String EstadoCivil,String Profissao,String Sexo,String RendaFamiliar,String Vendedor,String Loteamento,String EnderecoLoteamento,String RegistroLoteamento,String Quadra,String Lote,String NumeroContrato,String Area,String Medicoes,String ValorDaCompra,String ValorEntrada,String PrimeiraParcela,String SegundaParcela,String TerceiraParcela,String QuartaParcela,String QuantidadeDeParcelas,String ValorDaParcela,String DiaVencimento,String SituacaoPagamento,String DataContrato,String RuaCobranca,String NumeroCobranca,String BairroCobranca,String CidadeCobranca,String UfCobranca,String CEPCobranca,String NomeConjugue,String IdentidadeConjugue,String ProfissaoConjugue,String NascimentoConjugue,String CPFConjugue, String DataInicioDaUtilizacaoDoSistema, String Perfil, String Graduacao, String QuantidadeDeGraus,String Tipo,String Idade,String Nacionalidade,String NacionalidadeConugue,String TelefoneConjugue,String ValorDaCompraPorExtenso,String DataDoContratoPorExtenso,String DescricaoFrente,String DEscricaoFundos,String MedicaoFrente,String MedicaoFundos,String DescricaoLD,String DescricaoLE,String MedicaoLD,String MedicaoLE,String TotalParcelado,String StatusCadastro) {
        this.id = id;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.telefone = telefone;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.cnpj = cnpj;
        this.ie = ie;
        this.email = email;
        this.observacao = observacao;
        this.dataNascimento = dataNascimento;
        this.codigo_municipio = codigo_municipio;
        this.tel_trabalho = tel_trabalho;
        this.pai = pai;
        this.mae = mae;
        this.matricula = matricula;
        this.descricaoContrato = descricaoContrato;
        this.valorInstalacao = valorInstalacao;
        this.valorMensalidade = valorMensalidade;
        this.numeroDeMensalidades = numeroDeMensalidades;
        this.vencimentoMensalidade = vencimentoMensalidade;
        this.celular = celular;
        this.razao = razao;
        this.Integrado = Integrado;
        this.DataIntegracao = DataIntegracao;
        this.EstadoCivil=EstadoCivil;
        this.Profissao=Profissao;
        this.Sexo=Sexo;
        this.RendaFamiliar=RendaFamiliar;
        this.Vendedor=Vendedor;
        this.Loteamento=Loteamento;
        this.EnderecoLoteamento=EnderecoLoteamento;
        this.RegistroLoteamento=RegistroLoteamento;
        this.Quadra=Quadra;
        this.Lote=Lote;
        this.NumeroContrato=NumeroContrato;
        this.Area=Area;
        this.Medicoes=Medicoes;
        this.ValorDaCompra=ValorDaCompra;
        this.ValorEntrada=ValorEntrada;
        this.PrimeiraParcela=PrimeiraParcela;
        this.SegundaParcela=SegundaParcela;
        this.TerceiraParcela=TerceiraParcela;
        this.QuartaParcela=QuartaParcela;
        this.QuantidadeDeParcelas=QuantidadeDeParcelas;
        this.ValorDaParcela=ValorDaParcela;
        this.DiaVencimento=DiaVencimento;
        this.SituacaoPagamento=SituacaoPagamento;
        this.DataContrato=DataContrato;
        this.RuaCobranca=RuaCobranca;
        this.NumeroCobranca=NumeroCobranca;
        this.BairroCobranca=BairroCobranca;
        this.CidadeCobranca=CidadeCobranca;
        this.UfCobranca=UfCobranca;
        this.CEPCobranca=CEPCobranca;
        this.NomeConjugue=NomeConjugue;
        this.IdentidadeConjugue=IdentidadeConjugue;
        this.ProfissaoConjugue=ProfissaoConjugue;
        this.NascimentoConjugue=NascimentoConjugue;
        this.CPFConjugue=CPFConjugue;
        this.DataInicioDaUtilizacaoDoSistema = DataInicioDaUtilizacaoDoSistema;
        this.Perfil = Perfil;
        this.Graduacao = Graduacao;
        this.QuantidadeDeGraus = QuantidadeDeGraus;
        this.Tipo = Tipo;
        this.Idade = Idade;
        this.Nacionalidade=Nacionalidade;
        this.NacionalidadeConugue=NacionalidadeConugue;
        this.TelefoneConjugue=TelefoneConjugue;
        this.ValorDaCompraPorExtenso=ValorDaCompraPorExtenso;
        this.DataDoContratoPorExtenso=DataDoContratoPorExtenso;
        this.DescricaoFrente=DescricaoFrente;
        this.DEscricaoFundos=DEscricaoFundos;
        this.MedicaoFrente=MedicaoFrente;
        this.MedicaoFundos=MedicaoFundos;
        this.DescricaoLD=DescricaoLD;
        this.DescricaoLE=DescricaoLE;
        this.MedicaoLD=MedicaoLD;
        this.MedicaoLE=MedicaoLE;
        this.TotalParcelado=TotalParcelado;
        this.StatusCadastro = StatusCadastro;
    }

    public String getStatusCadastro() {
        return StatusCadastro;
    }

    public void setStatusCadastro(String StatusCadastro) {
        this.StatusCadastro = StatusCadastro;
    }
    
    

    public void setNacionalidade(String Nacionalidade) {
        this.Nacionalidade = Nacionalidade;
    }

    public void setNacionalidadeConugue(String NacionalidadeConugue) {
        this.NacionalidadeConugue = NacionalidadeConugue;
    }

    public void setTelefoneConjugue(String TelefoneConjugue) {
        this.TelefoneConjugue = TelefoneConjugue;
    }

    public void setValorDaCompraPorExtenso(String ValorDaCompraPorExtenso) {
        this.ValorDaCompraPorExtenso = ValorDaCompraPorExtenso;
    }

    public void setDataDoContratoPorExtenso(String DataDoContratoPorExtenso) {
        this.DataDoContratoPorExtenso = DataDoContratoPorExtenso;
    }

    public void setDescricaoFrente(String DescricaoFrente) {
        this.DescricaoFrente = DescricaoFrente;
    }

    public void setDEscricaoFundos(String DEscricaoFundos) {
        this.DEscricaoFundos = DEscricaoFundos;
    }

    public void setMedicaoFrente(String MedicaoFrente) {
        this.MedicaoFrente = MedicaoFrente;
    }

    public void setMedicaoFundos(String MedicaoFundos) {
        this.MedicaoFundos = MedicaoFundos;
    }

    public void setDescricaoLD(String DescricaoLD) {
        this.DescricaoLD = DescricaoLD;
    }

    public void setDescricaoLE(String DescricaoLE) {
        this.DescricaoLE = DescricaoLE;
    }

    public void setMedicaoLD(String MedicaoLD) {
        this.MedicaoLD = MedicaoLD;
    }

    public void setMedicaoLE(String MedicaoLE) {
        this.MedicaoLE = MedicaoLE;
    }

    public void setTotalParcelado(String TotalParcelado) {
        this.TotalParcelado = TotalParcelado;
    }

    public String getNacionalidade() {
        return Nacionalidade;
    }

    public String getNacionalidadeConugue() {
        return NacionalidadeConugue;
    }

    public String getTelefoneConjugue() {
        return TelefoneConjugue;
    }

    public String getValorDaCompraPorExtenso() {
        return ValorDaCompraPorExtenso;
    }

    public String getDataDoContratoPorExtenso() {
        return DataDoContratoPorExtenso;
    }

    public String getDescricaoFrente() {
        return DescricaoFrente;
    }

    public String getDEscricaoFundos() {
        return DEscricaoFundos;
    }

    public String getMedicaoFrente() {
        return MedicaoFrente;
    }

    public String getMedicaoFundos() {
        return MedicaoFundos;
    }

    public String getDescricaoLD() {
        return DescricaoLD;
    }

    public String getDescricaoLE() {
        return DescricaoLE;
    }

    public String getMedicaoLD() {
        return MedicaoLD;
    }

    public String getMedicaoLE() {
        return MedicaoLE;
    }

    public String getTotalParcelado() {
        return TotalParcelado;
    }

    
    public String getIdade() {
        return Idade;
    }

    public void setIdade(String Idade) {
        this.Idade = Idade;
    }
    

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    

    public void setGraduacao(String Graduacao) {
        this.Graduacao = Graduacao;
    }

    public void setQuantidadeDeGraus(String QuantidadeDeGraus) {
        this.QuantidadeDeGraus = QuantidadeDeGraus;
    }
    

    public String getGraduacao() {
        return Graduacao;
    }

    public String getQuantidadeDeGraus() {
        return QuantidadeDeGraus;
    }
    

    public String getDataInicioDaUtilizacaoDoSistema() {
        return DataInicioDaUtilizacaoDoSistema;
    }

    public String getPerfil() {
        return Perfil;
    }

    public void setDataInicioDaUtilizacaoDoSistema(String DataInicioDaUtilizacaoDoSistema) {
        this.DataInicioDaUtilizacaoDoSistema = DataInicioDaUtilizacaoDoSistema;
    }

    public void setPerfil(String Perfil) {
        this.Perfil = Perfil;
    }
    

    public void setRuaCobranca(String RuaCobranca) {
        this.RuaCobranca = RuaCobranca;
    }

    public void setNumeroCobranca(String NumeroCobranca) {
        this.NumeroCobranca = NumeroCobranca;
    }

    public void setBairroCobranca(String BairroCobranca) {
        this.BairroCobranca = BairroCobranca;
    }

    public void setCidadeCobranca(String CidadeCobranca) {
        this.CidadeCobranca = CidadeCobranca;
    }

    public void setUfCobranca(String UfCobranca) {
        this.UfCobranca = UfCobranca;
    }

    public void setCEPCobranca(String CEPCobranca) {
        this.CEPCobranca = CEPCobranca;
    }

    public void setNomeConjugue(String NomeConjugue) {
        this.NomeConjugue = NomeConjugue;
    }

    public void setIdentidadeConjugue(String IdentidadeConjugue) {
        this.IdentidadeConjugue = IdentidadeConjugue;
    }

    public void setProfissaoConjugue(String ProfissaoConjugue) {
        this.ProfissaoConjugue = ProfissaoConjugue;
    }

    public void setNascimentoConjugue(String NascimentoConjugue) {
        this.NascimentoConjugue = NascimentoConjugue;
    }

    public void setCPFConjugue(String CPFConjugue) {
        this.CPFConjugue = CPFConjugue;
    }

    public String getRuaCobranca() {
        return RuaCobranca;
    }

    public String getNumeroCobranca() {
        return NumeroCobranca;
    }

    public String getBairroCobranca() {
        return BairroCobranca;
    }

    public String getCidadeCobranca() {
        return CidadeCobranca;
    }

    public String getUfCobranca() {
        return UfCobranca;
    }

    public String getCEPCobranca() {
        return CEPCobranca;
    }

    public String getNomeConjugue() {
        return NomeConjugue;
    }

    public String getIdentidadeConjugue() {
        return IdentidadeConjugue;
    }

    public String getProfissaoConjugue() {
        return ProfissaoConjugue;
    }

    public String getNascimentoConjugue() {
        return NascimentoConjugue;
    }

    public String getCPFConjugue() {
        return CPFConjugue;
    }
    
    

    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }

    public void setProfissao(String Profissao) {
        this.Profissao = Profissao;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public void setRendaFamiliar(String RendaFamiliar) {
        this.RendaFamiliar = RendaFamiliar;
    }

    public void setVendedor(String Vendedor) {
        this.Vendedor = Vendedor;
    }

    public void setLoteamento(String Loteamento) {
        this.Loteamento = Loteamento;
    }

    public void setEnderecoLoteamento(String EnderecoLoteamento) {
        this.EnderecoLoteamento = EnderecoLoteamento;
    }

    public void setRegistroLoteamento(String RegistroLoteamento) {
        this.RegistroLoteamento = RegistroLoteamento;
    }

    public void setQuadra(String Quadra) {
        this.Quadra = Quadra;
    }

    public void setLote(String Lote) {
        this.Lote = Lote;
    }

    public void setNumeroContrato(String NumeroContrato) {
        this.NumeroContrato = NumeroContrato;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public void setMedicoes(String Medicoes) {
        this.Medicoes = Medicoes;
    }

    public void setValorDaCompra(String ValorDaCompra) {
        this.ValorDaCompra = ValorDaCompra;
    }

    public void setValorEntrada(String ValorEntrada) {
        this.ValorEntrada = ValorEntrada;
    }

    public void setPrimeiraParcela(String PrimeiraParcela) {
        this.PrimeiraParcela = PrimeiraParcela;
    }

    public void setSegundaParcela(String SegundaParcela) {
        this.SegundaParcela = SegundaParcela;
    }

    public void setTerceiraParcela(String TerceiraParcela) {
        this.TerceiraParcela = TerceiraParcela;
    }

    public void setQuartaParcela(String QuartaParcela) {
        this.QuartaParcela = QuartaParcela;
    }

    public void setQuantidadeDeParcelas(String QuantidadeDeParcelas) {
        this.QuantidadeDeParcelas = QuantidadeDeParcelas;
    }

    public void setValorDaParcela(String ValorDaParcela) {
        this.ValorDaParcela = ValorDaParcela;
    }

    public void setDiaVencimento(String DiaVencimento) {
        this.DiaVencimento = DiaVencimento;
    }

    public void setSituacaoPagamento(String SituacaoPagamento) {
        this.SituacaoPagamento = SituacaoPagamento;
    }

    public void setDataContrato(String DataContrato) {
        this.DataContrato = DataContrato;
    }
    

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public String getProfissao() {
        return Profissao;
    }

    public String getSexo() {
        return Sexo;
    }

    public String getRendaFamiliar() {
        return RendaFamiliar;
    }

    public String getVendedor() {
        return Vendedor;
    }

    public String getLoteamento() {
        return Loteamento;
    }

    public String getEnderecoLoteamento() {
        return EnderecoLoteamento;
    }

    public String getRegistroLoteamento() {
        return RegistroLoteamento;
    }

    public String getQuadra() {
        return Quadra;
    }

    public String getLote() {
        return Lote;
    }

    public String getNumeroContrato() {
        return NumeroContrato;
    }

    public String getArea() {
        return Area;
    }

    public String getMedicoes() {
        return Medicoes;
    }

    public String getValorDaCompra() {
        return ValorDaCompra;
    }

    public String getValorEntrada() {
        return ValorEntrada;
    }

    public String getPrimeiraParcela() {
        return PrimeiraParcela;
    }

    public String getSegundaParcela() {
        return SegundaParcela;
    }

    public String getTerceiraParcela() {
        return TerceiraParcela;
    }

    public String getQuartaParcela() {
        return QuartaParcela;
    }

    public String getQuantidadeDeParcelas() {
        return QuantidadeDeParcelas;
    }

    public String getValorDaParcela() {
        return ValorDaParcela;
    }

    public String getDiaVencimento() {
        return DiaVencimento;
    }

    public String getSituacaoPagamento() {
        return SituacaoPagamento;
    }

    public String getDataContrato() {
        return DataContrato;
    }
    
    

    public String getIntegrado() {
        return Integrado;
    }

    public String getDataIntegracao() {
        return DataIntegracao;
    }

    public void setIntegrado(String Integrado) {
        this.Integrado = Integrado;
    }

    public void setDataIntegracao(String DataIntegracao) {
        this.DataIntegracao = DataIntegracao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCodigo_municipio() {
        return codigo_municipio;
    }

    public void setCodigo_municipio(String codigo_municipio) {
        this.codigo_municipio = codigo_municipio;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getTel_trabalho() {
        return tel_trabalho;
    }

    public String getPai() {
        return pai;
    }

    public String getMae() {
        return mae;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setTel_trabalho(String tel_trabalho) {
        this.tel_trabalho = tel_trabalho;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDescricaoContrato() {
        return descricaoContrato;
    }

    public String getValorInstalacao() {
        return valorInstalacao;
    }

    public String getValorMensalidade() {
        return valorMensalidade;
    }

    public String getNumeroDeMensalidades() {
        return numeroDeMensalidades;
    }

    public String getVencimentoMensalidade() {
        return vencimentoMensalidade;
    }

    public void setDescricaoContrato(String descricaoContrato) {
        this.descricaoContrato = descricaoContrato;
    }

    public void setValorInstalacao(String valorInstalacao) {
        this.valorInstalacao = valorInstalacao;
    }

    public void setValorMensalidade(String valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }

    public void setNumeroDeMensalidades(String numeroDeMensalidades) {
        this.numeroDeMensalidades = numeroDeMensalidades;
    }

    public void setVencimentoMensalidade(String vencimentoMensalidade) {
        this.vencimentoMensalidade = vencimentoMensalidade;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }
    
    
    
}
