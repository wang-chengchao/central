package com.ccssoft.option;

import java.util.Optional;

/**
 * @Description: @Author: Administrator @CreateDate: 2018/9/11 9:56 @UpdateDate: 2018/9/11
 * 9:56 @Version: 1.0
 */
public class Option {

  public static void main(String[] args) {
    //
    Optional<String> str = Optional.ofNullable(null);
    System.out.println(str.isPresent());
    str.ifPresent(e -> System.out.println(e));
    System.out.println(str.orElse("没有值"));
  }
}
