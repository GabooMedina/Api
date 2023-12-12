/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.vichi.strategy.util;

import java.util.HashMap;

/**
 *
 * @author jaevi
 */
public class OnMemoryDataBase {

    private static final HashMap<String, User> USER_MAP = new HashMap();

    static {
        USER_MAP.put("vichi", new User("vichi", "1234", "Admin"));
        USER_MAP.put("lopez", new User("lopez", "2345", "Cajero"));
        USER_MAP.put("dayana", new User("dayana", "3456", "Pe"));
    }

    public static User findUserByName(String name) {
        return USER_MAP.get(name);
    }
}
