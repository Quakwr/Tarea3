import java.util.Scanner;

public class Juego {
    private Zona[] mapa = new Zona[11];
    private int posJugador;
    private int turnos;

    ;

    public Juego() {
        mapa[0] = new Pieza(50);
        mapa[1] = new Enemigo(130, 20, 25);
        mapa[2] = new Enemigo(50, 10, 15);
        mapa[3] = new Pildora(25);
        mapa[4] = new Muralla(50);
        mapa[5] = new Pieza(100);
        mapa[6] = new Enemigo(45, 8, 10);
        mapa[7] = new Pieza(35);
        mapa[8] = new Pildora(15);
        mapa[9] = new Enemigo(75, 15, 20);
        mapa[10] = new Muralla(150);

        posJugador = 5;
        turnos = 30;
    }

    public void moverIzq() {
        if (turnos > 0) {
            if (posJugador == 0) {
                posJugador = 10;
            } else {
                posJugador--;
            }
            turnos--;
            // recordar añadir interactuar con zona y pikmin
        }
    }

    public void moverDer() {
        if (turnos > 0) {
            if (posJugador == 10) {
                posJugador = 0;
            } else {
                posJugador++;
            }
            turnos--;
        }
    }

    public void Quedarse() {
        turnos--;
    }

    public static void main(String[] args) {
        // Crear una instancia de Juego
        Juego juego = new Juego();
        Scanner scanner = new Scanner(System.in);
        Zona zonaActual = juego.mapa[juego.posJugador];
        Pikinim[] colorPikinim = new Pikinim[3];

        colorPikinim[0] = new Cyan();
        colorPikinim[1] = new Magenta();
        colorPikinim[2] = new Amarillo();

        while (juego.turnos > 0) {
            if (juego.turnos == 30) {
                System.out.println(
                        "¡Has tenido un grave accidente! Has aterrizado en un misterioso planeta despues de chocar un un asteroide... pero te encontraste con unas critautras coloridas dispuestas a ayudarte.");
            }
            System.out.println("--------------------------------------");
            System.out.println("Turno " + juego.turnos + " (Cyan - " + colorPikinim[0].getCantidad() + ", Amarillo - "
                    + colorPikinim[2].getCantidad() + ", Magenta - " + colorPikinim[1].getCantidad() + ")");

            if (zonaActual instanceof Pieza) {
                Pieza pieza = (Pieza) zonaActual;
                System.out.println(
                        "Zona Actual: " + zonaActual.getClass().getSimpleName() + " (peso - " + pieza.getPeso() + ")");
            } else if (zonaActual instanceof Enemigo) {
                Enemigo enemigo = (Enemigo) zonaActual;
                System.out.println(
                        "Zona Actual: " + zonaActual.getClass().getSimpleName() + " (vida - " + enemigo.getVida()
                                + ", peso - " + enemigo.getPeso()
                                + ", ataque - "
                                + enemigo.getAtaque() + ")");
            } else if (zonaActual instanceof Pildora) {
                Pildora pildora = (Pildora) zonaActual;
                System.out.println(
                        "Zona Actual: " + zonaActual.getClass().getSimpleName() + " (peso - " + pildora.getPeso()
                                + ")");
            } else if (zonaActual instanceof Muralla) {
                Muralla muralla = (Muralla) zonaActual;
                System.out.println(
                        "Zona Actual: " + zonaActual.getClass().getSimpleName() + " (vida - " + muralla.getVida()
                                + ")");
            }

            System.out.println("Opciones:");
            if (juego.posJugador != 10 && juego.posJugador != 0) {
                System.out.println(
                        "1. Ir a derecha (" + juego.mapa[(juego.posJugador + 1)].getClass().getSimpleName() + ")");
                System.out.println("2. Ir a la izquierda ("
                        + juego.mapa[(juego.posJugador - 1)].getClass().getSimpleName() + ")");
            } else if (juego.posJugador == 10) {
                System.out.println(
                        "1. Ir a derecha (" + juego.mapa[0].getClass().getSimpleName() + ")");
                System.out.println("2. Ir a la izquierda ("
                        + juego.mapa[(juego.posJugador - 1)].getClass().getSimpleName() + ")");
            } else if (juego.posJugador == 0) {
                System.out.println(
                        "1. Ir a derecha (" + juego.mapa[(juego.posJugador + 1)].getClass().getSimpleName() + ")");
                System.out.println("2. Ir a la izquierda ("
                        + juego.mapa[10].getClass().getSimpleName() + ")");
            }
            System.out.println("3. Quedarse aquí");
            System.out.println("--------------------------------------");
            int opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    juego.moverDer();
                    zonaActual = juego.mapa[juego.posJugador];
                    zonaActual.Interactuar(colorPikinim);

                    break;
                case 2:
                    juego.moverIzq();
                    zonaActual = juego.mapa[juego.posJugador];
                    zonaActual.Interactuar(colorPikinim);
                    break;
                case 3:
                    juego.Quedarse();
                    zonaActual = juego.mapa[juego.posJugador];
                    zonaActual.Interactuar(colorPikinim);

                    break;
            }
        }
        scanner.close();
    }
}
