package de.debuglevel.iban.validation

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

interface ValidationServiceTests {
    val validationService: ValidationService

    fun validIbanProvider() = TestDataProvider.validIbanProvider()
    fun invalidIbanProvider() = TestDataProvider.invalidIbanProvider()

    @ParameterizedTest
    @MethodSource("validIbanProvider")
    fun `validate valid IBANs`(testData: TestDataProvider.IbanTestData) {
        // Arrange

        // Act
        val isValid = validationService.validate(testData.value)

        // Assert
        assertThat(isValid).isEqualTo(true)
    }

    @ParameterizedTest
    @MethodSource("invalidIbanProvider")
    fun `validate invalid IBANs`(testData: TestDataProvider.IbanTestData) {
        // Arrange

        // Act
        val isValid = validationService.validate(testData.value)

        // Assert
        assertThat(isValid).isEqualTo(false)
    }
}