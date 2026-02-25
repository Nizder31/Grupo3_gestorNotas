package gestor;

public class GestorNotas {

    private double[] notas;
    private int contador;

    public GestorNotas() {
        notas = new double[5];
        contador = 0;
    }

    public void agregarNota(double nota) {  //Jean Fix
    	   if (contador < notas.length) {
    	       notas[contador] = nota;
    	       contador++;
    	   } else {
    	       System.out.println("No hay espacio para más notas.");
    	   }
    	}


    public double calcularPromedio() {
        if (contador == 0) {
            throw new IllegalStateException("No hay notas registradas.");
        }

        double suma = 0;
        for (int i = 0; i < contador; i++) {
            suma += notas[i];
        }
        return suma / contador;
    }

    public double obtenerNotaMaxima() {

    	   if (contador == 0) {
    	       return 0; // o lanzar excepción
    	   }

    	   double max = notas[0];

    	   for (int i = 1; i < contador; i++) {
    	       if (notas[i] > max) {
    	           max = notas[i];
    	       }
    	   }

    	   return max;
    	}


    public void eliminarUltimaNota() {
        if (contador > 0) {
            contador--;
        }
    }

    public void mostrarNotas() {
        for (int i = 0; i < contador; i++) {
            System.out.println("Nota " + (i + 1) + ": " + notas[i]);
        }
    }

    public boolean hayEspacio() {
        return contador < notas.length;
    }

    public int contarAprobados() {
        int aprobados = 0;
        for (int i = 0; i < contador; i++) {
            if (notas[i] >= 5) {
                aprobados++;
            }
        }
        return aprobados;
    }
    
    public String evaluarGrupo() {

        if (contador == 0) {
            return "No hay notas registradas.";
        }

        int aprobados = 0;
        int suspensos = 0;
        double suma = 0;

        for (int i = 0; i < contador; i++) {

            suma += notas[i];

            if (notas[i] >= 5) {
                aprobados++;
            } else {
                suspensos++;
            }

            if (notas[i] < 0 || notas[i] > 10) {
                return "Existen notas fuera de rango.";
            }
        }

        double promedio = suma / contador;

        if (promedio >= 8 && suspensos == 0) {
            return "Grupo excelente.";
        } else if (promedio >= 5 && aprobados > suspensos) {
            return "Grupo aceptable.";
        } else if (promedio < 5 && suspensos > aprobados) {
            return "Grupo con dificultades.";
        } else {
            return "Situación irregular.";
        }
    }

}
