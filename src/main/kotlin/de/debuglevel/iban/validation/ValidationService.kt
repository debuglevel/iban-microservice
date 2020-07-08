package de.debuglevel.iban.validation

import mu.KotlinLogging

abstract class ValidationService {
    private val logger = KotlinLogging.logger {}

    protected abstract fun doValidate(iban: String): Boolean

    /**
     * Remove characters which are often included by users (e.g. formatting) but do not really matter.
     */
    private fun sanitize(iban: String): String {
        val sanitizedIban = iban
            .replace("-", "")
            .replace("\\s".toRegex(), "")
        logger.trace { "Sanitized IBAN '$iban': $sanitizedIban" }
        return sanitizedIban
    }

    /**
     * Validate IBAN. Formatting characters (e.g. whitespaces) will be ignored.
     */
    fun validate(iban: String): Boolean {
        logger.debug { "Validating IBAN '$iban'..." }

        val sanitizedIban = sanitize(iban)
        val isValid = doValidate(sanitizedIban)

        logger.debug { "Validated IBAN '$iban': $isValid" }
        return isValid
    }
}