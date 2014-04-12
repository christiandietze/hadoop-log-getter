package de.christiandietze.hadoop.logGetter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;


@JsonIgnoreProperties(ignoreUnknown = true)
public class  JsonResult {
  public JobAttempts jobAttempts;

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class JobAttempts {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class JobAttempt {
      public String logsLink;
    }

    public List<JobAttempt> jobAttempt;
  }
  
  public List<String> getLogUrls() {
    return jobAttempts.jobAttempt.parallelStream().map(attempt -> attempt.logsLink).collect(Collectors.toList());
  }
}
