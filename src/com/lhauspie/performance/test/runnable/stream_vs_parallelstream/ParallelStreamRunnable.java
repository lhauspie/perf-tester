package com.lhauspie.performance.test.runnable.stream_vs_parallelstream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.lhauspie.performance.test.runnable.IPerformanceRunnable;

public class ParallelStreamRunnable implements IPerformanceRunnable<List<Commande>> {

	private List<Commande> commandes;
	
	@Override
	public void run(int nbIteration) {
		for (int i = 0; i < nbIteration; i++) {
			this.test();
		}
		System.out.println(this.toString());
	}
	
	@Override
	public void init(List<Commande> object) {
		IPerformanceRunnable.super.init(object);
		commandes = object;
	}
	
	private void test() {
		List<Commande> commandes = (List<Commande>) ((ArrayList) this.commandes).clone();
		commandes.parallelStream()
			.filter(x -> {
//				System.out.println("filtering " + x.getNumero());
				return x.getNumero().startsWith("201405");	
			})
//			.sorted()
			.map(Commande::getNumero)
			.collect(Collectors.toList());
//			.forEach(System.out::println);
	}
}