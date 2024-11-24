package controle;

import model.desenvolvedor;
import model.funcionario;
import model.gerente;
import model.gerentedesenvolvedor;

import java.io.*;
import java.util.ArrayList;

public class funcionarioControle {
    private ArrayList<funcionario> funcionarios = new ArrayList<>();
    private final String FILE_NAME = "funcionarios.txt";

    public void adicionarFuncionario(funcionario funcionario) throws IOException {
        funcionarios.add(funcionario);
        salvarDados();
    }

    public void listarFuncionarios() {
        for (funcionario funcionario : funcionarios) {
            funcionario.mostrarDetalhes();
        }
    }

    public void atualizarFuncionario(int id, String nome, double salario) throws IOException {
        for (funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                funcionario.setNome(nome);
                funcionario.setSalario(salario);
                salvarDados();
                return;
            }
        }
        System.out.println("Funcionário não encontrado!");
    }

    public void excluirFuncionario(int id) throws IOException {
        funcionarios.removeIf(funcionario -> funcionario.getId() == id);
        salvarDados();
    }

    public void carregarDados() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                int id = Integer.parseInt(dados[0]);
                String tipo = dados[1];
                String nome = dados[2];
                double salario = Double.parseDouble(dados[3]);

                switch (tipo) {
                    case "Desenvolvedor":
                        funcionarios.add(new desenvolvedor(id, nome, salario));
                        break;
                    case "Gerente":
                        funcionarios.add(new gerente(id, nome, salario));
                        break;
                    case "GerenteDesenvolvedor":
                        funcionarios.add(new gerentedesenvolvedor(id, nome, salario));
                        break;
                }
            }
        }
    }

    private void salvarDados() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (funcionario funcionario : funcionarios) {
                String tipo = funcionario.getClass().getSimpleName();
                bw.write(funcionario.getId() + ";" + tipo + ";" + funcionario.getNome() + ";" + funcionario.getSalario());
                bw.newLine();
            }
        }
    }
}
