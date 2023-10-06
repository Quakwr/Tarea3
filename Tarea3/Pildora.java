import java.util.Scanner;

public class Pildora extends Zona {
    private int peso;

    public Pildora(int peso) {
        this.completada = false;
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
            System.out.println(
                    "¿Qué color de pikinim desea que se multiplique? (cantidad a multiplicar) " + peso);
            System.out.println("1. Cyan 2. Magenta 3. Amarillo");
            Scanner scanner = new Scanner(System.in);
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
