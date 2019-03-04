package win.regin.coroutine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mViewModel = MainModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            mViewModel.getWxSubscription({
                textView.text = "开始请求"
            }, {

            })
        }

        mViewModel.mWxSubscription.observe(this, Observer {
            textView.text = it.data.toString()
        })
    }
}
