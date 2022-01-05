package hello.effective.enums;

import java.util.Set;

/**
 * @author karl xie
 * Created on 2022-01-05 11:00
 */
// EnumSet - a modern replacement for bit fields
public class Text {
    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    // Any Set could be passed in, but EnumSet is clearly best
    public void applyStyles(Set<Style> styles) {
        System.out.println();
    }
}