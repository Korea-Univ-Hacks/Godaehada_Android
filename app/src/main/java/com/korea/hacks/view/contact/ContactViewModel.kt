package com.korea.hacks.view.contact

import androidx.lifecycle.MutableLiveData
import com.korea.hacks.base.BaseViewModel

class ContactViewModel: BaseViewModel() {

    val closeClickEvent = MutableLiveData<Boolean>()
    val contactClickEvent = MutableLiveData<Boolean>()

    fun onCloseClick() {
        closeClickEvent.value = true
    }

    fun onContactClick() {
        contactClickEvent.value = true
    }
}