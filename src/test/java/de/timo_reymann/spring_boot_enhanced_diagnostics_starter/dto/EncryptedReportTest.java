package de.timo_reymann.spring_boot_enhanced_diagnostics_starter.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.timo_reymann.spring_boot_enhanced_diagnostics_starter.util.CryptoUtility;
import de.timo_reymann.spring_boot_enhanced_diagnostics_starter.util.TestResourceLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class EncryptedReportTest {
    private PrivateKey key;
    private List<String> encryptedChunks;

    private ObjectMapper objectMapper;

    @Before
    public void initialize() throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, CertificateException {
        key = CryptoUtility.parsePrivateKey(new String(TestResourceLoader.readFile("priv8.pem"), UTF_8));
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        byte[] report = TestResourceLoader.readFile("report.json");
        String[] strings = objectMapper.readValue(report, String[].class);
        encryptedChunks = Arrays.asList(strings);
    }

    @Test
    public void testDecrypt() {
        EncryptedReport encryptedReport = new EncryptedReport(encryptedChunks);
        Report decrypt = encryptedReport.decrypt(key, objectMapper);
        Assert.assertFalse(decrypt.getDeviceInfo().isEmpty());
        Assert.assertFalse(decrypt.getLog().isEmpty());
    }
}
