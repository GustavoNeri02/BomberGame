package jogo;

import jogo.Atores.Caixa;
import jogo.Atores.Fogo;
import jogo.Atores.Jogador;
import jplay.GameObject;
import jplay.TileInfo;

import java.awt.*;
import java.util.Vector;

import static jogo.Cenarios.CenarioPartida.cena;
import static jogo.ControleCaixa.numCaixas;

public class ControleColisao {

    public ControleColisao() {
    }

    //colizao com tiles do cenarioPartida
    public boolean colidirTile(GameObject objeto){
        Point minimo = new Point((int)objeto.x, (int)objeto.y);
        Point maximo = new Point((int)objeto.x + objeto.width, (int)objeto.y + objeto.height);

        Vector<?> tiles = cena.getTilesFromPosition(minimo, maximo);

        for (int i = 0; i < tiles.size(); i++) {

            //TileInfo == GameObject
            //informacao do tile da arena
            TileInfo tile = (TileInfo) tiles.elementAt(i);

            //collided em controle.colisao.
            if (colisaoComTile(objeto, tile)) {
                if (objeto.getClass() == Jogador.class){
                    if (colisaoVertical(objeto, tile)){
                        //coloca o personagem acima do bloco
                        if (objeto.y > tile.y + tile.height -2) {
                            objeto.y = tile.y + tile.height;
                        }
                        //coloca o personagem abaixo do bloco
                        else if (tile.y > objeto.y + objeto.height -2 ) {
                            objeto.y = tile.y - objeto.height ;
                        }
                    }
                    if (colisaoHorizontal(objeto, tile)){
                        //coloca o personagem a esquerda do bloco
                        if (tile.x > objeto.x + objeto.width -2){
                            objeto.x = tile.x - objeto.width;
                        }
                        //coloca o personagem a diteira do bloco
                        else if(objeto.x > tile.x + tile.width -2){
                            objeto.x = tile.x + tile.width;
                        }
                    }
                }else if (objeto.getClass() == Fogo.class){
                    objeto.y = -32;
                }
                return true;
            }

        }
        return false;
    }


    //colizao com caixas e bombas
    public void colidirObjetos(GameObject objeto1, GameObject objeto2){
        if (objeto1.collided(objeto2)){

            if (objeto1.getClass() == Fogo.class && objeto2.getClass() == Caixa.class){
                objeto2.x = -32;
                objeto2 = null;
                numCaixas -= 1;
            }else {
                if (colisaoVertical(objeto1, objeto2)) {
                    //coloca o personagem acima do bloco
                    if (objeto1.y > objeto2.y + objeto2.height - 2) {
                        objeto1.y = objeto2.y + objeto2.height;
                    }
                    //coloca o personagem abaixo do bloco
                    else if (objeto2.y > objeto1.y + objeto1.height - 2) {
                        objeto1.y = objeto2.y - objeto1.height;
                    }

                }

                if (colisaoHorizontal(objeto1, objeto2)) {
                    //coloca o personagem a esquerda do bloco
                    if (objeto2.x > objeto1.x + objeto1.width - 2) {
                        objeto1.x = objeto2.x - objeto1.width;
                    }
                    //coloca o personagem a direita do bloco
                    else if (objeto1.x > objeto2.x + objeto2.width - 2) {
                        objeto1.x = objeto2.x + objeto2.width;
                    }
                }
            }
        }
    }

    private boolean colisaoVertical(GameObject obj1, GameObject obj2){
        //Lembrete: Ja estao colididos
        if (obj1.x >= obj2.x + obj2.width){
            return false;
        }
        if (obj2.x >= obj1.x + obj1.width){
            return false;
        }
        return true;
    }

    private boolean colisaoHorizontal(GameObject obj1, GameObject obj2){
        //Lembrete: Ja estao colididos
        if (obj2.y >= obj1.y + obj1.height){
            return false;
        }
        if (obj1.y >= obj2.y + obj2.height){
            return false;
        }
        return true;
    }

    public boolean colisaoComTile(GameObject objeto, TileInfo tile){
        //tiles com id > 1 no cenario.scn terao efeito de colisao
        if(tile.id >= 2 && tile.collided(objeto)){
            return true;
        }
        return false;
    }

}
