package javax.naming.directory;

import javax.naming.NamingException;

public class InvalidAttributeValueException
  extends NamingException
{
  private static final long serialVersionUID = 8720050295499275011L;
  
  public InvalidAttributeValueException(String paramString)
  {
    super(paramString);
  }
  
  public InvalidAttributeValueException() {}
}
