class Cyan extends Pikinim {
    public Cyan() {
        super(1, 1);
    }

    @Override
    public void multiplicar(int cantidad) {

        // int cantidad,  recibe un entero cantidad que se utiliza dentro de la formula de pikinim Cyan para multiplicarse.

        int nuevaCantidad = cantidad * 3;
        setCantidad(getCantidad() + nuevaCantidad);
        System.out.println("Los Pikinim Cyan han aumentado su cantidad en " + nuevaCantidad);
    }
}
