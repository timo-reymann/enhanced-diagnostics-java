package com.github.timo_reymann.spring_boot_enhanced_diagnostics_starter.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Representation of log entry
 */
@Data
public class LogEntry {
    /**
     * Log level
     */
    private LogLevel level;

    /**
     * Message
     */
    private String message;

    /**
     * Raw JSON payload
     */
    @JsonUnwrapped
    private String payload;

    /**
     * Creation date of entry
     */
    private LocalDateTime timestamp;

    /**
     * Log type (e. g. network, console)
     */
    private String type;

    public enum LogLevel {
        LOG, INFO, WARN, ERROR, DEBUG
    }
}
