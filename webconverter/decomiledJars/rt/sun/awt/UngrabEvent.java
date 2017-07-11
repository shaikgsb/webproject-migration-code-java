package sun.awt;

import java.awt.AWTEvent;
import java.awt.Component;

public class UngrabEvent
  extends AWTEvent
{
  private static final int UNGRAB_EVENT_ID = 1998;
  
  public UngrabEvent(Component paramComponent)
  {
    super(paramComponent, 1998);
  }
  
  public String toString()
  {
    return "sun.awt.UngrabEvent[" + getSource() + "]";
  }
}
