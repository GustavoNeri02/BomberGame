package jogo.Cenarios;

import jogo.Atores.Jogador;
import jogo.ControleCaixa;
import jogo.ControleColisao;
import jplay.Scene;

import java.awt.*;

import static jogo.Cenarios.CenarioSelecaoPersonagem.*;
import static jogo.ControleCaixa.numCaixas;
import static jogo.Main.janela;


public class CenarioPartida {

    public static Scene cena;
    public static ControleColisao controleColisaoControle;
    public static ControleCaixa controleCaixa;

    public CenarioPartida(){
        controleColisaoControle = new ControleColisao();
        controleCaixa = new ControleCaixa();

        cena = new Scene();
        cena.loadFromFile("src\\Recursos\\imagens\\scn\\Cenario1.scn");

        controleCaixa.gerarCaixas();

        janela.getKeyboard();

        jogador1.restaurar();
        jogador2.restaurar();

        run();
    }

    private void run(){
        posicionarJogador(jogador1);
        posicionarJogador(jogador2);

        while(numCaixas != 0){
            //cenario estilo camera para o personagem
            cena.moveScene(jogador1);

            //atualizacao das caixas
            controleCaixa.run();

            //atualizar movimentacao do jogador
            jogador1.movimentar();
            jogador2.movimentar();

            //verificar se foi pressionado botao de colocar bomba
            jogador1.colocarBomba();
            jogador2.colocarBomba();

            //exibir o jogador na tela
            jogador1.draw();
            jogador2.draw();

            //foto do personagem do jogador
            mostrarFoto(jogador1);
            mostrarFoto(jogador2);

            //dados sobre o jogador
            mostrarInformacoes(jogador1);
            mostrarInformacoes(jogador2);

            //atualizar janela
            janela.update();
        }
    }

    public void posicionarJogador(Jogador jogador){
        if (jogador.isJogador1()){
            jogador.setX(320);
            jogador.setY(64);
        }else{
            jogador.setX(960);
            jogador.setY(704);
        }
    }


    public void mostrarFoto(Jogador jogador){
        if (jogador.isJogador1()){
            jogador.getFoto().x =116;
            jogador.getFoto().y =126;
            jogador.getFoto().draw();
        }else{
            jogador.getFoto().x = 1085;
            jogador.getFoto().y = 126;
            jogador.getFoto().draw();
        }
    }

    public void mostrarInformacoes(Jogador jogador){
        if (jogador.isJogador1()){
            janela.drawText(String.valueOf( jogador.getPntsVida()), 135, 335, Color.BLACK);
            janela.drawText(String.valueOf( jogador.getQntBombas()), 229, 335, Color.BLACK);
            janela.drawText(("JOGADOR 1"), 136, 104, Color.BLACK);

        }else{
            janela.drawText(String.valueOf( jogador.getPntsVida()), 1106, 335, Color.BLACK);
            janela.drawText(String.valueOf( jogador.getQntBombas()), 1194, 335, Color.BLACK);
            janela.drawText(("JOGADOR 2"), 1104, 104, Color.BLACK);
        }
    }

}
