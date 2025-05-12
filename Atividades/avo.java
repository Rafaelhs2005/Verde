import java.util.*;

public class avo {

    public static void main(String[] args) {
        int[] players = new int[10001];
        Scanner sc = new Scanner(System.in);

        int nRank = sc.nextInt();
        int nPlayer = sc.nextInt();
        int player;

        while(((nRank)!= 0 && (nPlayer)!= 0)){
            Arrays.fill(players, 0);
            for(int i = 0; i < nRank; i++){
                for(int j = 0; j < nPlayer; j++){
                    player = sc.nextInt();
                    players[player]++;
                }
            }

            int maior = 0;
            int segundoMaior = 0;
            for(int i = 1; i < players.length; i++){
                if(players[i] > maior){
                    maior = players[i];
                }
            }
            for(int i = 1; i < players.length; i++){
                if(players[i] > segundoMaior && players[i] < maior){
                    segundoMaior = players[i];
                }
            }
            StringBuilder resultado = new StringBuilder();
            for(int i = 1; i < players.length; i++){
                if(players[i] == segundoMaior){
                    resultado.append(i).append(" ");
                }
            }
            System.out.println(resultado);

            nRank = sc.nextInt();
            nPlayer = sc.nextInt();
        }
        sc.close();
    }

}
