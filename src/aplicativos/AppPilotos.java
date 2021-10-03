package aplicativos;

import static aplicativos.Modelo.Piloto.setCpf;

import java.io.IOException;
import java.util.Scanner;

import aplicativos.Modelo.Pessoa;
import aplicativos.Modelo.Piloto;

public class AppPilotos {
    private static Object cpf;
    private static final Object EXTRACTED = extracted(cpf);

    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0;
        Pessoa[] Pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }
                Scanner ler = new Scanner(System.in);
                ler.nextLine();
            
                System.out.println("Informe o nome do piloto : ");
                Piloto.setNome(ler.nextLine());
        
                System.out.println("Informe o cpf do piloto : ");
                setCpf(ler.nextLine());
            

                System.out.println("Informe a habilitacao do piloto : ");
                Piloto.getHabilitacao(ler.nextLine());

                System.out.println("Informe a matricula do piloto : ");
                Piloto.setMatricula(ler.nextInt());
               
                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);
            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                System.out.println("O nome do piloto é " + Piloto.getNome());
                System.out.println("O cpf do piloto é " + Piloto.getCpf());
                System.out.println("A matricula do piloto é " + Piloto.getMatricula());
                System.out.println("A habilitação do piloto é " + Piloto.getHabilitacao(null));

                voltarMenu(in);
            } else if (opcao == 3) {
               
                System.out.println("Informe o cpf do piloto desejado: " );
                System.out.println("O piloto encontrado de acordo com o cpf foi " + Piloto.getNome());
                System.out.println("\nNão há pilotos com o cpf digitado para exibir.");
            }
             else if (opcao == 4) {

                System.out.println("Digite o novo tamhanho do armazenamento: ");
                Object vetorTamanho;
                if(vetorTamanho != null){
                for(int i = 0; i < vetorTamanho.length; i++){
                System.out.println(" O tamanho do novo vetor é " + vetorTamanho[i].getVetorTamnho());
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void extracted3(Scanner ler) {
        extracted2(ler);
    }

    private static void extracted2(Scanner ler) {
        Piloto.setCpf(ler.nextLine(), EXTRACTED);
    }

    private static Object extracted(Object cpf) {
        return cpf;
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }

    public static void setCpf(String cpf);
}
