package com.fundation.search.controller;

import java.util.*;

public class Controller{

    public Controller(){
        
    }

    public ArrayList<String> buscarArchivos(String buscar, String ubicacion, boolean buscTxt, boolean completa, boolean ascii, boolean utf, boolean unicode, boolean regex, boolean hexa, boolean mymi, boolean noexiste){
        if(!buscar.equals("") & !ubicacion.equals("")){
            if(buscTxt == true){
                System.out.println("BUSCAR "+buscar+" EN "+ubicacion + " con Filtros");
            }else{
                System.out.println("BUSCAR "+buscar+" EN "+ubicacion);
            }
        } else {
            System.out.println("Error de Campos, No debe haber campos vacios!");
        }
        return new ArrayList<>();
    } 

}