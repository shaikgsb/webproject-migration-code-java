package sun.management.resources;

import java.util.ListResourceBundle;

public final class agent_de
  extends ListResourceBundle
{
  public agent_de() {}
  
  protected final Object[][] getContents()
  {
    return new Object[][] { { "agent.err.access.file.not.readable", "Zugriffsdatei kann nicht gelesen werden" }, { "agent.err.access.file.notfound", "Zugriffsdatei nicht gefunden" }, { "agent.err.access.file.notset", "Es wurde keine Zugriffsdatei angegeben, obwohl com.sun.management.jmxremote.authenticate auf \"true\" gesetzt ist" }, { "agent.err.access.file.read.failed", "Zugriffsdatei konnte nicht gelesen werden" }, { "agent.err.acl.file.access.notrestricted", "Lesezugriff auf Kennwortdatei muss eingeschränkt werden" }, { "agent.err.acl.file.not.readable", "SNMP-ACL-Datei kann nicht gelesen werden" }, { "agent.err.acl.file.notfound", "SNMP-ACL-Datei konnte nicht gefunden werden" }, { "agent.err.acl.file.notset", "Es wurde keine SNMP-ACL-Datei angegeben, obwohl com.sun.management.snmp.acl auf \"true\" gesetzt ist" }, { "agent.err.acl.file.read.failed", "SNMP-ACL-Datei konnte nicht gelesen werden" }, { "agent.err.agentclass.access.denied", "Zugriff auf premain(String) wurde abgelehnt" }, { "agent.err.agentclass.failed", "Management Agent-Klasse nicht erfolgreich" }, { "agent.err.agentclass.notfound", "Management Agent-Klasse nicht gefunden" }, { "agent.err.configfile.access.denied", "Zugriff auf Konfigurationsdatei wurde abgelehnt" }, { "agent.err.configfile.closed.failed", "Konfigurationsdatei konnte nicht geschlossen werden" }, { "agent.err.configfile.failed", "Konfigurationsdatei konnte nicht gelesen werden" }, { "agent.err.configfile.notfound", "Konfigurationsdatei wurde nicht gefunden" }, { "agent.err.connector.server.io.error", "Fehler bei JMX-Connector-Serverkommunikation" }, { "agent.err.error", "Fehler" }, { "agent.err.exception", "Ausnahme von Agent ausgelöst " }, { "agent.err.exportaddress.failed", "Export der JMX-Connector-Adresse in Instrumentierungspuffer nicht erfolgreich" }, { "agent.err.file.access.not.restricted", "Lesezugriff auf Datei muss eingeschränkt werden" }, { "agent.err.file.not.found", "Datei wurde nicht gefunden" }, { "agent.err.file.not.readable", "Datei nicht lesbar" }, { "agent.err.file.not.set", "Datei nicht angegeben" }, { "agent.err.file.read.failed", "Datei konnte nicht gelesen werden" }, { "agent.err.invalid.agentclass", "Ungültiger Eigenschaftswert für com.sun.management.agent.class" }, { "agent.err.invalid.jmxremote.port", "Ungültige Nummer für com.sun.management.jmxremote.port" }, { "agent.err.invalid.jmxremote.rmi.port", "Ungültige Nummer für com.sun.management.jmxremote.rmi.port" }, { "agent.err.invalid.option", "Ungültige Option angegeben" }, { "agent.err.invalid.snmp.port", "Ungültige Nummer für com.sun.management.snmp.port" }, { "agent.err.invalid.snmp.trap.port", "Ungültige Nummer für com.sun.management.snmp.trap" }, { "agent.err.invalid.state", "Ungültiger Agent-Zustand" }, { "agent.err.password.file.access.notrestricted", "Lesezugriff auf Kennwortdatei muss eingeschränkt werden" }, { "agent.err.password.file.not.readable", "Kennwortdatei nicht lesbar" }, { "agent.err.password.file.notfound", "Kennwortdatei nicht gefunden" }, { "agent.err.password.file.notset", "Es wurde keine Kennwortdatei angegeben, obwohl com.sun.management.jmxremote.authenticate auf \"true\" gesetzt ist" }, { "agent.err.password.file.read.failed", "Kennwortdatei konnte nicht gelesen werden" }, { "agent.err.premain.notfound", "premain(String) ist in Agent-Klasse nicht vorhanden" }, { "agent.err.snmp.adaptor.start.failed", "Fehler beim Starten des SNMP-Adaptors mit Adresse" }, { "agent.err.snmp.mib.init.failed", "Initialisierung von SNMP-MIB nicht erfolgreich mit Fehler" }, { "agent.err.unknown.snmp.interface", "Unbekannte SNMP-Schnittstelle" }, { "agent.err.warning", "Warnung" }, { "jmxremote.AdaptorBootstrap.getTargetList.adding", "Ziel hinzufügen: {0}" }, { "jmxremote.AdaptorBootstrap.getTargetList.initialize1", "Adaptor bereit." }, { "jmxremote.AdaptorBootstrap.getTargetList.initialize2", "SNMP-Adaptor bereit unter: {0}:{1}" }, { "jmxremote.AdaptorBootstrap.getTargetList.processing", "ACL wird verarbeitet" }, { "jmxremote.AdaptorBootstrap.getTargetList.starting", "Adaptor-Server starten:" }, { "jmxremote.AdaptorBootstrap.getTargetList.terminate", "{0} beenden" }, { "jmxremote.ConnectorBootstrap.file.readonly", "Lesezugriff auf Datei muss eingeschränkt werden: {0}" }, { "jmxremote.ConnectorBootstrap.noAuthentication", "Keine Authentifizierung" }, { "jmxremote.ConnectorBootstrap.password.readonly", "Lesezugriff auf Kennwortdatei muss eingeschränkt werden: {0}" }, { "jmxremote.ConnectorBootstrap.ready", "JMX-Connector bereit unter: {0}" }, { "jmxremote.ConnectorBootstrap.starting", "JMX-Connector-Server starten:" } };
  }
}
