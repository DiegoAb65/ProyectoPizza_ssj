package Objetos;

public class Pizzas {
    private String id;
    private String nombre;
    private String precio;
    private String localizacion;

    public Pizzas(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public String toString() { //Si no se sobreescribe, retorna el hash code al hacer toString
        return nombre + " - $" + precio;
    }
}
