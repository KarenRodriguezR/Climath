package vista;

import java.util.List;

import controlador.CiudadControlador;
import modelo.Ciudad;

public class CiudadVista {
public static void main(String[] args) {
        CiudadControlador ns = new CiudadControlador();
        List<Ciudad> ls;
        ls=ns.listarCiudades();
        Ciudad n = new Ciudad();
        
        System.out.println(ls.get(0).getNombre());
    }
}
