package com.fastcode.email;

import com.fastcode.email.commons.logging.EmailLoggingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EmailPropertiesConfiguration {

    @Autowired
    private EmailLoggingHelper logHelper;

    @Autowired
    private Environment env;

    private static final String FASTCODE_OFFSET_DEFAULT_ENV = "FASTCODE_OFFSET_DEFAULT";
    private static final String FASTCODE_OFFSET_DEFAULT_SYSPROP = "fastCode.offset.default";

    private static final String FASTCODE_LIMIT_DEFAULT_ENV = "FASTCODE_LIMIT_DEFAULT";
    private static final String FASTCODE_LIMIT_DEFAULT_SYSPROP = "fastCode.limit.default";

    private static final String FASTCODE_SORT_DIRECTION_DEFAULT_ENV = "FASTCODE_SORT_DIRECTION_DEFAULT";
    private static final String FASTCODE_SORT_DIRECTION_DEFAULT_SYSPROP = "fastCode.sort.direction.default";

    private static final String SPRING_CONTENT_FS_FILESYSTEM_ROOT_ENV = "SPRING_CONTENT_FS_FILESYSTEM_ROOT";
    private static final String SPRING_CONTENT_FS_FILESYSTEM_ROOT_SYSPROP = "spring.content.fs.filesystem-root";

    private static final String MJML_FILE_BASE_DIR_ENV = "MJML_FILE_BASE_DIR";
    private static final String MJML_FILE_BASE_DIR_SYSPROP = "mjmlFile.base.dir";

    private static final String MJML_FILE_PATH_ENV = "MJML_FILE_PATH";
    private static final String MJML_FILE_PATH_SYSPROP = "mjmlFile.path";

    private static final String SPRING_MAIL_HOST_ENV = "SPRING_MAIL_HOST";
    private static final String SPRING_MAIL_HOST_SYSPROP = "spring.mail.host";

    private static final String SPRING_MAIL_USERNAME_ENV = "SPRING_MAIL_USERNAME";
    private static final String SPRING_MAIL_USERNAME_SYSPROP = "spring.mail.username";

    private static final String SPRING_MAIL_PASSWORD_ENV = "SPRING_MAIL_PASSWORD";
    private static final String SPRING_MAIL_PASSWORD_SYSPROP = "spring.mail.password";

    private static final String SPRING_MAIL_PORT_ENV = "SPRING_MAIL_PORT";
    private static final String SPRING_MAIL_PORT_SYSPROP = "spring.mail.port";

    private static final String SPRING_MAIL_TEST_CONNECTION_ENV = "SPRING_MAIL_TEST_CONNECTION";
    private static final String SPRING_MAIL_TEST_CONNECTION_SYSPROP = "spring.mail.test-connection";

    private static final String SPRING_MAIL_SMTP_SSL_TRUST_ENV = "SPRING_MAIL_SMTP_SSL_TRUST";
    private static final String SPRING_MAIL_SMTP_SSL_TRUST_SYSPROP = "spring.mail.properties.mail.smtp.ssl.trust";

    private static final String SPRING_MAIL_PROTOCOL_ENV = "SPRING_MAIL_PROTOCOL";
    private static final String SPRING_MAIL_PROTOCOL_SYSPROP = "spring.mail.properties.mail.transport.protocol";

    private static final String SPRING_MAIL_SMTP_AUTH_ENV = "SPRING_MAIL_SMTP_AUTH";
    private static final String SPRING_MAIL_SMTP_AUTH_SYSPROP = "spring.mail.properties.mail.smtp.auth";

    private static final String SPRING_MAIL_SMTP_CONNECTIONTIMEOUT_ENV = "SPRING_MAIL_SMTP_CONNECTIONTIMEOUT";
    private static final String SPRING_MAIL_SMTP_CONNECTIONTIMEOUT_SYSPROP = "spring.mail.properties.mail.smtp.connectiontimeout";

    private static final String SPRING_MAIL_SMTP_TIMEOUT_ENV = "SPRING_MAIL_SMTP_TIMEOUT";
    private static final String SPRING_MAIL_SMTP_TIMEOUT_SYSPROP = "spring.mail.properties.mail.smtp.timeout";

    private static final String SPRING_MAIL_SMTP_WRITETIMEOUT_ENV = "SPRING_MAIL_SMTP_WRITETIMEOUT";
    private static final String SPRING_MAIL_SMTP_WRITETIMEOUT_SYSPROP = "spring.mail.properties.mail.smtp.writetimeout";

    private static final String SPRING_MAIL_SMTP_STARTTLS_ENABLE_ENV = "SPRING_MAIL_SMTP_STARTTLS_ENABLE";
    private static final String SPRING_MAIL_SMTP_STARTTLS_ENABLE_SYSPROP = "spring.mail.properties.mail.smtp.starttls.enable";

    /**
     * @return the default offset for fastCode
     */
    public String getFastCodeOffsetDefault() {
        return getConfigurationProperty(FASTCODE_OFFSET_DEFAULT_ENV, FASTCODE_OFFSET_DEFAULT_SYSPROP, "0");
    }

    /**
     * @return the default limit for fastCode
     */
    public String getFastCodeLimitDefault() {
        return getConfigurationProperty(FASTCODE_LIMIT_DEFAULT_ENV, FASTCODE_LIMIT_DEFAULT_SYSPROP, "10");
    }

    /**
     * @return the default sort direction for fastCode
     */
    public String getFastCodeSortDirectionDefault() {
        return getConfigurationProperty(FASTCODE_SORT_DIRECTION_DEFAULT_ENV, FASTCODE_SORT_DIRECTION_DEFAULT_SYSPROP, "ASC");
    }

    /**
     * @return the filesystem root for spring content
     */
    public String getSpringContentFsFilesystemRoot() {
        return getConfigurationProperty(SPRING_CONTENT_FS_FILESYSTEM_ROOT_ENV, SPRING_CONTENT_FS_FILESYSTEM_ROOT_SYSPROP, "src/main/java");
    }

    /**
     * @return the base directory for MJML files
     */
    public String getMjmlFileBaseDir() {
        return getConfigurationProperty(MJML_FILE_BASE_DIR_ENV, MJML_FILE_BASE_DIR_SYSPROP, "emailBuilderFiles");
    }

    /**
     * @return the path for MJML files
     */
    public String getMjmlFilePath() {
        return getConfigurationProperty(MJML_FILE_PATH_ENV, MJML_FILE_PATH_SYSPROP, String.format("%s/%s.mjml", getMjmlFileBaseDir(), "%s"));
    }

    /**
     * @return the mail host for Spring Mail
     */
    public String getSpringMailHost() {
        return getConfigurationProperty(SPRING_MAIL_HOST_ENV, SPRING_MAIL_HOST_SYSPROP, "smtp.gmail.com");
    }

    /**
     * @return the mail username for Spring Mail
     */
    public String getSpringMailUsername() {
        return getConfigurationProperty(SPRING_MAIL_USERNAME_ENV, SPRING_MAIL_USERNAME_SYSPROP, "email@getfastcode.com");
    }

    /**
     * @return the mail password for Spring Mail
     */
    public String getSpringMailPassword() {
        return getConfigurationProperty(SPRING_MAIL_PASSWORD_ENV, SPRING_MAIL_PASSWORD_SYSPROP, "fastcode##");
    }

    /**
     * @return the mail port for Spring Mail
     */
    public String getSpringMailPort() {
        return getConfigurationProperty(SPRING_MAIL_PORT_ENV, SPRING_MAIL_PORT_SYSPROP, "587");
    }

    /**
     * @return the test connection flag for Spring Mail
     */
    public String getSpringMailTestConnection() {
        return getConfigurationProperty(SPRING_MAIL_TEST_CONNECTION_ENV, SPRING_MAIL_TEST_CONNECTION_SYSPROP, "false");
    }

    /**
     * @return the SMTP SSL trust setting for Spring Mail
     */
    public String getSpringMailSmtpSslTrust() {
        return getConfigurationProperty(SPRING_MAIL_SMTP_SSL_TRUST_ENV, SPRING_MAIL_SMTP_SSL_TRUST_SYSPROP, "smtp.gmail.com");
    }

    /**
     * @return the mail transport protocol for Spring Mail
     */
    public String getSpringMailProtocol() {
        return getConfigurationProperty(SPRING_MAIL_PROTOCOL_ENV, SPRING_MAIL_PROTOCOL_SYSPROP, "stmp");
    }

    /**
     * @return the SMTP auth setting for Spring Mail
     */
    public String getSpringMailSmtpAuth() {
        return getConfigurationProperty(SPRING_MAIL_SMTP_AUTH_ENV, SPRING_MAIL_SMTP_AUTH_SYSPROP, "true");
    }

    /**
     * @return the SMTP connection timeout for Spring Mail
     */
    public String getSpringMailSmtpConnectionTimeout() {
        return getConfigurationProperty(SPRING_MAIL_SMTP_CONNECTIONTIMEOUT_ENV, SPRING_MAIL_SMTP_CONNECTIONTIMEOUT_SYSPROP, "5000");
    }

    /**
     * @return the SMTP timeout for Spring Mail
     */
    public String getSpringMailSmtpTimeout() {
        return getConfigurationProperty(SPRING_MAIL_SMTP_TIMEOUT_ENV, SPRING_MAIL_SMTP_TIMEOUT_SYSPROP, "5000");
    }

    /**
     * @return the SMTP write timeout for Spring Mail
     */
    public String getSpringMailSmtpWriteTimeout() {
        return getConfigurationProperty(SPRING_MAIL_SMTP_WRITETIMEOUT_ENV, SPRING_MAIL_SMTP_WRITETIMEOUT_SYSPROP, "5000");
    }

    /**
     * @return the STARTTLS enable setting for Spring Mail
     */
    public String getSpringMailSmtpStarttlsEnable() {
        return getConfigurationProperty(SPRING_MAIL_SMTP_STARTTLS_ENABLE_ENV, SPRING_MAIL_SMTP_STARTTLS_ENABLE_SYSPROP, "true");
    }





    /**
     * Looks for the given key in the following places (in order):
     *
     * 1) Environment variables
     * 2) System Properties
     *
     * @param envKey
     * @param sysPropKey
     * @param defaultValue
     * @return the configured property value or default value if not found
     */
    private String getConfigurationProperty(String envKey, String sysPropKey, String defaultValue) {
        String value = env.getProperty(sysPropKey);
        if (value == null || value.trim().isEmpty()) {
            value = System.getenv(envKey);
        }
        if (value == null || value.trim().isEmpty()) {
            value = defaultValue;
        }
        logHelper.getLogger().debug("Config Property: {}/{} = {}", envKey, sysPropKey, value);
        return value;
    }
}