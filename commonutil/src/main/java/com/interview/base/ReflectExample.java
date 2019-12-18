package com.interview.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author sunyiban@panda-fintech.com
 * @title: ReflectExample
 * @copyright: Copyright (c) 2018
 * @description: java反射<br>
 * @company: panda-fintech
 * @created on 2019/12/18上午10:02
 */
public class ReflectExample {

  private int age;
  private String name;

  public String personInfo(int age, String name) {
    return "姓名：" + name + "， 年龄：" + age;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "ReflectExample{" +
            "age=" + age +
            ", name='" + name + '\'' +
            '}';
  }

  public static void main(String[] args) {
    //正常调用
    ReflectExample reflectExample = new ReflectExample();
    reflectExample.setAge(10);
    reflectExample.setName("zhangsan");
    System.out.println(reflectExample.toString());

    reflectExample.personInfo(reflectExample.getAge(), reflectExample.getName());

    // 反射调用
    try {
      // 获取类第一种方式
      Class exClass = Class.forName("com.interview.base.ReflectExample");
      // 获取类第二种方式
      exClass = ReflectExample.class;
      // 获取类第三种方式
      exClass = new ReflectExample().getClass();
      Method[] methods = exClass.getMethods();
      // 打印出所有的方法
      for (Method m : methods) {
        System.out.println("方法名" + m.getName());
      }

      Method setAge = exClass.getMethod("setAge", int.class);
      // 调用非静态方法需要先创建实例
      Object e = exClass.newInstance();
      setAge.invoke(e, 12);
      Method getAge = exClass.getMethod("getAge");
      int age = (int) getAge.invoke(e);
      System.out.println("反射获取age:" + age);

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    }
  }
}
