package com.montebruni.salescatalog.extensions

import com.montebruni.salescatalog.domain.valueobjects.Amount
import java.math.BigDecimal
import java.math.RoundingMode

fun BigDecimal.toAmount() = Amount(this.setScale(2, RoundingMode.HALF_EVEN))
