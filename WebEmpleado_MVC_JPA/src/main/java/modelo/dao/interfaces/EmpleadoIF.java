package modelo.dao.interfaces;



import java.util.List;

import modelo.Empleado;

public interface EmpleadoIF {
	
	public int insertar(Empleado empleado);
	public Empleado BuscarPorId(int id);
    public void actualizar(Empleado empleado);
    public void eliminar(int id);
    public List<Empleado>buscarPorNombre(String nombre);
    public List<Empleado> listar();

}
