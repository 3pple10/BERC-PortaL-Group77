package com.example.bercportal_2311991_2420585_2420808_2420953;

import java.io.*;

public class AuthenticatorClass {

    public static Consumer authenticateConsumer(String inputId, String inputPassword)
            throws IOException, ClassNotFoundException {

        File file = new File("users.bin");
        if (!file.exists()) return null;

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                try {
                    Consumer consumer = (Consumer) ois.readObject();
                    if (consumer.getConsumerID().equals(inputId) &&
                            consumer.login(inputPassword)) {
                        return consumer;
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        }
        return null;
    }
}
