package com.company.repositories;

import com.company.data.IDB;
import com.company.entities.Necklace;
import com.company.entities.Stone;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NecklaceRepository implements INecklaceRepository{
    private final IDB db;
    private ArrayList<Stone> stoneList;  //list of participated employees
    private ArrayList<Necklace> necklaceList;     //list of projects

    public NecklaceRepository(IDB db) {
        this.db = db;
    }

    @Override
    public void createNecklace(Necklace necklace) {
        necklaceList = new ArrayList<Necklace>();
        stoneList = necklace.getStoneList();
        necklaceList.add(necklace);
    }

    @Override
    public void addStone( Stone stone) {
        Connection con = null;
        stoneList.add(stone);
    }

    @Override
    public int totalCost() {

        int sum = 0;
        for (int i = 0; i < stoneList.size(); i++) {
            sum += stoneList.get(i).getCost();   //add salary of participated employees
        }
        return sum;
    }

    @Override
    public Necklace getNecklace(Necklace necklace) {
        if(necklaceList.contains(necklace)){   //check if project is exists
            return necklace;
        }
        return null;
    }

    @Override
    public ArrayList<Necklace> getAllNecklaces() {
        return necklaceList;
    }
}
