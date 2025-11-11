package com.coello.springsecuritycrud.persistence;

import com.coello.springsecuritycrud.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoDao extends JpaRepository<Curso, Long> {

}