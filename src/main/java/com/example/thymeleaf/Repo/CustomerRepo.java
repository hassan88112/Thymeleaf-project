package com.example.thymeleaf.Repo;

import com.example.thymeleaf.DTO.Customerdto;
import com.example.thymeleaf.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {

    @Query(
            value = "SELECT * FROM customer  WHERE customer.date BETWEEN :stat_date AND :end_date ",
            nativeQuery = true)
    public List<Customer> getCustomerByDate(@Param("stat_date") String statDate,@Param("end_date") String endDate);



}
