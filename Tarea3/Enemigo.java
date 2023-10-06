import java.util.Random;
import java.util.Scanner;

public class Enemigo extends Zona implements ILevantar {
    private int vida;
    private int peso;
    private int ataque;

    public Enemigo(int vida, int peso, int ataque) {

        // Constructor de enemigo, le da vida, peso y ataque. 

        this.completada = false;
        this.vida = vida;
        this.peso = peso;
        this.ataque = ataque;
    }

    public int getPeso() {

        //getter

        return peso;
    }

    public void setPeso(int peso) {
        //setter
        this.peso = peso;
    }

    public int getAtaque() {

        //getter

        return ataque;
    }

    public void setAtaque(int ataque) {
        //setter
        this.ataque = ataque;
    }

    public int getVida() {
        //getter
        return vida;
    }

    public void setVida(int vida) {
        //setter
        this.vida = vida;
    }

    @Override
    public void Interactuar(Pikinim[] colorPikinim) {

        //Pikinim[] colorPikinim, recibe los 3 colores  y utiliza la funcion de Pelear, para pelar contra el enemigo

        if (completada) {
            System.out.println("No queda nada que hacer aquí.");
        } else {
            Pelear(colorPikinim);

        }
    }

    public void Levantar(Pikinim[] colorPikinim) {

        // Pikinim[] colorPikinim, recibe los 3 colores e intenta levantar al enemigo en caso de que el peso de los pikinims sea mayor al del enemigo derrotado.

        Juego juego = new Juego();
        int aLevantar = 0;
        System.out
                .println("Has logrado derrotar al enemigo!! veamos si puedes levantarlo para llevarte una recompensa!");
        System.out.println("...");
        System.out.println("...");
        for (Pikinim pikinim : colorPikinim) {
            aLevantar += pikinim.getCantidad() * pikinim.getCapacidad();
        }

        if (aLevantar >= peso) {
            System.out.println(
                    "Has logrado levantar al enemigo, ahora tienes la posibilidad de multiplicar uno de tus Pikimins!");

            System.out.println(
                    "¿Qué color de pikinim desea que se multiplique? (cantidad a multiplicar) " + peso);
            System.out.println("1. Cyan 2. Magenta 3. Amarillo");
            Scanner scanner = juego.getScanner();
            int opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    colorPikinim[0].multiplicar(peso);
                    break;
                case 2:
                    colorPikinim[1].multiplicar(peso);
                    break;
                case 3:
                    colorPikinim[2].multiplicar(peso);
                    break;
            }
            completada = true;
        } else {
            System.out.println("Vaya! no has podido... debilucho");
            completada = true;
        }
    }

    public void Pelear(Pikinim[] colorPikinim) {

        //Pikinim[] colorPikinim, recibe los 3 colores y pelea con el enemigo haciendo y recibiendo daño, en caso de derrotarlo, intenta levantarlo utilizando Levantar

        int ataquePikinim = 0;
        for (Pikinim pikinim : colorPikinim) {
            ataquePikinim += pikinim.getCantidad() * pikinim.getAtaque();
        }
        System.out.println("--------------------------------------");
        System.out.println("Te has encontrado a un fuerte enemigo! ahora mismo tiene " + vida + " de vida!");
        System.out.println("Decides atacarlo rapidamente!");
        System.out.println("...");
        System.out.println("...");

        vida -= ataquePikinim;

        if (vida <= 0) {
            System.out.println("Le has hecho " + ataquePikinim + " de daño! Que gran golpe! Lo has derrotado!");
        } else {
            System.out
                    .println("Le has hecho " + ataquePikinim + " de daño! dejandolo con " + vida
                            + " puntos de de vida restantes!");
        }
        // ataque de enemigoa pikmin
        Random random = new Random();
        int colorAtacado = random.nextInt(3);
        colorPikinim[colorAtacado].disminuir(ataque);
        System.out.println("Vaya, Te han atacado de vuelta!, la cantidad de Pikinims "
                + colorPikinim[colorAtacado].getClass().getSimpleName()
                + " ha sido disminuida a " + colorPikinim[colorAtacado].getCantidad());

        if (vida <= 0) {
            Levantar(colorPikinim);
        }
    }
}
