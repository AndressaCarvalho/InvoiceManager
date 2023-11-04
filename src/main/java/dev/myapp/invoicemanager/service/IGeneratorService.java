package dev.myapp.invoicemanager.service;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

public interface IGeneratorService {
    @Async
    CompletableFuture<String> generate(String sourceFilePath);
}
