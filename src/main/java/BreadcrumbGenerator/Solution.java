package BreadcrumbGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static String generate_bc(String url, String separator) {
        String[] urlParts = url.split("(?<!/)/(?!/)");

        if (urlParts.length < 2) {
            return "<span class=\"active\">HOME</span>";
        }

        StringBuilder out = new StringBuilder("<a href=\"/\">HOME</a>" + separator);

        int pathEnd;
        String lastUrlPart = urlParts[urlParts.length - 1].split("[?#.]")[0];
        if (lastUrlPart.length() == 0 || lastUrlPart.matches("^\\W.+") || lastUrlPart.equals("index")) {
            pathEnd = urlParts.length - 2;
            if (pathEnd == 0) {
                return "<span class=\"active\">HOME</span>";
            }
            lastUrlPart = urlParts[pathEnd];
        } else {
            pathEnd = urlParts.length - 1;
        }

        lastUrlPart = shortenAndUppercase(lastUrlPart);

        StringBuilder fullUrl = new StringBuilder();
        for (int i = 1; i < pathEnd; ++i) {
            String shortName = shortenAndUppercase(urlParts[i]);
            fullUrl.append("/").append(urlParts[i]);
            out.append("<a href=\"")
                    .append(fullUrl.toString())
                    .append("/\">")
                    .append(shortName)
                    .append("</a>")
                    .append(separator);
        }

        out.append("<span class=\"active\">")
                .append(lastUrlPart)
                .append("</span>");

        return out.toString();
    }

    private static String shortenAndUppercase(String urlPart) {
        if (urlPart.length() <= 30) {
            return urlPart.replaceAll("-", " ").toUpperCase();
        }

        List<String> words = new ArrayList<>(Arrays.asList(urlPart.split("-")));
        List<String> wrongWords = new ArrayList<>(Arrays.asList("the", "of", "in", "from", "by", "with", "and", "or", "for", "to", "at", "a"));
        words.removeAll(wrongWords);

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word.charAt(0));
        }

        return sb.toString().toUpperCase();
    }
}