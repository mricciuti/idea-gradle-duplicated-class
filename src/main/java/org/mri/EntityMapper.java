package org.mri;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EntityMapper {

    @Mapping(source = "givenName", target = "name")
    SimpleSourceEntity map(SimpleTargetEntity targetEntity);

    @Mapping(target = "givenName", source = "name")
    SimpleTargetEntity map(SimpleSourceEntity sourceEntity);
}
