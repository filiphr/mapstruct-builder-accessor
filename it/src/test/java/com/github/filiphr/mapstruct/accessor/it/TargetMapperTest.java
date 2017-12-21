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