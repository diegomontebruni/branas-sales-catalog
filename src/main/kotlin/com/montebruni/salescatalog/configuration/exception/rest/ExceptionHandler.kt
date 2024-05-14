package com.montebruni.salescatalog.configuration.exception.rest

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    fun handleIllegalArgumentException(ex: java.lang.IllegalArgumentException) = MessageDetail(
        exceptionName = ex.javaClass.simpleName,
        message = ex.message.toString()
    )

    @ExceptionHandler(Exception::class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleGenericException(ex: Exception) = MessageDetail(
        exceptionName = ex.javaClass.simpleName,
        message = ex.message.toString()
    )
}
