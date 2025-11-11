package com.coello.springsecuritycrud.services;

import com.coello.springsecuritycrud.entities.Curso;
import java.util.List;

public interface ICursoService {

    List<Curso> findAll();

    void save(Curso curso);

    Curso findById(Long id);

    void delete(Long id);

}