package org.example.model.dao.impl;

import org.example.db.DB;
import org.example.db.DbException;
import org.example.model.dao.SellerDAO;
import org.example.model.entities.Department;
import org.example.model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SellerDaoJDBC implements SellerDAO {

    private Connection conn;

    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }

    public void insertSeller(Seller seller){}
    public void updateSeller(Integer id){}
    public void deleterById(Integer id){}
    public Seller findById(Integer id){
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select *, department.Name as DepName from seller " +
                    "inner join department on seller.DepartmentId = department.Id " +
                    "where seller.Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if(rs.next()){
                Department dp = instantiateDepartment(rs);
                return instantiateSeller(rs, dp);
            }
            return null;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }

    public List<Seller> findByDepartment(Department department){
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT seller.*, department.Name as depName" +
                    " from seller inner join department  " +
                    "on seller.DepartmentId = department.Id " +
                    "where DepartmentId = ? " +
                    "order by Name");

            st.setInt(1, department.getId());
            rs = st.executeQuery();
            List<Seller> listSeller = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();
            while (rs.next()){
                Department dep = map.get(rs.getInt("DepartmentId"));

                if(dep == null){
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }
                listSeller.add(instantiateSeller(rs, dep));
            }
            return listSeller;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    public List<Seller> findAll(){
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement("select seller.*, department.Name as DepName " +
                    "from seller inner join department on " +
                    "seller.DepartmentId = department.Id " +
                    "order by seller.Name");

            rs = st.executeQuery();

            List<Seller> sellerList = new ArrayList<>();
            Map<Integer, Department> mapDeparment = new HashMap<>();

            while (rs.next()){
                Integer id = rs.getInt("Id");
                String name = rs.getString("Name");
                String email = rs.getString("Email");
                Date birthDate = rs.getDate("BirthDate");
                Double baseSalary = rs.getDouble("BaseSalary");
                Department dep = mapDeparment.get(rs.getInt("DepartmentId"));
                if(dep == null){
                    dep = instantiateDepartment(rs);
                    mapDeparment.put(rs.getInt("DepartmentId"), dep);
                }
                sellerList.add(new Seller(id, name, email, birthDate, baseSalary, dep));
            }
            return sellerList;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException{
        return new Seller(rs.getInt("Id"), rs.getString("Name"), rs.getString("Email"), rs.getDate("BirthDate"),
                rs.getDouble("BaseSalary"), department);
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        return new Department(rs.getInt("DepartmentId"), rs.getString("DepName"));
    }

}
