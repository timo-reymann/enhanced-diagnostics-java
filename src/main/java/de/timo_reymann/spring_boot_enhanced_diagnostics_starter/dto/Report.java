package de.timo_reymann.spring_boot_enhanced_diagnostics_starter.dto;

import lombok.Data;

import java.util.List;

/**
 * Report for enhanced-diagnostics
 */
@Data
public class Report {
    private List<DeviceInfoEntry> deviceInfo;
    private List<LogEntry> log;
}
