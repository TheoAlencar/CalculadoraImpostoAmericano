import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entradas
        System.out.print("Descrição do Produto: ");
        String descricao = sc.nextLine();

        System.out.print("Origem (1-China, 2-UE, 3-Japão, 4-Coreia, 5-Vietnã, 6-Tailândia, 7-Canadá, 8-México, 9-Outros): ");
        int origem = sc.nextInt();

        System.out.print("Categoria (1-Geral, 2-Fármacos, 3-Semicondutores, 4-Cobre, 5-Madeira, 6-Energia/Minerais, 7-Bullion): ");
        int categoria = sc.nextInt();

        System.out.print("Valor da Mercadoria (USD): ");
        double valorMercadoria = sc.nextDouble();

        System.out.print("Valor do Frete (USD): ");
        double valorFrete = sc.nextDouble();

        boolean usmca = false;
        if (origem == 7 || origem == 8) {
            System.out.print("USMCA (true/false): ");
            usmca = sc.nextBoolean();
        }

        // Nome dos países
        String paisOrigem;
        switch (origem) {
            case 1: paisOrigem = "China"; break;
            case 2: paisOrigem = "União Europeia"; break;
            case 3: paisOrigem = "Japão"; break;
            case 4: paisOrigem = "Coreia do Sul"; break;
            case 5: paisOrigem = "Vietnã"; break;
            case 6: paisOrigem = "Tailândia"; break;
            case 7: paisOrigem = "Canadá"; break;
            case 8: paisOrigem = "México"; break;
            default: paisOrigem = "Outros"; break;
        }

        // Nome das categorias
        String nomeCategoria;
        switch (categoria) {
            case 1: nomeCategoria = "Geral"; break;
            case 2: nomeCategoria = "Fármacos"; break;
            case 3: nomeCategoria = "Semicondutores"; break;
            case 4: nomeCategoria = "Cobre"; break;
            case 5: nomeCategoria = "Madeira"; break;
            case 6: nomeCategoria = "Energia/Minerais"; break;
            case 7: nomeCategoria = "Bullion"; break;
            default: nomeCategoria = "Desconhecida"; break;
        }

        // Definir alíquota
        double aliquota = 0.0;

        if (origem == 7 || origem == 8) { // Canadá ou México
            if (usmca) {
                aliquota = 0.0;
            } else {
                if (categoria == 6) {
                    aliquota = 0.10;
                } else {
                    aliquota = 0.25;
                }
            }
        } else if (origem == 9) { // Outros
            aliquota = 0.10;
        } else { // China, UE, Japão, Coreia, Vietnã, Tailândia
            if (categoria == 1) { // Geral -> tabela
                switch (origem) {
                    case 1: aliquota = 0.34; break; // China
                    case 2: aliquota = 0.20; break; // UE
                    case 3: aliquota = 0.24; break; // Japão
                    case 4: aliquota = 0.26; break; // Coreia
                    case 5: aliquota = 0.46; break; // Vietnã
                    case 6: aliquota = 0.37; break; // Tailândia
                }
            } else {
                aliquota = 0.10;
            }
        }

        // Cálculo CIF e imposto
        double cif = valorMercadoria + valorFrete;
        double imposto = cif * aliquota;
        double valorFinal = cif + imposto;

        // Saída final
        System.out.println("\n--- Resultado ---");
        System.out.println("Produto: " + descricao);
        System.out.println("Origem: " + paisOrigem);
        System.out.println("Categoria: " + nomeCategoria);
        System.out.printf("CIF (Mercadoria + Frete): $%.2f%n", cif);
        System.out.printf("Alíquota aplicada: %.2f%%%n", aliquota * 100);
        System.out.printf("Imposto: $%.2f%n", imposto);
        System.out.printf("Valor Final: $%.2f%n", valorFinal);

        sc.close();
    }
}
