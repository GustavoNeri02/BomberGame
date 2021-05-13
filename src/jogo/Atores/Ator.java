package jogo.Atores;

import jplay.*;

public abstract class Ator extends Sprite {
    protected double velocidade;
    protected int direcao;
    protected boolean movendo;


    //construtor da classe Sprite
    public Ator(String enderecoSprite, int numeroFrames) {
        super(enderecoSprite, numeroFrames);
        this.velocidade = 0.5;
        this.movendo = false;



    }



    public void movimentar() {
    }
    public void colocarBomba() {
    }

    public double getVelocidade() {
        return velocidade;
    }
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public int getDirecao() {
        return direcao;
    }
    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }

    public boolean isMovendo() {
        return movendo;
    }
    public void setMovendo(boolean movendo) {
        this.movendo = movendo;
    }




}
