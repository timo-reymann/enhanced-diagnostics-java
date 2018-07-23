enhanced-diagnostics-java
===

Java library with batteries included for [enhanced-diagnostics](https://github.com/timo-reymann/enhanced-diagnostics) npm package

## Dependencies (already included)
- Jackson ObjectMapper: Parse json to java objects
- SLF4J: Error logging

## Usage
|Step|Code|
|:---|:---|
| Create public and private key| You can do this using openssl cli or ``CryptoUtility``packaged with the lib |
| Get private key into memory as string | e. g. ``EncryptedReport encryptedReport = new EncryptedReport(encryptedChunks)`` encryptedChunks is the json array parsed to ``List<string>``|
| Decrypt data and get report data | ``Report decrypt = encryptedReport.decrypt(privateKey, objectMapper)`` |

Thats it. Now you can process your report data. 

## Add to your dependencies
```xml
<dependency>
    <groupId>com.github.timo-reymann</groupId>
    <artifactId>enhanced-diagnostics-java</artifactId>
    <version>0.0.2</version>
</dependency>
```
