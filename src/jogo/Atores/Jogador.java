package jogo.Atores;

import jogo.Cenarios.CenarioPartida;
import jogo.ControleBomba;
import jplay.*;
import javax.swing.*;


import static jogo.Cenarios.CenarioPartida.controleColisaoControle;
import static jogo.Main.janela;

public class Jogador extends Ator {
    private boolean morto;
    private int pntsVida;
    private int qntBombas;
    private int tamanhoBomba;
    private GameImage foto;
    private boolean isJogador1;

    public Jogador(String enderecoSprite, Personagem personagem) {
        super(enderecoSprite, 8);
        this.setTotalDuration(1500);
        this.morto = false;
        this.pntsVida = 3;
        this.qntBombas = 1;
        this.tamanhoBomba = 1;
        this.foto = personagem.getFoto();
        this.isJogador1 = true;
    }

    @Override
    public void movimentar(){

        if ( janela.getKeyboard().keyDown(Keyboard.LEFT_KEY) && !isJogador1 || janela.getKeyboard().keyDown(65) && isJogador1){
            if (this.x>0){
                this.x-=velocidade;
            }
            if (direcao !=1){
                setSequence(2,4);
                direcao = 1;
            }
            movendo = true;


        }else if( janela.getKeyboard().keyDown(Keyboard.RIGHT_KEY) && !isJogador1 || janela.getKeyboard().keyDown(68) && isJogador1){
            if (this.x<1000){
                this.x+=velocidade;
            }
            if (direcao !=2){
                setSequence(6,8);
                direcao = 2;
            }
            movendo = true;


        }else if(janela.getKeyboard().keyDown(Keyboard.UP_KEY) && !isJogador1 || janela.getKeyboard().keyDown(87) && isJogador1){
            if (this.y>0){
                this.y-=velocidade;
            }
            if (direcao !=4){
                setSequence(4,6);
                direcao = 4;
            }
            movendo = true;


        }else if(janela.getKeyboard().keyDown(Keyboard.DOWN_KEY) && !isJogador1 || janela.getKeyboard().keyDown(83) && isJogador1){
            if (this.y<750){
                this.y+=velocidade;
            }
            if (direcao !=5){
                setSequence(0,2);
                direcao = 5;
            }
            movendo = true;

        }
        else if(janela.getKeyboard().keyDown(Keyboard.ESCAPE_KEY)){
            String[] opcoes = { "Continuar", "Reiniciar", "Sair" };
            int escolha = JOptionPane.showOptionDialog(null, "Jogo pausado!", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha == 1) {
                new CenarioPartida();
            } else if (escolha == 2){
                System.exit(0);
            }
        }

        if (movendo){
            controleColisaoControle.colidirTile(this);
            update();
            movendo = false;
        }
    }

    ControleBomba bombas = new ControleBomba();


    public void colocarBomba(){
        if (((janela.getKeyboard().keyDown(Keyboard.SPACE_KEY) && isJogador1) || (janela.getKeyboard().keyDown(97) && !isJogador1)) && !isMorto()){
            if (qntBombas >= 1){
                qntBombas -= 1;
                System.out.println("bomba colocada");
                bombas.colocar(this);

            }
        }
        bombas.run();
    }

    public void restaurar(){
        this.morto = false;
        this.pntsVida = 3;
        this.qntBombas = 1;
        this.tamanhoBomba = 1;
    }


    public boolean isJogador1() {
        return isJogador1;
    }

    public void setJogador1(boolean jogador1) {
        this.isJogador1 = jogador1;
    }

    public GameImage getFoto() {
        return foto;
    }

    public void setFoto(Sprite foto) {
        this.foto = foto;
    }

    public int getPntsVida() {
        return pntsVida;
    }

    public void setPntsVida(int pntsVida) {
        this.pntsVida = pntsVida;
    }

    public int getQntBombas() {
        return qntBombas;
    }

    public void setQntBombas(int qntBombas) {
        this.qntBombas = qntBombas;
    }

    public int getTamanhoBomba() {
        return tamanhoBomba;
    }

    public void setTamanhoBomba(int tamanhoBomba) {
        this.tamanhoBomba = tamanhoBomba;
    }

    public boolean isMorto() {
        return morto;
    }

    public void setMorto(boolean morto) {
        this.morto = morto;
    }
}


