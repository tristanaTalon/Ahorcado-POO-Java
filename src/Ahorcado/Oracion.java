package Ahorcado;

public class Oracion {
	String oracion;
	
	private static String[] oraciones = {
			"object solutions",
			"managing the object oriented project",
			"object oriented analysis and design with applications",
			"the unified modeling language user guide",
			"the mythical man month",
			"essays on software engineering",
			"extreme programming explained",
			"embrace change", 
			"embracing change",
			"refactoring",
			"improving the design of existing code",
			"uml distilled.",
			"a brief guide to the standard object modeling language",
			"patrones de diseño",
			"clean code",
			"a handbook of agile software craftsmanship",
			"object oriented software construction"
	}; 
	
	public Oracion (){
		oracion = "";
	}
	
	public Oracion(String oracion) {
		this.oracion = oracion;
	}

	public Oracion(Oracion oracion) {
		this();
		for(int i = 0; i<oracion.longitud(); i++) {
			if(oracion.obtenerLetra(i) != ' ') {
				this.oracion += "_";
			}else{
				this.oracion += " ";
			};
		}
	}
	
	public void elegirOracion() {
		int max = oraciones.length-1;
		int min = 0;
		int aleatorio = (int)(Math.random()*((max-min)+1))+min;
		oracion =  oraciones[aleatorio];
	}

	public void añadir() {
		GestorIO gestorIO = new GestorIO();
		gestorIO.out("Ingrese siguiente letra: ");
		oracion+=gestorIO.inChar();
	}
	
	private char obtenerLetra(int posicion) {
		return oracion.charAt(posicion);
	}

	public char ultimaLetra() {
		return obtenerLetra(oracion.length()-1);
	}

	public boolean incluye(char letra) {
		return oracion.indexOf(letra)!=-1;
	}

	private int longitud() {
		return oracion.length();
	}
	
	private void cortar(char letra) {
		oracion = oracion.replace(String.valueOf(letra),"");
	}
	
	private String cortado(String cadena) {
		return oracion.replace(cadena,"");
	}
	
	private Oracion sinCaracterRepetido() {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<oracion.length();i++){
			if(oracion.indexOf(oracion.charAt(i))==i){
				sb.append(oracion.charAt(i));
			}
		}
		String result=sb.toString();
		return new Oracion(result);
	}
	
	public boolean incluyeTodasLasLetras(Oracion letras) {
		Oracion oracionCortada = new Oracion(cortado(" "));
		Oracion letrasSinRepetir = letras.sinCaracterRepetido();
		for(int i = 0; i<letrasSinRepetir.longitud();i++) {
			oracionCortada.cortar(letrasSinRepetir.obtenerLetra(i));
		}
		return oracionCortada.longitud()==0;
	}
	
	private void cambiar(char letra, int posicion) {
		char[] caracteresOracion = oracion.toCharArray();		
		caracteresOracion[posicion]=letra;
		String oracionCaracteres = "";
		for(int i = 0; i<longitud();i++) {
			oracionCaracteres+=caracteresOracion[i];
		}
		oracion=oracionCaracteres;
	}
	
	private void llenarLetraAdivinada(Oracion oracion,char letra) {
		for(int i = 0; i<oracion.longitud();i++) {
			if(oracion.obtenerLetra(i)==letra) {
				cambiar(letra,i);
			}
		}
	}
	
	public void mostrarLetrasAdivinadas(Oracion letras) {
		Oracion rellenada = new Oracion(this);
		for(int i = 0; i<letras.longitud(); i++) {
			if(incluye(letras.obtenerLetra(i))) {
				rellenada.llenarLetraAdivinada(this,letras.obtenerLetra(i));
			}
		}
		rellenada.mostrar();
	}

	public void mostrar() {
		System.out.println(oracion);
	}

	
	public static void main(String[] args) {
		Oracion oracion=new Oracion("ab abc");
		Oracion letras=new Oracion("aaxabc");
		//oracion.mostrarLetrasAdivinadas(letras);
		//letras.añadir();
		//oracion.mostrarLetrasAdivinadas(letras);
		//letras.añadir();
		//oracion.mostrarLetrasAdivinadas(letras);
		
		
		System.out.println(oracion.incluyeTodasLasLetras(letras));
	}
}
