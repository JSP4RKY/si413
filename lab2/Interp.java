import java.io.Reader;
import java.io.FileReader;
import java.io.BufferedReader; //Gen AI suggestion
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Interp {
    static List<String> getLiterals(String fname) throws IOException {
        Reader source = new BufferedReader(new FileReader(fname)); //Gen AI suggestion
        List<String> literals = new ArrayList<>();

        // note, -1 is returned at EOF
        for (int gotRaw = source.read(); gotRaw != -1; gotRaw = source.read()) {
            char got = (char)gotRaw;
            if (got == '"') {
                // found one
                StringBuilder sb = new StringBuilder();
                // read inner characters until the matching "
                while (true) {
                    int innerRaw = source.read();
                    assert (innerRaw != -1);
                    char inner = (char)innerRaw;
                    if (inner == '"'){
                        //if double, ignore first ", print the second ", and move on.
                        char check_quote = (char) source.read(); 
                        if (check_quote != '"') break;
                    }
                    sb.append(inner);
                }
                literals.add(sb.toString());
            }
        }
        return literals;
    }

    public static void main(String[] args) throws IOException {
        String fname = args[0];
        System.out.format("literals in %s:\n", fname);
        for (String literal : getLiterals(fname)) {
            System.out.format("  |%s|\n", literal);
        }        
    }
}
