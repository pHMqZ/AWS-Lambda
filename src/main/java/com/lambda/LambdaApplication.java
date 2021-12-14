package com.lambda;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lambda.model.Lambda;
import com.lambda.repository.LambdaRepository;

@SpringBootApplication
public class LambdaApplication {
	@Autowired
	private LambdaRepository lambdaRepository;
	
	@Bean
	public Supplier<List<Lambda>> lambdas(){
		return () -> lambdaRepository.buildLambdas();
	}
	
	@Bean
	public Function<String, List<Lambda>> findLambda(){
		return (input) -> lambdaRepository.buildLambdas().stream().filter(lambda -> lambda.getString().equals(input)).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LambdaApplication.class, args);
	}

}
