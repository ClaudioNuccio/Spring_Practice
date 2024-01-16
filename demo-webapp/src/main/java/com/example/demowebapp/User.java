package com.example.demowebapp;

public class User {
    public User(String nome, String location, String ciao) {
        this.nome = nome;
        this.location = location;
    }
    public String nome;

    public String location;
    public String saluto = "Ciao " + nome + " com'è il tempo in " + location + "?";
}
