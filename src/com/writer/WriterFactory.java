package com.writer;

public interface WriterFactory {
        void writer(String text, boolean appendFlag);
        String reader();
}
