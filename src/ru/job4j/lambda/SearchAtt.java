package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> pred = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };
        return filter(list, pred);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> pred = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return filter(list, pred);
    }

    private static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> pred) {
        List<Attachment> res = new ArrayList<>();
        for (Attachment att : list) {
            if (pred.test(att)) {
                res.add(att);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 2", 100),
                new Attachment("bug", 34),
                new Attachment("image 4", 150),
                new Attachment("bug", 300),
                new Attachment("image 1", 13)
        );
        System.out.println(SearchAtt.filterName(attachments));
        System.out.println(SearchAtt.filterSize(attachments));
    }
}
