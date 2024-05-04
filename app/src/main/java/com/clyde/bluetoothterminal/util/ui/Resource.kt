package com.clyde.bluetoothterminal.util.ui

import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun dimension(@DimenRes id: Int) = dimensionResource(id)

@Composable
fun string(@StringRes id: Int) = stringResource(id)

@Composable
fun drawable(@DrawableRes id: Int) = painterResource(id)
