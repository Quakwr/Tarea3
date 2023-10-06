class Amarillo extends Pikinim {
    public Amarillo() {
        super(1, 3); // Valores iniciales de ataque y capacidad para Amarillo
    }

    @Override
    public void multiplicar(int cantidad) {
        
        // int cantidad,  recibe un entero cantidad que se utiliza dentro de la formula de pikinim amarillo para multiplicarse.

        int nuevaCantidad = (int) Math.ceil(cantidad * 1.5);
        setCantidad(getCantidad() + nuevaCantidad);
        System.out.println("Los Pikinim amarillos han aumentado su cantidad en " + nuevaCantidad);
    }
}
