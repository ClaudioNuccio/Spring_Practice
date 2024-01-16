package com.example.demowebapp;

public class User {
    public User(String nome, String location) {
        this.nome = nome;
        this.location = location;
      this.saluto = salutare(nome,location);
    }
    public String nome;
    public String location;
    public String saluto;

    public String salutare (String nome, String location){
        return "Ciao " + nome + " com'è il tempo in " + location + "?";
    }

}
