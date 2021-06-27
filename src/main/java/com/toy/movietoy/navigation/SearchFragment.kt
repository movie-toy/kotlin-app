package com.toy.movietoy.navigation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.ScrollView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.toy.movietoy.PhotoCollectionActivity
import com.toy.movietoy.R
import com.toy.movietoy.retrofit.RetrofitManager
import com.toy.movietoy.utils.Constants.TAG
import com.toy.movietoy.utils.RESPONSE_STATUS
import com.toy.movietoy.utils.onMyTextChanged
import kotlinx.android.synthetic.main.layout_button_search.*


class SearchFragment : Fragment() {

    private lateinit var searchEditText: EditText
    private lateinit var searchScrollView: ScrollView
    private lateinit var searchTermTextLayout: TextInputLayout
    private lateinit var btnSearch: MaterialButton
    private lateinit var btnProgress: ProgressBar


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_search, container, false)

        Log.d(TAG,"SearchFragment - onCreateView() called")
        searchEditText = view.findViewById(R.id.search_term_edit_text)
        searchScrollView = view.findViewById(R.id.search_scrollview)
        searchTermTextLayout = view.findViewById(R.id.search_term_text_layout)
        btnSearch = view.findViewById(R.id.btn_search)
        btnProgress = view.findViewById(R.id.btn_progress)

        // 텍스트 변경 시
        searchEditText.onMyTextChanged {
            // 입력된 글자가 하나라도 있으면
            if(it.toString().count() > 0){
                frame_search_btn.visibility = View.VISIBLE
                searchTermTextLayout.helperText = " "
                // 스크롤 뷰를 올림
                searchScrollView.scrollTo(0, 200)
            } else {
                frame_search_btn.visibility = View.INVISIBLE
                searchTermTextLayout.helperText = "검색어를 입력하세요"
            }
        }

        // 검색 버튼 클릭 시
        btnSearch.setOnClickListener {
            Log.d(TAG,"SearchFragment - onCreateView() 검색 버튼 클릭")
//            this.handlerSearchButtonUi()

            val userSearchInput = searchEditText.text.toString()

            // 검색 API 호출
            RetrofitManager.instance.searchUsers(searchTerm = userSearchInput, completion = {
                responseState, responseDataArrayList ->
                when (responseState) {
                    RESPONSE_STATUS.OKAY -> {
                        Log.d(TAG,"SearchFragment - onCreateView() api 호출 성공: ${responseDataArrayList?.size}")

                        val intent = Intent(activity, PhotoCollectionActivity::class.java)
                        val bundle = Bundle()
                        bundle.putSerializable("photo_array_list", responseDataArrayList)
                        intent.putExtra("array_bundle", bundle)
                        intent.putExtra("search_term", userSearchInput)
                        startActivity(intent)
                    }
                    RESPONSE_STATUS.FAIL -> {
                        Toast.makeText(activity, "api 호출 에러입니다.", Toast.LENGTH_SHORT).show()
                        Log.d(TAG,"SearchFragment - onCreateView() api 호출 실패: ${responseDataArrayList}")
                    }
                    RESPONSE_STATUS.NO_CONTENT -> {
                        Toast.makeText(activity, "검색 결과가 없습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                btnProgress.visibility = View.INVISIBLE
                btnSearch.text = "검색"
                searchEditText.setText("")
            })
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"SearchFragment - onCreate() called")
    }

    private fun handlerSearchButtonUi(){
        btnProgress.visibility = View.VISIBLE
        btnSearch.text = ""
//        Handler().postDelayed({
//            btnProgress.visibility = View.INVISIBLE
//            btnSearch.text = "검색"
//        }, 1500)
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        val user = arrayOf("홍심", "감자","누구","시계","물","워터","구름","이쁘다","최준","나이스","SG워너비")

        val userAdapter : ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, user)
        )
    }*/


}