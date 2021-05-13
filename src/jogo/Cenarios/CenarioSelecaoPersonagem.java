package jogo.Cenarios;

import jogo.Atores.Jogador;
import jogo.Atores.Personagem;
import jplay.Keyboard;
import jplay.Sprite;
import java.awt.*;

import static jogo.Main.janela;

public class CenarioSelecaoPersonagem {

    public static final Personagem generico1= new Personagem.PersonagemBuilder("Generico1")
            .sprite(Personagem.spriteGenerico1)
            .foto("src\\recursos\\imagens\\sprites\\atores\\personagem\\Generico1_Foto.png")
            .criarPersonagem();
    public static final Personagem generico2 = new Personagem.PersonagemBuilder("Generico2")
            .sprite(Personagem.spriteGenerico2)
            .foto("src\\recursos\\imagens\\sprites\\atores\\personagem\\Generico2_Foto.png")
            .criarPersonagem();
    public static final Personagem generico3 = new Personagem.PersonagemBuilder("Generico3")
            .sprite(Personagem.spriteGenerico3)
            .foto("src\\recursos\\imagens\\sprites\\atores\\personagem\\Generico3_Foto.png")
            .criarPersonagem();
    public static final Personagem generico4 = new Personagem.PersonagemBuilder("Generico4")
            .sprite(Personagem.spriteGenerico4)
            .foto("src\\recursos\\imagens\\sprites\\atores\\personagem\\Generico4_Foto.png")
            .criarPersonagem();
    public static final Personagem pikachu = new Personagem.PersonagemBuilder("pikachu")
            .sprite(Personagem.spritePikachu)
            .foto("src\\recursos\\imagens\\sprites\\atores\\personagem\\Pikachu_Foto.png")
            .criarPersonagem();

    public static Jogador jogador1;
    public static Jogador jogador2;
    protected static boolean vezJogadorDois;
    private Sprite telaFundo;

    public CenarioSelecaoPersonagem() {
        telaFundo = new Sprite("src\\recursos\\imagens\\sprites\\TelaPersonagens.png", 5);
        vezJogadorDois = false;

        while(true){
            telaFundo.draw();

            if (!vezJogadorDois){
                janela.drawText("Jogador 1", 612, 624, Color.black, new Font("Franklin Gothic Demi", Font.PLAIN, 13));
            }else{
                janela.drawText("Jogador 2", 612, 624, Color.black, new Font("Franklin Gothic Demi", Font.PLAIN, 13));
            }


            if(janela.getKeyboard().keyDown(Keyboard.LEFT_KEY)){
                telaFundo.setCurrFrame(0);
            }
            if(janela.getKeyboard().keyDown(Keyboard.UP_KEY)){
                telaFundo.setCurrFrame(1);
            }
            if(janela.getKeyboard().keyDown(Keyboard.DOWN_KEY)){
                telaFundo.setCurrFrame(2);
            }
            if(janela.getKeyboard().keyDown(Keyboard.RIGHT_KEY)){
                telaFundo.setCurrFrame(3);
            }
            if(janela.getKeyboard().keyDown(Keyboard.LEFT_KEY) && janela.getKeyboard().keyDown(80)){
                telaFundo.setCurrFrame(4);
            }
            if (janela.getKeyboard().keyDown(Keyboard.ENTER_KEY)){
                if (!vezJogadorDois){
                    switch (telaFundo.getCurrFrame()) {
                        case 0 -> jogador1 = new Jogador(Personagem.spriteGenerico1, generico1);
                        case 1 -> jogador1 = new Jogador(Personagem.spriteGenerico2, generico2);
                        case 2 -> jogador1 = new Jogador(Personagem.spriteGenerico3, generico3);
                        case 3 -> jogador1 = new Jogador(Personagem.spriteGenerico4, generico4);
                        case 4 -> jogador1 = new Jogador(Personagem.spritePikachu, pikachu);
                    }

                    vezJogadorDois = true;
                    telaFundo.setCurrFrame(0);
                }else{
                    switch (telaFundo.getCurrFrame()) {
                        case 0 -> jogador2 = new Jogador(Personagem.spriteGenerico1,generico1);
                        case 1 -> jogador2 = new Jogador(Personagem.spriteGenerico2,generico2);
                        case 2 -> jogador2 = new Jogador(Personagem.spriteGenerico3,generico3);
                        case 3 -> jogador2 = new Jogador(Personagem.spriteGenerico4,generico4);
                        case 4 -> jogador2 = new Jogador(Personagem.spritePikachu, pikachu);
                    }
                    jogador2.setJogador1(false);
                    new CenarioConfirmacao();
                }

            }
            if (janela.getKeyboard().keyDown(Keyboard.ESCAPE_KEY)){
                jogador1 = null;
                jogador2 = null;
                vezJogadorDois = false;
                break;
            }
            janela.update();
        }
    }


    public Sprite getTelaFundo() {
        return telaFundo;
    }
    public void setTelaFundo(Sprite telaFundo) {
        this.telaFundo = telaFundo;
    }
}
