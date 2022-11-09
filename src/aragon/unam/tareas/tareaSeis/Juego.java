package aragon.unam.tareas.tareaSeis;

public class Juego {
	private boolean meta = true;
	private Laberinto laberinto = new Laberinto();

	public Juego() {

	}
	
	public void iniciaJuego() {
		String coordenadas = laberinto.getPila().peek();
		for(int i = 0; i < 1; i++) {
			this.laberinto.evaluarReglas(Integer.parseInt(coordenadas.substring(0, 2)), i);
		}
	}
	
}
