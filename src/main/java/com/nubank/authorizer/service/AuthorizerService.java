package com.nubank.authorizer.service;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class AuthorizerService {

    public void authorize(final File file) {
        List<String> jsonStringList;

        try (Stream<String> lines = Files.lines(Paths.get(file.getAbsolutePath()))){
            jsonStringList = lines.collect(Collectors.toList());

            jsonStringList.stream().forEach(System.out::println);
        } catch(IOException e){

        }
    }
}
