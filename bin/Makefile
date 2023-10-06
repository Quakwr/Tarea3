
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
MAIN = Juego

CLASSES = \
        Enemigo.java \
		ILevantar.java \
		Magenta.java \
		Muralla.java \
		Pieza.java \
        Pikinim.java \
		Cyan.java \
        Amarillo.java \
		Pieza.java \
		Pildora.java \
		Zona.java \
        Juego.java

default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	java $(MAIN)
clean:
	$(RM) *.class