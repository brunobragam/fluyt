package com.fluytcloud.kubernetes.transport.mapper;

import com.fluytcloud.kubernetes.transport.response.StorageClassResponseList;
import io.kubernetes.client.openapi.models.V1StorageClass;

import java.util.List;

public class StorageClassMapper {

    public StorageClassResponseList mapResponseList(V1StorageClass storageClass) {
        return new StorageClassResponseList(
                storageClass.getMetadata().getName(),
                storageClass.getProvisioner(),
                storageClass.getReclaimPolicy(),
                KubernetesMapper.formatAge(storageClass.getMetadata().getCreationTimestamp())
        );
    }

    public List<StorageClassResponseList> mapResponseList(List<V1StorageClass> storageClasses) {
        return storageClasses.stream()
                .map(this::mapResponseList)
                .toList();
    }

}
