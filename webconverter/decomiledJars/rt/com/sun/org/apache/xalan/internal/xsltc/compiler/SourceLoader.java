package com.sun.org.apache.xalan.internal.xsltc.compiler;

import org.xml.sax.InputSource;

public abstract interface SourceLoader
{
  public abstract InputSource loadSource(String paramString1, String paramString2, XSLTC paramXSLTC);
}
