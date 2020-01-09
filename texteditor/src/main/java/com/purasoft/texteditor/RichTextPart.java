package com.purasoft.texteditor;

public class RichTextPart {
    private int start;
    private int end;

    public RichTextPart(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public boolean isValid() {
        return start < end;
    }
}
