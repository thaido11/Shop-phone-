package com.shopme.repository;

import com.shopme.common.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarItemRepository extends JpaRepository<CartItem, Integer> {

}
