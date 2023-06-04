package com.fluytcloud.kubernetes.datasources;

import com.fluytcloud.kubernetes.entities.Cluster;
import com.fluytcloud.kubernetes.entities.Search;
import com.fluytcloud.kubernetes.repositories.NamespaceRepository;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.models.V1Role;
import io.kubernetes.client.openapi.models.V1RoleList;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class NamespaceRepositoryImpl extends NamespaceObjectRepositoryImpl<V1Role> implements NamespaceRepository {
    @Override
    protected List<V1Role> listByNamespace(Cluster cluster, Search search) throws ApiException {
        var api = new Connection(cluster).getRbacAuthorizationApi();
        return Optional.ofNullable(
                        api.listNamespacedRole(
                                search.getNamespace(),
                                search.getPretty(),
                                search.getAllowWatchBookmarks(),
                                search.get_continue(),
                                search.getFieldSelector(),
                                search.getLabelSelector(),
                                search.getLimit(),
                                search.getResourceVersion(),
                                search.getResourceVersionMatch(),
                                search.getTimeoutSeconds(),
                                search.getWatch()
                        ))
                .map(V1RoleList::getItems)
                .orElse(Collections.emptyList());
    }

    @Override
    protected List<V1Role> listByAllNamespace(Cluster cluster, Search search) throws ApiException {
        var rbacApi = new Connection(cluster).getRbacAuthorizationApi();
        return Optional.ofNullable(
                        rbacApi.listRoleForAllNamespaces(
                                search.getAllowWatchBookmarks(),
                                search.get_continue(),
                                search.getFieldSelector(),
                                search.getLabelSelector(),
                                search.getLimit(),
                                search.getPretty(),
                                search.getResourceVersion(),
                                search.getResourceVersionMatch(),
                                search.getTimeoutSeconds(),
                                search.getWatch()
                        ))
                .map(V1RoleList::getItems)
                .orElse(Collections.emptyList());
    }

    @Override
    protected V1Role readObject(Cluster cluster, String namespace, String name) throws ApiException {
        var rbacApi = new Connection(cluster).getRbacAuthorizationApi();
        return rbacApi.readNamespacedRole(name, namespace, null);
    }

    @Override
    public V1Role apply(Cluster cluster, V1Role object) {
        return null; //todo
    }

    @Override
    public void delete(Cluster cluster, String namespace, String name) {
        //todo
    }
}
