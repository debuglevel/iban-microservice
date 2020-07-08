package de.debuglevel.iban.validation

import io.micronaut.context.annotation.Requires
import mu.KotlinLogging
import org.apache.commons.validator.routines.IBANValidator
import javax.inject.Singleton

@Singleton
@Requires(property = "app.iban.validation.backend", value = "apache-commons")
class ApacheCommonsValidationService : ValidationService() {
    private val logger = KotlinLogging.logger {}

    private val ibanValidator = IBANValidator.getInstance()

    override fun doValidate(iban: String): Boolean {
        return ibanValidator.isValid(iban)
    }
}