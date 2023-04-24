package com.ecommerceserver.data.db.jpa.entities;

import com.ecommerceserver.TestEntityGenerator;
import com.ecommerceserver.core.domain.Identity;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IdConverterTest {

    @Test
    public void convertIdShouldReturnNumberWhenNotNull() {
        // Given
        Long randomId = TestEntityGenerator.randomId();

        // When
        Long actualId = IdConverter.convertId(new Identity(randomId));

        // Then
        assertThat(actualId).isEqualTo(randomId);
    }

    @Test
    public void convertIdShouldReturnNullWhenInputIsNull() {
        // Given a null value for Id

        // When
        Long actualId = IdConverter.convertId(null);

        // Then
        assertThat(actualId).isNull();
    }

    @Test
    public void convertIdShouldReturnNullWhenInputIdentityIsEmpty() {
        // Given
        Identity identity = Identity.none();

        // When
        Long actualId = IdConverter.convertId(identity);

        // Then
        assertThat(actualId).isNull();
    }
}
