package jogo;

import jogo.Atores.Caixa;

import java.util.Random;

import static jogo.Cenarios.CenarioPartida.*;
import static jogo.Cenarios.CenarioSelecaoPersonagem.jogador1;
import static jogo.Cenarios.CenarioSelecaoPersonagem.jogador2;

public class ControleCaixa {
    public static Caixa[][] caixas;
    public static int numCaixas;
    private Caixa caixaPrototype;
    private Random caixaAleatoria ;

    public ControleCaixa() {
        caixas = new Caixa[21][21];
        numCaixas = 0;
        caixaPrototype= new Caixa();
        caixaAleatoria = new Random();
    }

    public void gerarCaixas() {

        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {


                if ((i % 2 != 0) && (j % 2 != 0)) {
                    //Nao vai criar caixas em cima dos blocos inquebraveis (Ímpares)

                } else if ((i == 0 && j == 0 || i == 0 && j == 1 || i == 1 && j == 0 || i == 19 && j == 20 ||
                        i == 20 && j == 19 || i == 20 && j == 20)) {
                    //Nao vai criar caixas em posicoes que nao podem haver caixas

                }else if (this.caixaAleatoria.nextBoolean()) {
                    //posicionamento das caixas dentro da arena
                    //caixas[i][j] = new Caixa(32 * (i) + 320,32 * (j) + 64);
                    caixas[i][j] = this.caixaPrototype.clonar();
                    caixas[i][j].setX(32 * (i) + 320);
                    caixas[i][j].setY(32 * (j) + 64);
                    numCaixas += 1;
                }
            }
        }
    }


    public void run() {
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                if (caixas[i][j] != null) {
                    //mostrar na tela e adiciona colisão com o jogador
                    //cena.addOverlay(caixas[i][j]);
                    caixas[i][j].draw();
                    controleColisaoControle.colidirObjetos(jogador1, caixas[i][j]);
                    controleColisaoControle.colidirObjetos(jogador2, caixas[i][j]);

                }
            }
        }
    }


    public static Caixa[][] getCaixas() {
        return caixas;
    }
    public void setCaixas(Caixa[][] caixas) {
        this.caixas = caixas;
    }

    public Caixa getCaixaPrototype() {
        return caixaPrototype;
    }
    public void setCaixaPrototype(Caixa caixaPrototype) {
        this.caixaPrototype = caixaPrototype;
    }
}
