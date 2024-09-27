package modelo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Departamento;
import modelo.dao.interfaces.DepartamentoIF;

public class DepartamentoDAO implements DepartamentoIF {
    private EntityManagerFactory emf;

    public DepartamentoDAO() {
        this.emf = Persistence.createEntityManagerFactory("DBEmpresaUP");
    }

    @Override
    public Departamento obtenerPorId(int idDepartamento) {
        EntityManager em = emf.createEntityManager();
        Departamento departamento = null;

        try {
            departamento = em.find(Departamento.class, idDepartamento);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return departamento;
    }

    @Override
    public List<Departamento> buscarPorNombre(String nombre) {
        // Implementación del método para buscar por nombre (opcional)
        return null; // Cambiar por la lógica de búsqueda
    }

    @Override
    public List<Departamento> listar() {
        EntityManager em = emf.createEntityManager();
        List<Departamento> departamentos = em.createQuery("SELECT d FROM Departamento d", Departamento.class).getResultList();
        em.close();
        return departamentos;
    }
}
