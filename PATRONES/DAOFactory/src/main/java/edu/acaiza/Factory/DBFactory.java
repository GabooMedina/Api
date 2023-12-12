package edu.acaiza.Factory;

import edu.acaiza.Factory.impl.MySQLDBAdapter;
import edu.acaiza.Factory.impl.PostgreDBAdapter;
import edu.acaiza.Factory.impl.SQLiteDBAdapter;

public class DBFactory {

    private IDBAdapter dbAdapter;

    public IDBAdapter getDBAdapter() {
        return this.dbAdapter;

    }

    public void createDBAdapter(DBType type) {
        if (type == DBType.MySQL) {
            this.dbAdapter = new MySQLDBAdapter();

        } else if (type == DBType.PostgreSQL) {
            this.dbAdapter = new PostgreDBAdapter();

        } else  if (type == DBType.SQLite) {
             this.dbAdapter = new SQLiteDBAdapter();
        }else {
            throw new IllegalArgumentException("Base de datos no soportado");

        }
    }

}
