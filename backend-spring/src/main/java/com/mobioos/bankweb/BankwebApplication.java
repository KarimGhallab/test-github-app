package com.mobioos.bankweb;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankwebApplication {

	public static void main(String[] args) {
		System.out.println("Feature 1! main");
		SpringApplication.run(BankwebApplication.class, args);
	}

	private static void initFlags() {
		var getFlagsRunnable = new Runnable() {
			public void run() {
				//
			}
		};
		var thread = new Thread(() -> {
			System.out.println("Feature 1: initFlags");
			ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
			executor.scheduleAtFixedRate(getFlagsRunnable, 0, 1, TimeUnit.SECONDS);
		});
		thread.start();
	}

}
