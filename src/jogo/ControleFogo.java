package jogo;


import jogo.Atores.Bomba;
import jogo.Atores.Fogo;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;


import static jogo.Cenarios.CenarioPartida.cena;
import static jogo.Cenarios.CenarioPartida.controleColisaoControle;
import static jogo.ControleCaixa.getCaixas;

public class ControleFogo {
    private Fogo[] fogo;
    private LinkedList<Fogo> fogos;

    public ControleFogo() {
        this.fogos = new LinkedList<>();
    }


    public void adicionarFogo(Bomba bomba, int tamanho){
        fogo = new Fogo[4*tamanho];
        fogo[0] = new Fogo(bomba.x + 32, bomba.y, true);
        fogo[1] = new Fogo(bomba.x - 32, bomba.y, true);
        fogo[2] = new Fogo(bomba.x, bomba.y + 32, false);
        fogo[3] = new Fogo(bomba.x, bomba.y - 32, false);
        if (tamanho > 1) {
            for (int i = 4; i < fogo.length; i++) {
                fogo[i] = fogo[i - 4].clonar();
                /* Teste
                if (controleColisaoControle.colidirTile(fogo[i])) {
                    System.out.println(i);
                }
                 */

                switch (i % 4) {
                    case 0 -> fogo[i].x += 32;
                    case 1 -> fogo[i].x -= 32;
                    case 2 -> fogo[i].y += 32;
                    case 3 -> fogo[i].y -= 32;
                }
            }
        }


        for (int i = 0; i < fogo.length; i++) {
            controleColisaoControle.colidirTile(fogo[i]);

            for (int j = 0; j < getCaixas().length; j++) {
                for (int k = 0; k < getCaixas().length; k++) {

                    if (getCaixas()[j][k] != null){
                        fogo[i].destruir(fogo[i], getCaixas()[j][k]);
                        getCaixas()[j][k].setDestruida(true);
                    }

                }
            }

            fogos.addFirst(fogo[i]);
            cena.addOverlay(fogo[i]);
        }


        Timer cronometro = new Timer();
        TimerTask tarefa = new TimerTask() {
            @Override
            public void run() {
                for (Fogo value : fogo) {
                    value.mover();
                }
            }
        };
        cronometro.schedule(tarefa, 400);
    }

    public void run(){
        for (int i = 0; i < fogos.size(); i++) {
            Fogo fogo = fogos.removeFirst();
            fogos.addLast(fogo);
        }
    }



    public Fogo[] getFogo() {
        return fogo;
    }
    public void setFogo(Fogo[] fogo) {
        this.fogo = fogo;
    }

    public LinkedList<Fogo> getFogos() {
        return fogos;
    }
    public void setFogos(LinkedList<Fogo> fogos) {
        this.fogos = fogos;
    }
}
