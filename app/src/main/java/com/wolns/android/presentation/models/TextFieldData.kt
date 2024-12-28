package com.wolns.android.presentation.models

data class TextFieldData(
    val value: String,
    val onValueChange: (String) -> Unit,
    val label: String? = null,
    val isError: Boolean = false,
    val supportingText: String? = null
)