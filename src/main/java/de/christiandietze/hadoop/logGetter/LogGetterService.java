package de.christiandietze.hadoop.logGetter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class LogGetterService {
  @Autowired
  private JobAttemptsRepository jobAttemptsRepository;
  
  @Autowired
  private LogHtmlParser parser;

  public String fetchLogsForJob(String jobId) {
    return jobAttemptsRepository.getLogLinks(jobId).getLogUrls().stream().flatMap((link) -> Stream.of(link + "/syslog", link + "/stderr", link + "/stdout")).map((exploded) -> exploded + "?start=0").map(parser::parse).collect(Collectors.joining());
  }
}
