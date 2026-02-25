package gestor;

public class GestorNotas {

    private double[] notas;
    private int contador;

    public GestorNotas() {
        notas = new double[5];
        contador = 0;
    }

    public void agregarNota(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 10.");
        }

        if (contador >= notas.length) {
            throw new IllegalStateException("No hay espacio para más notas.");
        }

        notas[contador++] = nota;
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
    	       notas[contador] = 0;
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

            if (notas[i] < 0 || notas[i] > 10) {
                return "Existen notas fuera de rango.";
            }

            suma += notas[i];

            if (notas[i] >= 5) {
                aprobados++;
            } else {
                suspensos++;
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
