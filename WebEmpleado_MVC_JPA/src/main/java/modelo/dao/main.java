package modelo.dao;

import java.util.List;
import modelo.Departamento;

public class main {

    public static void main(String[] args) {
        // Crear instancia de DepartamentoDAO
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();

        // Obtener la lista de departamentos
        List<Departamento> departamentos = departamentoDAO.listar();

        // Imprimir cada departamento en la lista
        for (Departamento departamento : departamentos) {
            System.out.println(departamento);
        }
    }
}
