package modelo.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Empleado;
import modelo.dao.interfaces.EmpleadoIF;

public class EmpleadoDAO implements EmpleadoIF {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public EmpleadoDAO() {
		
		this.emf= Persistence.createEntityManagerFactory("DBEmpresaUP");
		this.em= emf.createEntityManager();
	}	

	@Override
	public int insertar(Empleado empleado) {
		
		//iniciar la transaccion
		em.getTransaction().begin();
		
		//envia el nuevo empleado
		
		em.persist(empleado);
		
		//confirmamos la transaccion
		
		em.getTransaction().commit();
		
		em.close();
		//recuperamos y retornamos el nuevo id
		
		 return empleado.getId();
	}

	@Override
	public Empleado BuscarPorId(int id) {
		
		//iniciar la transaccion
				em.getTransaction().begin();
				
				//buscar empleado
				
				Empleado empleadoBuscado= em.find(Empleado.class, id);
				
				//confirmamos la transaccion
				
				em.getTransaction().commit();
				
				em.close();
				//Retorno el empleado encontrado
				
				 return empleadoBuscado;
		
	}

	@Override
	public void actualizar(Empleado empleado) {
		//iniciar 
		em.getTransaction().begin();
		//buscamos empleado
		Empleado empleadoActualizar= em.find(Empleado.class, empleado.getId());
		empleadoActualizar.setNombre(empleado.getNombre());
		empleadoActualizar.setApellido(empleado.getApellido());
		empleadoActualizar.setSalario(empleado.getSalario());
		empleadoActualizar.setDepartamento(empleado.getDepartamento());
		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void eliminar(int id) {
		
		em.getTransaction().begin();
		Empleado empleadoEliminar= em.find(Empleado.class, id);
		em.remove(empleadoEliminar);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public List<Empleado> buscarPorNombre(String nombre) {
		//crear la sentencia JPQL para hacer la consulta
		
		String jpql= "SELECT e FROM Empleado e where e.nombre like :nombreP";
		TypedQuery<Empleado> consultaJPQL= em.createQuery(jpql, Empleado.class);
		consultaJPQL.setParameter("nombreP", "%"+nombre+"%");
		
		return consultaJPQL.getResultList();
	}

	@Override
	public List<Empleado> listar() {
		
		String jpql = "Select e from Empleado e";
        TypedQuery<Empleado> consultaJPQL = em.createQuery(jpql, Empleado.class);

        return consultaJPQL.getResultList();
	}

}
