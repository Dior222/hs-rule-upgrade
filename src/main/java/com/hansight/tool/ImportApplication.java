package com.hansight.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ImportApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ImportApplication.class, args);
		MigrationService migrationService = ctx.getBean(MigrationService.class);
		migrationService.work();
//		migrationService.close();
	}
}
