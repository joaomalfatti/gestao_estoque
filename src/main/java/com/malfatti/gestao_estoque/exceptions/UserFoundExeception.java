package com.malfatti.gestao_estoque.exceptions;

public class UserFoundExeception extends RuntimeException {
    public UserFoundExeception() {
        super("Usuário já cadastrado com o mesmo username ou email.");
    }

}
