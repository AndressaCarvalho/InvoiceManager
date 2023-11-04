package dev.myapp.invoicemanager.command;

import dev.myapp.invoicemanager.config.FileConfiguration;
import dev.myapp.invoicemanager.config.GeneralConfiguration;
import dev.myapp.invoicemanager.service.IGeneratorService;
import dev.myapp.invoicemanager.service.GeneratorService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.concurrent.CompletableFuture;

@ShellComponent
public class GenerateFileCommand {
    private final IGeneratorService generatorService;
    private final GeneralConfiguration.MessageProperties generalMessageConfiguration;
    private final FileConfiguration.MessageProperties fileMessageConfiguration;

    public GenerateFileCommand(GeneratorService generatorService, GeneralConfiguration.MessageProperties generalMessageConfiguration, FileConfiguration.MessageProperties fileMessageConfiguration) {
        this.generatorService = generatorService;
        this.generalMessageConfiguration = generalMessageConfiguration;
        this.fileMessageConfiguration = fileMessageConfiguration;
    }

    @ShellMethod(key = "generate", value = "Inform the TXT file absolute path, and the CSV file(s) will be generated according to it.")
    public void generate(@ShellOption String arg) {
        System.out.println(fileMessageConfiguration.getFilesWaitGenerated());

        CompletableFuture<String> future = generatorService.generate(arg);

        try {
            String message = future.get();
            System.out.println(message);
        }
        catch (Exception e) {
            System.out.println(generalMessageConfiguration.getMessagesDefaultError() + e);
        }
    }
}
