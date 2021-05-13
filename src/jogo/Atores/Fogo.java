package jogo.Atores;

import jplay.Sprite;

import static jogo.Cenarios.CenarioPartida.*;

public class Fogo extends Sprite {

    public Fogo(double x, double y, boolean vertical) {
        super("src\\Recursos\\imagens\\sprites\\atores\\bombaSprite.png", 11);
        if (vertical) {
            setCurrFrame(9);
        } else {
            setCurrFrame(10);
        }
        this.x = x;
        this.y = y;
    }

    public Fogo(Fogo fogoPrototipo){
        super("src\\Recursos\\imagens\\sprites\\atores\\bombaSprite.png", 11);
        this.setCurrFrame(fogoPrototipo.getCurrFrame());
        this.x = fogoPrototipo.getX();
        this.y = fogoPrototipo.getY();
    }



    public void mover(){
        this.y = -32;
    }

    public void destruir(Fogo fogo, Caixa caixa) {
        controleColisaoControle.colidirObjetos(fogo, caixa);
    }

    public Fogo clonar(){
        return new Fogo(this);
    }
}
