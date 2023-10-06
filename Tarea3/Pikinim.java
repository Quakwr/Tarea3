public abstract class Pikinim {
    protected int ataque;
    protected int capacidad;
    protected int cantidad;

    public Pikinim(int ataque, int capacidad) {
        this.ataque = ataque;
        this.capacidad = capacidad;
        this.cantidad = 10;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getCapacidad() {
        return capacidad;
    }

    // Setter para establecer el valor de capacidad
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    // Getter para obtener el valor de cantidad
    public int getCantidad() {
        return cantidad;
    }

    // Setter para establecer el valor de cantidad
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método abstracto para multiplicar la cantidad de Pikinim
    public abstract void multiplicar(int cantidad);

    // Método para disminuir la cantidad de Pikinim
    void disminuir(int cantidad) {
        if (this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
        } else {
            this.cantidad = 0;
        }
    }
}
