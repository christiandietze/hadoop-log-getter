package de.christiandietze.hadoop.logGetter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LogGetterController {
  @Autowired
  private LogGetterService service;

  @RequestMapping("/{jobId}")
  public String getLogForJob(@PathVariable
                             String jobId) {
    return service.fetchLogsForJob(jobId);
  }
}
