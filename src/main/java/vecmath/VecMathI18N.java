package vecmath;

import java.util.MissingResourceException;
import java.util.ResourceBundle;


class VecMathI18N {
    static String getString(String key) {
        String s;
        try {
            s = (String) ResourceBundle.getBundle("javax.gltf_builder.vecmath.ExceptionStrings").getString(key);
        }
        catch (MissingResourceException e) {
            System.err.println("VecMathI18N: Error looking up: " + key);
            s = key;
        }
        return s;
    }
}
