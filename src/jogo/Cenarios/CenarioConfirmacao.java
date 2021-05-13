package jogo.Cenarios;

import jogo.Atores.Jogador;
import jplay.Keyboard;
import jplay.Sprite;

import static jogo.Cenarios.CenarioSelecaoPersonagem.*;
import static jogo.Main.janela;

public class CenarioConfirmacao {

    private Sprite planoFundo;


    public CenarioConfirmacao(){
        this.planoFundo = new Sprite("src\\Recursos\\imagens\\sprites\\TelaConfirmacao_2F.png", 2);

        while(true){
            planoFundo.draw();


            if (jogador1!=null){
                mostrarFoto(jogador1);
            }
            if (jogador2 != null){
                mostrarFoto(jogador2);
            }



            if (janela.getKeyboard().keyDown(Keyboard.UP_KEY)){
                planoFundo.setCurrFrame(0);
            }
            if(janela.getKeyboard().keyDown(Keyboard.DOWN_KEY)){
                planoFundo.setCurrFrame(1);
            }
            if (janela.getKeyboard().keyDown(Keyboard.ENTER_KEY)){
                if (planoFundo.getCurrFrame() == 0){
                    new CenarioPartida();
                }else{
                    jogador1 = null;
                    jogador2 = null;
                    vezJogadorDois = false;
                    break;
                }
            }

            janela.update();
        }
    }



    public void mostrarFoto(Jogador jogador){
        if (jogador.isJogador1()){
            jogador.getFoto().x =116;
            jogador.getFoto().y =126;
            jogador.getFoto().draw();
        }else{
            jogador.getFoto().x = 1062;
            jogador.getFoto().y = 126;
            jogador.getFoto().draw();
        }
    }


    public Sprite getPlanoFundo() {
        return planoFundo;
    }
    public void setPlanoFundo(Sprite planoFundo) {
        this.planoFundo = planoFundo;
    }
}
