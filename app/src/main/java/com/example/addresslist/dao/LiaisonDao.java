package com.example.addresslist.dao;

import com.example.addresslist.entity.Liaison;
import com.example.addresslist.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LiaisonDao {

    public boolean addLiaison(Liaison liaison){

        String sql = "insert into liaison(name,phone) values (?,?)";

        Connection con = JDBCUtils.getConn();

        try {
            PreparedStatement pst=con.prepareStatement(sql);

            pst.setString(1,liaison.getName());
            pst.setString(2,liaison.getPhone());

            int value = pst.executeUpdate();

            if(value>0){
                return true;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con);
        }
        return false;
    }

    public Liaison selectLiaisonByPhone(String phone){
        String sql = "select * from liaison where phone = ?";
        Connection con = JDBCUtils.getConn();

        Liaison ans = null;

        try {
            PreparedStatement pst=con.prepareStatement(sql);

            pst.setString(1,phone);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                ans = new Liaison(rs.getString(1), rs.getString(2));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con);
        }
        return ans;
    }

    public List<Liaison> selectLiaisonByName(String name){

        String sql = "select * from liaison where name = ?";
        Connection con = JDBCUtils.getConn();
        List<Liaison> list = new ArrayList<>();

        try {
            PreparedStatement pst=con.prepareStatement(sql);

            pst.setString(1,name);

            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                Liaison liaison = new Liaison(rs.getString(1), rs.getString(2));
                list.add(liaison);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con);
        }
        return list;
    }

    public int deleteLiaisonByPhone(String phone){

        String sql = "delete from liaison where phone = ?";
        Connection con = JDBCUtils.getConn();
        int ans = 0;

        // 判断是否存在该号码
        Liaison liaison = selectLiaisonByPhone(phone);
        if(liaison == null){
            return 0;
        }

        try {
            PreparedStatement pst=con.prepareStatement(sql);

            pst.setString(1,phone);

            ans = pst.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con);
        }
        return ans;
    }

}
