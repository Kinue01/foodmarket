package com.tverd.foodmarket.remote.mappers

import com.tverd.foodmarket.domain.model.Service
import com.tverd.foodmarket.remote.model.ServiceApi


class ServiceApiMapper: EntityMapper<ServiceApi, Service> {

    override suspend fun mapFromModel(model: ServiceApi): Service {
        return Service(
            service_id = model.serviceId,
            service_name = model.serviceName,
            service_image = model.serviceImage
        )
    }

}