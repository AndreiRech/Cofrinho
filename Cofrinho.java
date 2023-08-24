public class Cofrinho {
    private Moeda [] moedas;
    private final int CAPACIDADE = 100;
    private int capacidadeAtual;

    public Cofrinho() {
        moedas = new Moeda[CAPACIDADE];
        capacidadeAtual = 0;
    }

    public void adicionaMoeda(Moeda m) {
        if (capacidadeAtual < moedas.length) {
            moedas[capacidadeAtual] = m;

            System.out.println("Foi adicionado com sucesso R$" +m.getValorReais());

            capacidadeAtual++;
        }
        else {
            System.out.println("O cofrinho está cheio!");
        }
    }

    public int calculaCentavos() {
        int total = 0;
        for (int i=0; i<capacidadeAtual; i++) {
            total += moedas[i].getValorCentavos();
        }
        return total;
    }

    public double calculaReal() {
        double total = 0;
        for (int i=0; i<capacidadeAtual; i++) {
            total += moedas[i].getValorReais();
        }
        return total;
    }

    public int quantidadeMoeda() {
        return capacidadeAtual;
    }

    public int quantidadePorMoeda(Moeda m) {
        int quantidade = 0;
        for (int i=0; i<capacidadeAtual; i++) {
            if (moedas[i].getNomeMoeda() == m.getNomeMoeda()) {
                quantidade++;
            }
        }
        return quantidade;
    }
    
    public void esvaziar() {
        double real = calculaReal();

        capacidadeAtual = 0;
        moedas = new Moeda[moedas.length];

        System.out.println("\nVocê esvaziou o cofrinho e perdeu R$" +real +".");
    }

    public void retiraUltima () {
        if (capacidadeAtual > 0) {
            Moeda moedaRetirada = moedas[capacidadeAtual-1];
            moedas[capacidadeAtual-1] = null;
            capacidadeAtual--;

            System.out.println("\nFoi retirado do cofrinho R$" +moedaRetirada.getValorReais());
        }  
        else {
            System.out.println("\nNão foi possível retirar nada do cofrinho pois ele está vazio!");
        }
    }
}