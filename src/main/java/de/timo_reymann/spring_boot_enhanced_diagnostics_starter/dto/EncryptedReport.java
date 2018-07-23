package de.timo_reymann.spring_boot_enhanced_diagnostics_starter.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.timo_reymann.spring_boot_enhanced_diagnostics_starter.exception.DecryptReportFailedException;
import de.timo_reymann.spring_boot_enhanced_diagnostics_starter.util.CryptoUtility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Data
@AllArgsConstructor
@Slf4j
public class EncryptedReport {
    private List<String> chunks;

    private EncryptedReport() {
    }

    public Report decrypt(final PrivateKey key, ObjectMapper objectMapper)  {
        List<String> decryptedChunks = new ArrayList<>();

        for (String c : chunks) {
            try {
                decryptedChunks.add(new String(CryptoUtility.decrypt(key, Base64.getDecoder().decode(c)), StandardCharsets.UTF_8));
            } catch (Exception e) {
                log.error("Decrypt chunk failed", e);
                throw new DecryptReportFailedException(e);
            }
        }

        String parsedReport = String.join("", decryptedChunks);

        try {
            return objectMapper.readValue(parsedReport, Report.class);
        } catch (IOException e) {
            throw new DecryptReportFailedException(e);
        }
    }
}
