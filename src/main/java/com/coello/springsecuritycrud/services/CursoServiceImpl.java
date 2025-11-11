package com.coello.springsecuritycrud.services;

import com.coello.springsecuritycrud.entities.Curso;
import com.coello.springsecuritycrud.persistence.ICursoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoServiceImpl implements ICursoService {

    @Autowired
    private ICursoDao cursoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> findAll() {
        return cursoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Curso curso) {
        cursoDao.save(curso);
    }

    @Override
    @Transactional(readOnly = true)
    public Curso findById(Long id) {
        return cursoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        cursoDao.deleteById(id);
    }

}