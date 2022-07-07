package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Address;
import com.revature.models.User;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
