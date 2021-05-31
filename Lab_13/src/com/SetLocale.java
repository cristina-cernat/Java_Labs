package com;

import app.LocaleExplorer;

import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale {
    public static void setLocale(String languageTag)
    {
        LocaleExplorer.locale = Locale.forLanguageTag(languageTag);
        LocaleExplorer.resourceBundle = ResourceBundle.getBundle(LocaleExplorer.baseName, LocaleExplorer.locale);
        System.out.println(LocaleExplorer.message("locale.set", languageTag));
    }
}
