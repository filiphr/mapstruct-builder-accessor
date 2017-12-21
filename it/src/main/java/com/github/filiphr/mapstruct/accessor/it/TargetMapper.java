package com.github.filiphr.mapstruct.accessor.it;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface TargetMapper {

    Target.Builder map(Source source);

    void update(@MappingTarget Target.Builder builder, Source source);
}
