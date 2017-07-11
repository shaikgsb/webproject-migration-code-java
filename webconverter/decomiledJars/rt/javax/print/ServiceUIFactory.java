package javax.print;

public abstract class ServiceUIFactory
{
  public static final String JCOMPONENT_UI = "javax.swing.JComponent";
  public static final String PANEL_UI = "java.awt.Panel";
  public static final String DIALOG_UI = "java.awt.Dialog";
  public static final String JDIALOG_UI = "javax.swing.JDialog";
  public static final int ABOUT_UIROLE = 1;
  public static final int ADMIN_UIROLE = 2;
  public static final int MAIN_UIROLE = 3;
  public static final int RESERVED_UIROLE = 99;
  
  public ServiceUIFactory() {}
  
  public abstract Object getUI(int paramInt, String paramString);
  
  public abstract String[] getUIClassNamesForRole(int paramInt);
}
