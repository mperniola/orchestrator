package it.reply.orchestrator.service;

import it.reply.orchestrator.dto.CloudProvider;
import it.reply.orchestrator.dto.cmdb.CloudService;
import it.reply.orchestrator.dto.cmdb.Image;
import it.reply.orchestrator.dto.cmdb.Provider;

import java.util.List;

public interface CmdbService {

  public CloudService getServiceById(String id);

  public Provider getProviderById(String id);

  // /**
  // * Complex method to retrieve {@link Image}s with all metadata for a given provider. <br/>
  // * Currently, it is needed to extract the correct service from the provider and the query the
  // CMDB
  // * to retrieve metadata of each single image (because only ID and Name are listed in the API).
  // *
  // * @param providerId
  // * .
  // * @return .
  // */
  // public List<Image> getImagesByProvider(String providerId);

  public List<Image> getImagesByService(String serviceId);

  public Image getImageById(String imageId);

  public String getUrl();

  public CloudProvider fillCloudProviderInfo(CloudProvider cp);
}
