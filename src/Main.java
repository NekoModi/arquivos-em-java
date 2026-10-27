import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {


        String caminhoArquivo = "produtos-java\\produtos.txt";


        try (BufferedReader leitor = new BufferedReader(
                new FileReader(caminhoArquivo))) {

            String linha;

            while ((linha = leitor.readLine()) != null) {

                if (linha.isBlank()) {
                    continue;
                }
                String[] dados = linha.split(";");

                if (dados.length != 3) {
                    System.out.println("Linha inválida: " + linha);
                    continue;
                }

                try {
                    int id = Integer.parseInt(dados[0].trim());
                    String nome = dados[1].trim();
                    double preco = Double.parseDouble(dados[2].trim());

                    Produto produto = new Produto(id, nome, preco);

                    System.out.println(produto.toXML());

                    System.out.println();

                } catch (NumberFormatException e) {
                    System.out.println("Erro nos dados da linha: " + linha);
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
