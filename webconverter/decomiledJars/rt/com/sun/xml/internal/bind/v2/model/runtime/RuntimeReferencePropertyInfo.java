package com.sun.xml.internal.bind.v2.model.runtime;

import com.sun.xml.internal.bind.v2.model.core.ReferencePropertyInfo;
import java.lang.reflect.Type;
import java.util.Set;

public abstract interface RuntimeReferencePropertyInfo
  extends ReferencePropertyInfo<Type, Class>, RuntimePropertyInfo
{
  public abstract Set<? extends RuntimeElement> getElements();
}
