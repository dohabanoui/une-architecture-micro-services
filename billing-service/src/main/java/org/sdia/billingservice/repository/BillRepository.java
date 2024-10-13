package org.sdia.billingservice.repository;

import org.sdia.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill, Long> {
    //permet de me donner les commandes d'un client
    @RestResource(path = "/byCustomerId")
    List<Bill> findByCustomerID(@Param("customerID") Long customerID);


}
