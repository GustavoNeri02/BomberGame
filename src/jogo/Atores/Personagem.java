package jogo.Atores;

import jplay.GameImage;

public class Personagem {
    public static final String spriteGenerico1 = "src\\recursos\\imagens\\sprites\\atores\\personagem\\Generico1_Sprite.png";
    public static final String spriteGenerico2 = "src\\recursos\\imagens\\sprites\\atores\\personagem\\Generico2_Sprite.png";
    public static final String spriteGenerico3 = "src\\recursos\\imagens\\sprites\\atores\\personagem\\Generico3_Sprite.png";
    public static final String spriteGenerico4 = "src\\recursos\\imagens\\sprites\\atores\\personagem\\Generico4_Sprite.png";
    public static final String spritePikachu = "src\\recursos\\imagens\\sprites\\atores\\personagem\\Pikachu_Sprite.png";

    private String nome;
    private String sprite;
    private GameImage foto;

    private Personagem(String nome, String enderecoSprite, GameImage foto){
        this.nome = nome;
        this.sprite = enderecoSprite;
        this.foto = foto;
    }

    public static class PersonagemBuilder {

        private String nome;
        private String sprite;
        private GameImage foto;


        public PersonagemBuilder (String nome){
            this.nome = nome;
        }

        public PersonagemBuilder sprite(String enderecoSprite){
            this.sprite = enderecoSprite;
            return this;
        }
        public PersonagemBuilder foto(String foto){
            this.foto = new GameImage(foto);
            return this;
        }


        public Personagem criarPersonagem(){
            return new Personagem(this.nome, this.sprite, this.foto);
        }

    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSprite() {
        return sprite;
    }
    public void setSprite(String sprite) {
        this.sprite = sprite;
    }
    public GameImage getFoto() {
        return foto;
    }
    public void setFoto(GameImage foto) {
        this.foto = foto;
    }
}
