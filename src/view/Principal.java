package view;

import java.util.concurrent.Semaphore;

import controller.ThreadProcessoFCFS;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int id = 1; id < 21; id++) {
			Thread tProcesso = new ThreadProcessoFCFS(id, semaforo);
			tProcesso.start();
		}

	}

}
