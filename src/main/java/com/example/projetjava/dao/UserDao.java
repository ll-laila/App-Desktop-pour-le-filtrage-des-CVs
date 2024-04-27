package com.example.projetjava.dao;

import com.example.projetjava.Models.User;

import java.util.List;



public interface UserDao {
    // Lire tous les utilisateurs
    List<User> getAllUsers();
    // Vérifier si un login est déjà utilisé
    // S'il est return false, cela signifie que le login existe déjà
    boolean isLoginUnique(String login);
    int Authentication_user(User user);
}

