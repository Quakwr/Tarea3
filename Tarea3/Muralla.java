public class Muralla extends Zona {
    private int vida;

    public Muralla(int vida) {
        this.completada = false;
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public void Interactuar(Pikinim[] colorPikinim) {
        
        if (completada) {
            System.out.println("No queda nada por hacer aca!");
        } else {
            System.out.println("Te has encontrado con una gran Muralla!");
            System.out.println("Debes destruirla antes de poder avanzar!");
            TryRomper(colorPikinim);
            if (vida > 0) {
                System.out.println(
                        "No has podido derrubar la gran muralla :c, pero... le has hecho daño! disminuyendo su vida a "
                                + vida);
            }
        }
    }

    public void TryRomper(Pikinim[] colorPikinim) {
        int ataquePikinim = 0;
        for (Pikinim pikinim : colorPikinim) {
            ataquePikinim += pikinim.getCantidad() * pikinim.getAtaque();
        }
        vida -= ataquePikinim;

        if (vida <= 0) {
            System.out.println("¡Has logrado derrurbar la gran muralla!, ahora puedes avanzar tranquilamente");
            completada = true;
        }
    }
}
