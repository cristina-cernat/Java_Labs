package com;

import app.LocaleExplorer;

import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public class DisplayLocales {
    public static void displayLocales()
    {
        Set<ResourceBundle> resourceBundleSet = new HashSet<>();
        for (Locale locale : Locale.getAvailableLocales())
        {
            resourceBundleSet.add(ResourceBundle.getBundle(LocaleExplorer.baseName, locale));
        }
        for (ResourceBundle resource : resourceBundleSet)
        {
            System.out.println(resource.getLocale());
        }
    }
}
