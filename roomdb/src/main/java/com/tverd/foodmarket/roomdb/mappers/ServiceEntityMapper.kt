package com.tverd.foodmarket.roomdb.mappers

import com.tverd.foodmarket.domain.model.Service
import com.tverd.foodmarket.roomdb.model.ServiceEntity

class ServiceEntityMapper : RoomMapper<ServiceEntity, Service> {
    override suspend fun mapFromEntity(type: ServiceEntity): Service {
        return Service(
            type.serviceId,
            type.serviceName,
            type.serviceImage
        )
    }

    override fun mapToEntity(type: Service): ServiceEntity {
        return ServiceEntity(
            type.service_id,
            type.service_name,
            type.service_image
        )
    }
}