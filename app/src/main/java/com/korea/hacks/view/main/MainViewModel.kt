package com.korea.hacks.view.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.korea.hacks.base.BaseViewModel
import com.korea.hacks.model.response.User
import com.korea.hacks.service.api.APIService
import com.korea.hacks.service.retrofit.RetrofitHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class MainViewModel: BaseViewModel() {

    val userListLiveData = MutableLiveData<MutableList<User>>()

    fun getUserList() {

        val service = RetrofitHelper.getRetrofitService(APIService::class.java)

        service.getUserList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleUserList, this::handleError)
            .register()
    }

    private fun handleUserList(userList: Response<MutableList<User>>) {
        Log.d("result", userList.body().toString())
        userListLiveData.value = userList.body()
    }

    private fun handleError(throwable: Throwable) {
        Log.e("error", throwable.message!!)
    }
}