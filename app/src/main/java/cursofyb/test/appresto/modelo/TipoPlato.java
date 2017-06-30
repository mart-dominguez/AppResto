package cursofyb.test.appresto.modelo;

/**
 * Created by martdominguez on 29/06/2017.
 */

public class TipoPlato {
    private static Integer ID_TIPO_PLATO=1;
    private Integer id;

    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoPlato() {
        this.id=ID_TIPO_PLATO++;
    }

    public TipoPlato(String nombre) {
        this();
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "TipoPlato{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoPlato tipoPlato = (TipoPlato) o;

        if (!id.equals(tipoPlato.id)) return false;
        return nombre.equals(tipoPlato.nombre);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nombre.hashCode();
        return result;
    }
}
