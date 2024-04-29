package view;

import lib.model.Lista;

public class Principal
{
	public static void main(String[] args)
	{
		Lista<Integer> A = new Lista<>();
		Lista<Integer> B = new Lista<>();
		Lista<Integer> I = new Lista<>();
		Lista<Integer> U = new Lista<>();
		
		preencherListaA(A);
		mostrarLista(A);
		preencherListaB(B);
		mostrarLista(B);
		
		//INTERSECCAO
		try {
			int tamanhoA = A.size();
			for (int i = 0; i < tamanhoA; i++) {
				int num = A.get(i);
				if (temNaLista(num, B))
					addLista(num, i, I);
			}
			
			//UNIVERSO
			for (int i = 0; i < tamanhoA; i++)
				addLista(A.get(i), i, U);
			int tamanhoB = B.size();
			for (int i = 0; i < tamanhoB; i++) {
				int num = B.get(i);
				if (!temNaLista(num, A))
					addLista(num, i, U);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		//MOSTRAR LISTAS
		mostrarLista(I);
		mostrarLista(U);
	}
	
	private static void preencherListaA(Lista<Integer> L)
	{
		L.addFirst(	16	);
		L.addFirst(	7	);
		L.addFirst(	9	);
		L.addFirst(	12	);
		L.addFirst(	8	);
		L.addFirst(	5	);
		L.addFirst(	3	);
	}
	
	private static void preencherListaB(Lista<Integer> L)
	{
		L.addFirst(	7	);
		L.addFirst(	3	);
		L.addFirst(	2	);
		L.addFirst(	6	);
		L.addFirst(	9	);
	}
	
	private static boolean temNaLista(int valor, Lista<Integer> L)
	{
		int tamanho = L.size();
		
		try {
			for (int i = 0; i < tamanho; i++) {
				if (L.get(i) == valor) return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	private static void mostrarLista(Lista<Integer> L)
	{
		try {
			int tamanho = L.size();
			for (int i = 0; i < tamanho; i++)
			{
				int num = L.get(0);
				L.remove(0);
				L.addLast(num);
				System.out.print(num + " -> ");
			}
			System.out.println("Fim!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private static void addLista(int num, int pos, Lista<Integer> L)
	{
		try {
			if (pos == 0) L.addFirst(num);
			else L.addLast(num);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
