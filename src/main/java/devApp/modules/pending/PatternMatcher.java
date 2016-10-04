package devApp.modules.pending;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

    /**
     * Utility method to retain elements that match the regex.
     * @param elements elements to search.
     * @param regex pattern to find.
     * @return elements that match the patter.
     */
    public static List<String> match(List<String> elements, String regex) {
        if (!CollectionUtils.isEmpty(elements) &&
                StringUtils.hasText(regex)) {
            final List<String> matches = new ArrayList<>();
            final Pattern pattern = Pattern.compile(regex);
            for (String string : elements) {
                final Matcher matcher = pattern.matcher(string);
                if (matcher.find()) {
                    matches.add(string);
                }
            }
            return matches;
        }
        // invalid parameters were passed
        return null;
    }
}
