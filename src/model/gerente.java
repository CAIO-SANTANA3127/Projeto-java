package model;

public class gerente extends funcionario implements gerencia {
    public gerente(int id, String nome, double salario) {
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
    public void mostrarDetalhes() {
        System.out.println("Gerente: " + getNome() + ", Salário: R$" + getSalario());
    }
}
