/*package ua.training.controller;

import java.util.Locale;

@ManagedBean
@SessionScoped
public class LocaleController {

    public static Locale LOCALE_RU = new Locale("ru");
    public static Locale LOCALE_EN = new Locale("en");
    private Locale locale = LOCALE_RU;

    public Locale getLocale() {
        return locale;
    }

    public String selectLanguage(String selectedLanguage) {
        locale = convert(selectedLanguage);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        return FacesContext.getCurrentInstance().getViewRoot().getViewId() + "?faces-redirect=true";//перезагружаем страницу
    }

    public static Locale convert(String languageName) {
        if ("en".equals(languageName)) {
            return LOCALE_EN;
        }

        return LOCALE_RU;
    }

    public boolean isRu() {
        return LOCALE_RU.equals(locale);
    }

}
*/