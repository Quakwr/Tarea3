public abstract class Zona {
    protected boolean completada;

    public Zona() {
        this.completada = false;
    }
    
    public abstract void Interactuar(Pikinim[] colorPikinim);
}
