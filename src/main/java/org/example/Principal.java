package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Principal {

    public List<Funcionario> inserirTodosFuncionarios() {
        // #3.1 insere todos os funcionários em ordem
        Funcionario maria = new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador");
        Funcionario joao = new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador");
        Funcionario caio = new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador");
        Funcionario miguel = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor");
        Funcionario alice = new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista");
        Funcionario heitor = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador");
        Funcionario arthur = new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador");
        Funcionario laura = new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente");
        Funcionario heloisa = new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista");
        Funcionario helena = new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente");

        List<Funcionario> listaDeFuncionarios = new ArrayList<>(Arrays.asList(maria, joao, caio, miguel, alice, heitor, arthur, laura, heloisa, helena));

        return listaDeFuncionarios;

        /*
          Neste método, se fossem disponibilizados os dados em um arquivo csv,
          eu poderia ler os dados do arquivo em um for loop para adicionar de maneira
          mais fácil e menos repetitiva.
         */
    }

    public List<Funcionario> aumentarSalario(List<Funcionario> listaDeFuncionarios) {
        // #3.4 Atualiza salários com aumento de 10%
        // Adicionei um recurso a mais, para o aumento ser somente pros funcionarios, não diretor
        for (Funcionario funcionario : listaDeFuncionarios) {
            if (funcionario.getFuncao() != "Diretor") {
                funcionario.setSalario(funcionario.getSalario().multiply(BigDecimal.valueOf(1.1)));
            }
        }
        return listaDeFuncionarios;
    }

    public Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> listaDeFuncionarios) {
        Map<String, List<Funcionario>> mapDeFuncionarios = new HashMap<>();
        for (Funcionario funcionario : listaDeFuncionarios) {
            List<Funcionario> funcionarioPorFuncao = mapDeFuncionarios.getOrDefault(funcionario.getFuncao(), new ArrayList<>());
            funcionarioPorFuncao.add(funcionario);
            mapDeFuncionarios.put(funcionario.getFuncao(), funcionarioPorFuncao);
        }
        return mapDeFuncionarios;
    }

    public static void main(String[] args) {
        // #3 Cria instância da classe Principal
        Principal principal = new Principal();

        // #3.1 Chama o método inserirTodosFuncionarios
        System.out.println("#3.1 Inserir todos os funcionários:");
        List<Funcionario> listaFuncionarios = principal.inserirTodosFuncionarios();
        System.out.println("Ok!");
        System.out.println("-----------------------------------\n");

        // #3.2 Remover o funcionário João da lista
        System.out.println("#3.2 Remover o funcionário João:");
        int indexFuncionarioToRemove = 0;
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getNome() == "João") {
                // Aqui eu tentei dar list.remove(funcionario) mas não tenho como remover
                // um item dentro de uma iteração pois alteraria os indexes, dando exception
                indexFuncionarioToRemove = listaFuncionarios.indexOf(funcionario);
            }
        }
        listaFuncionarios.remove(indexFuncionarioToRemove);
        System.out.println("Ok!");
        System.out.println("-----------------------------------\n");

        // #3.3 Imprime um por linha em ordem de inserção, respeitando os formatos
        System.out.println("#3.3 Imprimir todos os funcionários:");
        for (Funcionario funcionario : listaFuncionarios) {
            System.out.println(funcionario);
        }
        System.out.println("-----------------------------------\n");

        // #3.4 Atualizar lista com aumento de 10% do salário
        System.out.println("#3.4 Aumentar salários em 10% (menos do diretor):");
        principal.aumentarSalario(listaFuncionarios);
        for (Funcionario funcionario : listaFuncionarios) {
            System.out.println(funcionario);
        }
        System.out.println("-----------------------------------\n");

        // #3.5 Agrupar funcionarios por função em um Map
        System.out.println("#3.5 Agrupar funcionarios por função em um Map:");
        Map<String, List<Funcionario>> mapDeFuncionarios = principal.agruparPorFuncao(listaFuncionarios);
        System.out.println("Ok!");
        System.out.println("-----------------------------------\n");

    }
}