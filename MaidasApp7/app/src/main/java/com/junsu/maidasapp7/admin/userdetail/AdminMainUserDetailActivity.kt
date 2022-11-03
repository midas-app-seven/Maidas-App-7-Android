package com.junsu.maidasapp7.admin.userdetail

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import com.junsu.maidasapp7.R
import com.junsu.maidasapp7.base.BaseActivity
import com.junsu.maidasapp7.databinding.ActivityAdminMainUserDetailBinding

class AdminMainUserDetailActivity : BaseActivity<ActivityAdminMainUserDetailBinding>(
    R.layout.activity_admin_main_user_detail
) {

    var value: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.btnEditWorkSystem.setOnClickListener {
            val inflater =
                getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.cstdialog_xml, null)

            val alertDialog = AlertDialog.Builder(this)
                .setTitle("변경할 닉네임을 입력해 주세요")
                .setPositiveButton("변경") { dialog, which ->

                    val et = view.findViewById<EditText>(R.id.etDialog)
                    value = et.text.toString()
                    binding.userName.text = value
                    binding.textUserName.text = value
                }
                .setNeutralButton("취소", null)
                .create()

            //  여백 눌러도 창 안없어지게
            alertDialog.setCancelable(false)

            alertDialog.setView(view)
            alertDialog.show()
        }
    }

    override fun observeEvent() {
    }
}