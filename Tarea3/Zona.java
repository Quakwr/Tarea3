public abstract class Zona {
    protected boolean completada;

    public Zona() {

        // constructor de zona
        this.completada = false;
    }
    
    // Metodo de inteactuar utilizado en cada una de las zonas.
    
    public abstract void Interactuar(Pikinim[] colorPikinim);
}
