package model;

public class desenvolvedor extends funcionario implements desenvolve {
    public desenvolvedor(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public void codar() {
        System.out.println(getNome() + " está codando.");
    }

    @Override
    public void resolverProblemas() {
        System.out.println(getNome() + " está resolvendo problemas técnicos.");
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Desenvolvedor: " + getNome() + ", Salário: R$" + getSalario());
    }
}
