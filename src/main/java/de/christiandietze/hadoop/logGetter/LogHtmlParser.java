package de.christiandietze.hadoop.logGetter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import java.io.IOException;


@Component
public class LogHtmlParser {
  public String parse(String link) {
    try {
      Document document = Jsoup.connect(link).get();
      return document.select("pre").toString();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }

  }
}
