package br.com.larissa.AulaJava.modelo;

public class Endereco {

    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private Double ibge;
    private Integer ddd;

    public Endereco() {
//        this.id = id;
//        this.cep = cep;
//        this.logradouro = logradouro;
//        this.complemento = complemento;
//        this.bairro = bairro;
//        this.localidade = localidade;
//        this.uf = uf;
//        this.ibge = ibge;
//        this.ddd = ddd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Double getIbge() {
        return ibge;
    }

    public void setIbge(Double ibge) {
        this.ibge = ibge;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }
}
