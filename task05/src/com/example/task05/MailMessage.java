package com.example.task05;

public class MailMessage implements IMail<String> {
    private String сontent;
    private String to;
    private String from;

    public MailMessage(String from, String to, String Content) {
        this.from = from;
        this.to = to;
        this.сontent = Content;
    }

    public String getContent() {
        return сontent;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }
}
