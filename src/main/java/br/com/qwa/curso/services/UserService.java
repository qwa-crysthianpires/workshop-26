package br.com.qwa.curso.services;

import br.com.qwa.curso.entities.Usuario;
import br.com.qwa.curso.repositories.UserRepository;

import br.com.qwa.curso.services.exceptions.DatabaseException;
import br.com.qwa.curso.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public List<Usuario> findAll() {
        return repository.findAll();
    }


    public Usuario findById(Long id) {
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Usuario insert (Usuario obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
           throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());

        }

        catch (RuntimeException e){
            e.printStackTrace();
        }

    }

    public Usuario update(Long id, Usuario obj){
        try {
            Usuario entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }

    }
    private void updateData(Usuario entity, Usuario obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());

    }
}