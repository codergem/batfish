package org.batfish.representation.palo_alto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNullableByDefault;

/** PAN datamodel component containing application-override rule configuration */
@ParametersAreNullableByDefault
public final class ApplicationOverrideRule implements Serializable {

  // Possible protocols for traffic to match an application-override rule
  public enum Protocol {
    TCP,
    UDP
  }

  // Name of the rule
  @Nonnull private final String _name;

  // Description of the rule
  @Nullable private String _description;

  // Application used for traffic matching this rule
  @Nullable private String _application;

  private boolean _disabled;

  // Zones to match
  @Nonnull private final SortedSet<String> _from;
  @Nonnull private final SortedSet<String> _to;

  // IPs to match
  @Nonnull private final List<RuleEndpoint> _source;
  @Nonnull private final List<RuleEndpoint> _destination;
  private boolean _negateSource;
  private boolean _negateDestination;

  // Traffic characteristics to match
  @Nullable private Protocol _protocol;
  @Nullable private Integer _port;

  @Nonnull private final Set<String> _tags;

  public ApplicationOverrideRule(@Nonnull String name) {
    _destination = new LinkedList<>();
    _negateDestination = false;
    _source = new LinkedList<>();
    _negateSource = false;
    _disabled = false;
    _from = new TreeSet<>();
    _to = new TreeSet<>();
    _tags = new HashSet<>(1);
    _name = name;
  }

  @Nonnull
  public String getName() {
    return _name;
  }

  @Nullable
  public String getDescription() {
    return _description;
  }

  @Nullable
  public String getApplication() {
    return _application;
  }

  public boolean getDisabled() {
    return _disabled;
  }

  @Nonnull
  public SortedSet<String> getFrom() {
    return _from;
  }

  @Nonnull
  public SortedSet<String> getTo() {
    return _to;
  }

  @Nonnull
  public List<RuleEndpoint> getSource() {
    return _source;
  }

  @Nonnull
  public List<RuleEndpoint> getDestination() {
    return _destination;
  }

  public boolean getNegateSource() {
    return _negateSource;
  }

  public boolean getNegateDestination() {
    return _negateDestination;
  }

  @Nullable
  public Protocol getProtocol() {
    return _protocol;
  }

  @Nullable
  public Integer getPort() {
    return _port;
  }

  @Nonnull
  public Set<String> getTags() {
    return _tags;
  }

  public void setDescription(String description) {
    _description = description;
  }

  public void setApplication(String application) {
    _application = application;
  }

  public void setDisabled(boolean disabled) {
    _disabled = disabled;
  }

  public void setNegateSource(boolean negateSource) {
    _negateSource = negateSource;
  }

  public void setNegateDestination(boolean negateDestination) {
    _negateDestination = negateDestination;
  }

  public void setProtocol(Protocol protocol) {
    _protocol = protocol;
  }

  public void setPort(Integer port) {
    _port = port;
  }
}
