package com.example.demowebapp;

public class User {
    public User(String nome, String location) {
        this.nome = nome;
        this.location = location;
        this.saluto = salutare(nome, location);
    }

    public String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSaluto() {
        return saluto;
    }

    public void setSaluto(String saluto) {
        this.saluto = saluto;
    }

    public String location;
    public String saluto;

    public String salutare(String nome, String location) {
        return "Ciao " + nome + " com'è il tempo in " + location + "?";
    }

}
