/*
 * Created by Leo on 2021. 10. 02 ..
 */
package com.mashup.helltabus.features.launcher

import androidx.activity.viewModels
import com.helltabus.presentation.R
import com.helltabus.presentation.databinding.ActivityLauncherBinding
import com.mashup.helltabus.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LauncherActivity : BaseActivity<ActivityLauncherBinding>(R.layout.activity_launcher) {

    private val viewModel by viewModels<LauncherViewModel>()
}
