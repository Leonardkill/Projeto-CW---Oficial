package com.example.projetocw;

public class User implements Comparable {

    private String nome;
    private String cpf;
    private String email;
    private int pontuacao;

    public User(){ }

    public User(String nome, String cpf, String email, int pontuacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public int compareTo(Object obj) {
        User other = (User) obj;
        if (this.pontuacao < other.pontuacao) {
            return 1;
        }
        if (this.pontuacao > other.pontuacao) {
            return -1;
        }
        return 0;
    }
}

