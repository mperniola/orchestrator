package it.reply.orchestrator.dto.cmdb;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudService extends CmdbDataWrapper<CloudService, CloudServiceData>
    implements Serializable {

  private static final long serialVersionUID = 6559999818418491070L;

}
