package org.example.model.dao;

import org.example.model.entities.Seller;

import java.util.List;

public interface SellerDAO {

    void insertSeller(Seller seller);
    void updateSeller(Integer id);
    void deleterById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();


}
