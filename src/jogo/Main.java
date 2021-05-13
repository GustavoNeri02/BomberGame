package jogo;

import jogo.Cenarios.CenarioInicial;
import jplay.Window;

public class Main {
    public static Window janela;

    public static void main(String[] args) {

        janela = new Window(1024 ,768);
        //Letra A = 65

        janela.getKeyboard().addKey(65,0);
        //Letra D = 68
        janela.getKeyboard().addKey(68,0);
        //Letra W = 87
        janela.getKeyboard().addKey(87,0);
        //Letra S = 83
        janela.getKeyboard().addKey(83, 0);
        //Letra P = 80
        janela.getKeyboard().addKey(80, 0);
        //NumPad 1 = 97
        janela.getKeyboard().addKey(97, 0);

        new CenarioInicial();
    }
}
