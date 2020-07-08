package de.debuglevel.iban.validation


import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.TestInstance

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JavaIbanValidationServiceTests : ValidationServiceTests {
    override val validationService = JavaIbanValidationService()
}