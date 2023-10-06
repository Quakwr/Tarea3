public class Pieza extends Zona implements ILevantar {
    private int peso;

    public Pieza(int peso) {
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public void Interactuar(Pikinim[] colorPikinim) {
        if (completada) {
            System.out.println("No queda nada que hacer aquí.");
        } else {
            System.out.println("--------------------------------------");
            System.out.println("Has encontrado una pieza! ahora intentaras levantarla para poder llevartela!");
            System.out.println("...");
            Levantar(colorPikinim);
        }
    }

    public void Levantar(Pikinim[] colorPikinim) {
        int sumaPikinim = 0;
        for (Pikinim pikinim : colorPikinim) {
            sumaPikinim += pikinim.getCantidad() * pikinim.getCapacidad();
        }

        if (sumaPikinim >= peso) {
            System.out.println("Has recuperado una pieza!");
            completada = true;
        } else {
            System.out.println("No puedes levantar la pieza :c");
        }
    }

}
