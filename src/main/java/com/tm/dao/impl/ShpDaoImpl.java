package com.tm.dao.impl;

import com.tm.dao.ShpDao;
import com.tm.postgresql.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShpDaoImpl implements ShpDao {

    public String getBoundaryChn2PShp() {
        String result ="";
        String sql = "SELECT row_to_json(fc) FROM ( SELECT 'FeatureCollection' As type,array_to_json(array_agg(f)) As features FROM (SELECT 'Feature' As type, ST_AsGeoJSON(lg.geom)::json As geometry ,gid As properties FROM boundarychn2_4p As lg ) As f )  As fc";
        try (Connection conn = DBHelper.getConnection();

             PreparedStatement pstmt = conn.prepareStatement(sql);

             ResultSet rs = pstmt.executeQuery();) {

            if (rs.next()) {
               result = rs.getString(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public String getBoundaryChn2LShp() {
        String result ="";
        String sql = "SELECT row_to_json(fc) FROM ( SELECT 'FeatureCollection' As type,array_to_json(array_agg(f)) As features FROM (SELECT 'Feature' As type, ST_AsGeoJSON(lg.geom)::json As geometry ,gid As properties FROM boundarychn1_4l As lg ) As f )  As fc";
        try (Connection conn = DBHelper.getConnection();

             PreparedStatement pstmt = conn.prepareStatement(sql);

             ResultSet rs = pstmt.executeQuery();) {

            if (rs.next()) {
                result = rs.getString(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public String getBoundaryChn1LShp() {
        String result ="";
        String sql = "SELECT row_to_json(fc) FROM ( SELECT 'FeatureCollection' As type,array_to_json(array_agg(f)) As features FROM (SELECT 'Feature' As type, ST_AsGeoJSON(lg.geom)::json As geometry ,gid As properties FROM boundarychn2_4l As lg ) As f )  As fc";
        try (Connection conn = DBHelper.getConnection();

             PreparedStatement pstmt = conn.prepareStatement(sql);

             ResultSet rs = pstmt.executeQuery();) {

            if (rs.next()) {
                result = rs.getString(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
