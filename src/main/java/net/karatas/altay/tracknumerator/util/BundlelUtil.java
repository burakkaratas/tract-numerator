package net.karatas.altay.tracknumerator.util;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class BundlelUtil {

  public static String getMessage(String key, Object... params) {
    final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:/message");
    messageSource.setDefaultEncoding("UTF-8");
    return ((MessageSource) messageSource).getMessage(key, params, new Locale("tr-TR"));

  }

}
