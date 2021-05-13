package jogo.Atores;

import jplay.Sprite;


public class Caixa extends Sprite {
    private static String enderecoSprite = "src\\recursos\\imagens\\sprites\\atores\\caixaSprite.png";

    private boolean destruida;

    public Caixa(){
        super(enderecoSprite, 3);
        this.destruida = false;
    }

    public Caixa(Caixa caixaPrototype) {
        super(enderecoSprite, 3);
        this.x = caixaPrototype.getX();
        this.y = caixaPrototype.getY();
        this.destruida = caixaPrototype.isDestruida();
    }


    public Caixa clonar(){
        return new Caixa(this);
    }



    public boolean isDestruida() {
        return destruida;
    }
    public void setDestruida(boolean destruida) {
        this.destruida = destruida;
    }

    public static String getEnderecoSprite() {
        return enderecoSprite;
    }
    public static void setEnderecoSprite(String enderecoSprite) {
        Caixa.enderecoSprite = enderecoSprite;
    }
}
