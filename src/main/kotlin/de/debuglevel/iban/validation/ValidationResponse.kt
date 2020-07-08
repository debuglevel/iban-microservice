package de.debuglevel.iban.validation

data class ValidationResponse(
    val iban: String,
    val valid: Boolean,
    val error: String? = null
)