package com.suitmedia.sample.di.component

import com.suitmedia.sample.di.module.APIServiceModule
import com.suitmedia.sample.di.scope.SuitCoreApplicationScope
import com.suitmedia.sample.feature.login.LoginPresenter
import com.suitmedia.sample.feature.member.MemberPresenter
import dagger.Component

@SuitCoreApplicationScope
@Component(modules = [(APIServiceModule::class)])
interface ApplicationComponent {

    fun inject(memberPresenter: MemberPresenter)

    fun inject(loginPresenter: LoginPresenter)
}