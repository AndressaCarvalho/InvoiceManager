package dev.myapp.invoicemanager.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(GeneralConfiguration.class)
public class GeneralConfiguration {
    @Configuration
    @ConfigurationProperties(prefix = "general.msg")
    public static class MessageProperties {
        private String messagesDefaultError;

        public String getMessagesDefaultError() {
            return messagesDefaultError;
        }

        public void setMessagesDefaultError(String messagesDefaultError) {
            this.messagesDefaultError = messagesDefaultError;
        }
    }
}
