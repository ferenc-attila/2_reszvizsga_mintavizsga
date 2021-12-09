package uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {

    public List<Character> getUniqueChars(String input) {
        try {
            return getCharacterList(input);

        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("Text is null.", npe);
        }
    }

    private List<Character> getCharacterList(String input) {
        List<Character> output = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (!output.contains(c)) {
                output.add(c);
            }
        }
        return output;
    }
}
