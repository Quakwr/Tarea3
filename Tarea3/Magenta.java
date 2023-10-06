class Magenta extends Pikinim {
    public Magenta() {
        super(2, 1); // Valores iniciales de ataque y capacidad para Magenta
    }

    @Override
    public void multiplicar(int cantidad) {
        // int cantidad,  recibe un entero cantidad que se utiliza dentro de la formula de pikinim Magenta para multiplicarse.

        int nuevaCantidad = cantidad * getAtaque();
        setCantidad(getCantidad() + nuevaCantidad);
        System.out.println("Los Pikinim magenta han aumentado su cantidad en " + nuevaCantidad);
    }
}
