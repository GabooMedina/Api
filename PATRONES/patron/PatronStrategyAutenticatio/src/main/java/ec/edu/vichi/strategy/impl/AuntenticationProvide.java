/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.vichi.strategy.impl;

/**
 *
 * @author jaevi
 */
public class AuntenticationProvide {

    private IAutenticateStrategy autenticateStrategy;

    public void setAuntenticationProvideide(IAutenticateStrategy autenticateStrategy) {
        this.autenticateStrategy = autenticateStrategy;
    }

    public Principal autenticate(String usuario, String password) {
        if (autenticateStrategy == null) {
            throw new RuntimeException("Estrategia de autenticacion no definida");
        }
        return autenticateStrategy.autenticate(usuario, password); 
    }
}
