package Empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static Utils.ES.*;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    private EmpresaRepo empresaRepo;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    ListaEmpresas empresas = new ListaEmpresas();
    int proxCod = 0;

    @Override
    public void run(String... args) {
        // Recupera os dados do banco de dados para a memória
        Iterable<Empresa> empresasdb = empresaRepo.findAll();
        for (Empresa e : empresasdb) {
            EmpresaNode node = new EmpresaNode(
                    e.getCodEmpresa(),
                    e.getRazaoSocial(),
                    e.getCnpj(),
                    e.getRua(),
                    e.getNumero(),
                    e.getBairro(),
                    e.getComplemento(),
                    e.getCidade(),
                    e.getEstado());
            empresas.insereFinal(node);
            if (e.getCodEmpresa() >= proxCod)
                proxCod = e.getCodEmpresa() + 1;
        }

        print("\n## GERENCIADOR DE TITULARES ##");

        boolean sair = false;

        while (!sair) {
            print("\n## MENU PRINCIPAL ##");
            print("(1) Criar empresa");
            print("(2) Ler todas as empresas");
            print("(3) Ler uma empresa");
            print("(4) Atualizar uma empresa");
            print("(5) Apagar uma empresa");
            print("(0) Sair");
            String opcao = inputString("\n## Escolha uma opção: ");
            switch (opcao) {
                case "1":
                    criar();
                    break;
                case "2":
                    lerTodos();
                    break;
                case "3":
                    lerUm();
                    break;
                case "4":
                    alterar();
                    break;
                case "5":
                    apagar();
                    break;
                case "0":
                    sair = true;
                    break;
                default:
                    print("\n## Opção inválida!");
            }
        }

        print("\n## FIM DO PROGRAMA! ##");
    }

    private void criar() {
        print("\n## Criação de uma empresa");
        String razaoSocial = inputString("Razão social: ");
        String cnpj = inputString("CNPJ: ");
        String rua = inputString("Rua: ");
        String numero = inputString("Número: ");
        String bairro = inputString("Bairro: ");
        String complemento = inputString("Complemento: ");
        String cidade = inputString("Cidade: ");
        String estado = inputString("Estado: ");
        EmpresaNode empresaNode = new EmpresaNode(proxCod++, razaoSocial, cnpj, rua, numero, bairro, complemento, cidade, estado);
        empresas.insereFinal(empresaNode);
        print("# Empresa criada");
    }

    private void lerTodos() {
        print("\n## Leitura de todas as empresas");
        print(empresas.imprime());
        print("# Fim da lista");

    }

    private void lerUm() {
        print("\n## Leitura de uma empresa");
        String cnpj = inputString("Digite o CNPJ da empresa que deseja encontrar: ");
        EmpresaNode empresa = empresas.procurar(cnpj);
        if (empresa != null) {
            print(empresa.toString());
        } else {
            print("# Não foi encontrada uma empresa com esse CNPJ");
        }
    }

    private void alterar() {
        print("\n## Alteração de uma empresa");
        String cnpj = inputString("Digite o CNPJ da empresa que deseja alterar: ");
        EmpresaNode emp = empresas.procurar(cnpj);
        print("Caso não deseje mudar, basta teclar enter com o campo vazio.");
        if (emp != null) {
            String razaoSocial = inputString("Razão social: ");
            if (!razaoSocial.equals("")) {
                emp.setRazaoSocial(razaoSocial);
            }
            String rua = inputString("Rua: ");
            if (!rua.isEmpty()) {
                emp.setRua(rua);
            }
            String numero = inputString("Número: ");
            if (!numero.isEmpty()) {
                emp.setNumero(numero);
            }
            String bairro = inputString("Bairro: ");
            if (!bairro.isEmpty()) {
                emp.setBairro(bairro);
            }
            String complemento = inputString("Complemento: ");
            if (!complemento.isEmpty()) {
                emp.setComplemento(complemento);
            }
            String cidade = inputString("Cidade: ");
            if (!cidade.isEmpty()) {
                emp.setCidade(cidade);
            }
            String estado = inputString("Estado: ");
            if (!estado.isEmpty()) {
                emp.setEstado(estado);
            }
            print("\n# Empresa atualizada");
        } else {
            print("# Empresa não encontrada");
        }
    }

    private void apagar() {
        print("\n## Apagar uma empresa");
        String cnpj = inputString("Digite o CNPJ da empresa que deseja apagar: ");
        boolean removido = empresas.remove(cnpj);
        if (removido) {
            print("\n# Empresa removida");
        } else {
            print("\n# Empresa não encontrada");
        }
    }
}
