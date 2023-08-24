import java.util.Scanner;
public class App {
    private static Scanner in = new Scanner (System.in);
    private static Cofrinho cofrinho = new Cofrinho();
    public static void main(String[] args) {
        opcao();
    }

    public static void menu () {
        String mensagem = """

                --------------- [ MENU ] ---------------

                Informe o que deseja fazer:

                1 - Inserir moeda no cofrinho;
                2 - Retirar a última moeda inserida;
                3 - Informar quantidades de moedas no cofrinho;
                4 - Quantas moedas por tipo;
                5 - Total em centavos;
                6 - Total em reais;
                7 - Esvaziar o cofrinho;
                8 - Sair.
                """;
        System.out.println(mensagem);
    }

    public static void opcao () {
        int opc = 0;
        do {
            menu();
            opc = in.nextInt();

            switch(opc) {
                case 1:
                    insereMoedas();
                    break;
                case 2:
                    retiraUltima();
                    break;
                case 3:
                    quantidadeMoeda();
                    break;
                case 4:
                    moedasTipo();
                    break;
                case 5:
                    totalCentavos();
                    break;
                case 6:
                    totalReais();
                    break;
                case 7:
                    esvaziarCofrinho();
                    break;
                case 8:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Informe uma das opção válidas!");
                    break;
            }
        }
        while (opc != 8);
    }

    public static String converteMoeda(int moedaTipo) {
        String nome = "";
        switch (moedaTipo) {
            case 1:
                nome = "UmReal";
                return nome;
            case 2:
                nome = "CinquentaCentavos";
                return nome;
            case 3:
                nome = "VinteCincoCentavos";
                return nome;
            case 4:
                nome = "DezCentavos";
                return nome;
            case 5:
                nome = "CincoCentavos";
                return nome;
            case 6:
                nome = "UmCentavo";
                return nome;
        }
        return nome;
    }

    public static void menuEscolher() {
        String mensagem = """
                    1 - Um real [R$1,00];
                    2 - Cinquenta centavos [R$0,50];
                    3 - Vinte e Cinco centavos [R$0,25];
                    4 - Dez centavos [R$0,10];
                    5 - Cinco centavos [R$0,05];
                    6 - Um centavo [R$0,01];
                    7 - Cancelar operação.
                    """;
            System.out.println(mensagem);
    }

    public static void insereMoedas() {
        int moedaTipo = 0;
        do {
            System.out.println("\n--------------- [ ADICIONA MOEDA ] ---------------");
            System.out.println("\nInforme a moeda que deseja adicionar ao confrinho:");
            menuEscolher();

            moedaTipo = in.nextInt();

            if (moedaTipo >= 1 && moedaTipo <= 6) {
                NomeMoeda nomeMoedaEnum = NomeMoeda.valueOf(converteMoeda(moedaTipo));
                Moeda moeda = new Moeda(nomeMoedaEnum);
                cofrinho.adicionaMoeda(moeda);
            }
            else if (moedaTipo == 7) {
                System.out.println("\nParando de adicionar moedas!");
            }
            else {
                System.out.println("\nOpção de moeda inválida.");
            }
        }
        while (moedaTipo != 7);
    }

    public static void retiraUltima() {
        String opc;
        do {
            System.out.println("\n--------------- [ RETIRA ÚLTIMA MOEDA ] ---------------");
            cofrinho.retiraUltima();

            System.out.println("Deseja continua? [S - SIM | N - NÃO]");
            opc = in.next();
        }
        while (opc.equalsIgnoreCase("S"));
    }

    public static void quantidadeMoeda () {
        System.out.println("\n--------------- [ VERIFICAR TOTAL DE MOEDAS ] ---------------");
        System.out.println("\nO cofrinho tem um total de " +cofrinho.quantidadeMoeda() +" moedas.");
    }

    public static void moedasTipo () {
        int moedaTipo = 0;
        do {
            System.out.println("\n--------------- [ TOTAL DE MOEDAS POR TIPO ] ---------------");
            System.out.println("\nInforme a moeda que deseja adicionar ao confrinho:");
            menuEscolher();

            moedaTipo = in.nextInt();

            if (moedaTipo >= 1 && moedaTipo <= 6) {
                NomeMoeda nomeMoedaEnum = NomeMoeda.valueOf(converteMoeda(moedaTipo));
                Moeda moeda = new Moeda(nomeMoedaEnum);
                System.out.println("\nHá um total de " +cofrinho.quantidadePorMoeda(moeda) +" moedas desse valor!");
            }
            else if (moedaTipo == 7) {
                System.out.println("\nParando de verificar as moedas!");
            }
            else {
                System.out.println("\nOpção de moeda inválida.");
            }
        }
        while (moedaTipo != 7);
    }

    public static void totalCentavos () {
        System.out.println("\n--------------- [ VALOR TOTAL EM CENTAVOS ] ---------------");
        System.out.println("\nNo cofrinho, há um total de " +cofrinho.calculaCentavos() +" centavos.");
    }

    public static void totalReais () {
        System.out.println("\n--------------- [ VALOR TOTAL EM REAIS ] ---------------");
        System.out.println("\nNo cofrinho, há um total de " +cofrinho.calculaReal() +" reais.");
    }

    public static void esvaziarCofrinho () {
        System.out.println("\n--------------- [ ESVAZIAR COFRINHO ] ---------------");
        cofrinho.esvaziar();
    }
}