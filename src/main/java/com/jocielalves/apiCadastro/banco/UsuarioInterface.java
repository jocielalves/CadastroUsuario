package com.jocielalves.apiCadastro.banco;

import org.springframework.data.repository.CrudRepository;

import com.jocielalves.apiCadastro.entidade.Usuario;

public interface UsuarioInterface extends CrudRepository< Usuario, Integer>{
    
}
