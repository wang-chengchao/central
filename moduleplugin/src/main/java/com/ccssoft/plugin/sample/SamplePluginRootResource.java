package com.ccssoft.plugin.sample;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.camunda.bpm.tasklist.resource.AbstractTasklistPluginRootResource;

@Path("plugin/" + SamplePlugin.ID)
public class SamplePluginRootResource extends AbstractTasklistPluginRootResource {

  public SamplePluginRootResource() {
    super(SamplePlugin.ID);
  }

  @Path("hello/{name}")
  public String hello(@PathParam("name") String name) {
    return "hello " + name;
  }
}
