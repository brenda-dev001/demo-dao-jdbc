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
import java.util.List;

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
                return instantiateSellet(rs, instantiateDepartment(rs));
            }
            return null;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }

    private Seller instantiateSellet(ResultSet rs, Department department) throws SQLException{
        return new Seller(rs.getInt("Id"), rs.getString("Name"), rs.getString("Email"), rs.getDate("BirthDate"),
                rs.getDouble("BaseSalary"), department);
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        return new Department(rs.getInt("DepartmentId"), rs.getString("DepName"));
    }

    public List<Seller> findAll(){return null;}
}
