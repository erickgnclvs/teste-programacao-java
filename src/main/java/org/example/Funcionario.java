package org.example;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataDeNascimento, BigDecimal salario, String funcao) {
        super(nome, dataDeNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public Funcionario(BigDecimal salario, String funcao) {
        this.salario = salario;
        this.funcao = funcao;
    }

    public Funcionario() {
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {

        // Editei esse método para suprir os requisitos do item #3.3
        return "Nome: " + super.getNome() +
                " | Data de nascimento: " + super.getDataDeNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " | Salário: R$ " + new DecimalFormat("#,##0.00").format(salario) +
                " | Função: " + funcao;
    }
}
