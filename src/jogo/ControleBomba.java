package jogo;

import jogo.Atores.Bomba;
import jogo.Atores.Jogador;
import jplay.Sprite;
import java.util.LinkedList;

import static jogo.Cenarios.CenarioPartida.*;
import static jogo.Cenarios.CenarioSelecaoPersonagem.jogador1;
import static jogo.Cenarios.CenarioSelecaoPersonagem.jogador2;

public class ControleBomba {
    private Jogador ator;
    private LinkedList<Bomba> bombas;
    private ControleFogo fogos;

    public ControleBomba() {
        this.bombas = new LinkedList<>();
        this.fogos = new ControleFogo();
    }

    public void colocar(Jogador ator){
        Bomba bomba = new Bomba(ator);
        this.ator = ator;
        bombas.addFirst(bomba);
        cena.addOverlay(bomba);
    }

    public void explodir(Bomba bomba){

        machucar(bomba, jogador1);
        machucar(bomba, jogador2);
        bomba.stop();
        bombas.remove(bomba);
        bomba.x = (-32);
        bomba.setExplodiu(true);
        if (!ator.isMorto()){
            ator.setQntBombas(ator.getQntBombas() + 1);
        }
    }

    public void run(){
        for (int i = 0; i < bombas.size(); i++) {
            Bomba bomba = bombas.removeFirst();
            controleColisaoControle.colidirObjetos(jogador1, bomba);
            if (jogador2 != null){
                controleColisaoControle.colidirObjetos(jogador2, bomba);
            }
            bomba.update();
            bombas.addLast(bomba);
            if (!bomba.isExplodiu() && bomba.getCurrFrame()==9) {
                expandir(bomba);
                for (int j = 0; j < fogos.getFogo().length; j++) {
                    machucar(fogos.getFogo()[j], jogador1);
                    if (jogador2 != null) {
                        machucar(fogos.getFogo()[j], jogador2);
                    }
                }
                explodir(bomba);
                bomba.setExplodiu(true);
            }
        }
    }

    private void machucar(Sprite bomba, Jogador jogador){
        if (jogador.getClass() == Jogador.class && bomba.collided(jogador)) {
            jogador.setPntsVida(jogador.getPntsVida()-1);
            if (jogador.getPntsVida() >=1) {
                System.out.println("Doeu!");
            }else{
                jogador.setMorto(true);
                jogador.stop();
                jogador.setQntBombas(0);
                jogador.x = -32;
            }
        }
    }

    public void expandir(Bomba bomba){
        fogos.adicionarFogo(bomba, bomba.getTamanho());
        fogos.run();
    }


    public Jogador getAtor() {
        return ator;
    }
    public void setAtor(Jogador ator) {
        this.ator = ator;
    }
    public LinkedList<Bomba> getBombas() {
        return bombas;
    }
    public void setBombas(LinkedList<Bomba> bombas) {
        this.bombas = bombas;
    }
    public ControleFogo getFogos() {
        return fogos;
    }
    public void setFogos(ControleFogo fogos) {
        this.fogos = fogos;
    }
}
