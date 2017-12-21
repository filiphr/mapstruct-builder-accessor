/*
 *  Copyright 2017-2017 Filip Hrisafov (https://github.com/filiphr)
 *  and/or other contributors as indicated by the @authors tag.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.filiphr.mapstruct.accessor.it;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class TargetMapperTest {

    private TargetMapper underTest;

    @BeforeEach
    void setUp() {
        underTest = Mappers.getMapper( TargetMapper.class );
    }

    @Test
    void map() {
        Target.Builder builder = underTest.map( new Source( "Filip", "Hrisafov", true, true ) );
        Target target = builder.build();
        assertThat( target.getFirstName() ).isEqualTo( "Filip" );
        assertThat( target.getLastName() ).isEqualTo( "Hrisafov" );
        assertThat( target.isActive() ).isTrue();
        assertThat( target.isAdmin() ).isTrue();
    }

    @Test
    void update() {
        Target.Builder builder = new Target.Builder();
        builder.firstName( "Jon" )
            .setLastName( "Snow" )
            .active( true )
            .isAdmin( false );

        Target beforeUpdate = builder.build();
        assertThat( beforeUpdate.getFirstName() ).isEqualTo( "Jon" );
        assertThat( beforeUpdate.getLastName() ).isEqualTo( "Snow" );
        assertThat( beforeUpdate.isActive() ).isTrue();
        assertThat( beforeUpdate.isAdmin() ).isFalse();

        underTest.update( builder, new Source( "Filip", "Hrisafov", false, true ) );

        Target afterUpdate = builder.build();
        assertThat( afterUpdate.getFirstName() ).isEqualTo( "Filip" );
        assertThat( afterUpdate.getLastName() ).isEqualTo( "Hrisafov" );
        assertThat( afterUpdate.isActive() ).isFalse();
        assertThat( afterUpdate.isAdmin() ).isTrue();
    }
}