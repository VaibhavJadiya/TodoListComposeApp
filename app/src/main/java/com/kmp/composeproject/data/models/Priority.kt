package com.kmp.composeproject.data.models

import androidx.compose.ui.graphics.Color
import com.kmp.composeproject.ui.theme.HighPriorityColor
import com.kmp.composeproject.ui.theme.LowPriorityColor
import com.kmp.composeproject.ui.theme.MediumPriorityColor
import com.kmp.composeproject.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}