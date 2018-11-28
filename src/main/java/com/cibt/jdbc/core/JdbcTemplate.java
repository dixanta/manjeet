/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.jdbc.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class JdbcTemplate<T> {

    public List<T> query(String sql, RowMapper<T> mapper)
            throws Exception {
        List<T> rows=new ArrayList<T>();
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://ec2-54-235-156-60.compute-1.amazonaws.com/d7mougtm30aksq?sslmode=require";
        String user = "uedxllbdwzhxnz";
        String password = "dec23922f80fd7bee8d27219a235caf315254bb679035f11ab899724d64a3e45";
        Connection conn = DriverManager
                .getConnection(url, user, password);

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            rows.add(mapper.mapRow(rs));
        }
        
        conn.close();
        return rows;
        
    }
}
