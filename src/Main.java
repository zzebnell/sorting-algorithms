public class Main {

	public static void ordenacionShell(double a[]) {
		int intervalo, i, j, k;
		int n = a.length;
		intervalo = n / 2;
		
		while (intervalo > 0) {
			for (i = intervalo; i < n; i++) {
				j = i - intervalo;
				
				while (j >= 0) {
					k = j + intervalo;
					if (a[j] <= a[k])
						j = -1; // par de elementos ordenado
					else {
						intercambiar(a, j, j + 1);
						j -= intervalo;
					}
				}
				
			}
			intervalo = intervalo / 2;
		}
	}

	public static void intercambiar(double[] a, int i, int j) {
		double aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}

	public static void main(String[] args) {

		double[] arreglo = { 51, 21, 39, 80, 36 };

		ordenacionShell(arreglo);

		for (double d : arreglo) {
			System.out.print(d + " ");
		}

	}

}