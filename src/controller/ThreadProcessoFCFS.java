package controller;

import java.util.concurrent.Semaphore;

public class ThreadProcessoFCFS extends Thread {

	private Semaphore semaforo;
	private int id;

	public ThreadProcessoFCFS(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			int duracao = (int) (Math.random() * 117) + 4;
			System.out.println(
					"Processo #" + id + " está em execução com duração de " + duracao + " segundos. Aguarde...");
			sleep(duracao * 1000);
			System.out.println("Processo #" + id + " terminou a execução.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

}
