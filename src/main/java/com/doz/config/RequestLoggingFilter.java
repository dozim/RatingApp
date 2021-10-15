package com.doz.config;

import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

public class RequestLoggingFilter extends AbstractRequestLoggingFilter {

    private final String logLevel;

    public RequestLoggingFilter(String logLevel) {
        this.logLevel = logLevel;
    }

    protected boolean shouldLog(HttpServletRequest request) {
        return checkConfiguedLogLevel();
    }

    protected void beforeRequest(HttpServletRequest request, String message) {
        if ("DEBUG".equalsIgnoreCase(this.logLevel)) {
            this.logger.debug(message);
        } else if ("INFO".equalsIgnoreCase(this.logLevel)) {
            this.logger.info(message);
        } else {
            this.logger.debug(message);
        }
    }

    protected void afterRequest(HttpServletRequest request, String message) {
        if ("DEBUG".equalsIgnoreCase(this.logLevel)) {
            this.logger.debug(message);
        } else if ("INFO".equalsIgnoreCase(this.logLevel)) {
            this.logger.info(message);
        } else {
            this.logger.debug(message);
        }    }

    private boolean checkConfiguedLogLevel() {
        if ("WARN".equalsIgnoreCase(this.logLevel)) {
            return this.logger.isWarnEnabled();
        } else if ("INFO".equalsIgnoreCase(this.logLevel)) {
            return this.logger.isInfoEnabled();
        }
        return this.logger.isDebugEnabled();
    }
}