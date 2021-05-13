package jogo.Cenarios;

import jplay.Keyboard;
import jplay.Sprite;

import static jogo.Main.janela;

public class CenarioInicial {
    private Sprite planoFundo;


    public CenarioInicial() {
        int opcao = 0;
        this.planoFundo = new Sprite("src\\Recursos\\imagens\\sprites\\cenarios\\TelaInicial_2F.png", 2);


        while(true){
            planoFundo.draw();
            janela.update();

            if (janela.getKeyboard().keyDown(Keyboard.UP_KEY)){
                planoFundo.setCurrFrame(0);
                opcao = 0;
            }
            if(janela.getKeyboard().keyDown(Keyboard.DOWN_KEY)){
                planoFundo.setCurrFrame(1);
                opcao = 1;
            }
            if (janela.getKeyboard().keyDown(Keyboard.ENTER_KEY)){
                if (opcao == 0){
                    new CenarioSelecaoPersonagem();
                }else{
                    janela.exit();
                }
            }
        }
    }


    public Sprite getPlanoFundo() {
        return planoFundo;
    }
    public void setPlanoFundo(Sprite planoFundo) {
        this.planoFundo = planoFundo;
    }
}
