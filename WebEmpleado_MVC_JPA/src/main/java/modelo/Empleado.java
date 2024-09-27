package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "Empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "El nombre no puede estar vacío.")
    private String nombre;

    @NotEmpty(message = "El apellido no puede estar vacío.")
    private String apellido;

    @Positive(message = "El salario debe ser un valor positivo.")
    @Min(value = 1200, message = "El salario debe ser al menos 1200.")
    @Max(value = 52000, message = "El salario no debe exceder los 52000.")
    private double salario;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    // Constructor vacío
    public Empleado() {
    }

    // Constructor con parámetros
    public Empleado(String nombre, String apellido, double salario, Departamento departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.departamento = departamento;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
