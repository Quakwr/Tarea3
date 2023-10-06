import java.util.Scanner;

public class Pildora extends Zona {
    private int peso;
    
    public Pildora(int peso) {

        //Constructor de pildora 

        this.completada = false;
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

        //Pikinim[] colorPikinim, recibe los 3 colores, interactua con la zona y consume una pildora para multiplicar alguno de los pikinims, utilizando su respectivo multiplicar.

        Juego juego = new Juego();
        Scanner scanner = juego.getScanner();
        if (completada) {
            System.out.println("No queda nada que hacer aquí.");
        } else {
            System.out.println("Has encontrado una pildora! Ahora puedes aumentar al cantidad de uno de tus pinikim!");
            System.out.println("");
            System.out.println(
                    "¿Qué color de pikinim desea que se multiplique? (cantidad a multiplicar) " + peso);
            
            System.out.println("1. Cyan 2. Magenta 3. Amarillo");
            
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
        }
    }
}
