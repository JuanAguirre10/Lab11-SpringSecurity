package com.coello.springsecuritycrud.persistence;

import com.coello.springsecuritycrud.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolDao extends JpaRepository<Rol, Long> {

}