package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Address;
import com.revature.models.User;

@Repository // Sterotype Annotation for this component 
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
