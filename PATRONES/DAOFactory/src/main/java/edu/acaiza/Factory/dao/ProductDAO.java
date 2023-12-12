package edu.acaiza.Factory.dao;

import edu.acaiza.Factory.DBFactory;
import edu.acaiza.Factory.DBType;
import edu.acaiza.Factory.IDBAdapter;
import edu.acaiza.Factory.entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private IDBAdapter dbAdapter;
    private DBFactory dbFactory = new DBFactory();

    public ProductDAO(DBType type) {
        dbFactory.createDBAdapter(type);
        dbAdapter = dbFactory.getDBAdapter();
    }

    public List<Product> findAllProducts() {

        Connection connection = dbAdapter.getConnection();
        List<Product> productList = new ArrayList<>();
        try {

            PreparedStatement statement = connection
                    .prepareStatement("SELECT idProductos, productName, productPrice FROM productos");
            ResultSet results = statement.executeQuery();

            while (results.next()) {
                productList.add(new Product(results.getInt(1),
                        results.getString(2), results.getDouble(3)));
            }
            return productList;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    public boolean saveProduct(Product product) {
        Connection connection = dbAdapter.getConnection();

        try {

            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO productos(idProductos, productName, productPrice) VALUES(?, ?, ?)");
            statement.setInt(1, product.getIdProduct());
            statement.setString(2, product.getProductName());
            statement.setDouble(3, product.getPrice());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    public int actualizar(Product product) {

        int registros = 0;
        Connection connection = dbAdapter.getConnection();

        try {
            PreparedStatement statement = connection
                    .prepareStatement("UPDATE productos SET productName = ?,productPrice = ? WHERE idProductos = ?");
            statement.setString(1, product.getProductName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getIdProduct());
            registros = statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return 0;
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int eliminar(Product product) {

        int registros = 0;
        Connection connection = dbAdapter.getConnection();

        try {
            PreparedStatement statement = connection
                    .prepareStatement("DELETE FROM  productos WHERE idProductos=? ");

            statement.setInt(1, product.getIdProduct());
            registros = statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return 0;
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

}
