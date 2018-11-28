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
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class DbConnection {

    private Connection conn = null;
    private PreparedStatement stmt = null;

    public void connect() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://ec2-54-235-156-60.compute-1.amazonaws.com/d7mougtm30aksq?sslmode=require";
        String user = "uedxllbdwzhxnz";
        String password = "dec23922f80fd7bee8d27219a235caf315254bb679035f11ab899724d64a3e45";
        conn = DriverManager
                .getConnection(url, user, password);
    }

    public PreparedStatement init(String sql) throws SQLException {
        stmt = conn.prepareStatement(sql);
        return stmt;
    }

    public ResultSet executeQuery() throws SQLException {
        return stmt.executeQuery();
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            conn = null;
            stmt = null;
        }
    }
}
