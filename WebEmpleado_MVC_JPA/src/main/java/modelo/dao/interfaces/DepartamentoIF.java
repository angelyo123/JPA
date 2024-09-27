package modelo.dao.interfaces;

import java.util.List;
import modelo.Departamento;

public interface DepartamentoIF {
    
    // Método para buscar un departamento por su ID
    Departamento obtenerPorId(int id);
    
    // Método para buscar departamentos por su nombre
    List<Departamento> buscarPorNombre(String nombre);
    
    // Método para listar todos los departamentos
    List<Departamento> listar();
}
