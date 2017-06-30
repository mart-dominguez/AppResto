package cursofyb.test.appresto.modelo;

/**
 * Created by martdominguez on 29/06/2017.
 */

public class Plato {
    private static Integer ID_PLATO=0;
    private Integer id;
    private String nombre;
    private String descripcion;
    private TipoPlato tipo;
    private Double precio;

    public Plato() {
        this.id=ID_PLATO++;
    }

    public Plato(String nombre, String descripcion, TipoPlato tipo, Double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.precio = precio;
    }

    public Plato(Integer id, String nombre, String descripcion, TipoPlato tipo, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoPlato getTipo() {
        return tipo;
    }

    public void setTipo(TipoPlato tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plato plato = (Plato) o;

        if (!id.equals(plato.id)) return false;
        return nombre.equals(plato.nombre);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nombre.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
