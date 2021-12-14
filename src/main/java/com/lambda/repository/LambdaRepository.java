package com.lambda.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.lambda.model.Lambda;


@Repository
public class LambdaRepository {
	
	public List<Lambda> buildLambdas(){
		return Stream.of(
				new Lambda("Projeto BlueBank - Squad 5 Turma 2 Integrantes: - Gabriel Costa Dias; - Henrique Barbosa Douglas Barbosa; - Pedro Lucas Roseno Pacheco; - Phillip Marques Silva; - Vinicius Trindade Ribeiro")).collect(Collectors.toList());
	}

}
