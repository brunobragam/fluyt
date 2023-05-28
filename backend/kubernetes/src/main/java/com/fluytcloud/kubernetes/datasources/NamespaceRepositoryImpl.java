package com.fluytcloud.kubernetes.datasources;

import com.fluytcloud.kubernetes.entities.Cluster;
import com.fluytcloud.kubernetes.entities.Search;
import com.fluytcloud.kubernetes.repositories.NamespaceRepository;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.models.V1Role;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class NamespaceRepositoryImpl extends NamespaceObjectRepositoryImpl<V1Role> implements NamespaceRepository {
    @Override
    protected List<V1Role> listByNamespace(Cluster cluster, Search search) throws ApiException {
        return null; //todo
    }

    @Override
    protected List<V1Role> listByAllNamespace(Cluster cluster, Search search) throws ApiException {
        return null; //todo
    }

    @Override
    protected V1Role readObject(Cluster cluster, String namespace, String name) throws ApiException {
        return null; //todo
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
