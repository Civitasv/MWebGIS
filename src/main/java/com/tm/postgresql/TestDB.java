package com.tm.postgresql;

import com.tm.dao.ShpDao;
import com.tm.dao.impl.ShpDaoImpl;

import java.sql.SQLException;

public class TestDB {
    public static void main(String[] args) throws SQLException {
        DBHelper.getConnection();
        ShpDao shpDao = new ShpDaoImpl();
        System.out.println(shpDao.getBoundaryChn2LShp());
    }
}
