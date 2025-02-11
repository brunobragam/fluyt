package com.fluytcloud.kubernetes.transport.http;

import com.fluytcloud.kubernetes.entities.Filter;
import com.fluytcloud.kubernetes.entities.OwnerReference;
import com.fluytcloud.kubernetes.interactors.ClusterService;
import com.fluytcloud.kubernetes.interactors.PodService;
import com.fluytcloud.kubernetes.transport.mapper.PodMapper;
import com.fluytcloud.kubernetes.transport.request.NamespaceObjectRequestFilter;
import com.fluytcloud.kubernetes.transport.request.NamespaceObjectRequestListFilter;
import com.fluytcloud.kubernetes.transport.response.PodSimpleResponseList;
import com.fluytcloud.kubernetes.transport.response.PodResponseList;
import io.kubernetes.client.openapi.models.V1Pod;
import io.quarkus.security.Authenticated;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Path("/api/v1/kubernetes/pod")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PodResource {

    private final PodService podService;
    private final ClusterService clusterService;

    private static final PodMapper POD_MAPPER = new PodMapper();

    public PodResource(PodService podService, ClusterService clusterService) {
        this.podService = podService;
        this.clusterService = clusterService;
    }

    @GET
    @Path("list")
    public List<PodResponseList> find(@BeanParam @Valid NamespaceObjectRequestListFilter requestFilter) {
        var cluster = clusterService.findById(requestFilter.getClusterId())
                .orElseThrow();
        var filter = new Filter(cluster).setNamespaces(requestFilter.getNamespaces()).setSearch(requestFilter.getName());
        var pods = podService.list(filter);
        return POD_MAPPER.mapResponseList(pods);
    }

    @GET
    public V1Pod get(@BeanParam @Valid NamespaceObjectRequestFilter podFilter) {
        var cluster = clusterService.findById(podFilter.getClusterId())
                .orElseThrow();
        return podService.read(cluster, podFilter.getNamespace(), podFilter.getName())
                .orElseThrow(() -> new NotFoundException("Pod not found"));
    }

    @GET
    @Path("simple/list")
    public List<PodSimpleResponseList> getSimpleList(@BeanParam @Valid NamespaceObjectRequestListFilter requestFilter) {
        if (Objects.isNull(requestFilter.getOwners()) || requestFilter.getOwners().isEmpty()) {
            throw new IllegalArgumentException("Param Owner is required");
        }

        var cluster = clusterService.findById(requestFilter.getClusterId()).orElseThrow();
        var filter = new Filter(cluster).setNamespaces(requestFilter.getNamespaces())
                .setOwnerReference(new OwnerReference(requestFilter.getOwners()))
                .setSelector(requestFilter.getLabelSelector());
        var pods = podService.list(filter);
        return POD_MAPPER.mapSimpleResponseList(pods);
    }

}
