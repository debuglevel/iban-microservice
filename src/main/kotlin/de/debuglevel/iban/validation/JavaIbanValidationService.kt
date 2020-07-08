package de.debuglevel.iban.validation

import io.micronaut.context.annotation.Requires
import mu.KotlinLogging
import nl.garvelink.iban.IBAN
import org.apache.commons.validator.routines.IBANValidator
import javax.inject.Singleton

@Singleton
@Requires(property = "app.iban.validation-backend", value = "java-iban")
class JavaIbanValidationService : ValidationService {
    private val logger = KotlinLogging.logger {}

    private val ibanValidator = IBANValidator.getInstance()

    override fun validate(iban: String): Boolean {
        return try {
            IBAN.parse(iban)
            true
        } catch (e: Exception) {
            false
        }
    }
}