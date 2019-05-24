package com.ccssoft.plugin.sample;

import java.util.HashSet;
import java.util.Set;

import org.camunda.bpm.tasklist.plugin.spi.impl.AbstractTasklistPlugin;

public class SamplePlugin extends AbstractTasklistPlugin {

  public static final String ID = "sample-plugin";

  public String getId() {
    return ID;
  }

  public String getStyle() {
    return null;
  }

  @Override
  public Set<Class<?>> getResourceClasses() {
    Set<Class<?>> classes = new HashSet<Class<?>>();
    classes.add(SamplePluginRootResource.class);
    return classes;
  }
}
