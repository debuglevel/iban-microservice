package de.debuglevel.iban.validation

import io.micronaut.context.annotation.Requires
import mu.KotlinLogging
import org.iban4j.IbanUtil
import javax.inject.Singleton

@Singleton
@Requires(property = "app.iban.validation-backend", value = "iban4j")
class Iban4jValidationService : ValidationService() {
    private val logger = KotlinLogging.logger {}

    override fun doValidate(iban: String): Boolean {
        return try {
            IbanUtil.validate(iban)
            true
        } catch (e: Exception) {
            false
        }
    }
}