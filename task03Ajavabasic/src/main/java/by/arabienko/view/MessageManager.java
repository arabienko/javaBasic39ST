package by.arabienko.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Enum class, Localization
 */
public enum MessageManager {
    EN(ResourceBundle.getBundle("property.text", new Locale("en", "US"))),
    BY(ResourceBundle.getBundle("property.text", new Locale("be", "BY"))),
    RU(ResourceBundle.getBundle("property.text", new Locale("ru", "RU")));

    private ResourceBundle bundle;
    MessageManager(ResourceBundle bundle) {
        this.bundle = bundle;
    }
    public String getString(String key) {
        return bundle.getString(key);
    }
}
