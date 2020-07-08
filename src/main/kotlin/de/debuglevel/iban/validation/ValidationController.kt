package de.debuglevel.iban.validation

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import mu.KotlinLogging

@Controller("/validation")
class ValidationController(private val validationService: ValidationService) {
    private val logger = KotlinLogging.logger {}

    @Post("/")
    fun postOne(validationRequest: ValidationRequest): HttpResponse<ValidationResponse> {
        logger.debug("Called postOne($validationRequest)")

        val isValid = validationService.validate(validationRequest.iban)

        val validationResponse = ValidationResponse(
            validationRequest.iban,
            isValid
        )

        return HttpResponse.ok(validationResponse)
    }
}