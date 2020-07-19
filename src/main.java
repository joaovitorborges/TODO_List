import java.security.cert.TrustAnchor;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        to_do_list list = new to_do_list();
        Scanner scan = new Scanner(System.in);


        while(true){
            list.print_list();

            System.out.println("\nEscolha uma função(digite o número ou nome):");
            System.out.println(" 1 - Adicionar tarefa" +
                    "\n 2 - marcar / desmarcar tarefa" +
                    "\n 3 - deletar tarefa" +
                    "\n 4 - fechar programa");

            String answer = scan.nextLine();

            if (answer.equals("1") || answer.toLowerCase().contains("adicionar")){
                System.out.println("Insira o nome da tarefa:");
                answer = scan.nextLine();
                if (!list.add_task(answer)){
                    System.out.println("Nome já existente.");
                }
                else{
                    System.out.println("Tarefa adicionada.");
                }

            }
            if (answer.equals("2") || answer.toLowerCase().contains("marcar")){
                System.out.println("Insira o nome da tarefa:");
                answer = scan.nextLine();

                if (!list.update_task(answer)){
                    System.out.println("Tarefa não encontrada.");
                }
                else{
                    System.out.println("Tarefa atualizada.");
                }

            }
            if (answer.equals("3") || answer.contains("deletar")){
                System.out.println("Insira o nome da tarefa:");
                answer = scan.nextLine();
                System.out.println("Tem certeza de que quer deletar \""+answer+"\"?(sim/não)");
                if(scan.nextLine().toLowerCase().equals("sim")) {
                    if (list.delete_task(answer)){
                        System.out.println("Tarefa deletada.");
                    }
                    else{
                        System.out.println("Tarefa não encontrada.");
                    }
                }
                else{
                    System.out.println("ação cancelada.");
                }
            }
            if (answer.equals("4") || answer.contains("fechar")){
                break;
            }

            System.out.println("pressione enter para continuar.");
            scan.nextLine();

            System.out.println("\n\n\n\n\n");
        }


    }
}
