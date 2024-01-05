import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public static void main(String[] args) {
        System.out.println(new TextJustification().fullJustify(new String []{"What","must","be","acknowledgment",
        "shall","be"}, 16));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        
        StringBuilder sb = new StringBuilder();
        List<String> lines = new ArrayList<>();
        int curr_width;
        int endPos = 0;
        int betweenSpace, extraSpace, endSpace;
        
        for (int i = 0; i < words.length;) {
            curr_width = words[endPos].length();

            while (endPos + 1  < words.length && (curr_width + words[endPos + 1].length() + 1) <= maxWidth) {
                endPos++;
                curr_width += words[endPos].length() + 1;
            };

            if (endPos == words.length - 1 || endPos - i == 0) {
                betweenSpace = 0;
                extraSpace = 0;
                endSpace = maxWidth - curr_width;
            }
            else {
                betweenSpace = (maxWidth - curr_width) / (endPos - i);
                extraSpace = (maxWidth - curr_width) % (endPos - i);
                endSpace = 0;
            }

            while (i < endPos) {
                sb.append(words[i] + " ");
                for (int j = 0; j < betweenSpace; j++) {
                    sb.append(" ");
                }
                if (extraSpace > 0) {
                    sb.append(" ");
                    extraSpace--;
                }
                i++;
            }
            sb.append(words[i]);

            for (int j = 0; j < endSpace; j++) {
                    sb.append(" ");
            }

            lines.add(sb.toString());
            sb.setLength(0);
            
            endPos++;
            i++;
        }

        return lines;
    }
}
