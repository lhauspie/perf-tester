package com.lhauspie.performance.test.runnable;

import java.util.ArrayList;
import java.util.List;

import com.lhauspie.performance.test.runnable.stream_vs_parallelstream.Commande;
import com.lhauspie.performance.test.runnable.stream_vs_parallelstream.ParallelStreamRunnable;
import com.lhauspie.performance.test.runnable.stream_vs_parallelstream.StreamRunnable;

public class PerformanceRunner {

	static IPerformanceRunnable performanceRunnable1 = new ParallelStreamRunnable();
	static IPerformanceRunnable performanceRunnable2 = new StreamRunnable();
	
	private static List<Commande> listeCommandes = new ArrayList<Commande>();

	public static void main(String[] args) {
		final int nbIterations = 1000;
		
		long start = System.currentTimeMillis();
		listeCommandes = Commande.getCommandes(100000);
		
		System.out.println("init takes " + (System.currentTimeMillis() - start) + "ms");
		
		performanceRunnable1.init(listeCommandes);
		System.out.println("Result test ParallelStreamRunnable : " + Tester.test(() -> performanceRunnable1.run(nbIterations)) + " ms");

		performanceRunnable2.init(listeCommandes);
		System.out.println("Result test StreamRunnable : " + Tester.test(() -> performanceRunnable2.run(nbIterations)) + " ms");
	}
}
