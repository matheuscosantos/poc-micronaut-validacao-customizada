package br.com.matheuscosantos.carros

import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import javax.inject.Singleton
import javax.validation.Constraint
import javax.validation.ConstraintValidatorContext
import kotlin.annotation.AnnotationRetention.*
import kotlin.annotation.AnnotationTarget.CONSTRUCTOR
import kotlin.annotation.AnnotationTarget.FIELD

@MustBeDocumented
@Target(FIELD, CONSTRUCTOR)
@Retention(RUNTIME)
@Constraint(validatedBy = [PlacaValidator::class])
annotation class Placa(
    val message: String = "paca com formato inválido."
)

@Singleton
class PlacaValidator : ConstraintValidator<Placa, String> {

    override fun isValid(
        value: String?,
        annotationMetadata: AnnotationValue<Placa>,
        context: io.micronaut.validation.validator.constraints.ConstraintValidatorContext,
    ): Boolean {
        if( value == null){
            return true
        }

        // AAA0A00 - [A-Z]{3}[0-9][0-9A-Z][0-9]{2}
        return value.matches("[A-Z]{3}[0-9][0-9A-Z][0-9]{2}".toRegex())
    }

}
