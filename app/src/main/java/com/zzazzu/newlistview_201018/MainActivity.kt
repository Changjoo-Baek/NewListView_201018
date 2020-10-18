package com.zzazzu.newlistview_201018

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.zzazzu.newlistview_201018.adapter.StudentAdapter
import com.zzazzu.newlistview_201018.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<Student>()

    lateinit var mAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("조경진", "서울시 은평구",  1988))
        mStudentList.add(Student("강윤정", "경기도 안양시",  1991))
        mStudentList.add(Student("구주영", "서울시 용산구",  1968))
        mStudentList.add(Student("윤은영", "경기도 수원시",  1992))
        mStudentList.add(Student("이선영", "경기도 고양시",  1985))
        mStudentList.add(Student("이용찬", "서울시 노원구",  1976))
        mStudentList.add(Student("장동국", "서울시 은평구",  1974))
        mStudentList.add(Student("최인선", "서울시 영등포구",  1992))

        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)
        studentListView.adapter = mAdapter

        studentListView.setOnItemClickListener {parent, view, position, id ->

            val clickedStudent = mStudentList[position]

            Toast.makeText(this,clickedStudent.name, Toast.LENGTH_SHORT).show()

    }

        studentListView.setOnItemLongClickListener {parent, view, position, id ->


            val alert = AlertDialog.Builder(this)
            alert.setTitle("학생 삭제 확인")
            alert.setMessage("정말 해당 학생을 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                    mStudentList.removeAt(position)

            mAdapter.notifyDataSetChanged()
        })
            alert.setNegativeButton("취소", null)

        alert.show()

        return@setOnItemLongClickListener true
        }

    }
}