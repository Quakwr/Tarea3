public class Pieza extends Zona implements ILevantar {
    private int peso;

    public Pieza(int peso) {

        //Constructor de pieza

        this.peso = peso;
    }

    public int getPeso() {

        //getter 
        return peso;
    }

    public void setPeso(int peso) {

        //setter
        this.peso = peso;
    }

    @Override
    public void Interactuar(Pikinim[] colorPikinim) {

        //Pikinim[] colorPikinim, recibe los 3 colores, interactua con la zona e intenta recoger la pieza utilizando Levantar.

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

        //Pikinim[] colorPikinim, recibe los 3 colores, intenta levantar la pieza de nave si la suma de cantidad y capacidad de los pikimins es mayor del peso de la pieza.
        
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
