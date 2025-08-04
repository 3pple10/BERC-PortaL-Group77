package com.example.bercportal_2311991_2420585_2420808_2420953;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }
        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
        }
}