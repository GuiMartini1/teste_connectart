package com.connectart.models;

public class Produto {
   
    private String produtoNome;  // Atributo correspondente a produto_nome na tabela
    private String produtoDescricao;  // Atributo correspondente a produto_descricao na tabela
    private String produtoEmailArtista;

    // Construtor padrão (sem argumentos)
    public Produto() {
        this.produtoNome = "";
        this.produtoDescricao = "";
        this.produtoEmailArtista = "";
    }

    // Construtor com argumentos
    public Produto(String produtoNome, String produtoDescricao, String produtoEmailArtista) {
        this.produtoNome = produtoNome;
        this.produtoDescricao = produtoDescricao;
        this.produtoEmailArtista = produtoEmailArtista;
    }

    // Métodos getter e setter para os atributos

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }


    public String getProdutoDescricao() {
        return produtoDescricao;
    }

    public void setProdutoDescricao(String produtoDescricao) {
        this.produtoDescricao = produtoDescricao;
    }

    public String getProdutoEmailArtista(){
        return produtoEmailArtista;
    }

    public void setProdutoEmailArtista(String produtoEmailArtista){
        this.produtoEmailArtista = produtoEmailArtista;
    }


    // Método toString para representar o objeto como uma string
    @Override
    public String toString() {
        return "Produto [produtoNome=" + produtoNome + ", produtoDescricao=" + produtoDescricao + ", produtoEmailArtista" + produtoEmailArtista + "]";
    }
}
