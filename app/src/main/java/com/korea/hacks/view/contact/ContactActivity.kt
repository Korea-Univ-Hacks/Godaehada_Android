package com.korea.hacks.view.contact

import androidx.lifecycle.Observer
import com.korea.hacks.R
import com.korea.hacks.base.BaseActivity
import com.korea.hacks.databinding.ActivityContactBinding
import com.korea.hacks.view.contact.entity.ContactItem
import com.korea.hacks.view.portfolio.PortfolioFragment

class ContactActivity: BaseActivity<ActivityContactBinding>() {
    override val layoutRes = R.layout.activity_contact
    private val contactViewModel = ContactViewModel()

    override fun onDataBinding() {
        getData()
        binding.vm = contactViewModel
        super.onDataBinding()
    }

    private fun getData() {
        val imageUrl = intent.getStringExtra(PortfolioFragment.EXTRA_IMAGE_URL)
        binding.item = ContactItem(imageUrl!!)
    }

    override fun setupView() {
        observeContactViewModel()
    }

    private fun observeContactViewModel() {
        val owner = this
        with(contactViewModel) {
            closeClickEvent.observe(owner, Observer {
                finish()
            })
            contactClickEvent.observe(owner, Observer {

            })
        }
    }
}
