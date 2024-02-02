package com.example.lezioneHibernate.repositories;

import com.example.lezioneHibernate.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
