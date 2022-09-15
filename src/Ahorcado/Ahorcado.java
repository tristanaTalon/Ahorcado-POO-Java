package Ahorcado;

class Ahorcado {

	private Muñeco muñeco;
	
	private Oracion oracion;
	
	private Oracion letras;	
	
	public Ahorcado() {
		oracion = new Oracion();
		letras = new Oracion();
		muñeco = new Muñeco();
	}
	
	public void jugar() {
		oracion.elegirOracion();
		do {
			mostrar();
			letras.añadir();
			char ultimaLetra = letras.ultimaLetra();
			if(!oracion.incluye(ultimaLetra)) {
				muñeco.añadir();
			}
		}while(!oracion.incluyeTodasLasLetras(letras) && !muñeco.ahorcado());
		mostrarResultadoFinalPartida();
	}
	
	private void mostrar() {
		oracion.mostrarLetrasAdivinadas(letras);
		muñeco.mostrar();
		letras.mostrar();
	}
	
	private void mostrarResultadoFinalPartida() {
		if(oracion.incluyeTodasLasLetras(letras)) {
			System.out.println("Victoria!");
		}
		
		if(muñeco.ahorcado()) {
			System.out.println("Derrota!");
		}
	}


	public static void main(String[] args) {
		new Ahorcado().jugar();
	}

}
