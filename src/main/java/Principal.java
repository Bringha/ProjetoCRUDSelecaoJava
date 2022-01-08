
import java.io.IOException;
import java.util.*;
import model.Aluno;
import model.Pessoa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fabio
 */
public class Principal {

    public static void main(String args[]) throws IOException, InterruptedException {

        ArrayList<Pessoa> dados = new ArrayList<Pessoa>();
        int opcao;

        do {
            mostrarMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    System.out.println("Opcao 1 . Cadastrar Pessoas ou Alunos");
                    cadastrarPessoa(dados);
                    System.out.println("Cadastro Realizado!");
                    break;
                case 2:
                    System.out.println("Opcao 2 . Mostrar todas as pessoas e alunos");
                    mostrarPessoas(dados);
                    break;
                case 3:
                    System.out.println("Opcao 3 . Atualizar dados de uma pessoa/aluno");
                    atualizarDados(dados);
                    System.out.println("Dados Autalizados!");
                    break;
                case 4:
                    System.out.println("Opcao 4. Deletar dados de uma pessoa/aluno");
                    deletarDados(dados);
                    System.out.println("Dados excluidos!");
                    break;
                case 5:
                    System.out.println("Opcao 5. Encerrando programa!");
                    break;
                default:
                    System.out.println("Nao há essa opçao no menu! Tente novamente.");
            }
            System.out.println("*******************************************************");
        } while (opcao != 5);
    }

    public static void deletarDados(ArrayList<Pessoa> d) {
        System.out.println("Digite o nome da Pessoa/Aluno que queira deletar os dados.");
        Boolean excluiu = false;
        Pessoa p = null;
        Scanner pesq = new Scanner(System.in);
        for (int i = 0; i < d.size(); i++) {
            p = d.get(i);
            String nome = p.getNome();
            if (nome.equalsIgnoreCase(pesq.next())) {
                d.remove(i);
                excluiu = true;
            } else {
                System.out.println("Nao foi possível excluir a pessoa/aluno!");
            }
        }
    }

    public static void atualizarDados(ArrayList<Pessoa> d) {
        Boolean atualizou = false;
        Pessoa p = null;
        System.out.println("Digite o nome da Pessoa/Aluno que queira atualizar os dados.");
        Scanner pesq = new Scanner(System.in);
        for (int i = 0; i < d.size(); i++) {
            p = d.get(i);
            String nome = p.getNome();
            if (nome.equalsIgnoreCase(pesq.next())) {
                System.out.println("Qual o nome da Pessoa?");
                Scanner novoNome = new Scanner(System.in);
                try {
                    p.setNome(novoNome.next());
                } catch (Exception e) {
                    System.out.println("Nao foi possível atualizar o nome da pessoa!");
                }

                System.out.println("Qual o telefone da Pessoa?");
                Scanner novoTelefone = new Scanner(System.in);
                try {
                    p.setTelefone(novoTelefone.next());
                } catch (Exception e) {
                    System.out.println("Nao foi possível atualizar o telefone da pessoa!");
                }

                System.out.println("Qual a data de nascimento da Pessoa?");
                Scanner novaDtNasc = new Scanner(System.in);
                try {
                    p.setDataNascimento(novaDtNasc.next());
                } catch (Exception e) {
                    System.out.println("Nao foi possível atualizar a data de nascimento da pessoa!");
                }

                p.setDataAlteracao(Calendar.getInstance().getTime());

                System.out.println("Eh um aluno? S ou N");
                Scanner resposta = new Scanner(System.in);
                if (resposta.next().equalsIgnoreCase("S")) {
                    Scanner novaNotaFinal = new Scanner(System.in);
                    try {
                        Aluno a = new Aluno(novaNotaFinal.nextFloat());
                        a.setNome(p.getNome());
                        a.setTelefone(p.getTelefone());
                        a.setDataNascimento(p.getDataNascimento());
                        a.setDataAlteracao(p.getDataAlteracao());
                        d.set(i, a);
                        atualizou = true;
                    } catch (Exception e) {
                        System.out.println("Nao foi possível atualizar a nota do aluno!");
                    }
                } else {
                    d.set(i, p);
                    atualizou = true;
                }
            }
            if (!atualizou) {
                System.out.println("Essa pessoa nao está cadastrada no sistema!");
            }
        }
    }

    public static void mostrarPessoas(ArrayList<Pessoa> d) {
        Pessoa p = null;
        for (int i = 0; i < d.size(); i++) {
            p = d.get(i);
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.err.println("Nome: " + p.getNome());
            System.err.println("Telefone: " + p.getTelefone());
            System.err.println("Data de Nascimento: " + p.getDataNascimento());
            System.err.println("Data de Cadastro: " + p.getDataCadastro());
            System.err.println("Data da última Alteraçao: " + p.getDataAlteracao());
            if (d.get(i) instanceof Aluno) {
                Aluno a = (Aluno) p;
                System.err.println("Nota: " + a.getNotaFinal());
            }
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    public static void cadastrarPessoa(ArrayList<Pessoa> d) {
        Pessoa p = new Pessoa();
        System.out.println("Qual o nome da Pessoa?");
        Scanner nome = new Scanner(System.in);
        try {
            p.setNome(nome.next());
        } catch (Exception e) {
            System.out.println("Nao foi possível registrar o nome da pessoa!");
        }

        System.out.println("Qual o telefone da Pessoa?");
        Scanner telefone = new Scanner(System.in);
        try {
            p.setTelefone(telefone.next());
        } catch (Exception e) {
            System.out.println("Nao foi possível registrar o telefone da pessoa!");
        }

        System.out.println("Qual a data de nascimento da Pessoa?");
        Scanner dtNasc = new Scanner(System.in);
        try {
            p.setDataNascimento(dtNasc.next());
        } catch (Exception e) {
            System.out.println("Nao foi possível registrar a data de nascimento da pessoa!");
        }

        p.setDataCadastro(Calendar.getInstance().getTime());
        p.setDataAlteracao(p.getDataCadastro());

        System.out.println("Eh um aluno? S ou N");
        Scanner resposta = new Scanner(System.in);
        if (resposta.next().equalsIgnoreCase("S")) {
            System.out.println("Qual a nota do aluno?");
            Scanner notaFinal = new Scanner(System.in);
            try {
                Aluno a = new Aluno(notaFinal.nextFloat());
                a.setNome(p.getNome());
                a.setTelefone(p.getTelefone());
                a.setDataNascimento(p.getDataNascimento());
                a.setDataCadastro(p.getDataCadastro());
                a.setDataAlteracao(p.getDataCadastro());
                d.add(a);
            } catch (Exception e) {
                System.out.println("Nao foi possível registrar a nota do aluno!");                
            }
        } else {
            d.add(p);
        }
    }

    public static void mostrarMenu() {

        limparConsole();
        System.out.println("*******************************************************");
        System.out.println("*Bem-vindo ao Projeto de Selecao do Programa MaisPraTI*");
        System.out.println("*******************************************************");
        System.out.println("*        Desenvolvido por Fabio Bringhenti            *");
        System.out.println("*******************************************************");
        System.out.println("*                        Menu                         *");
        System.out.println("*******************************************************");
        System.out.println("* 1 - Criar Pessoa ou Aluno                           *");
        System.out.println("* 2 - Mostrar Pessoas e Alunos criados                *");
        System.out.println("* 3 - Atualizar dados de uma Pessoa ou Aluno          *");
        System.out.println("* 4 - Deletar uma Pessoa ou Aluno                     *");
        System.out.println("* 5 - Encerrar o programa                             *");
        System.out.println("*******************************************************");

    }

    public static int lerOpcao() {

        int opcao;
        System.out.println("* Digite o número da opcao desejada:                  *");
        Scanner entrada = new Scanner(System.in);
        try {
            opcao = entrada.nextInt();
        } catch (Exception e) {
            opcao = 0;
        }
        System.out.println("*******************************************************");

        return opcao;

    }

    public final static void limparConsole() {

        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");

            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Tratar Exceptions
        }
    }

}
