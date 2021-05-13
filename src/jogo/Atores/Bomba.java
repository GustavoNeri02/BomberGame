package jogo.Atores;

public class Bomba extends Ator {
    private int tamanho;
    private boolean explodiu;

    public Bomba(Jogador ator) {
        super("src\\Recursos\\imagens\\sprites\\atores\\bombaSprite.png", 11);
        this.x = ator.x;
        this.y = ator.y;
        this.tamanho = ator.getTamanhoBomba();
        this.explodiu = false;
        //colocar posicao da bomba entre 32 pixels para ajustar posicionamento com a arena
        do{
            if (this.x >= 32){
                this.x -= 32;
            }
            if (this.y >= 32){
                this.y -= 32;
            }
        }while(this.x>=32 || this.y >=32);

        //posicao da bomba em relacao ao personagem e a arena

        if (ator.x - this.x < 320){
            this.x = 320;
        }else{
            this.x = ator.x - this.x;
        }

        if (ator.y - this.y > 704){
            this.y = 704;
        }else{
            this.y = ator.y - this.y ;
        }



        this.setFinalFrame(10);
        this.setTotalDuration(4000);
    }


    public boolean isExplodiu() {
        return explodiu;
    }
    public void setExplodiu(boolean explodiu) {
        this.explodiu = explodiu;
    }

    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
