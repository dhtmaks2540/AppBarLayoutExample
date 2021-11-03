package kr.co.lee.appbarlayoutexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var toolBar: Toolbar
    lateinit var textList: ArrayList<String>
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        toolBar = findViewById(R.id.toolbar)
        recyclerView = findViewById(R.id.recyclerView)
        setSupportActionBar(toolBar)

        // Adapter에 설정할 데이터셋
        textList = ArrayList()
        for(i in 1..20) {
            textList.add("item = $i")
        }

        // Adapter 생성 및 초기화
        val customRecyclerAdapter = CustomRecyclerAdapter(textList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = customRecyclerAdapter
    }

    // 메뉴 초기화 메서드
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // menu layout inflate
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    // RecyclerView Adapter
    class CustomRecyclerAdapter(val textList: ArrayList<String>): RecyclerView.Adapter<CustomViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
            return CustomViewHolder(view)
        }

        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
            val text = textList[position]
            holder.itemText.text = text
        }

        override fun getItemCount(): Int {
            return textList.size
        }

    }

    // RecyclerView ViewHolder
    class CustomViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val itemText: TextView = view.findViewById(android.R.id.text1)
    }
}