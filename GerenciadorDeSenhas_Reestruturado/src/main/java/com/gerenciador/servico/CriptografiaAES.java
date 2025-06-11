package servico;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Classe para criptografar e descriptografar senhas usando AES.
 */
public class CriptografiaAES {
    private static final String CHAVE = "1234567890123456"; // Deve ter 16 bytes (128 bits)

    public static String criptografar(String texto) throws Exception {
        SecretKeySpec key = new SecretKeySpec(CHAVE.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(texto.getBytes()));
    }

    public static String descriptografar(String textoCriptografado) throws Exception {
        SecretKeySpec key = new SecretKeySpec(CHAVE.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(textoCriptografado)));
    }
}
