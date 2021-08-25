package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> lista = new ArrayList<>();
		
		lista.add(5);
		lista.add(7);
		lista.add(8);
		lista.add(2, 9);
		
		List<Integer> result = lista.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		
		for(Integer x : lista) {
			System.out.println(x);
		}
		
		System.out.println("--------------------");
		
		for(Integer y : result) {
			System.out.println(y);
		}
		
		System.out.println("--------------------");
		int primeiro = lista.stream().filter(x -> x % 2 != 0).findFirst().orElse(0);
		
		System.out.println(primeiro);
		
	}

}
