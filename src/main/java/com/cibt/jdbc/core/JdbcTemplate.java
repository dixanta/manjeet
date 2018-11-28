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
    private DbConnection db=new DbConnection();
    public List<T> query(String sql, RowMapper<T> mapper)
            throws Exception {
        List<T> rows=new ArrayList<T>();
        db.connect();
        db.init(sql);
        ResultSet rs = db.executeQuery();
        while(rs.next()){
            rows.add(mapper.mapRow(rs));
        }
        
        db.close();
        return rows;
        
    }
    
    public T queryForObject(String sql,Object[] params,RowMapper<T> mapper)
            throws Exception {
        T row=null;
        db.connect();
        PreparedStatement stmt = db.init(sql);
        int i=1;
        for(Object param:params){
            stmt.setObject(i, param);
            i++;
        }
        ResultSet rs =db.executeQuery();
        while(rs.next()){
            row=mapper.mapRow(rs);
        }
        
        
        return row;
        
    }
}
