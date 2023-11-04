package dev.myapp.invoicemanager.service;

import com.opencsv.CSVWriter;
import dev.myapp.invoicemanager.config.FileConfiguration;
import dev.myapp.invoicemanager.config.GeneralConfiguration;
import dev.myapp.invoicemanager.model.InvoiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class GeneratorService implements IGeneratorService {
    private final String fileDirectory;
    private final List<InvoiceModel> listInvoicesWithValueZero = new ArrayList<>(), listInvoicesWithNumberPageLessThanOrEqualToSix = new ArrayList<>(), listInvoicesWithNumberPageLessThanOrEqualToTwelve = new ArrayList<>(), listInvoicesWithNumberPageGreaterThanTwelve = new ArrayList<>();
    private final IInvoiceService invoiceService;
    private final GeneralConfiguration.MessageProperties generalMessageConfiguration;
    private final FileConfiguration.ConfigProperties fileGeneralConfiguration;
    private final FileConfiguration.MessageProperties fileMessageConfiguration;

    @Autowired
    public GeneratorService(InvoiceService invoiceService, GeneralConfiguration.MessageProperties generalMessageConfiguration, FileConfiguration.ConfigProperties fileGeneralConfiguration, FileConfiguration.MessageProperties fileMessageConfiguration) {
        this.invoiceService = invoiceService;
        this.generalMessageConfiguration = generalMessageConfiguration;
        this.fileGeneralConfiguration = fileGeneralConfiguration;
        this.fileMessageConfiguration = fileMessageConfiguration;
        this.fileDirectory = System.getProperty("user.home") + File.separator + fileGeneralConfiguration.getFilesDefaultDir() + File.separator + fileGeneralConfiguration.getFilesDefaultDirFiles();
    }

    @Async
    public CompletableFuture<String> generate(String sourceFilePath) {
        String resultMessage = "";

        try {
            clearInvoicesLists();

            if (filterDataFromSourceFile(sourceFilePath)) {
                if (createFileDirectory()) {
                    generateFileByType();
                    resultMessage = fileMessageConfiguration.getFilesGeneratedSuccess() + fileDirectory;
                }
                else
                    resultMessage = fileMessageConfiguration.getFilesCreateDirError();
            }
            else
                resultMessage = fileMessageConfiguration.getFilesNoDataFound();
        }
        catch (Exception e) {
            System.out.println(generalMessageConfiguration.getMessagesDefaultError() + e);
            resultMessage = fileMessageConfiguration.getFilesGeneratedError();
        }

        return CompletableFuture.completedFuture(resultMessage);
    }

    private void clearInvoicesLists() {
        listInvoicesWithValueZero.clear();
        listInvoicesWithNumberPageLessThanOrEqualToSix.clear();
        listInvoicesWithNumberPageLessThanOrEqualToTwelve.clear();
        listInvoicesWithNumberPageGreaterThanTwelve.clear();
    }

    private Boolean filterDataFromSourceFile(String sourceFilePath) throws Exception {
        boolean isDataToFileFound = false;

        try {
            String row = "";
            int rowNumber = 0;

            BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFilePath));

            while (row != null) {
                System.out.println(fileMessageConfiguration.getFilesCurrentRow() + rowNumber);

                if (!row.isEmpty() && rowNumber != 1) {
                    String[] records = row.split(";");

                    if (isValidZipCode(records[1])) {
                        isDataToFileFound = true;

                        String nameCustomer = records[0].trim();
                        String completeAddress = records[2].trim() + " - " + records[1].trim() + " - " + records[3].trim() + " - " + records[4].trim() + " - " + records[5].trim();
                        double invoiceValue = Double.parseDouble(records[6].trim().replaceAll(",", "."));
                        int numberOfPages = formatNumberOfPages(Integer.parseInt(records[7].trim()));

                        InvoiceModel newInvoice = invoiceService.create(
                                nameCustomer,
                                completeAddress,
                                invoiceValue,
                                numberOfPages
                        );

                        if (isInvoiceValueZero(invoiceValue))
                            listInvoicesWithValueZero.add(newInvoice);
                        else {
                            if (isNumberPageLessThanOrEqualToSix(numberOfPages)) {
                                listInvoicesWithNumberPageLessThanOrEqualToSix.add(newInvoice);

                                listInvoicesWithNumberPageLessThanOrEqualToTwelve.add(newInvoice);
                            }
                            else if (isNumberPageLessThanOrEqualToTwelve(numberOfPages))
                                listInvoicesWithNumberPageLessThanOrEqualToTwelve.add(newInvoice);
                            else
                                listInvoicesWithNumberPageGreaterThanTwelve.add(newInvoice);
                        }
                    }
                }

                rowNumber++;

                row = bufferedReader.readLine();
            }

            bufferedReader.close();
        }
        catch (Exception e) {
            throw e;
        }

        return isDataToFileFound;
    }

    private void generateFileByType() throws Exception {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

            if (!listInvoicesWithValueZero.isEmpty())
                generateFile(listInvoicesWithValueZero, fileGeneralConfiguration.getFilesNameInvoicesValueZero() + dateFormat.format(new Date()));

            if (!listInvoicesWithNumberPageLessThanOrEqualToSix.isEmpty())
                generateFile(listInvoicesWithNumberPageLessThanOrEqualToSix, fileGeneralConfiguration.getFilesNameInvoicesPagesLessEqualSix() + dateFormat.format(new Date()));

            if (!listInvoicesWithNumberPageLessThanOrEqualToTwelve.isEmpty())
                generateFile(listInvoicesWithNumberPageLessThanOrEqualToTwelve, fileGeneralConfiguration.getFilesNameInvoicesPagesLessEqualTwelve() + dateFormat.format(new Date()));

            if (!listInvoicesWithNumberPageGreaterThanTwelve.isEmpty())
                generateFile(listInvoicesWithNumberPageGreaterThanTwelve, fileGeneralConfiguration.getFilesNameInvoicesPagesAboveTwelve() + dateFormat.format(new Date()));
        }
        catch (Exception e) {
            throw e;
        }
    }

    private void generateFile(List<InvoiceModel> invoices, String fileName) throws Exception {
        String fileDirectoryPath = fileDirectory + File.separator;

        try (FileWriter writer = new FileWriter(fileDirectoryPath + fileName.concat(".csv"));
             CSVWriter csvWriter = new CSVWriter(writer)) {
            csvWriter.writeNext(new String[]{ fileGeneralConfiguration.getFilesHeaderColOne(), fileGeneralConfiguration.getFilesHeaderColTwo(), fileGeneralConfiguration.getFilesHeaderColThree(), fileGeneralConfiguration.getFilesHeaderColFour() });

            for (InvoiceModel invoice : invoices) {
                String[] row = { invoice.getNameCustomer(), invoice.getAddress(), invoice.getValue().toString(), invoice.getNumberOfPages().toString() };
                csvWriter.writeNext(row);
            }
        }
        catch (Exception e) {
            throw e;
        }
    }

    private Boolean createFileDirectory() throws Exception {
        boolean isDirectoryCreated = false;

        try {
            File directoryFile = new File(fileDirectory);

            if (!directoryFile.exists())
                isDirectoryCreated = directoryFile.mkdirs();
            else
                isDirectoryCreated = true;
        }
        catch (Exception e) {
            throw e;
        }

        return isDirectoryCreated;
    }

    private Boolean isValidZipCode(String zipCode) {
        zipCode = zipCode.trim();

        if (zipCode.matches("[0-9]+")) {
            int zipCodeLength = zipCode.length();

            return zipCodeLength >= 7 && zipCodeLength <= 8 && Integer.parseInt(zipCode) != 0;
        }

        return false;
    }

    private int formatNumberOfPages(int numberOfPages) {
        if (numberOfPages % 2 == 0)
            return numberOfPages;

        return numberOfPages + 1;
    }

    private Boolean isInvoiceValueZero(double invoiceValue) {
        return (int)invoiceValue == 0;
    }

    private Boolean isNumberPageLessThanOrEqualToSix(int invoicePageNumber) {
        return invoicePageNumber <= 6;
    }

    private Boolean isNumberPageLessThanOrEqualToTwelve(int invoicePageNumber) {
        return invoicePageNumber <= 12;
    }
}
