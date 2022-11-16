package com.jocielalves.apiCadastro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jocielalves.apiCadastro.banco.UsuarioInterface;
import com.jocielalves.apiCadastro.entidade.Usuario;

import java.util.List;

@Controller
@CrossOrigin("*")
public class UsuarioController{


    @Autowired
    private UsuarioInterface banco;
 

    @GetMapping("/")
    public String index(){
        return "home/index";
    }

    
    @GetMapping("/login")
    public String login(){
        return "login/login";
    }


    @GetMapping("/cadastro")
    public String cadastrar(){
        return "login/cadastro";
    }

    
    @GetMapping("/usuarios")
    public String listar(Model model){
        List<Usuario> listaUsuarios =  (List<Usuario>) banco.findAll();
        model.addAttribute( "usuarios", listaUsuarios);
        return "relatorio/usuarios";
    }

    @PostMapping("/logar")
    public String logar(Model model, String usuario, String senha){
        List<Usuario> listaUsuarios = (List<Usuario>) banco.findAll();
        for ( Usuario user : listaUsuarios){
            if( user.getUsuario().toLowerCase().equals(usuario.toLowerCase()) 
            && user.getSenha().toLowerCase().equals(senha.toLowerCase())){
                return "home/index";
            }
        } 
        model.addAttribute("erro", "Usuario ou senha inválida");
        return "login/login";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser( @PathVariable int id){
         banco.deleteById(id);
         return "Deletado"+id ; 
    } 

    @PostMapping("/cadastrar")
    public Usuario criarUser( @RequestBody Usuario usuario, Model model){
        Usuario novoUser = banco.save(usuario);
            
        return novoUser ;
    } 
    @PutMapping("/alterar/{id}")
    public Usuario alteraUser( @RequestBody Usuario usuario){
        Usuario novoUser = banco.save(usuario);
         return novoUser ;
    }
 
}
