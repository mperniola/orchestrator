package it.reply.orchestrator.service;

import alien4cloud.model.components.AbstractPropertyValue;
import alien4cloud.model.components.PropertyValue;
import alien4cloud.model.topology.Capability;
import alien4cloud.model.topology.NodeTemplate;
import alien4cloud.model.topology.RelationshipTemplate;
import alien4cloud.tosca.model.ArchiveRoot;
import alien4cloud.tosca.parser.ParsingException;
import alien4cloud.tosca.parser.ParsingResult;

import com.sun.istack.NotNull;

import it.reply.orchestrator.exception.service.ToscaException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

public interface ToscaService {

  @Nonnull
  public ParsingResult<ArchiveRoot> getArchiveRootFromTemplate(@Nonnull String toscaTemplate)
      throws IOException, ParsingException;

  /**
   * Obtain the string TOSCA template representation from the in-memory representation. <br/>
   * <b>WARNING: Some nodes or properties might be missing!! Use at your own risk!</b>
   * 
   * @param archiveRoot
   * @return
   * @throws IOException
   */
  @Nonnull
  public String getTemplateFromTopology(@Nonnull ArchiveRoot archiveRoot) throws IOException;

  @Nonnull
  public String customizeTemplate(@Nonnull String toscaTemplate, @NotNull String deploymentId)
      throws IOException, ToscaException, ParsingException;

  /**
   * Parse the TOSCA template (string) and get the in-memory representation.<br/>
   * This also checks for validation errors.
   * 
   * @param toscaTemplate
   *          the TOSCA template as string.
   * @return an {@link ArchiveRoot} representing the template.
   * @throws IOException
   *           if an I/O error occurs (converting the string to a CSAR zipped archive internally).
   * @throws ParsingException
   *           if parsing errors occur.
   * @throws ToscaException
   *           if validation errors occur.
   */
  @Nonnull
  public ArchiveRoot parseTemplate(@Nonnull String toscaTemplate)
      throws IOException, ParsingException, ToscaException;

  @Nonnull
  public Capability getNodeCapabilityByName(NodeTemplate node, String propertyName);

  @Nonnull
  public AbstractPropertyValue getNodePropertyByName(NodeTemplate node, String propertyName);

  @Nonnull
  public PropertyValue<?> getNodePropertyValueByName(NodeTemplate node, String propertyName);

  @Nonnull
  public PropertyValue<?> getCapabilityPropertyValueByName(Capability capability,
      String propertyName);

  public RelationshipTemplate getRelationshipTemplateByCapabilityName(
      Map<String, RelationshipTemplate> relationships, String capabilityName);

  public Map<String, NodeTemplate> getCountNodes(ArchiveRoot archiveRoot);

  public int getCount(NodeTemplate nodeTemplate);

  /**
   * Get the list of resources to be removed.
   * 
   * @param nodeTemplate
   *          {@link NodeTemplate}
   * @return the list of resources to be removed or an empty list
   */
  public List<String> getRemovalList(NodeTemplate nodeTemplate);

  public String updateTemplate(String template) throws IOException;

  public String updateCount(ArchiveRoot archiveRoot, int count) throws IOException;
}
