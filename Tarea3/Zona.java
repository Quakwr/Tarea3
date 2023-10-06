public abstract class Zona {
    protected boolean completada;

    public Zona() {
        completada = false;
    }

    public abstract void Interactuar(Pikinim[] colorPikinim);
}
