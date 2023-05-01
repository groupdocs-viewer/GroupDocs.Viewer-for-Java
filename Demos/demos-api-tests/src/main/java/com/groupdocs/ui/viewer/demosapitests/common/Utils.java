package com.groupdocs.ui.viewer.demosapitests.common;

public class Utils {
    private Utils() {
    }

    public static String normalizeDataBeforeComparing(String inputData) {
        return inputData
                .replace("\r\n", "\n")
                .replaceAll("(\\d+)\\.\\d+(em|pt|px)", "$1$2")
                .replaceAll("\\d{1,2}/\\d{1,2}/\\d{4} \\d{1,2}:\\d{2} \\w{2}", "XX/YY/ZZZ XX:YY ZZ")
                .replaceAll("\\p{L}{2} \\d{1,2}\\.\\d{2}\\.\\d{2}", "XX XX.YY.ZZ")
                .replaceAll("\\w{3} \\d{1,2}/\\d{2}/\\d{2}", "XX XX.YY.ZZ")
                .replaceAll("font-family:\\s?\"\\w+\\+([^\"']+)\"", "font-family:\"AAAAA+$1\"")
                .replaceAll("id=\"cp_\\d+\"", "id=\"cp_1234\"")
                .replaceAll("class=\"(p+\\d+)-\\w+-(\\s)", "class=\"$1-SOMEUID-$2")
                .replaceAll("class=\"(p+\\d+)-\\w+-\\w+", "class=\"$1-SOMEUID-SUF")
                .replaceAll("class=\"(p+\\d-SOMEUID-(?:SUF)?)\\s+(p\\d+)-\\w+-\\w+\"", "class=\"$1 $2-SOMEUID-SUF\"")
                .replaceAll("#cp_\\d+", "#cp_1234")
                // Somewhy it is different in almost each request
                .replaceAll("(?s)(font-family:\"AAAAA\\+[^\"]+\";\\s+src:url\\(\"data:application/octet-stream;base64,)[^\"]+", "$1FONT-BASE64-DATA")
                .trim();
    }

    public static float differenceOfStrings(String str1, String str2) {
        return differenceOfStrings(str1, str2, 3);
    }

    /**
     * Difference between two strings, values are in range 0..1.
     */
    public static float differenceOfStrings(String str1, String str2, int lookAhead) {
        int diff = Math.abs(str1.length() - str2.length());

        int str1Index = 0, str2Index = 0, contentDiff = 0;
        for (; true; str1Index++, str2Index++) {
            if (str1Index >= str1.length() || str2Index >= str2.length()) {
                break;
            }
            if (str1.charAt(str1Index) != str2.charAt(str2Index)) {
                int nextIndex = 0;
                for (; nextIndex + str1Index < str1.length() && nextIndex + str2Index < str2.length() && nextIndex <= lookAhead; nextIndex++) {
                    if (str1.charAt(str1Index + nextIndex) == str2.charAt(str2Index + nextIndex)) {
                        break;
                    }
                }
                int str1NextIndex = 0;
                int str2NextIndex = 0;
                for (; str1Index + str1NextIndex < str1.length() && str1NextIndex <= lookAhead; str1NextIndex++) {
                    if (str1.charAt(str1Index + str1NextIndex) == str2.charAt(str2Index)) {
                        break;
                    }
                }
                for (; str2Index + str2NextIndex < str2.length() && str2NextIndex <= lookAhead; str2NextIndex++) {
                    if (str2.charAt(str2Index + str2NextIndex) == str1.charAt(str1Index)) {
                        break;
                    }
                }
                if (nextIndex > 0 && nextIndex < str1NextIndex && nextIndex < str2NextIndex) {
                    contentDiff += nextIndex;
                    str1Index += nextIndex;
                    str2Index += nextIndex;
                } else if (str1NextIndex < str2NextIndex) {
                    contentDiff += str1NextIndex;
                    str1Index += str1NextIndex;
                } else if (str1NextIndex >= str2NextIndex && (str1NextIndex > 0 || str2NextIndex > 0)) {
                    contentDiff += str2NextIndex;
                    str2Index += str2NextIndex;
                }

            }
        }
        double maxLength = Math.max(str1.length(), str2.length());
        float commonDifference = (float) round(((diff + contentDiff) / (maxLength / 100d)) / 100d, 2);
        return commonDifference;
    }

    private static double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
