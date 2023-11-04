package dev.myapp.invoicemanager.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(FileConfiguration.class)
public class FileConfiguration {
    @Configuration
    @ConfigurationProperties(prefix = "file.config")
    public static class ConfigProperties {
        private String filesDefaultDir;
        private String filesDefaultDirFiles;
        private String filesNameInvoicesValueZero;
        private String filesNameInvoicesPagesLessEqualSix;
        private String filesNameInvoicesPagesLessEqualTwelve;
        private String filesNameInvoicesPagesAboveTwelve;
        private String filesHeaderColOne;
        private String filesHeaderColTwo;
        private String filesHeaderColThree;
        private String filesHeaderColFour;

        public String getFilesDefaultDir() {
            return filesDefaultDir;
        }

        public void setFilesDefaultDir(String filesDefaultDir) {
            this.filesDefaultDir = filesDefaultDir;
        }

        public String getFilesDefaultDirFiles() {
            return filesDefaultDirFiles;
        }

        public void setFilesDefaultDirFiles(String filesDefaultDirFiles) {
            this.filesDefaultDirFiles = filesDefaultDirFiles;
        }

        public String getFilesNameInvoicesValueZero() {
            return filesNameInvoicesValueZero;
        }

        public void setFilesNameInvoicesValueZero(String filesNameInvoicesValueZero) {
            this.filesNameInvoicesValueZero = filesNameInvoicesValueZero;
        }

        public String getFilesNameInvoicesPagesLessEqualSix() {
            return filesNameInvoicesPagesLessEqualSix;
        }

        public void setFilesNameInvoicesPagesLessEqualSix(String filesNameInvoicesPagesLessEqualSix) {
            this.filesNameInvoicesPagesLessEqualSix = filesNameInvoicesPagesLessEqualSix;
        }

        public String getFilesNameInvoicesPagesLessEqualTwelve() {
            return filesNameInvoicesPagesLessEqualTwelve;
        }

        public void setFilesNameInvoicesPagesLessEqualTwelve(String filesNameInvoicesPagesLessEqualTwelve) {
            this.filesNameInvoicesPagesLessEqualTwelve = filesNameInvoicesPagesLessEqualTwelve;
        }

        public String getFilesNameInvoicesPagesAboveTwelve() {
            return filesNameInvoicesPagesAboveTwelve;
        }

        public void setFilesNameInvoicesPagesAboveTwelve(String filesNameInvoicesPagesAboveTwelve) {
            this.filesNameInvoicesPagesAboveTwelve = filesNameInvoicesPagesAboveTwelve;
        }

        public String getFilesHeaderColOne() {
            return filesHeaderColOne;
        }

        public void setFilesHeaderColOne(String filesHeaderColOne) {
            this.filesHeaderColOne = filesHeaderColOne;
        }

        public String getFilesHeaderColTwo() {
            return filesHeaderColTwo;
        }

        public void setFilesHeaderColTwo(String filesHeaderColTwo) {
            this.filesHeaderColTwo = filesHeaderColTwo;
        }

        public String getFilesHeaderColThree() {
            return filesHeaderColThree;
        }

        public void setFilesHeaderColThree(String filesHeaderColThree) {
            this.filesHeaderColThree = filesHeaderColThree;
        }

        public String getFilesHeaderColFour() {
            return filesHeaderColFour;
        }

        public void setFilesHeaderColFour(String filesHeaderColFour) {
            this.filesHeaderColFour = filesHeaderColFour;
        }
    }

    @Configuration
    @ConfigurationProperties(prefix = "file.msg")
    public static class MessageProperties {
        private String filesCurrentRow;
        private String filesWaitGenerated;
        private String filesGeneratedSuccess;
        private String filesGeneratedError;
        private String filesNoDataFound;
        private String filesCreateDirError;

        public String getFilesCurrentRow() {
            return filesCurrentRow;
        }

        public void setFilesCurrentRow(String filesCurrentRow) {
            this.filesCurrentRow = filesCurrentRow;
        }

        public String getFilesWaitGenerated() {
            return filesWaitGenerated;
        }

        public void setFilesWaitGenerated(String filesWaitGenerated) {
            this.filesWaitGenerated = filesWaitGenerated;
        }

        public String getFilesGeneratedSuccess() {
            return filesGeneratedSuccess;
        }

        public void setFilesGeneratedSuccess(String filesGeneratedSuccess) {
            this.filesGeneratedSuccess = filesGeneratedSuccess;
        }

        public String getFilesGeneratedError() {
            return filesGeneratedError;
        }

        public void setFilesGeneratedError(String filesGeneratedError) {
            this.filesGeneratedError = filesGeneratedError;
        }

        public String getFilesNoDataFound() {
            return filesNoDataFound;
        }

        public void setFilesNoDataFound(String filesNoDataFound) {
            this.filesNoDataFound = filesNoDataFound;
        }

        public String getFilesCreateDirError() {
            return filesCreateDirError;
        }

        public void setFilesCreateDirError(String filesCreateDirError) {
            this.filesCreateDirError = filesCreateDirError;
        }
    }
}
