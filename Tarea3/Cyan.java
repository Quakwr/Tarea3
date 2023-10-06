class Cyan extends Pikinim {
    public Cyan() {
        super(1, 1);
    }

    @Override
    public void multiplicar(int cantidad) {
        int nuevaCantidad = cantidad * 3;
        setCantidad(getCantidad() + nuevaCantidad);
        System.out.println("Los Pikinim Cyan han aumentado su cantidad en " + nuevaCantidad);
    }
}
