package com.sun.corba.se.spi.protocol;

import com.sun.corba.se.pept.protocol.ServerRequestDispatcher;
import com.sun.corba.se.spi.ior.IOR;
import com.sun.corba.se.spi.ior.ObjectKey;

public abstract interface CorbaServerRequestDispatcher
  extends ServerRequestDispatcher
{
  public abstract IOR locate(ObjectKey paramObjectKey);
}
