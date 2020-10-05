import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		ArrayList<Jogo> jogo = new ArrayList<Jogo>();
		
		jogo.add(new Jogo(12));
		jogo.add(new Jogo(24));
		jogo.add(new Jogo(10));
		jogo.add(new Jogo(24));
		
		int opcao;
		
		//Enquanto não optar por 3 a consulta irá continuar
		do {
			System.out.println("Digite 1 para consulta ou 2 para inserir jogos ou 3 para sair: ");
			opcao = entrada.nextInt();
			
			if(opcao != 1 && opcao != 2 && opcao != 3) {
				break;
			}
			else if(opcao == 1) {
				int partida = 1;
				int maior = 0;
				int menor = 999;
				int recordMin = 0;
				int recordMax = 0;
				
				System.out.printf("Jogos\tPlacar\tMínimo da temporada\tMáximo da temporada\tQuebra recorde"
						+ "min.\tQuebra recorde máx.\n ");
				
				//vai percorrer a lista de jogos e ver o maior, menor e os recordes de pontos
				for(int i = 0; i < jogo.size(); i++) {
					if(menor > jogo.get(i).getPlacar()) {
						menor = jogo.get(i).getPlacar();
					}
					
					if(maior < jogo.get(i).getPlacar()) {
						maior = jogo.get(i).getPlacar(); 
					}
					
					if(i > 0 && jogo.get(i).getPlacar() > jogo.get(i - 1).getPlacar()) {
						recordMax++;
					}
					else if(i > 0 && jogo.get(i).getPlacar() < jogo.get(i - 1).getPlacar()) {
						recordMin++;
					}
					System.out.printf("%d\t%d\t%d\t\t\t%d\t\t\t%d\t\t\t%d\n ", partida, jogo.get(i).getPlacar(), 
							menor,maior,recordMin,recordMax);
					partida++;
				}	
			}
			else if(opcao == 2) {
				System.out.println("Digite o placar do jogo: ");
				if(entrada.hasNextInt()) {
					int placar = entrada.nextInt();
					
					jogo.add(new Jogo(placar));
				}
				else {
					System.out.println("Erro: Apenas números inteiros. ");
				}
			}
		}while(opcao != 3);
		
	}
}
