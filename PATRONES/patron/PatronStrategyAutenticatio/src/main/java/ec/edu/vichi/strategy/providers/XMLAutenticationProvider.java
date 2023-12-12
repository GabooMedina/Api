/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.vichi.strategy.providers;

import ec.edu.vichi.strategy.impl.IAutenticateStrategy;
import ec.edu.vichi.strategy.impl.Principal;
import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import org.w3c.dom.Document;

/**
 *
 * @author jaevi
 */
public class XMLAutenticationProvider implements IAutenticateStrategy {

    private static final String rolXPath = "Users/User[@userName='%s' and @password='%s']/@rol";

    @Override
    public Principal autenticate(String username, String password) {
        FileInputStream file = null;
        try {
            file=new FileInputStream("UserFile.xml");
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            var builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(file);
            XPath xPath = XPathFactory.newInstance().newXPath();

            String xpath = String.format(rolXPath, username, password);
            String rol = xPath.compile(xpath).evaluate(xmlDocument);
            if (rol != null && !rol.isEmpty()) {
                return new Principal(username, rol);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
            }
        }
    }
}
