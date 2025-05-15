package com.example.pedidosAPP.servicios;

import com.example.pedidosAPP.dtos.usuariodtos.UsuarioDTO;
import com.example.pedidosAPP.mapas.usuario.MapaUsuario;
import com.example.pedidosAPP.modelos.Usuario;
import com.example.pedidosAPP.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    IUsuarioRepositorio repositorio;
    @Autowired
    MapaUsuario mapaUsuario;

    //Listar los metodos que activaran
    //las consultas en la BD

    //guardar
    public UsuarioDTO guardarUsuario(Usuario datosUsuario)throws Exception{
        try{
            //validar los datos entrada
            return mapaUsuario.cambiarAdto(this.repositorio.save(datosUsuario));

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //buscar todos los registros
    public List<UsuarioDTO> buscarTodosUsuarios()throws Exception{
        try{
            return mapaUsuario.cambiarAListaDto(this.repositorio.findAll());
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //buscar por ID
    public UsuarioDTO buscarUsuarioPorId(Integer idUsuario)throws Exception{
        try{
            Optional<Usuario> usuarioBuscado=this.repositorio.findById(idUsuario);
            if(usuarioBuscado.isPresent()){
                return mapaUsuario.cambiarAdto(usuarioBuscado.get());
            }else{
                throw new Exception("El usuario consultado no esta en BD");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //modificar por id
    public UsuarioDTO modificarUsuario(Integer id, Usuario datosUsuario) throws Exception{
        try{
            Optional<Usuario> usuarioBuscado=this.repositorio.findById(id);
            if(usuarioBuscado.isPresent()){
                usuarioBuscado.get().setTelefono(datosUsuario.getTelefono());
                usuarioBuscado.get().setCorreoElectronico(datosUsuario.getCorreoElectronico());
                return mapaUsuario.cambiarAdto(this.repositorio.save(usuarioBuscado.get()));
            }else{
                throw new Exception("usuario no encontrado");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //eliminar por id
    public boolean eliminarUsuario(Integer id) throws Exception{
        try{
            Optional<Usuario> usuarioBuscado=this.repositorio.findById(id);
            if(usuarioBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


}
