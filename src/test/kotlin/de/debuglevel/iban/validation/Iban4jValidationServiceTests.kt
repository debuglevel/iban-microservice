package de.debuglevel.iban.validation


import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.TestInstance

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Iban4jValidationServiceTests : ValidationServiceTests {
    override val validationService = Iban4jValidationService()
}