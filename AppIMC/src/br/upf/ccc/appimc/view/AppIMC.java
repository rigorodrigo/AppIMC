package br.upf.ccc.appimc.view;

import br.upf.ccc.appimc.model.Pessoa;
import br.upf.ccc.appimc.utilities.Teclado;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo Rigo
 */
public class AppIMC {

    static ArrayList<Pessoa> pessoas = new ArrayList();

    public static void main(String[] args) {
        String[] options = {"Inserir", "Alterar", "Listar", "Excluir", "Sair"};

        while (true) {
            Integer lido = JOptionPane.showOptionDialog(null, "Opção", "Menu", 0, 0, null, options, "");

            switch (lido) {
                case 0 ->
                    inserir();
                case 1 ->
                    alterar();
                case 2 ->
                    listar();
                case 3 ->
                    excluir();
                case 4 ->
                    sair();
                default ->
                    JOptionPane.showMessageDialog(null, "Opção inválida.Por favor,digite uma opção válida.");

            }
        }
    }

    private static void inserir() {
        Pessoa p = new Pessoa();
        System.out.println("Adicionando nova pessoa... ");
        System.out.println("-----------------------------------");

        try {

            p.setNome(Teclado.lerString("Nome: "));
            p.setCpf(Teclado.lerString("CPF: "));
            p.setPeso(Teclado.lerDouble("Seu Peso: "));
            p.setAltura(Teclado.lerFloat("Sua Altura: "));
            p.interpretarIMC();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        pessoas.add(p);
        System.out.println();
    }

    private static void alterar() {
        String lerCpf = String.valueOf(JOptionPane.showInputDialog("Digite o CPF da pessoa: "));
        Pessoa alterar = new Pessoa(lerCpf);

        if (pessoas.contains(alterar)) {
            try {
                alterar = pessoas.get(pessoas.indexOf(alterar));

                alterar.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Alterar peso de "
                        + alterar.toString() + " para ")));

                alterar.setAltura(Float.parseFloat(JOptionPane.showInputDialog("Alterar altura de "
                        + alterar.toString() + " para ")));

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro: Digite um número válido para peso e altura.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage()); // Trata exceções do setPeso e setAltura
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pessoa não encontrada!");
        }

    }

    private static void listar() {

        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada!");
        } else {
            System.out.println("Exibindo as pessoas inseridas: ");
            for (Pessoa p : pessoas) {
                System.out.println("-----------------------------------");
                System.out.println(p);
                System.out.println("Seu IMC calculado indica " + p.interpretarIMC());
                System.out.println("-----------------------------------");
            }
        }
    }

    private static void excluir() {
        String lerCpf = String.valueOf(JOptionPane.showInputDialog("Digite o CPF da pessoa: "));
        Pessoa excluir = new Pessoa(lerCpf);

        if (pessoas.contains(excluir)) {
            excluir = pessoas.get(pessoas.indexOf(excluir));
            pessoas.remove(excluir);
            JOptionPane.showMessageDialog(null, "Pessoa " + excluir.toString() + "removida com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Pessoa não encontrada!");
        }
    }

    private static void sair() {

        HashMap<String, Integer> stats = new HashMap<>();

        if (pessoas.isEmpty()) {
            System.out.println("Nao ha nenhum teste para ser mostrado!");
            System.exit(0);
        } else {
            System.out.println("Total de " + pessoas.size() + " testes realizados. ");
            for (Pessoa p : pessoas) {
                String categoria = p.interpretarIMC();
                // Se a categoria já existe no HashMap, pega o valor atual e incrementa 1.
                //Se a categoria ainda não existe, incia em 0 e incrementa 1.
                stats.put(categoria, stats.getOrDefault(categoria, 0) + 1);
            }

            for (String c : stats.keySet()) {   // percorre por todas as chaves do hashmap
                int qtd = stats.get(c);
                double percentual = (qtd * 100.0) / pessoas.size();
                System.out.printf("%s: %d (%.2f%%)\n", c, qtd, percentual);
            }

            System.out.println("Encerrando...");
            System.exit(0);
        }
    }
}
