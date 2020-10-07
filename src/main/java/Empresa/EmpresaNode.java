package Empresa;

public class EmpresaNode {
    private Integer codEmpresa;
    private String razaoSocial;
    private String cnpj;
    private String rua;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;
    private EmpresaNode proximo;
    
    @Override
    public String toString() {
        return "\n\nEmpresa {\n" +
                "    Código da Empresa = " + codEmpresa +
                ",\n    Razão Social = " + razaoSocial +
                ",\n    CNPJ = " + cnpj +
                ",\n    Rua = " + rua +
                ",\n    Numero = " + numero +
                ",\n    Bairro = " + bairro +
                ",\n    complemento = " + complemento +
                ",\n    cidade = " + cidade +
                ",\n    estado = " + estado +"\n" +
                '}';
    }
    public EmpresaNode(int codEmpresa, String razaoSocial, String cnpj, String rua, String numero,String bairro, String complemento, String cidade, String estado) {
        this.codEmpresa = codEmpresa;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EmpresaNode getProximo() {
        return proximo;
    }

    public void setProximo(EmpresaNode proximo) {
        this.proximo = proximo;
    }
}
