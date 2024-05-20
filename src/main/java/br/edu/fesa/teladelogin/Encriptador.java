package br.edu.fesa.teladelogin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encriptador {
    private Encriptador() {
    }

    public static String encriptar(String texto) {
        String textoEncriptado = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedBytes = md.digest(texto.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            textoEncriptado = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return textoEncriptado;
    }
}
