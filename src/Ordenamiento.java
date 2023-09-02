public class Ordenamiento {

	private static void ordIntercambio(int[] arreglo) {
		int sel;
		
		for (int i = 0; i < arreglo.length - 1; i++) {
			for (int j = i + 1; j < arreglo.length; j++) {
				sel = arreglo[i];
				if (sel > arreglo[j])
					swap(arreglo, i, j);
			}
		}
	}

	private static void ordSeleccion(int[] arreglo) {
		int min;
		
		for (int i = 0; i < arreglo.length - 1; i++) {
			min = i;
			
			for (int j = i + 1; j < arreglo.length; j++) {
				if (arreglo[j] < arreglo[min])
					min = j;
			}
			
			if (min != i)
				swap(arreglo, min, i);
		}
	}

	private static void ordInsercion(int[] arreglo) {
		int j;
		
		for (int i = 1; i < arreglo.length; i++) {
			j = i;
			int val = arreglo[i];
			
			while (j > 0 && val < arreglo[j - 1]) {
				arreglo[j] = arreglo[j - 1];
				j--;
			}
			
			arreglo[j] = val;
			
		}
	}
	
	public static void ordShell(int[] arreglo) {
		int intervalo = arreglo.length / 2;
		int j;
		int k;
		
		while (intervalo > 0) {
			
			for (int i = 0; i < arreglo.length; i++) {
				j = i - intervalo;
				
				while (j > 0) {
					k = j + intervalo;
					
					if (arreglo[j] < arreglo[k])
						j = -1;
					else {
						swap(arreglo, j, j + 1);
						j -= intervalo;
					}
				}
			}
			
			intervalo /= 2;
			
		}
	}
	
	public static void quicksort(int[] arreglo) {
		quicksort(arreglo, 0, arreglo.length - 1);
	}
	
	private static void quicksort(int[] arreglo, int begin, int end) {
		int central = (begin + end) / 2;
		int pivote = arreglo[central];
		int i = begin;
		int j = end;
		
		do {
			while (arreglo[i] < pivote) i++;
			while (arreglo[j] > pivote) j--;
			
			if (i <= j) {
				swap(arreglo, i, j);
				i++;
				j--;
			}
		} while (i <= j);
		
		if (begin < j)
			quicksort(arreglo, begin, j);
		if (i < end)
			quicksort(arreglo, i, end);
	}
	
	private static void swap(int[] arreglo, int i, int j) {
		int aux = arreglo[i];
		
		arreglo[i] = arreglo[j];
		arreglo[j] = aux;
	}
	
	private static void imprimirArreglo(int[] arreglo) {
		for (int i : arreglo) {
			System.out.print(i + " ");
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		
		int[] arreglo = {5, 2, 8, 0, 6, 3, 1, 12, 9, 15, 11}; // 11 elementos
		
		long start = System.nanoTime();
		
		quicksort(arreglo); // Cualquier funcion de ordenamiento
		
		long end = System.nanoTime();
		
		long time = end - start;
		
		imprimirArreglo(arreglo);
		
		System.out.println();
		System.out.println("Time in segundos: " + (time / 1000000000.0) + " segundos.\n" + 
								 "Tiempo en milisegundos: " + (time / 1000000.0) + " milisegundos.");
		
	}

}