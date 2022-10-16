package com.example.mul.service;

import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.example.mul.model.StringModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PrintService {

	public Consumer<? super StringModel> printWhatever(StringModel s) throws InterruptedException {
		
		log.info("processing {}: ...",s.getName());
		Thread.sleep(20000);
		log.info("processed {}: ...",s.getName());
		return null;
		

	}
}
