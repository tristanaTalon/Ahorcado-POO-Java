package Ahorcado;

public class Muñeco {
	private int vidas;
	
	public Muñeco() {
		vidas=2;
	}
	
	public void mostrar() {
		new GestorIO().out("El muñeco tiene: " + vidas + " vidas\n");
	}

	public void añadir() {
		vidas--;
	}

	public boolean ahorcado() {
		return vidas==0;
	}

	public static void main(String[] args) {
		Muñeco muñeco = new Muñeco();
		muñeco.mostrar();
		muñeco.añadir();
		muñeco.mostrar();
		System.out.println(muñeco.ahorcado());
		muñeco.añadir();
		muñeco.mostrar();
		System.out.println(muñeco.ahorcado());
	}
	
}
