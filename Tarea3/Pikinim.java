public abstract class Pikinim {
    protected int ataque;
    protected int capacidad;
    protected int cantidad;

    public Pikinim(int ataque, int capacidad) {

        //Constructor de Pikinim, les da ataque y capacidad

        this.ataque = ataque;
        this.capacidad = capacidad;
        this.cantidad = 10;
    }

    public int getAtaque() {

        //getter
        return ataque;
    }

    public void setAtaque(int ataque) {

        //setter
        this.ataque = ataque;
    }

    public int getCapacidad() {

        //getter
        return capacidad;
    }

    // Setter para establecer el valor de capacidad
    public void setCapacidad(int capacidad) {

         //setter
        this.capacidad = capacidad;
    }

    // Getter para obtener el valor de cantidad
    public int getCantidad() {

        //getter
        return cantidad;
    }

    // Setter para establecer el valor de cantidad
    public void setCantidad(int cantidad) {

        //setter
        this.cantidad = cantidad;
    }

    // Método abstracto para multiplicar la cantidad de Pikinim, se utiliza en los 3 archivos de pikinim.
    public abstract void multiplicar(int cantidad);

    
    void disminuir(int cantidad) {

        // Disminuye la cantidad de pikinims

        if (this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
        } else {
            this.cantidad = 0;
        }
    }
}
