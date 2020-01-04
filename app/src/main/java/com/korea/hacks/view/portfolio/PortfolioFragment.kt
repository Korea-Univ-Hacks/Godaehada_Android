package com.korea.hacks.view.portfolio

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import androidx.lifecycle.Observer
import com.korea.hacks.R
import com.korea.hacks.base.BaseFragment
import com.korea.hacks.databinding.FragmentPortfolioBinding
import com.korea.hacks.view.contact.ContactActivity
import com.korea.hacks.view.portfolio.data.PortfolioRepositoryImpl
import com.korea.hacks.view.portfolio.entity.PortfolioItem

class PortfolioFragment(
    private var item: PortfolioItem,
    private val isBuyer: Boolean
): BaseFragment<FragmentPortfolioBinding>() {

    companion object {
        private const val REQUEST_PERMISSION = 1001
        private const val REQUEST_GALLERY = 5001
        const val EXTRA_IMAGE_URL = "EXTRA_IMAGE_URL"
    }

    override val layoutRes = R.layout.fragment_portfolio
    private val viewModel = PortfolioViewModel(PortfolioRepositoryImpl())

    private lateinit var activity: Activity

    override fun onDataBinding() {
        binding.vm = viewModel
        binding.item = item
        super.onDataBinding()
    }

    override fun setupView() {
        observePortfolioViewModel()
    }

    private fun observePortfolioViewModel() {
        val owner = this
        with(viewModel) {
            portfolioClickEvent.observe(owner, Observer {
                when (it.isSet && isBuyer) {
                    true -> goToContactActivity(it)
                    false -> {
                        item = it
                        requestPermission()
                    }
                }
            })
        }
    }

    private fun goToContactActivity(item: PortfolioItem) {
        val intent = Intent(activity, ContactActivity::class.java)
        intent.putExtra(EXTRA_IMAGE_URL, item.imageUrl)
        activity?.startActivity(intent)
    }

    /** 카메라
     */
    private fun requestPermission() {
        requestPermissions(
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            REQUEST_PERMISSION
        )
    }

    private fun goToGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
        startActivityForResult(intent, REQUEST_GALLERY)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_PERMISSION -> {
                if (grantResults.isNotEmpty() && grantResults[0].compareTo(PackageManager.PERMISSION_GRANTED) == 0) {
                    goToGallery()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        when (requestCode) {
            REQUEST_GALLERY -> {
                when (resultCode) {
                    Activity.RESULT_OK -> {
                        val uri = intent?.data
                        item.imageUri = uri
                        binding.item = item
//                        showCategoryDialog()
                    }
                }
            }
        }
    }

    private fun showCategoryDialog() {
        val dialog = CategoryDialog(activity)
        dialog.show()
        dialog.categoryLiveData.observe(this, Observer {
            item.tag = it.tag
            item.isSet = true
            binding.item = item
        })
    }
}