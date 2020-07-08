package de.debuglevel.iban.validation

interface ValidationService {
    fun validate(iban: String): Boolean
}