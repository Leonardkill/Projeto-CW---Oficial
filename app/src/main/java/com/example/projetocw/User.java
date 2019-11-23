package com.example.projetocw;

public class User {
    public String nome , cpf , email  ;
    public int pontuacao;


    public User(){

    }

    public User(String nome, String cpf, String email, int pontuacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.pontuacao = pontuacao;

    }
}
