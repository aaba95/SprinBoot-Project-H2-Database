package com.cjc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.app.model.Product;
import java.lang.String;
import java.util.Optional;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer>{

	Optional<Product> findByPname(String pname);
}
