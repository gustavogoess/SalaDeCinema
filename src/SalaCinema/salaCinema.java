package SalaCinema;

import java.util.Scanner;

public class salaCinema {
	
	private static void exibir () {
		System.out.print
		("\n1 - Visualizar lugares diponíveis\n"
		+ "2 - Realizar compra de ingresso\n"
		+ "3 - Exibir relátorio\n"
		+ "4 - Sair\n"
		+ "Escolha uma opção: ");
	}

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		int cadeiras [][]= new int[8][20];int col,n,soma=0,fila;char letra;
		exibir();	
		n = entrada.nextInt();
		
		if (n==4) {System.out.println("PROGRAMA FINALIZADO!");}
		
		while (n!=4){
			
			switch(n) {
			
				case 1:
					System.out.println();
					for (int i=0; i<cadeiras.length;i++) {
						for (int j=0; j<cadeiras[0].length;j++) {							
							System.out.print(cadeiras[i][j] + "  ");
						}System.out.println();
					}
					break;
					
				case 2:			
					System.out.print("Informe a fila (A-H): ");
					letra=entrada.next().toUpperCase().charAt(0);
					fila=((int)letra-64);
					System.out.print("Informe a posição da poltrona (1-20): ");
					col=entrada.nextInt();
					
					if (fila<0 || fila>=8 || col<0 || col>=20) {
						System.out.println("ERRO: Poltrona não Existe");
						break;
					}
						
					if (cadeiras[fila-1][col-1]==0) {
						cadeiras[fila-1][col-1]=1;
						System.out.println("Compra efetuada com sucesso!");
					}else {
						System.out.println("Erro: Poltrona não disponível");
					}
					break;
					
				case 3:
					for (int i=0; i<cadeiras.length;i++) {
						for (int j=0; j<cadeiras[0].length;j++) {
							if(cadeiras[i][j]==1) {
								soma+=1;
							}
						}
					}
					double arrecadado = soma*45;
					System.out.println("Ingressos vendidos....: " + soma);
					System.out.format("Total Arrecadado......: R$ %.2f\n",arrecadado);
					break;
					
					default: System.out.println("Opção Inválida. Escolha novamente.");
			}
			
			exibir();	
			n=entrada.nextInt();
			
		}	
		System.out.print("Programa Finalizado!");
		entrada.close();

	}

}
