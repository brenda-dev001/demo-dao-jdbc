package org.example.model.dao;

import org.example.db.DB;
import org.example.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDaoJDBC createSellerDao(){
        return new SellerDaoJDBC(DB.getConn());
    }
}
