/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.vichi.strategy.providers;

import ec.edu.vichi.strategy.impl.IAutenticateStrategy;
import ec.edu.vichi.strategy.impl.Principal;
import ec.edu.vichi.strategy.util.OnMemoryDataBase;
import ec.edu.vichi.strategy.util.User;

/**
 *
 * @author jaevi
 */
public class OnMemoryAutenticationProvider implements IAutenticateStrategy {

    @Override
    public Principal autenticate(String username, String password) {
        User user = OnMemoryDataBase.findUserByName(username);
        if (user != null && user.getPassword().equals(password)) {
            return new Principal(user.getUsername(), user.getRol());
        }
        return null;

    }

}
