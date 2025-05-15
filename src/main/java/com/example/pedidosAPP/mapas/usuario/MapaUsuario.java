package com.example.pedidosAPP.mapas.usuario;

import com.example.pedidosAPP.dtos.usuariodtos.UsuarioDTO;
import com.example.pedidosAPP.modelos.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapaUsuario {

    MapaUsuario INSTANCIA = Mappers.getMapper(MapaUsuario.class);

    UsuarioDTO cambiarAdto(Usuario usuario);
    Usuario cambiarAModelo(UsuarioDTO usuarioDTO);

    List<UsuarioDTO> cambiarAListaDto(List<Usuario> usuarios);
}
