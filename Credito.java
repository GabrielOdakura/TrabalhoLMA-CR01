import java.util.Scanner;

public class Credito {

    public static void main(String[] args) {
        // Declaração de variáveis para armazenar os valores individuais dos dígitos
        int [] valor = new int[16];


        long numero;

        Scanner input = new Scanner(System.in);

        // Solicita um número longo até que seja inserido um valor maior ou igual a 1
        do {
            numero = input.nextLong();
        }while(numero < 1);

        // Pegando do último ao primeiro dígito, pulando um por um e multiplicando por 2
        valor[14] = (((int) numero / 10) % 10) * 2;
        valor[12] = ((((int) numero / 10) / 100) % 10) * 2;
        valor[10] = (((((int) numero / 10) / 100) / 100) % 10) * 2;
        valor[8] = ((((((int) numero / 10) / 100) / 100) / 100) % 10) * 2;
        valor[6] = (((((((int) numero / 10) / 100) / 100) / 100) / 100) % 10) * 2;
        valor[4] = ((((((((int) numero / 10) / 100) / 100) / 100) / 100) / 100) % 10) * 2;
        valor[2] = (((((((((int) numero / 10) / 100) / 100) / 100) / 100) / 100) / 100) % 10) * 2;
        valor[0] = ((((((((((int) numero / 10) / 100) / 100) / 100) / 100) / 100) / 100) / 100) % 10) * 2;

        // Pegar os valores e somar (transformando os decimais em unidades)
        valor[14] = ((valor[14] / 10) % 10) + (valor[14] % 10);
        valor[12] = ((valor[12] / 10) % 10) + (valor[12] % 10);
        valor[10] = ((valor[10] / 10) % 10) + (valor[10] % 10);
        valor[8] = ((valor[8] / 10) % 10) + (valor[8] % 10);
        valor[6] = ((valor[6] / 10) % 10) + (valor[6] % 10);
        valor[4] = ((valor[4] / 10) % 10) + (valor[4] % 10);
        valor[2] = ((valor[2] / 10) % 10) + (valor[2] % 10);
        valor[0] = ((valor[0] / 10) % 10) + (valor[0] % 10);

        int primeiraSoma = valor[0] + valor[2] + valor[4] + valor[6] + valor[8] + valor[10] + valor[12] + valor[14];

        // Pegando os números que não foram somados
        valor[1] = (int) numero % 10;
        valor[3] = ((int) numero / 10000) % 10;
        valor[5] = ((int) numero / 1000000) % 10;
        valor[7] = ((int) numero / 100000000) % 10;
        valor[9] = ((int) numero / (100000 * 100000)) % 10;
        valor[11] = ((int) numero / (100000 * 10000000)) % 10;
        valor[13] = ((int) numero / (1000000 * 100000000)) % 10;
        valor[15] = ((int) numero / (10000000 * 1000000000)) % 10;

        int segundaSoma  = valor[1] + valor[3] + valor[5] + valor[7] + valor[9] + valor[11] + valor[13] + valor[15];

        int somaTotal = primeiraSoma + segundaSoma;

        // Verificar se o cartão tem resto 0 após a soma
        if (somaTotal % 10 != 0) {
            System.out.println("Invalido\nSoma total: " + somaTotal);
            System.exit(0);
        }

        // Contador de dígitos do número
        int contador = 0;

        while (numero != 0) {
            numero /= 10; // dividindo o valor da variável numero por 10 e, em seguida,
            contador++;    // atribuindo o resultado de volta à variável numero
        }

        // Verificando a marca do cartão com base no número de dígitos e no primeiro dígito
        if (contador == 16 && ((valor[0] + valor[1]) >= 6 && (valor[0] + valor[1]) <= 10)) {
            System.out.println("MASTERCARD");
        }else if (contador == 15 && ((valor[0] + valor[1]) >= 7 && (valor[0] + valor[1]) <= 10)) {
            System.out.println("AMERICAN EXPRESS");
        }else if ((contador == 13 || contador == 16) && (valor[0] == 4)) {
            System.out.println("VISA");
        }
    }
}
