package com.suitmedia.sample.feature.login

import com.suitmedia.sample.BaseApplication
import com.suitmedia.sample.base.presenter.BasePresenter

/**
 * Created by dodydmw19 on 7/18/18.
 */

class LoginPresenter : BasePresenter<LoginView>{

    private var mvpView: LoginView? = null

    init {
        BaseApplication.applicationComponent.inject(this)
    }

    fun login(){
        mvpView?.onLoginSuccess("success")
    }

    override fun onStart() {
    }

    override fun onPause() {
    }

    override fun onDestroy() {
    }

    override fun attachView(view: LoginView) {
        mvpView = view
    }

    override fun detachView() {
        mvpView = null
    }
}