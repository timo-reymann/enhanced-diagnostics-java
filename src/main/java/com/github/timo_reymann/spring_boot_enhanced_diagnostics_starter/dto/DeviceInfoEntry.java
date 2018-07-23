package com.github.timo_reymann.spring_boot_enhanced_diagnostics_starter.dto;

import lombok.Data;

/**
 * Entry representation of device info
 */
@Data
public class DeviceInfoEntry {
    /**
     * Key for entry
     */
    private String key;

    /**
     * Value for entry
     */
    private String value;
}
