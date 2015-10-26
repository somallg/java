package java.chapter06.item32;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by somallg on 8/24/14.
 */
// EnumSet - a modern replacemant for bit fields
public class Text {
    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

    // Any Set could be passed in, but EnumSet is clearly the best
    public void applyStyles(Set<Style> styles) {
        System.out.println(styles);
    }

    public static void main(String[] args) {
        EnumSet<Style> of = EnumSet.of(Style.BOLD, Style.ITALIC);

        new Text().applyStyles(of);
    }

}
