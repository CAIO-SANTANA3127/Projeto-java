package model;

public class gerentedesenvolvedor extends funcionario implements gerencia, desenvolve {
    public gerentedesenvolvedor(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public void organizarEquipe() {
        System.out.println(getNome() + " está organizando a equipe.");
    }

    @Override
    public void conduzirReunioes() {
        System.out.println(getNome() + " está conduzindo reuniões.");
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
        System.out.println("Gerente Desenvolvedor: " + getNome() + ", Salário: R$" + getSalario());
    }
}
