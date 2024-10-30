package com.lucas.api_rest_coffee_shop.repositories;

import com.lucas.api_rest_coffee_shop.models.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {}
