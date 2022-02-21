package com.eo.demo.repository.person;

import com.eo.demo.entity.person.Principal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrincipalRepository extends CrudRepository<Principal, Long> {
}
