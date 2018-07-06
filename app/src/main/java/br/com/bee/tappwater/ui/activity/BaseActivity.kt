package br.com.bee.tappwater.ui.activity

import android.support.v7.app.AppCompatActivity
import com.google.firebase.internal.FirebaseAppHelper.getUid
import android.app.ProgressDialog
import com.google.firebase.auth.FirebaseAuth


open class BaseActivity : AppCompatActivity() {

    private var mProgressDialog: ProgressDialog? = null

    fun showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(this)
            mProgressDialog!!.setCancelable(false)
            mProgressDialog!!.setMessage("Loading...")
        }

        mProgressDialog!!.show()
    }

    fun hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.dismiss()
        }
    }

    fun getUid(): String? {
        val instance = FirebaseAuth.getInstance()
        return if (instance.currentUser != null) instance.uid else null

    }
}