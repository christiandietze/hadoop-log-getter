package de.christiandietze.hadoop.logGetter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class JobAttemptsRepository {
  @Autowired
  private RestTemplate restTemplate;

  @Value("${history.server.host}")
  private String historyServerHost;

  public JsonResult getLogLinks(String jobId) {
    return restTemplate.getForObject("http://" + historyServerHost + ":19888/ws/v1/history/mapreduce/jobs/" + jobId +
      "/jobattempts",
      JsonResult.class);
  }
}
