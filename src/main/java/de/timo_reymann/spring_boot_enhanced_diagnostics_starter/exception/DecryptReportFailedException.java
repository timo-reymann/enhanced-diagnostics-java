package de.timo_reymann.spring_boot_enhanced_diagnostics_starter.exception;

public class DecryptReportFailedException extends RuntimeException {
    public DecryptReportFailedException(Throwable cause) {
        super(cause);
    }
}
