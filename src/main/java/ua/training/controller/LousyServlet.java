/*package ua.training.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;

public class LousyServlet extends HttpServlet {
    private Properties supportedLanguages;
    private Locale requestLocale = (Locale) supportedLanguages.get("DEFAULT");

    public LousyServlet() {
        supportedLanguages = new Properties();
        // Just for demonstration of the concept
        // you would probably load it from i.e. XML
        supportedLanguages.put("DEFAULT", Locale.US);
        // example mapping of "de" to "de_DE"
        supportedLanguages.put("ua", new Locale("ua", "UA"));
        //supportedLanguages.put("de_AT", new Locale("de", "AT"));
        //supportedLanguages.put("de_CH", new Locale("de", "CH"));
        //supportedLanguages.put("ja_JP", Locale.JAPAN);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        detectLocale(request);

        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        detectLocale(request);
        super.doPost(request, response);
    }

    private void detectLocale(HttpServletRequest request) {
        Enumeration locales = request.getLocales();
        while (locales.hasMoreElements()) {
            Locale locale = (Locale) locales.nextElement();
            if (supportedLanguages.contains(locale)) {
                requestLocale = locale;
                break;
            }
        }
    }

    public String getLanguage() {
        // get English name of the language
        // For native call requestLocale.getDisplayName(requestLocale)
        return requestLocale.getDisplayLanguage();
    }
}
*/