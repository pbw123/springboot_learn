package cn.niit.springbootexceptionhandler.util;

public class EmployeeExJsonException extends Exception {

  private static final long serialVersionUID = -3332292346834265371L;

  public EmployeeExJsonException(int id){
    super("这是异常信息，id="+id);
  }
}
