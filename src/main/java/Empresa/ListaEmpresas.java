package Empresa;

public class ListaEmpresas {
    EmpresaNode inicio;

    public ListaEmpresas() {
        this.inicio = null;
    }

    public boolean vazia() {
        return inicio == null;
    }

    public EmpresaNode procurar(String cnpj) {
        EmpresaNode x = inicio;
        while (x != null) {
            if (x.getCnpj().equals(cnpj)){
                return x;}
            x = x.getProximo();
        }
        return null;
    }

    public void insereInicio(EmpresaNode e) {
        e.setProximo(inicio);
        inicio = e;
    }


    public void insereFinal(EmpresaNode e) {
        if (vazia()) {
            insereInicio(e);
        } else {
            EmpresaNode x = inicio;
            while (x.getProximo() != null) {
                x = x.getProximo();
            }
            x.setProximo(e);
        }
    }

    public boolean alterarEmpresa(int pos, String rua, String numero, String complemento, String cidade, String estado) {
        if (vazia()) {
            return false;
        }
        int posAtual = 1;
        EmpresaNode x = inicio;
        while (x != null) {
            if (posAtual == pos) {
                x.setRua(rua);
                x.setNumero(numero);
                x.setComplemento(complemento);
                x.setCidade(cidade);
                x.setEstado(estado);
                return true;
            }
            x = x.getProximo();
            posAtual++;
        }
        return false;
    }

    public String imprime() {
        String ret = "";
        if (!vazia()) {
            EmpresaNode x = inicio;
            while (true) {
                ret += x;
                if (x.getProximo() != null) {
                    x = x.getProximo();
                } else {
                    break;
                }
            }

        }
        return ret;

    }

    public boolean inserirLocal(int pos, EmpresaNode e) {
        if (!vazia() && pos > 0) {
            EmpresaNode x = inicio;
            int count = 1;
            while (x != null) {
                if (pos == 1 && pos == count) {
                    e.setProximo(inicio);
                    inicio = e;
                    return true;
                } else if (pos == count + 1) {
                    e.setProximo(x.getProximo());
                    x.setProximo(e);
                    return true;
                }
                count++;
                x = x.getProximo();
                if (x == null && count == pos) {
                    insereFinal(e);
                }
            }
        }
        return false;
    }

    public boolean remove(String cnpj) {
        if (!vazia()) {
            EmpresaNode x = inicio;
            if (x == inicio && inicio.getCnpj().equals(cnpj)) {
                inicio = inicio.getProximo();
                return true;
            }
            while (x.getProximo() != null) {
                if (x.getProximo().getCnpj().equals(cnpj)) {
                    EmpresaNode prox = x.getProximo();
                    x.setProximo(prox.getProximo());
                    prox.setProximo(null);
                    return true;
                }
                x = x.getProximo();
            }
        }
        return false;
    }

    public int contar() {
        if (!vazia()) {
            int contador = 0;
            EmpresaNode x = inicio;
            while (x != null) {
                contador++;
                x = x.getProximo();
            }
            return contador;
        }
        return 0;
    }
}
