package com.example.pedidosAPP.servicios;

import com.example.pedidosAPP.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {

    @Autowired
    IUsuarioRepositorio repositorio;

}
