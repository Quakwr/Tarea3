import java.util.Scanner;

public class Juego {
    
    private Scanner scanner;
    private Zona[] mapa = new Zona[11];
    private int posJugador;
    private int turnos;
    private int nPiezas = 0;
    ;

    public Juego() {

        // Crea el trablero y constructor de Juego
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

        this.scanner = new Scanner(System.in);
        posJugador = 5;
        turnos = 30;
    }

    public void moverIzq() {

        // Mueve al jugador a la izquerda.

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

        //Mueve al jugador a la derecha.
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

        //El jugador se queda quieto 
        turnos--;
    }

    public Scanner getScanner() {

        //Scanner utilizado para detectar las opciones del jugador.
        return scanner;
    }
    public static void main(String[] args) {
        // Crear una instancia de Juego y main, le da opciones al y muestra toda las opciones necesarias para jugar el juego. Da inicio y termino al juego. le permite la mobilidad al jugador y la opciones en caso de enconrtarse con un muro.
       
        Juego juego = new Juego();
        
        Zona zonaActual = juego.mapa[juego.posJugador];
        Pikinim[] colorPikinim = new Pikinim[3];

        colorPikinim[0] = new Cyan();
        colorPikinim[1] = new Magenta();
        colorPikinim[2] = new Amarillo();

        while (juego.turnos > 0 || juego.nPiezas == 3) {
            if (juego.turnos == 30) {
                System.out.println(
                        "¡Has tenido un grave accidente! Has aterrizado en un misterioso planeta despues de chocar un un asteroide... pero te encontraste con unas critautras coloridas dispuestas a ayudarte.");
            }
            System.out.println("--------------------------------------");
            System.out.println("Turno " + juego.turnos + " (Cyan - " + colorPikinim[0].getCantidad() + ", Amarillo - "
                    + colorPikinim[2].getCantidad() + ", Magenta - " + colorPikinim[1].getCantidad() + ")    Piezas recuperadas: " + juego.nPiezas + "/3" );
            if (juego.nPiezas == 3) {
                break;
            }
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
            int opcion = juego.scanner.nextInt();

            switch (opcion) {

                case 1:
                    juego.moverDer();
                    zonaActual = juego.mapa[juego.posJugador];
                    if (zonaActual instanceof Pieza) {
                        if (zonaActual.completada == false) {
                            zonaActual.Interactuar(colorPikinim);
                            if (zonaActual.completada == true) {
                                juego.nPiezas += 1;
                            }
                        }
                    }
                    zonaActual.Interactuar(colorPikinim);
                    if (zonaActual instanceof Muralla) {
                        if (zonaActual.completada == true) {
                            System.out.println("--------------------------------------");
                            break;
                        } else {
                            while (zonaActual instanceof Muralla && zonaActual.completada == false){
                                System.out.println("--------------------------------------");
                                System.out.println("OOPS! Has chocado con la gran muralla!, los pikinims se rien de ti :c, te das cuenta de que la gran muralla te prohibe el paso.");
                                System.out.println("");
                                System.out.println("¿Que eliges hacer?");
                                System.out.println("1. Devolverse a zona anterior? " + "(" + juego.mapa[juego.posJugador - 1].getClass().getSimpleName() + ")");
                                System.out.println("2. Continuar batallando contra la muralla");
                                System.out.println("--------------------------------------");
                                int opcion2 = juego.scanner.nextInt();
                            
                                switch (opcion2) {
                                    case 1:
                                        juego.moverIzq();
                                        zonaActual = juego.mapa[juego.posJugador];
                                        zonaActual.Interactuar(colorPikinim);
                                        break;
                                    case 2:
                                        juego.Quedarse();
                                        zonaActual.Interactuar(colorPikinim);
                                        break;
                                }
                            }
                        }
                    }

                    break;
                case 2:
                    juego.moverIzq();
                    zonaActual = juego.mapa[juego.posJugador];
                    if (zonaActual instanceof Pieza) {
                        if (zonaActual.completada == false) {
                            zonaActual.Interactuar(colorPikinim);
                            if (zonaActual.completada == true) {
                                juego.nPiezas += 1;
                            }
                        }
                    }
                    zonaActual.Interactuar(colorPikinim);
                    if (zonaActual instanceof Muralla) {
                        Muralla muralla = (Muralla) zonaActual;
                        if (zonaActual.completada == true ) {
                            System.out.println("--------------------------------------");
                            break;
                        } else {
                            while (zonaActual instanceof Muralla && zonaActual.completada == false) {
                                if (zonaActual.completada == false ){
                                    System.out.println("--------------------------------------");
                                    System.out.println("No puedes seguir por este camino! la gran muralla te prohibe el paso.        (Turno: " + juego.turnos + ")");
                                    System.out.println("Ahora mismo la muralla tiene " + muralla.getVida() + " de vida!");
                                    System.out.println("¿Que eliges hacer?");
                                    System.out.println("1. Devolverse a zona anterior? " + "(" + juego.mapa[juego.posJugador + 1].getClass().getSimpleName() + ")");
                                    System.out.println("2. Continuar batallando contra la muralla");
                                    System.out.println("--------------------------------------");
                                    int opcion2 = juego.scanner.nextInt();
                                
                                    switch (opcion2) {
                                        case 1:
                                            juego.moverDer();
                                            zonaActual = juego.mapa[juego.posJugador];
                                            zonaActual.Interactuar(colorPikinim);
                                            break;
                                        case 2:
                                            juego.Quedarse();
                                            zonaActual.Interactuar(colorPikinim);
                                            break;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    juego.Quedarse();
                    zonaActual = juego.mapa[juego.posJugador];
                    if (zonaActual instanceof Pieza) {
                        if (zonaActual.completada == false) {
                            zonaActual.Interactuar(colorPikinim);
                            if (zonaActual.completada == true) {
                                juego.nPiezas += 1;
                            }
                        }
                    }
                    zonaActual.Interactuar(colorPikinim);
                    
                    break;

            }
            System.out.println("--------------------------------------");
        }
        if (juego.turnos == 0) {
            System.out.println("--------------------------------------");
            System.out.println("NOOO, Te has quedado sin turnos!, has perdido tu oportunidad y los pikinims se abuerrieron de ti!");
            System.out.println("Ahora quedaras para siempre en este misterioso planeta...");
            System.out.println("...");
            System.out.println("...");
            System.out.println("sin amigos...");
        } else {
            System.out.println("--------------------------------------");
            System.out.println("FELICIDADES! Gracias a tu gran esfuerzo y a la ayuda de los pikinims has podido conseguir todas piezas de tu nave!");
            System.out.println("Ahora puedes reparar tu nave e irte de este planeta! pero extrañaras a tus nuevos amigos... ;C");
            System.out.println("...");
            System.out.println("Vuelves a tu planeta.");
        }
        juego.scanner.close(); //Cierre de scanner
    }
}
