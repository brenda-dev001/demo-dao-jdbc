package org.example.application;

import org.example.db.DB;
import org.example.model.dao.DaoFactory;
import org.example.model.dao.impl.SellerDaoJDBC;
import org.example.model.entities.Department;
import org.example.model.entities.Seller;

import java.util.List;

public class Program {

    public static void main(String[] args){

        SellerDaoJDBC sellerDaoJdbc = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDaoJdbc.findById(1);
        System.out.println(seller);

        System.out.println("=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, "departmentTest");
        List<Seller> list = sellerDaoJdbc.findByDepartment(department);

        for(Seller obj : list){
            System.out.println(obj);
        }
    }
}
