package com.example.mul.config;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.mul.model.StringModel;
import com.example.mul.service.PrintService;

import lombok.extern.slf4j.Slf4j;

@Configuration	
@Slf4j
public class ProcessAll {

	@Autowired
	private PrintService printService;
	
	@PostConstruct
	public void processAllCL() throws InterruptedException {

		log.info("fetching list...");
		Thread.sleep(5000);
		List<StringModel> stringListdb= new ArrayList<>();
		stringListdb.add(new StringModel("a"));
		stringListdb.add(new StringModel("b"));
		stringListdb.add(new StringModel("c"));
		stringListdb.add(new StringModel("d"));
		stringListdb.add(new StringModel("e"));
		stringListdb.add(new StringModel("f"));
		
		log.info("list fetched");
		
		Stream<StringModel> text = stringListdb.stream();
		
		
		text.parallel().forEach(s -> {
			try {
				printService.printWhatever(s);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		log.info("done...");
	}
}
