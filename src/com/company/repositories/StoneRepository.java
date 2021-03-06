package com.company.repositories;

import com.company.data.IDB;
import com.company.entities.Stone;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


    public class StoneRepository implements IStoneRepository {
        private final IDB db;

        public StoneRepository(IDB db) {
            this.db = db;
        }
        @Override
        public boolean createStone(Stone stone) {
            Connection con = null;
            try {
                con = db.getConnection(); //connection with DB(database)
                String sql = "INSERT INTO stones(name,weight,cost,precious) VALUES (?,?,?,?)"; /* sql statement for
                                                                                                 inserting data into
                                                                                                table employees*/
                PreparedStatement st = con.prepareStatement(sql);

                st.setString(1, stone.getName());    //setting name,position and salar
                st.setInt(2, stone.getWeight());
                st.setInt(3, stone.getCost());
                st.setBoolean(4, stone.isPrecious());

                boolean executed = st.execute();
                return executed;
            } catch (SQLException throwables) {   //error handling
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            return false;
        }
        @Override
        public Stone getStone(int id){
            Connection con = null;   //connection with DB(database)
            try {
                con = db.getConnection();
                String sql = "SELECT id,name,weight,cost,precious FROM stones WHERE id=?"; /* sql statement for
                                                                                                 selecting one employee
                                                                                                  from table employees*/
                PreparedStatement st = con.prepareStatement(sql);

                st.setInt(1, id);

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    Stone stone= new Stone(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("weight"),
                            rs.getInt("cost"),
                            rs.getBoolean("precious"));


                    return stone;
                }
            } catch (SQLException throwables) {    //error handling
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            return null;
        }
        @Override
        public List<Stone> getAllStones() {
            Connection con = null;
            try {
                con = db.getConnection();  //connection with DB(database)
                String sql = "SELECT id,name,weight,cost,precious FROM stones";  /* sql statement for
                                                                                     selecting all employees
                                                                                   from table employees*/
                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery(sql);
                List<Stone> stones = new ArrayList<>();
                while (rs.next()) {
                    Stone stone= new Stone(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("weight"),
                            rs.getInt("cost"),
                            rs.getBoolean("precious"));

                    stones.add(stone);
                }

                return stones;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            return null;
        }
    }


