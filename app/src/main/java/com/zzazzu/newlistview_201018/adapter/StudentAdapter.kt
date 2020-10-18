package com.zzazzu.newlistview_201018.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.zzazzu.newlistview_201018.R
import com.zzazzu.newlistview_201018.datas.Student
import kotlinx.android.synthetic.main.student_list_item.view.*
import java.util.*
import kotlin.collections.ArrayList

class StudentAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<Student>) : ArrayAdapter<Student>(mContext, resId, mList) {

    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.student_list_item, null)
        }

        val row = tempRow!!

        val studentNameTxt = row.findViewById<TextView>(R.id.studentNameTxt)
        val studentAgeTxt = row.findViewById<TextView>(R.id.studentAgeTxt)
        val studentAddressTxt = row.findViewById<TextView>(R.id.studentAddressTxt)

        val student = mList[position]

        studentNameTxt.text = student.name
        studentAddressTxt.text = student.address


        val now = Calendar.getInstance()
        val koreanAge = now.get(Calendar.YEAR) - student.birthYear + 1

        studentAgeTxt.text = "(${koreanAge}세)"

        return row

    }
}
