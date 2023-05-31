package com.montebruni.salescatalog.extensions

import com.montebruni.salescatalog.domain.valueobjects.PositiveDouble
import java.math.BigDecimal
import java.math.RoundingMode

fun Double.toDecimal(): Double = BigDecimal(this).setScale(2, RoundingMode.DOWN).toDouble()
fun Double.toPositiveDouble(): PositiveDouble = PositiveDouble(this)
