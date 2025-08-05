package sistemas.adivinha;

import java.util.Scanner;

public class Adivinha {
    public static void main(String [] args){
        Scanner leitor = new Scanner(System.in);
        System.out.print("Numero de tentativas: ");
        int maxNum = Integer.parseInt(leitor.nextLine());
        int pontos =100;
        int tentativas = 0;
        int y = sorteiaNum(maxNum);
        boolean acertou = false;
        while(acertou==false){
            System.out.print("digite um numero: ");
            int numero = Integer.parseInt(leitor.nextLine());
            tentativas++;
            if(numero==y){
                System.out.println("Parabéns! voçê acertou \nPontos "+pontos+"\nNumero de Tentativas "+tentativas);
                acertou = true;
            }else{
                System.out.println("ERROU! tente novamente");
                pontos-=2;
                if(numero<y){
                    System.out.println("Eh maior");
                }else{
                    System.out.println("Eh menor");
                }
            }
        }
    }
    public static int sorteiaNum(int maxTentativas){
        int x = (int) (Math.random()*maxTentativas+1);
        return x;
    }
}
