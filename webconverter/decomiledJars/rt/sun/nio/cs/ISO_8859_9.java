package sun.nio.cs;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class ISO_8859_9
  extends Charset
  implements HistoricallyNamedCharset
{
  private static final String b2cTable = " ¡¢£¤¥¦§¨©ª«¬­®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏĞÑÒÓÔÕÖ×ØÙÚÛÜİŞßàáâãäåæçèéêëìíîïğñòóôõö÷øùúûüışÿ\000\001\002\003\004\005\006\007\b\t\n\013\f\r\016\017\020\021\022\023\024\025\026\027\030\031\032\033\034\035\036\037 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
  private static final char[] b2c = " ¡¢£¤¥¦§¨©ª«¬­®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏĞÑÒÓÔÕÖ×ØÙÚÛÜİŞßàáâãäåæçèéêëìíîïğñòóôõö÷øùúûüışÿ\000\001\002\003\004\005\006\007\b\t\n\013\f\r\016\017\020\021\022\023\024\025\026\027\030\031\032\033\034\035\036\037 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".toCharArray();
  private static final char[] c2b = new char['Ȁ'];
  private static final char[] c2bIndex = new char['Ā'];
  
  public ISO_8859_9()
  {
    super("ISO-8859-9", StandardCharsets.aliases_ISO_8859_9);
  }
  
  public String historicalName()
  {
    return "ISO8859_9";
  }
  
  public boolean contains(Charset paramCharset)
  {
    return (paramCharset.name().equals("US-ASCII")) || ((paramCharset instanceof ISO_8859_9));
  }
  
  public CharsetDecoder newDecoder()
  {
    return new SingleByte.Decoder(this, b2c);
  }
  
  public CharsetEncoder newEncoder()
  {
    return new SingleByte.Encoder(this, c2b, c2bIndex);
  }
  
  static
  {
    char[] arrayOfChar1 = b2c;
    char[] arrayOfChar2 = null;
    SingleByte.initC2B(arrayOfChar1, arrayOfChar2, c2b, c2bIndex);
  }
}
