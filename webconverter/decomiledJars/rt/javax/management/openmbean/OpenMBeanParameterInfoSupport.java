package javax.management.openmbean;

import java.util.Set;
import javax.management.Descriptor;
import javax.management.ImmutableDescriptor;
import javax.management.MBeanParameterInfo;

public class OpenMBeanParameterInfoSupport
  extends MBeanParameterInfo
  implements OpenMBeanParameterInfo
{
  static final long serialVersionUID = -7235016873758443122L;
  private OpenType<?> openType;
  private Object defaultValue = null;
  private Set<?> legalValues = null;
  private Comparable<?> minValue = null;
  private Comparable<?> maxValue = null;
  private transient Integer myHashCode = null;
  private transient String myToString = null;
  
  public OpenMBeanParameterInfoSupport(String paramString1, String paramString2, OpenType<?> paramOpenType)
  {
    this(paramString1, paramString2, paramOpenType, (Descriptor)null);
  }
  
  public OpenMBeanParameterInfoSupport(String paramString1, String paramString2, OpenType<?> paramOpenType, Descriptor paramDescriptor)
  {
    super(paramString1, paramOpenType == null ? null : paramOpenType.getClassName(), paramString2, ImmutableDescriptor.union(new Descriptor[] { paramDescriptor, paramOpenType == null ? null : paramOpenType.getDescriptor() }));
    this.openType = paramOpenType;
    paramDescriptor = getDescriptor();
    this.defaultValue = OpenMBeanAttributeInfoSupport.valueFrom(paramDescriptor, "defaultValue", paramOpenType);
    this.legalValues = OpenMBeanAttributeInfoSupport.valuesFrom(paramDescriptor, "legalValues", paramOpenType);
    this.minValue = OpenMBeanAttributeInfoSupport.comparableValueFrom(paramDescriptor, "minValue", paramOpenType);
    this.maxValue = OpenMBeanAttributeInfoSupport.comparableValueFrom(paramDescriptor, "maxValue", paramOpenType);
    try
    {
      OpenMBeanAttributeInfoSupport.check(this);
    }
    catch (OpenDataException localOpenDataException)
    {
      throw new IllegalArgumentException(localOpenDataException.getMessage(), localOpenDataException);
    }
  }
  
  public <T> OpenMBeanParameterInfoSupport(String paramString1, String paramString2, OpenType<T> paramOpenType, T paramT)
    throws OpenDataException
  {
    this(paramString1, paramString2, paramOpenType, paramT, (Object[])null);
  }
  
  public <T> OpenMBeanParameterInfoSupport(String paramString1, String paramString2, OpenType<T> paramOpenType, T paramT, T[] paramArrayOfT)
    throws OpenDataException
  {
    this(paramString1, paramString2, paramOpenType, paramT, paramArrayOfT, null, null);
  }
  
  public <T> OpenMBeanParameterInfoSupport(String paramString1, String paramString2, OpenType<T> paramOpenType, T paramT, Comparable<T> paramComparable1, Comparable<T> paramComparable2)
    throws OpenDataException
  {
    this(paramString1, paramString2, paramOpenType, paramT, null, paramComparable1, paramComparable2);
  }
  
  private <T> OpenMBeanParameterInfoSupport(String paramString1, String paramString2, OpenType<T> paramOpenType, T paramT, T[] paramArrayOfT, Comparable<T> paramComparable1, Comparable<T> paramComparable2)
    throws OpenDataException
  {
    super(paramString1, paramOpenType == null ? null : paramOpenType.getClassName(), paramString2, OpenMBeanAttributeInfoSupport.makeDescriptor(paramOpenType, paramT, paramArrayOfT, paramComparable1, paramComparable2));
    this.openType = paramOpenType;
    Descriptor localDescriptor = getDescriptor();
    this.defaultValue = paramT;
    this.minValue = paramComparable1;
    this.maxValue = paramComparable2;
    this.legalValues = ((Set)localDescriptor.getFieldValue("legalValues"));
    OpenMBeanAttributeInfoSupport.check(this);
  }
  
  private Object readResolve()
  {
    if (getDescriptor().getFieldNames().length == 0)
    {
      OpenType localOpenType = (OpenType)OpenMBeanAttributeInfoSupport.cast(this.openType);
      Set localSet = (Set)OpenMBeanAttributeInfoSupport.cast(this.legalValues);
      Comparable localComparable1 = (Comparable)OpenMBeanAttributeInfoSupport.cast(this.minValue);
      Comparable localComparable2 = (Comparable)OpenMBeanAttributeInfoSupport.cast(this.maxValue);
      return new OpenMBeanParameterInfoSupport(this.name, this.description, this.openType, OpenMBeanAttributeInfoSupport.makeDescriptor(localOpenType, this.defaultValue, localSet, localComparable1, localComparable2));
    }
    return this;
  }
  
  public OpenType<?> getOpenType()
  {
    return this.openType;
  }
  
  public Object getDefaultValue()
  {
    return this.defaultValue;
  }
  
  public Set<?> getLegalValues()
  {
    return this.legalValues;
  }
  
  public Comparable<?> getMinValue()
  {
    return this.minValue;
  }
  
  public Comparable<?> getMaxValue()
  {
    return this.maxValue;
  }
  
  public boolean hasDefaultValue()
  {
    return this.defaultValue != null;
  }
  
  public boolean hasLegalValues()
  {
    return this.legalValues != null;
  }
  
  public boolean hasMinValue()
  {
    return this.minValue != null;
  }
  
  public boolean hasMaxValue()
  {
    return this.maxValue != null;
  }
  
  public boolean isValue(Object paramObject)
  {
    return OpenMBeanAttributeInfoSupport.isValue(this, paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof OpenMBeanParameterInfo)) {
      return false;
    }
    OpenMBeanParameterInfo localOpenMBeanParameterInfo = (OpenMBeanParameterInfo)paramObject;
    return OpenMBeanAttributeInfoSupport.equal(this, localOpenMBeanParameterInfo);
  }
  
  public int hashCode()
  {
    if (this.myHashCode == null) {
      this.myHashCode = Integer.valueOf(OpenMBeanAttributeInfoSupport.hashCode(this));
    }
    return this.myHashCode.intValue();
  }
  
  public String toString()
  {
    if (this.myToString == null) {
      this.myToString = OpenMBeanAttributeInfoSupport.toString(this);
    }
    return this.myToString;
  }
}
